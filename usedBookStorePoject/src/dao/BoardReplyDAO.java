package dao;

import static db.JdbcUtil.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BoardBean;

public class BoardReplyDAO {

	DataSource ds;
	Connection con;

	private static BoardReplyDAO boardReplyDAO;

	private BoardReplyDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardReplyDAO getInstance() {
		if (boardReplyDAO == null) {
			boardReplyDAO = new BoardReplyDAO();
		}
		return boardReplyDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public BoardBean selectArticle(int post_serial_number) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM customer_board WHERE post_serial_number = ?");
			pstmt.setInt(1, post_serial_number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardBean = new BoardBean();
				boardBean.setPost_serial_number(post_serial_number);
				boardBean.setWriting_user_serial_number(rs.getInt("Writing_user_serial_number"));
				boardBean.setUser_id(rs.getString("user_id"));
				boardBean.setPost_title(rs.getString("post_title"));
				boardBean.setPost_content(rs.getString("post_content"));
				boardBean.setPost_readcount(rs.getInt("post_readcount"));
				boardBean.setPost_date(rs.getDate("post_date"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_Ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
			}
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	public ArrayList<BoardBean> selectArticleList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "SELECT * FROM customer_board ORDER BY board_re_ref DESC,board_re_seq ASC LIMIT ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; // 읽기 시작할 row 번호..

		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardBean();
				board.setPost_content(rs.getString("post_content"));
				board.setPost_title(rs.getString("post_title"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setPost_date(rs.getDate("post_date"));
				articleList.add(board);
			}

		} catch (Exception ex) {
			System.out.println("getBoardList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	// 글 답변.
	public int insertReplyArticle(BoardBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql = "SELECT max(post_serial_number) FROM customer_board";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getBoard_re_ref();
		int	re_lev = article.getBoard_re_lev();
		int	re_seq = article.getBoard_re_seq();
		System.out.println(re_ref);
		System.out.println(re_lev);
		System.out.println(re_seq);
		
		try {
			pstmt = con.prepareStatement(board_max_sql);
			rs=pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1)+1;
			else num = 1;
			sql = "UPDATE customer_board SET board_re_seq = board_re_seq+1 WHERE board_re_ref=? and board_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount > 0) {
				commit(con);
			}
			
			re_seq = re_seq+1;
			re_lev = re_lev+1;
			
			sql = "INSERT INTO customer_board (writing_user_serial_number,post_title,post_content,board_re_ref,board_re_lev,board_re_seq,post_readcount,post_date) VALUES(?,?,?,?,?,?,?,now())";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getWriting_user_serial_number());
			pstmt.setString(2, article.getPost_title());
			pstmt.setString(3, article.getPost_content());
			pstmt.setInt(4, re_ref);
			pstmt.setInt(5, re_lev);
			pstmt.setInt(6, re_seq);
			pstmt.setInt(7, 0);
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("boardReply 에러 : "+ex);
			
		} finally {

			close(rs);
			close(pstmt);
			
		}

		return insertCount;

	}

	// 답변 수정.
	public int updateReplyArticle(BoardBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE customer_board SET post_date=now(),post_title,post_content=? WHERE post_serial_number=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, article.getPost_title());
			pstmt.setString(3, article.getPost_content());
			pstmt.setInt(4, article.getPost_serial_number());
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardModify 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return updateCount;

	}

	// 답변 삭제.
	public int deleteReplyArticle(int post_serial_number) {

		PreparedStatement pstmt = null;
		String board_delete_sql = "DELETE FROM customer_board WHERE post_serial_number=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, post_serial_number);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardDelete 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;

	}

	public int selectListCount() {
		// TODO Auto-generated method stub

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from customer_board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("BoardListCount 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	public ArrayList<BoardBean> selectReplyList(int board_re_ref) {
		// TODO Auto-generated method stub
		ArrayList<BoardBean> replyList = new ArrayList<BoardBean>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM customer_board WHERE board_re_ref = ?");
			pstmt.setInt(1, board_re_ref);
			rs = pstmt.executeQuery();
			System.out.println("보드 리플라이 디에이오 포스트 시리얼 넘버" + board_re_ref);
			while (rs.next()) {
				boardBean = new BoardBean();
				boardBean.setPost_serial_number(rs.getInt("post_serial_number"));
				boardBean.setBoard_re_ref(board_re_ref);
				boardBean.setWriting_user_serial_number(rs.getInt("writing_user_serial_number"));
				boardBean.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));
				boardBean.setPost_title(rs.getString("post_title"));
				System.out.println(rs.getString("post_title"));
				boardBean.setPost_content(rs.getString("post_content"));
				boardBean.setPost_readcount(rs.getInt("post_readcount"));
				boardBean.setPost_date(rs.getDate("post_date"));
				replyList.add(boardBean);
			}
			System.out.println("답변목록숫자"+replyList.size());
		} catch (Exception ex) {
			System.out.println("ReplygetDetail 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return replyList;

	}

	public int updateReadCount(int post_serial_number) {

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "UPDATE customer_board SET post_readcount = " + "post_readcount+1 WHERE post_serial_number = "
				+ post_serial_number;

		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate 에러 : " + ex);
		} finally {
			close(pstmt);

		}

		return updateCount;

	}
}

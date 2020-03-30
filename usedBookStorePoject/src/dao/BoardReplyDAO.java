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

	public ArrayList<BoardBean> selectArticleList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "SELECT * FROM board ORDER BY board_re_ref DESC,board_re_seq ASC LIMIT ?,10";
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
		String board_max_sql = "SELECT MAX(post_serial_number) FROM board";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getBoard_re_ref();
		int re_lev = article.getBoard_re_lev();
		int re_seq = article.getBoard_re_seq();

		try {
			pstmt = con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;
			sql = "UPDATE board SET board_re_seq=board_re_seq+1 WHERE board_re_ref=? ";
			sql += "AND board_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();

			if (updateCount > 0) {
				commit(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			sql = "INSERT INTO board (post_serial_number,post_content,";
			sql += "board_re_ref,board_re_lev,board_re_seq,";
			sql += "post_date) VALUES(?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getPost_content());
			pstmt.setInt(3, re_ref);
			pstmt.setInt(4, re_lev);
			pstmt.setInt(5, re_seq);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("boardReply 에러 : " + ex);
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
		String sql = "UPDATE board SET post_date=now(),post_content=? WHERE post_serial_number=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, article.getPost_content());
			pstmt.setInt(3, article.getPost_serial_number());
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
		String board_delete_sql = "DELETE FROM board WHERE post_serial_number=?";
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

}

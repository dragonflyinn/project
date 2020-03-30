package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import Common.getId;
import vo.BoardBean;

public class CustomerDAO {

	DataSource ds;
	Connection con;

	private static CustomerDAO customerDAO;

	private CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CustomerDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new CustomerDAO();
		}
		return customerDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글의 개수 구하기.
	public int selectListCount() {

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
			System.out.println("getListCount 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	// 글 목록 보기.
	public ArrayList<BoardBean> selectArticleList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "SELECT * FROM customer_board ORDER BY post_serial_number DESC LIMIT ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; // 읽기 시작할 row 번호..

		try {
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new BoardBean();
				getId getIdService = new getId();
				String user_id = getIdService.getIdBySerial(rs.getInt("Writing_user_serial_number"));
				board.setWriting_user_serial_number(rs.getInt("Writing_user_serial_number"));
				board.setPost_serial_number(rs.getInt("post_serial_number"));
				board.setUser_id(user_id);
				board.setPost_title(rs.getString("post_title"));
				board.setPost_content(rs.getString("post_content"));
				board.setBoard_readcount(rs.getInt("post_readcount"));
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

	// 글 내용 보기.
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
				boardBean.setBoard_readcount(rs.getInt("post_readcount"));
				boardBean.setPost_date(rs.getDate("post_date"));
			}
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	// 글 등록.
	public int insertArticle(BoardBean article) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {

			/*
			 * pstmt=con.
			 * prepareStatement("SELECT MAX(post_serial_number) FROM customer_board"); rs =
			 * pstmt.executeQuery();
			 * 
			 * if(rs.next()) num =rs.getInt(1)+1; else num=1;
			 */
			sql = "INSERT INTO customer_board (post_title,writing_user_serial_number,post_content,post_date) VALUES(?,?,?,now())";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getPost_title());
			pstmt.setInt(2, article.getWriting_user_serial_number());
			pstmt.setString(3, article.getPost_content());
			System.out.println("제목" + article.getPost_title());
			System.out.println("내용" + article.getPost_content());
			System.out.println("아이디" + article.getUser_id());

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("boardInsert 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	// 글 수정.
	public int updateArticle(BoardBean article) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE customer_board SET post_title=?,post_content=? WHERE post_serial_number=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getPost_title());
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

	// 글 삭제.
	public int deleteArticle(int post_serial_number) {

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

	// 조회수 업데이트.
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

	// 글쓴이인지 확인. 세션이 있으니까 괜찮다. 비로그인 게시판일 경우 확인이 필요하니까 isArticleBoardWriter (int
	// porst_serial_number,string pass)부분이 필요하다.

}

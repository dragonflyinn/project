package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.BookBoardBean;
import static db.JdbcUtil.*;

public class BookBoardDAO {
	public static BookBoardDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private BookBoardDAO() {

	}

	public static BookBoardDAO getInstance() {
		if (instance == null) {
			instance = new BookBoardDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertArticle(BookBoardBean article) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;

		try {

			sql = "insert into book_board (book_serial_number,writing_user_serial_number,post_content,post_date) values(?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getBook_serial_number());
			pstmt.setInt(2, article.getWriting_user_serial_number());
			pstmt.setString(3, article.getPost_content());

			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {

			System.out.println("boardInsert 에러 : " + ex);

		} finally {

			close(pstmt);

		}

		return insertCount;
	}

	public ArrayList<BookBoardBean> selectArticleList(int book_serial_number) {
		// TODO Auto-generated method stub
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		
		ArrayList<BookBoardBean> articleList = new ArrayList<BookBoardBean>();
		BookBoardBean board = null;

		try {
			String sql1 = "select * from book_board where book_serial_number = ? ";
			
			System.out.println("SQL"+sql1);
			
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1,book_serial_number);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				board = new BookBoardBean();
				board.setBook_serial_number(rs.getInt("book_serial_number"));
				board.setPost_date(rs.getDate("post_date"));
				board.setPost_content(rs.getString("post_content"));
				articleList.add(board);
			}

		} catch (Exception ex) {
			
			System.out.println("getBoardList 에러 : " + ex);
			
		} finally {
			
			close(pstmt);
			
		}

		return articleList;

	}

	public int updateArticle(BookBoardBean book) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteBookBoard(int book_serial_number) {
		// TODO Auto-generated method stub
		return 0;
	}

}
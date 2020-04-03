package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BookBean;
import static db.JdbcUtil.*;

public class BookDAO {
	public static BookDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private BookDAO() {

	}

	public static BookDAO getInstance() {
		if (instance == null) {
			instance = new BookDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public BookBean selectbook(int book_serial_number) {
		BookBean bookBean = null;
		String sql = "SELECT * FROM book_information WHERE book_serial_number=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book_serial_number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bookBean = new BookBean();
				bookBean.setBook_serial_number(rs.getInt("book_serial_number"));
				bookBean.setBook_name(rs.getString("book_name"));
			}
		} catch (Exception ex) {
			System.out.println("selectbook 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return bookBean;
	}

	public ArrayList<BookBean> selectBookList() {
		String sql = "SELECT * FROM book_information";
		ArrayList<BookBean> bookList = new ArrayList<BookBean>();
		BookBean book = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					book = new BookBean();
					book.setBook_serial_number(rs.getInt("book_serial_number"));
					bookList.add(book);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilBook 에러: " + ex);
		} finally {
			close(pstmt);
		}
		return bookList;
	}

	public BookBean selectBook(String book_serial_number) {
		String sql = "SELECT * FROM book_information WHERE book_serial_number=?";
		BookBean book = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book_serial_number);
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				book = new BookBean();
				book.setBook_serial_number(rs.getInt("book_serial_number"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilBook 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return book;
	}

}
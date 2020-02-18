package vo;

import java.sql.Date;

public class BookBoardBean {
	
	private int post_serial_number;
	private String post_group;
	private int sale_book_serial_number;
	private int writing_user_serial_number;
	private int target_user_serial_number;
	private String post_content;
	private Date post_date;
	private int user_serial_number;
	private int book_serial_number;
	
	public int getPost_serial_number() {
		return post_serial_number;
	}
	public void setPost_serial_number(int post_serial_number) {
		this.post_serial_number = post_serial_number;
	}
	public String getPost_group() {
		return post_group;
	}
	public void setPost_group(String post_group) {
		this.post_group = post_group;
	}
	public int getSale_book_serial_number() {
		return sale_book_serial_number;
	}
	public void setSale_book_serial_number(int sale_book_serial_number) {
		this.sale_book_serial_number = sale_book_serial_number;
	}
	public int getWriting_user_serial_number() {
		return writing_user_serial_number;
	}
	public void setWriting_user_serial_number(int writing_user_serial_number) {
		this.writing_user_serial_number = writing_user_serial_number;
	}
	public int getTarget_user_serial_number() {
		return target_user_serial_number;
	}
	public void setTarget_user_serial_number(int target_user_serial_number) {
		this.target_user_serial_number = target_user_serial_number;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public int getUser_serial_number() {
		return user_serial_number;
	}
	public void setUser_serial_number(int user_serial_number) {
		this.user_serial_number = user_serial_number;
	}
	public int getBook_serial_number() {
		return book_serial_number;
	}
	public void setBook_serial_number(int book_serial_number) {
		this.book_serial_number = book_serial_number;
	}
	
}
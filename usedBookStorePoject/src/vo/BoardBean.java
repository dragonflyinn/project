package vo;

import java.sql.Date;

public class BoardBean {

	private int post_serial_number;
	private int user_serial_number;
	private int writing_user_serial_number;
	private int book_serial_number;
	private String User_id;
	private String post_title;
	private String post_content;
	private Date post_date;
	private int board_readcount;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private String post_group;
	
	public int getPost_serial_number() {
		return post_serial_number;
	}
	public void setPost_serial_number(int post_serial_number) {
		this.post_serial_number = post_serial_number;
	}
	public int getUser_serial_number() {
		return user_serial_number;
	}
	public void setUser_serial_number(int user_serial_number) {
		this.user_serial_number = user_serial_number;
	}
	public int getWriting_user_serial_number() {
		return writing_user_serial_number;
	}
	public void setWriting_user_serial_number(int writing_user_serial_number) {
		this.writing_user_serial_number = writing_user_serial_number;
	}
	public int getBook_serial_number() {
		return book_serial_number;
	}
	public void setBook_serial_number(int book_serial_number) {
		this.book_serial_number = book_serial_number;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
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
	public int getBoard_readcount() {
		return board_readcount;
	}
	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}
	public int getBoard_re_ref() {
		return board_re_ref;
	}
	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}
	public int getBoard_re_lev() {
		return board_re_lev;
	}
	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}
	public int getBoard_re_seq() {
		return board_re_seq;
	}
	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}
	public String getPost_group() {
		return post_group;
	}
	public void setPost_group(String post_group) {
		this.post_group = post_group;
	}
	
}
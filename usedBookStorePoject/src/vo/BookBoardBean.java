package vo;

import java.sql.Date;

public class BookBoardBean {
	
	private int book_serial_number;
	private int post_serial_number;
	private int writing_user_serial_number;
	private String ISBN;
	private int book_category_serial_num;
	private String book_name;
	private int book_sale_regular_price;
	private String publish_company;
	private Date publish_date;
	private String book_introduction;
	

	private String post_group;
	private int sale_book_serial_number;
	private int target_user_serial_number;
	private String post_content;
	private Date post_date;
	private int user_serial_number;
	
	
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
	public int getPost_serial_number() {
		return post_serial_number;
	}
	public void setPost_serial_number(int post_serial_number) {
		this.post_serial_number = post_serial_number;
	}
	public int getWriting_user_serial_number() {
		return writing_user_serial_number;
	}
	public void setWriting_user_serial_number(int writing_user_serial_number) {
		this.writing_user_serial_number = writing_user_serial_number;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getBook_category_serial_num() {
		return book_category_serial_num;
	}
	public void setBook_category_serial_num(int book_category_serial_num) {
		this.book_category_serial_num = book_category_serial_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_sale_regular_price() {
		return book_sale_regular_price;
	}
	public void setBook_sale_regular_price(int book_sale_regular_price) {
		this.book_sale_regular_price = book_sale_regular_price;
	}
	public String getPublish_company() {
		return publish_company;
	}
	public void setPublish_company(String publish_company) {
		this.publish_company = publish_company;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getBook_introduction() {
		return book_introduction;
	}
	public void setBook_introduction(String book_introduction) {
		this.book_introduction = book_introduction;
	}
	
}

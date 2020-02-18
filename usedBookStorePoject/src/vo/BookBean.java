package vo;

import java.sql.Date;

public class BookBean {
	
	private int book_serial_number;
	private String book_name;
	private String ISBN;
	private int book_sale_regular_price;
	private String publish_company;
	private Date publish_date;
	private String book_introduction;
	private int book_category_serial_num;
	
	public int getBook_serial_number() {
		return book_serial_number;
	}
	public void setBook_serial_number(int book_serial_number) {
		this.book_serial_number = book_serial_number;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
	public int getBook_category_serial_num() {
		return book_category_serial_num;
	}
	public void setBook_category_serial_num(int book_category_serial_num) {
		this.book_category_serial_num = book_category_serial_num;
	}
	
}

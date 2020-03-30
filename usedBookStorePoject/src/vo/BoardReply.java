package vo;
import java.sql.Date;

public class BoardReply {

	private String reply_content;
	private Date reply_date;
	private Date update_reply_date;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int user_serial_number;
	private int post_serial_number;
	
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public Date getUpdate_reply_date() {
		return update_reply_date;
	}
	public void setUpdate_reply_date(Date update_reply_date) {
		this.update_reply_date = update_reply_date;
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
	public int getUser_serial_number() {
		return user_serial_number;
	}
	public void setUser_serial_number(int user_serial_number) {
		this.user_serial_number = user_serial_number;
	}
	public int getPost_serial_number() {
		return post_serial_number;
	}
	public void setPost_serial_number(int post_serial_number) {
		this.post_serial_number = post_serial_number;
	}
	


}

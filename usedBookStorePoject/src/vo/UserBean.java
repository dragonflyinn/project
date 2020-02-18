package vo;

public class UserBean {
	private int user_serial_number;
	private String user_id;
	private String user_password;
	private String user_email;
	
	public int getUser_serial_number() {
		return user_serial_number;
	}
	public void setUser_serial_number(int user_serial_number) {
		this.user_serial_number = user_serial_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
}
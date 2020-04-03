package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.UserBean;
import static db.JdbcUtil.*;

public class UserDAO {
	public static UserDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private UserDAO() {
		System.out.println("1");
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertUser(UserBean user) {
		String sql = "INSERT INTO users_inform_table (user_id,user_password,user_email,user_grade) VALUES (?,?,?,?)";
		int insertCount = 0;

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_email());
			pstmt.setString(4, user.getUser_grade());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("joinUser 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public ArrayList<UserBean> selectUserList() {
		String sql = "SELECT * FROM users_inform_table";
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		UserBean ub = null;
		try {

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					ub = new UserBean();
					ub.setUser_id(rs.getString("user_serial_number"));
					ub.setUser_id(rs.getString("user_id"));
					ub.setUser_password(rs.getString("user_password"));
					ub.setUser_email(rs.getString("user_email"));
					ub.setUser_grade(rs.getString("user_grade"));
					userList.add(ub);
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return userList;
	}

	public UserBean loginUser(String user_id, String user_passwd) {
		String sql = "SELECT * FROM users_inform_table WHERE user_id=? AND user_password=?";
		UserBean ub = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_passwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ub = new UserBean();
				System.out.println("회원등급" + rs.getString("user_grade"));
				ub.setUser_serial_number(rs.getInt("user_serial_number"));
				ub.setUser_id(rs.getString("user_id"));
				ub.setUser_password(rs.getString("user_password"));
				ub.setUser_email(rs.getString("user_email"));
				ub.setUser_grade(rs.getString("user_grade"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return ub;
	}

	public UserBean selectUser(String user_id, String user_passwd) {
		String sql = "SELECT * FROM users_inform_table WHERE user_id=?";
		UserBean ub = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ub = new UserBean();
				ub.setUser_id(rs.getString("user_serial_number"));
				ub.setUser_id(rs.getString("user_id"));
				ub.setUser_password(rs.getString("user_password"));
				ub.setUser_email(rs.getString("user_email"));
				ub.setUser_grade(rs.getString("user_grade"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return ub;
	}

	public UserBean getUser(String user_id) {
		String sql = "SELECT * FROM users_inform_table WHERE user_id=?";
		UserBean ub = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			System.out.println("dao에서 확인하는 겟유저 변수" + user_id);
			if (rs.next()) {
				ub = new UserBean();
				ub.setUser_id(rs.getString("user_serial_number"));
				ub.setUser_id(rs.getString("user_id"));
				ub.setUser_password(rs.getString("user_password"));
				ub.setUser_email(rs.getString("user_email"));
				ub.setUser_grade(rs.getString("user_grade"));
			}
		} catch (Exception ex) {
			System.out.println("getDeatilUser 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return ub;
	}

	public int deleteUser(String id) {
		String sql = "DELETE from users_inform_table WHERE user_id=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("deleteUser 에러: " + ex);
		} finally {
			close(pstmt);
		}

		return deleteCount;
	}

	public int modifyUser(UserBean modifyuser) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users_inform_table SET user_email = ? WHERE user_id = ?";
		System.out.println("dao : " + modifyuser.getUser_grade());
		int modifyCount = 0;

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, modifyuser.getUser_email());
			pstmt.setString(2, modifyuser.getUser_id());
			modifyCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("ModifyUser 에러: " + ex);
		} finally {
			close(pstmt);
		}
		System.out.println("수정이 되는지 확인" + modifyCount);

		System.out.println(modifyCount);
		return modifyCount;
	}

	public int modifyAdmin(UserBean modifyadmin) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users_inform_table SET user_grade = ? WHERE user_id = ?";
		System.out.println("dao : " + modifyadmin.getUser_grade());
		int modifyCount = 0;

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, modifyadmin.getUser_grade());
			pstmt.setString(2, modifyadmin.getUser_id());
			modifyCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("ModifyAdmin 에러: " + ex);
		} finally {
			close(pstmt);
		}
		System.out.println("수정이 되는지 확인" + modifyCount);

		System.out.println(modifyCount);
		return modifyCount;
	}

	public String findUserBySerial(int user_serial_number) {
		// TODO Auto-generated method stub
		String sql = "SELECT user_id FROM users_inform_table WHERE user_serial_number=?";
		String user_id = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_serial_number);
			rs = pstmt.executeQuery();
			System.out.println("userSerialNumber;" + user_serial_number);
			if (rs.next())
				user_id = rs.getString(1);
			System.out.println("user_id" + user_id);
		} catch (Exception ex) {
			System.out.println("getID 에러: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return user_id;
	}

}
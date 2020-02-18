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
	public static UserDAO getInstance(){
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public String selectLoginId(UserBean user){
		String loginId = null;
		String sql="SELECT user_id FROM users_inform_table WHERE user_id=? AND user_password=?";
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				loginId = rs.getString("User_id");
			}
		}catch(Exception ex){
			System.out.println(" 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	
	public int insertUser(UserBean user){
		String sql="INSERT INTO users_inform_table (user_id,user_password,user_email) VALUES (?,?,?)";
		int insertCount=0;
		
		try{

			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_email());
			insertCount=pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("joinUser 에러: " + ex);			
		}finally{
			close(pstmt);
		}
		
		return insertCount;
	}
	
	public ArrayList<UserBean> selectUserList(){
		String sql="SELECT * FROM users_inform_table";
		ArrayList<UserBean> userList=new ArrayList<UserBean>();
		UserBean ub = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				do{
				ub=new UserBean();
				ub.setUser_id(rs.getString("user_id"));
				ub.setUser_password(rs.getString("user_password"));
				ub.setUser_email(rs.getString("user_email"));
				userList.add(ub);
				}while(rs.next());
			}
		}catch(Exception ex){
			System.out.println("getDeatilUser 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		return userList;
	}
	
	public UserBean selectUser(String id){
		String sql="SELECT * FROM users_inform_table WHERE user_id=?";
		UserBean ub = null;
		try{
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
			ub=new UserBean();
			ub.setUser_id(rs.getString("user_id"));
			ub.setUser_password(rs.getString("user_password"));
			ub.setUser_email(rs.getString("user_email"));
			}
		}catch(Exception ex){
			System.out.println("getDeatilUser 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return ub;
	}
	public int deleteUser(String id){
		String sql="DELETE users_inform_table WHERE user_id=?";
		int deleteCount = 0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("deleteUser 에러: " + ex);	
		}finally{
			close(pstmt);
		}
		
		return deleteCount;
	}
}
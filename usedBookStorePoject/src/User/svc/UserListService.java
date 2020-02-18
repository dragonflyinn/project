package User.svc;

import java.sql.Connection;
import java.util.ArrayList;
import dao.UserDAO;
import static db.JdbcUtil.*;
import vo.UserBean;

public class UserListService {

	public static ArrayList<UserBean> getUserList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		ArrayList<UserBean> userList = userDAO.selectUserList();
		close(con);
		return userList;
	}

}

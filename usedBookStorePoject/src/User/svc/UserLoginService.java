package User.svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserLoginService {
//

	public UserBean login(String user_id, String user_passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserBean userBean = userDAO.loginUser(user_id,user_passwd);
		
		close(con);
		return userBean;
	}

}

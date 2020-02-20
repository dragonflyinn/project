package User.svc;

import vo.UserBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class UserViewService {

	public UserBean getUser(String viewId) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		UserBean user = userDAO.getUser(viewId);
		close(con);
		return user;
	}

}

package admin.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.UserDAO;

public class AdminDeleteService {

	public boolean deleteUser(String deleteId) {
		// TODO Auto-generated method stub
		boolean deleteResult = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		int deleteCount = userDAO.deleteUser(deleteId);
		if(deleteCount > 0){
			commit(con);
			deleteResult = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}

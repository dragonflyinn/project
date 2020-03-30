package admin.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.UserBean;
import dao.UserDAO;

public class AdminInfoModifyProService {

	public boolean modifyUser(UserBean modifyuser) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		int updateCount = userDAO.modifyUser(modifyuser);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		System.out.println(isModifySuccess);
		close(con);
		return isModifySuccess;
		
	}

}

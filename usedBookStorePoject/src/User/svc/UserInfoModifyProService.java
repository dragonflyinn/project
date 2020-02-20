package User.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.UserBean;
import dao.UserDAO;

public class UserInfoModifyProService {

	public boolean modifyUser(String user_id,String user_password) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		int updateCount = userDAO.ModifyUserList(user_id,user_password);
		
		if(updateCount > 0){
			commit(con);
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}

}
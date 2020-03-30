package customer.svc;

import java.sql.Connection;



import dao.CustomerDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;
public class CustomerWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int insertCount = customerDAO.insertArticle(boardBean);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}

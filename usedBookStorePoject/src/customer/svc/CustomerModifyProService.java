package customer.svc;

import static db.JdbcUtil.*;





import java.sql.Connection;
import vo.BoardBean;
import dao.CustomerDAO;

public class CustomerModifyProService {

	public boolean modifyArticle(BoardBean article) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int updateCount = customerDAO.updateArticle(article);
		
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

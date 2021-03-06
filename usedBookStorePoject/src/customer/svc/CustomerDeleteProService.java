package customer.svc;

import static db.JdbcUtil.close;



import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;

import dao.CustomerDAO;
import vo.UserBean;

public class CustomerDeleteProService {

	public boolean isArticleWriter (int post_serial_number, UserBean loginUser) throws Exception {
			
			boolean isArticleWriter = false;
			Connection con = getConnection();
			CustomerDAO customerDAO = CustomerDAO.getInstance();
			customerDAO.setConnection(con);
			isArticleWriter = customerDAO.isArticleWriter(post_serial_number,loginUser);
			return isArticleWriter;
		}
		
	
	public boolean removeArticle(int post_serial_number) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int deleteCount = customerDAO.deleteArticle(post_serial_number);
		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}

}

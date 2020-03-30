package customer.svc;

import java.sql.Connection;


import dao.CustomerDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class CustomerDetailService {

	public BoardBean getArticle(int post_serial_number) throws Exception{
		// TODO Auto-generated method stub
		
		BoardBean article = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int updateCount = customerDAO.updateReadCount(post_serial_number);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = customerDAO.selectArticle(post_serial_number);
		close(con);
		return article;
		
	}

}

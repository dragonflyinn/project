package customer.svc;

import java.sql.Connection;

import dao.BoardReplyDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class CustomerReplyDetailService {

	public BoardBean getArticle(int post_serial_number) throws Exception{
		// TODO Auto-generated method stub
		
		BoardBean article = null;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		int updateCount = boardReplyDAO.updateReadCount(post_serial_number);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = boardReplyDAO.selectArticle(post_serial_number);
		close(con);
		return article;
		
	}

}

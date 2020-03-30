package customer.svc;

import static db.JdbcUtil.*;




import java.sql.Connection;
import dao.BoardReplyDAO;
import vo.BoardBean;

public class CustomerReplyProService {

	public boolean replyArticle(BoardBean article) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		insertCount = boardReplyDAO.insertReplyArticle(article);
		
		if(insertCount > 0){
			commit(con);
			isReplySuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}

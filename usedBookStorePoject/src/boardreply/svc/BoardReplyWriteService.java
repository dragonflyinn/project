package boardreply.svc;

import java.sql.Connection;


import dao.BoardReplyDAO;
import vo.BoardBean;

import static db.JdbcUtil.*;

public class BoardReplyWriteService {

	public boolean registArticle(BoardBean boardBean) {
		// TODO Auto-generated method stub

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		int insertCount = boardReplyDAO.insertReplyArticle(boardBean);

		if (insertCount > 0) {
			
			commit(con);
			isWriteSuccess = true;
		
		} else {
			
			rollback(con);
			
		}

		close(con);
		return isWriteSuccess;
	}
}

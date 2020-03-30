package boardreply.svc;

import java.sql.Connection;

import dao.BoardReplyDAO;
import vo.BoardReply;

import static db.JdbcUtil.*;

public class BoardReplyWriteService {

	public boolean registArticle(BoardReply boardReply) {
		// TODO Auto-generated method stub

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		int insertCount = boardReplyDAO.insertReplyArticle(boardReply);

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

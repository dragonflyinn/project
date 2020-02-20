package notice.svc;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;
import static db.JdbcUtil.*;
public class NoticeWriteProService {

	public boolean registArticle(NoticeBean noticeBean) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int insertCount = noticeDAO.insertArticle(noticeBean);
		
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

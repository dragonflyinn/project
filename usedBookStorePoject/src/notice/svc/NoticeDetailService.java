package notice.svc;

import java.sql.Connection;

import dao.NoticeDAO;
import vo.NoticeBean;
import static db.JdbcUtil.*;

public class NoticeDetailService {

	public NoticeBean getArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		NoticeBean article = null;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int updateCount = noticeDAO.updateReadCount(board_num);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = noticeDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}

}

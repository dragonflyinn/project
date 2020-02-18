package notice.svc;

import java.sql.Connection;
import dao.BoardDAO;
import vo.NoticeBean;
import static db.JdbcUtil.*;

public class NoticeDetailService {

	public NoticeBean getArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		NoticeBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(board_num);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}

}

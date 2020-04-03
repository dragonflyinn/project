package notice.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.BoardBean;
import vo.UserBean;
import dao.BoardDAO;

public class NoticeModifyProService {

	public boolean isArticleWriter(int post_serial_number, UserBean loginuser ) {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(post_serial_number,loginuser);
		return isArticleWriter;
	}
	
	public boolean modifyArticle(BoardBean article) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateArticle(article);
		
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

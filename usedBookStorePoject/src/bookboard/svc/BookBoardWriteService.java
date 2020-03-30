package bookboard.svc;

import java.sql.Connection;


import dao.BookBoardDAO;
import vo.BoardBean;
import vo.BookBoardBean;

import static db.JdbcUtil.*;

public class BookBoardWriteService {

	public boolean registArticle(BookBoardBean bookBoardBean) {
		// TODO Auto-generated method stub

		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BookBoardDAO bookBoardDAO = BookBoardDAO.getInstance();
		bookBoardDAO.setConnection(con);
		int insertCount = bookBoardDAO.insertArticle(bookBoardBean);

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

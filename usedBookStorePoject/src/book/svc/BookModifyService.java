package book.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import vo.BookBoardBean;
import dao.BookDAO;

public class BookModifyService {

	public boolean modifyBook(BookBoardBean book) throws Exception {
		// TODO Auto-generated method stub

		boolean isModifySuccess = false;
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		rollback(con);
		close(con);
		return isModifySuccess;

	}

}

package book.svc;

import vo.BookBoardBean;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BookDAO;

public class BookInsertService {

	public boolean BookInsert(BookBoardBean book) {
		// TODO Auto-generated method stub
		boolean BookInsertSuccess = false;
		BookDAO bookDAO = BookDAO.getInstance();
		Connection con = getConnection();
		bookDAO.setConnection(con);
		commit(con);
		rollback(con);
		close(con);
		return BookInsertSuccess;
	}

}

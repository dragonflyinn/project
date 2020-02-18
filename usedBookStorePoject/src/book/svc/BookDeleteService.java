package book.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BookDAO;

public class BookDeleteService {

	public boolean deleteBook(String deleteBook) {
		// TODO Auto-generated method stub
		boolean deleteResult = false;
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		rollback(con);
		close(con);
		return deleteResult;
	}

}

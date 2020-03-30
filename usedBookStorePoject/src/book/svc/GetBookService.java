package book.svc;


import java.sql.Connection;


import dao.BookDAO;
import vo.BookBean;
import static db.JdbcUtil.*;

public class GetBookService {

	public BookBean getbook(int book_serial_number) throws Exception{
		// TODO Auto-generated method stub
		
		BookBean book = null;
		Connection con = getConnection();
		BookDAO bookDAO = BookDAO.getInstance();
		bookDAO.setConnection(con);
		
		book = bookDAO.selectbook(book_serial_number);
		close(con);
		return book;
		
	}

}

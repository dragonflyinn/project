package bookboard.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.BookBoardDAO;
import vo.BookBoardBean;

public class BookBoardListService {

	public ArrayList<BookBoardBean> getArticleList(int book_serial_number) throws Exception{
		
		ArrayList<BookBoardBean> articleList = null;
		System.out.println("");
		Connection con = getConnection();
		System.out.println("3");
		BookBoardDAO bookboardDAO = BookBoardDAO.getInstance();
		System.out.println("4");
		bookboardDAO.setConnection(con);
		System.out.println("5");
		articleList = bookboardDAO.selectArticleList(book_serial_number);
		close(con);
		return articleList;
		
	}

}

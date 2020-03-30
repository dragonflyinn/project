package book.action;

import java.io.PrintWriter;




import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import book.svc.GetBookService;
import bookboard.svc.BookBoardListService;
import vo.ActionForward;
import vo.BookBoardBean;
import vo.BookBean;

public class GetBookAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int book_serial_number = Integer.parseInt(request.getParameter("book_serial_number"));
		GetBookService GetBookService = new GetBookService();
		BookBean book = GetBookService.getbook(book_serial_number);
		BookBoardListService bookboardListService = new BookBoardListService();
		ArrayList<BookBoardBean> articleList = bookboardListService.getArticleList(book_serial_number);
		System.out.println("articleList.size()"+articleList.size());
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		request.setAttribute("book", book);
		forward.setPath("bookform2.jsp");
		return forward;

	}
}

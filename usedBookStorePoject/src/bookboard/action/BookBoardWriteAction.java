package bookboard.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import bookboard.svc.BookBoardWriteService;
import vo.ActionForward;
import vo.BookBoardBean;

public class BookBoardWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		BookBoardBean bookBoardBean = null;
		String book_serial_number = "1";
		String writing_user_serial_number ="1";
		bookBoardBean = new BookBoardBean();
		bookBoardBean.setBook_serial_number(Integer.parseInt(book_serial_number));
		bookBoardBean.setWriting_user_serial_number(Integer.parseInt(writing_user_serial_number));
		bookBoardBean.setPost_content(request.getParameter("post_content"));
		
		BookBoardWriteService bookBoardWriteService = new BookBoardWriteService();
		boolean isWriteSuccess = bookBoardWriteService.registArticle(bookBoardBean);

		if (!isWriteSuccess) {
		
			response.setContentType("text/html; Charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("GetBookAction.book?book_serial_number="+book_serial_number);
		}

		return forward;
	}
}
package bookboard.action;

import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import bookboard.svc.BookBoardListService;
import vo.ActionForward;
import vo.BookBoardBean;
import vo.PageInfo;

 public class BookBoardListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<BookBoardBean> articleList=new ArrayList<BookBoardBean>();
		
		BookBoardListService bookboardListService = new BookBoardListService();
		
		int book_serial_number = Integer.parseInt(request.getParameter("book_serial_number"));
   		
		articleList = bookboardListService.getArticleList(book_serial_number);
		
		PageInfo pageInfo = new PageInfo();
   		
		pageInfo.setPage(book_serial_number);	
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("bookform2.jsp");
   		return forward;
   		
	 }
	 
 }

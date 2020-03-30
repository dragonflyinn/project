package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeViewService;
import vo.ActionForward;
import vo.BoardBean;

 public class NoticeViewAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
		String page = request.getParameter("page");
		NoticeViewService noticeViewService = new NoticeViewService();
		BoardBean article = noticeViewService.getArticle(post_serial_number);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/noticeBoard/notice_board_view.jsp");
   		return forward;

	 }
	 
}
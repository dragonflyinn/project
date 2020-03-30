package notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeViewService;
import vo.ActionForward;
import vo.BoardBean;

public class NoticeModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
			NoticeViewService noticeViewService
			= new NoticeViewService();	
			BoardBean article =noticeViewService.getArticle(post_serial_number);
		   	request.setAttribute("article", article);
	   		forward.setPath("/noticeBoard/notice_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}
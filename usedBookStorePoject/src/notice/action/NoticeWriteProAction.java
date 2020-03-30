package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.BoardBean;

import action.Action;
import notice.svc.NoticeWriteProService;

public class NoticeWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		BoardBean user = (BoardBean) session.getAttribute("writing_user_serial_number");
		
		ActionForward forward=null;
		BoardBean boardBean = null;
		
		boardBean = new BoardBean();
		boardBean.setPost_title(request.getParameter("post_title"));
		boardBean.setPost_content(request.getParameter("post_content"));
		
		NoticeWriteProService noticeWriteProService = new NoticeWriteProService();
		boolean isWriteSuccess = noticeWriteProService.registArticle(boardBean);

		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("noticeListAction.notice");
		}

		return forward;
		
	}  	
	
}
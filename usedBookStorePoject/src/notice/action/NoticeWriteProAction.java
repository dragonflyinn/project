package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.BoardBean;
import vo.UserBean;
import action.Action;
import notice.svc.NoticeWriteProService;

public class NoticeWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		ActionForward forward=null;
		BoardBean boardBean = null;
		
		boardBean = new BoardBean();
		int user_serial_number = user.getUser_serial_number();
		boardBean.setUser_serial_number(user_serial_number);
		boardBean.setPost_title(request.getParameter("post_title"));
		System.out.println("노티스 액션"+request.getParameter("post_title"));
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
			forward.setPath("noticeList.notice");
		}

		return forward;
		
	}  	
	
}
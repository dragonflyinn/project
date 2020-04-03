package boardreply.action;

import java.io.PrintWriter;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import boardreply.svc.BoardReplyWriteService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		BoardBean boardBean = null;
		String post_serial_number = "1";
		String user_serial_number ="1";
		boardBean = new BoardBean();
		boardBean.setPost_serial_number(Integer.parseInt(post_serial_number));
		boardBean.setUser_serial_number(Integer.parseInt(user_serial_number));
		boardBean.setPost_content(request.getParameter("post_content"));
		
		BoardReplyWriteService boardReplyWriteService = new BoardReplyWriteService();
		boolean isWriteSuccess = boardReplyWriteService.registArticle(boardBean);

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
			forward.setPath("BoardReplyAction.re?post_serial_number="+post_serial_number);
		}
		return forward;
	}
}
package boardreply.action;

import java.io.PrintWriter;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import boardreply.svc.BoardReplyWriteService;
import vo.ActionForward;
import vo.BoardReply;

public class BoardReplyWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		BoardReply boardReply = null;
		String post_serial_number = "1";
		String user_serial_number ="1";
		boardReply = new BoardReply();
		boardReply.setPost_serial_number(Integer.parseInt(post_serial_number));
		boardReply.setUser_serial_number(Integer.parseInt(user_serial_number));
		boardReply.setReply_content(request.getParameter("reply_content"));
		
		BoardReplyWriteService boardReplyWriteService = new BoardReplyWriteService();
		boolean isWriteSuccess = boardReplyWriteService.registArticle(boardReply);

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
package customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;
import vo.BoardBean;
import vo.UserBean;
import action.Action;
import customer.svc.CustomerWriteProService;

public class CustomerWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		

		ActionForward forward = null;
		BoardBean boardBean = null;

		boardBean = new BoardBean();
		boardBean.setPost_title(request.getParameter("post_title"));
		boardBean.setPost_content(request.getParameter("post_content"));
		boardBean.setWriting_user_serial_number(user.getUser_serial_number());
		CustomerWriteProService boardWriteProService = new CustomerWriteProService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);

		if (!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.board");
		}

		return forward;

	}

}
package User.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import User.svc.UserDeleteService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		ActionForward forward = null;
		if (user.getUser_id() == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./UserLogin.me");
			System.out.println("아이다가 널값일때");
		} else if (!user.getUser_id().equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='./UserLogin.me';");
			out.println("</script>");
			System.out.println("아이디가 널값도 관리자도 아닐때");
		} else {
			String deleteId = request.getParameter("id");
			UserDeleteService userDeleteService = new UserDeleteService();
			boolean deleteResult = userDeleteService.deleteUser(deleteId);

			if (deleteResult) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./UserListAction.me");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보삭제 실패.');");
				out.println("location.href='./UserLogin.me';");
				out.println("</script>");
			}
		}
		return forward;
	}
}
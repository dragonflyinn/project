package User.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import User.svc.UserLoginService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String user_id = request.getParameter("user_id");
		String user_passwd = request.getParameter("user_password");

		UserLoginService userLoginService = new UserLoginService();
		UserBean user = userLoginService.login(user_id, user_passwd);
		
		ActionForward forward = null;
		if (user != null) {
			//System.out.println(user.getUser_grade());
			forward = new ActionForward();
			session.setMaxInactiveInterval(60 * 60 * 24);
			session.setAttribute("user", user);
			forward.setRedirect(true);
			forward.setPath("main.jsp"); // ./는 현재 위치
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("location.href='userLogin.me';");
			out.println("</script>");
		}
		return forward;
	}
}
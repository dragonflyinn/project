package User.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import User.svc.UserViewService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		ActionForward forward = null;

		if (user == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 하세요');");
			out.println("location.href='userLogin.me';");
			out.println("</script>");
		} else {
			System.out.println("사용자 정보 보기 ");
			forward = new ActionForward();
			String viewId = user.getUser_id();
			UserViewService userViewService = new UserViewService();
			System.out.println(viewId);
			UserBean viewUser = userViewService.getUser(viewId);
			request.setAttribute("viewUser", viewUser);
			forward.setPath("/user_info.jsp");
		}
		return forward;
	}

}
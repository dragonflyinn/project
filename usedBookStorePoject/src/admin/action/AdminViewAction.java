package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.Action;
import admin.svc.AdminViewService;
import vo.ActionForward;
import vo.UserBean;

public class AdminViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		UserBean userGrade = (UserBean) session.getAttribute("user_grade");
		ActionForward forward = null;
System.out.println(userGrade);
		if (!(userGrade.equals("A") || userGrade.equals("B"))) {
			System.out.println("사용자 정보 보기 1234");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='userLogin.me'");
			out.println("</script>");
		} else {
			System.out.println("사용자 정보 보기 ");
			forward = new ActionForward();
			String viewId = user.getUser_id();
			AdminViewService adminViewService = new AdminViewService();
			System.out.println(viewId);
			UserBean viewUser = adminViewService.getUser(viewId);
			request.setAttribute("viewUser", viewUser);
			forward.setPath("/admin_info.jsp");
			System.out.println(viewUser.getUser_id());
		}
		return forward;
	}

}

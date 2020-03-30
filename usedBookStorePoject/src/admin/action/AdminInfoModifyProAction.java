package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.svc.AdminInfoModifyProService;
import vo.ActionForward;

import vo.UserBean;

public class AdminInfoModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		System.out.println();
		ActionForward forward = null;

		System.out.println("수정");

			request.setCharacterEncoding("UTF-8");
			UserBean modifyuser = new UserBean();
			modifyuser.setUser_id(request.getParameter("user_id"));
			modifyuser.setUser_email(request.getParameter("user_email"));
			System.out.println("111"+request.getParameter("user_email"));
			AdminInfoModifyProService adminInfoModifyProSvc = new AdminInfoModifyProService();
			boolean result = adminInfoModifyProSvc.modifyUser(modifyuser);

			if (!result) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정에 오류가 발생했습니다. 다시 작성하세요.');");
				out.println("history.back();");
				out.println("</script>");

			} else {
				forward = new ActionForward();
				forward.setPath("adminViewAction.me?id=" + modifyuser.getUser_id());

				System.out.println("gggg" + forward.isRedirect());
			}
		return forward;
	}
}
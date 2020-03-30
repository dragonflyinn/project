package admin.action;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.svc.AdminListService;
import vo.ActionForward;
import vo.UserBean;

public class AdminListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		ActionForward forward = null;

		if (!(user.getUser_grade().equals("A") || user.getUser_grade().equals("B"))) {
			 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("location.href='userLogin.me';");
			out.println("</script>");
		}

		else {
			forward = new ActionForward();
			AdminListService adminListService = new AdminListService();
			ArrayList<UserBean> userList = adminListService.getUserList();
			request.setAttribute("userList", userList);
			forward.setPath("/admin_list.jsp");
		}
		return forward;
	}
}

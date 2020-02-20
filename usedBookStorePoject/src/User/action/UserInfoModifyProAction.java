package User.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.svc.UserInfoModifyProService;
import User.svc.UserListService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserInfoModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String user_grade = (String) session.getAttribute("user_grade");
		String user = (String) session.getAttribute("user");
		ActionForward forward = null;

		if (!(user_grade.equals("A") || user_grade.equals("B"))) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}

		else {
			forward = new ActionForward();
			UserListService userListService = new UserListService();
			ArrayList<UserBean> userList = userListService.getUserList();
			request.setAttribute("userList", userList);
			forward.setPath("/UserViewAction.me");
		}
		return forward;
	}
}

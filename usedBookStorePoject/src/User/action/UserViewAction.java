package User.action;

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

		System.out.println("사용자 정보 보기 ");
		forward = new ActionForward();
		String viewId = user.getUser_id();
		UserViewService userViewService = new UserViewService();
		System.out.println(viewId);
		UserBean viewUser = userViewService.getUser(viewId);
		request.setAttribute("viewUser", viewUser);
		forward.setPath("/user_info.jsp");
		return forward;
	}

}
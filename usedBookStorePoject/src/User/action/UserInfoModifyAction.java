package User.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.svc.UserViewService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserInfoModifyAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String user_id =request.getParameter("user_id");
			UserViewService userViewService
			= new UserViewService();	
			
		   	UserBean User =userViewService.getUser(user_id);
		   	request.getAttribute(user_id);
	   		forward.setPath("user_info_modify.jsp");
	   		return forward;
	   		
	 }
	 
}

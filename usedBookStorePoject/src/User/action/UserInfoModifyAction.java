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
			String user_id =request.getParameter("id");
			UserViewService userViewService
			= new UserViewService();	
			 System.out.println("11"+user_id);	
			
		   	UserBean user =userViewService.getUser(user_id);
		   	System.out.println("11111"+user.getUser_grade());
		   	request.setAttribute("user",user);
	   		forward.setPath("user_info_modify.jsp");
	   		return forward;
	   		
	 }
	 
}

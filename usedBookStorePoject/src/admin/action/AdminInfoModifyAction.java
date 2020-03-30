package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.svc.AdminViewService;
import vo.ActionForward;
import vo.UserBean;

public class AdminInfoModifyAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 	ActionForward forward = new ActionForward();
			String user_id =request.getParameter("id");
			AdminViewService adminViewService = new AdminViewService();	
			 System.out.println("11"+user_id);	
			
		   	UserBean user =adminViewService.getUser(user_id);
		   	System.out.println("11111"+user.getUser_grade());
		   	request.setAttribute("user",user);
	   		forward.setPath("admin_info_modify.jsp");
	   		return forward;
	   		
	 }
	 
}

package User.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import User.svc.UserJoinService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserJoinAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	UserBean user=new UserBean();
	   		boolean joinResult=false;
	   		
	   		user.setUser_id(request.getParameter("user_id"));
	   		user.setUser_password(request.getParameter("user_password"));
	   		user.setUser_email(request.getParameter("user_email"));
	   		
	   		UserJoinService userJoinService = new UserJoinService();
	   		joinResult=userJoinService.joinUser(user);
	   		
	   		ActionForward forward = null;
	   		if(joinResult==false){
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('회원등록실패')");
	   			out.println("history.back()");
	   			out.println("</script>");
		   	}
	   		else{
	   	    forward = new ActionForward();
	   		forward.setPath("/UserLogin.me");
	   		}
	   		return forward;
	}
}
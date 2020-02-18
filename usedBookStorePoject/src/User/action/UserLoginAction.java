package User.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import User.svc.UserLoginService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserLoginAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 	HttpSession session=request.getSession();
	   		UserBean user=new UserBean();
	   		
	   		user.setUser_id(request.getParameter("user_id"));
	   		user.setUser_password(request.getParameter("user_password"));
	   		
	   		UserLoginService userLoginService = new UserLoginService();
	   		boolean loginResult = userLoginService.login(user);
	   		ActionForward forward = null;
	   		if(loginResult){
	   	    forward = new ActionForward();
	   		session.setAttribute("id", user.getUser_id());
	   		forward.setRedirect(true);
	   		forward.setPath("./UserListAction.me");
	   		}
	   		else{
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('로그인 실패');");
		   		out.println("location.href='./UserLogin.me';");
		   		out.println("</script>");
	   		}
	   		return forward;
	}
}
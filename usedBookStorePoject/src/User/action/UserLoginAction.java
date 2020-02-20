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
	   		
	   		String user_id = request.getParameter("user_id");
	   		String user_passwd = request.getParameter("user_password");
	   		
	   		UserLoginService userLoginService = new UserLoginService();
	   		UserBean user = userLoginService.login(user_id,user_passwd);
	   		ActionForward forward = null;
	   		if(user!=null){
	   	    forward = new ActionForward();
	   		session.setAttribute("user",user);
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
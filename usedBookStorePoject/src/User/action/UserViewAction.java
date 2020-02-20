package User.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import User.svc.UserViewService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserViewAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	HttpSession session=request.getSession();
		 	UserBean loginUser = (UserBean)session.getAttribute("user");
	   		String userGrade = loginUser.getUser_grade(); 
	   		ActionForward forward = null;
	   		
	   		if(!(userGrade.equals("A")||userGrade.equals("B"))){
	   			response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('관리자가 아닙니다.');");
		   		out.println("location.href='/UserLogin.me");
		   		out.println("</script>");
	   		}
	   		
	   		else{
	   		forward = new ActionForward();
	   		String viewId=request.getParameter("id");
	   		UserViewService userViewService = new UserViewService();
	   		System.out.println(viewId);
	   		UserBean viewUser= userViewService.getUser(viewId);
	   		request.setAttribute("viewUser", viewUser);
	   		forward.setPath("./user_info.jsp");
	   		}
	   		return forward;
	}

	private Object user_grade() {
		// TODO Auto-generated method stub
		return null;
	}
}
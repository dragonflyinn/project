package User.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.svc.UserListService;
import action.Action;
import vo.ActionForward;
import vo.UserBean;

public class UserListAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	HttpSession session=request.getSession();
	   		String id=(String)session.getAttribute("id");
	   		System.out.println("action"+id);
	   		ActionForward forward = null;
	   		if(id==null){
	   			forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("/UserLogin.me");  
	   		}else if(!id.equals("admin")){
	   			response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('관리자가 아닙니다.');");
		   		out.println("location.href='/UserLogin.me");
		   		out.println("</script>");
	   		}
	   		else{
	   	    forward = new ActionForward();
	   	    UserListService userListService = new UserListService();
	   		ArrayList<UserBean> userList=UserListService.getUserList();
	   		request.setAttribute("userList", userList);
	   		forward.setPath("/user_list.jsp");
	   		}
	   		return forward;
	}
}
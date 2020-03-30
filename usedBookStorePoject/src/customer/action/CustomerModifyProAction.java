package customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import customer.svc.CustomerModifyProService;
import vo.ActionForward;
import vo.BoardBean;
import vo.UserBean;

public class CustomerModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		HttpSession session=request.getSession();
	 	UserBean loginUser = (UserBean)session.getAttribute("user");
   		String userGrade = loginUser.getUser_grade(); 
   		ActionForward forward = null;
   		
		boolean isModifySuccess = false;
		int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
		BoardBean article=new BoardBean();
		CustomerModifyProService boardModifyProService = new CustomerModifyProService();
		//여기도 세션

		if(!(userGrade.equals("A")||userGrade.equals("B"))){
   			response.setContentType("text/html;charset=UTF-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('수정할 권한이 없습니다.');");
	   		out.println("location.href='/userLogin.me");
	   		out.println("</script>");
   		}
		
		else{
			article.setPost_serial_number(post_serial_number);
			article.setPost_title(request.getParameter("post_title"));
			article.setPost_content(request.getParameter("post_content")); 
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
		
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?post_serial_number="+article.getPost_serial_number()); 
			}

		}

		return forward;
	}

}
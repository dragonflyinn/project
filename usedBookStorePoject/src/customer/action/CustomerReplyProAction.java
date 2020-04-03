package customer.action;

import java.io.PrintWriter;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import customer.svc.CustomerReplyProService;
import vo.ActionForward;
import vo.BoardBean;
import vo.UserBean;

public class CustomerReplyProAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 
		 	ActionForward forward = null;
		    String nowPage = request.getParameter("page");
			
			BoardBean article = new BoardBean();
		 	article.setWriting_user_serial_number(Integer.parseInt(request.getParameter("writing_user_serial_number")));
		 	article.setPost_title(request.getParameter("post_title"));
		 	article.setPost_content(request.getParameter("post_content"));
		 	article.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		 	article.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		 	article.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		 	
		 	CustomerReplyProService boardReplyProService = new CustomerReplyProService();
		 	boolean isReplySuccess = boardReplyProService.replyArticle(article);
		 	
	   		if(isReplySuccess){
	   			forward = new ActionForward();
	   			forward.setRedirect(true);
	   			forward.setPath("boardList.board?page=" + nowPage);
	   		}
	   		else{
	   			response.setContentType("text/html;charset=UTF-8");
	   			PrintWriter out = response.getWriter();
	   			out.println("<script>");
	   			out.println("alert('답글 실패')");
	   			out.println("history.back()");
	   			out.println("</script>");
	   		}
	   		
	   		return forward;
	   		
	}  	
	 
}
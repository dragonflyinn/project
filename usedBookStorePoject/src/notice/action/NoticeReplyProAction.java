package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import notice.svc.NoticeReplyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeReplyProAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 throws Exception{
		 
		 	ActionForward forward = null;
		    String nowPage = request.getParameter("page");
		 	NoticeBean article = new NoticeBean();  		
		 	article.setBoard_num(Integer.parseInt(request.getParameter("BOARD_NUM")));
		 	article.setBoard_subject(request.getParameter("BOARD_SUBJECT"));
		 	article.setBoard_content(request.getParameter("BOARD_CONTENT"));
		 	article.setBoard_re_ref(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
		 	article.setBoard_re_lev(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
		 	article.setBoard_re_seq(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));	   		
		 	NoticeReplyProService boardReplyProService = new NoticeReplyProService();
		 	boolean isReplySuccess = boardReplyProService.replyArticle(article);
		 	
	   		if(isReplySuccess){
	   			forward = new ActionForward();
	   			forward.setRedirect(true);
	   			forward.setPath("boardList.bo?page=" + nowPage);
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
package notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import notice.svc.NoticeDeleteProService;
import vo.ActionForward;

public class NoticeDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 
		
		HttpSession session = request.getSession();
		String user_grade = (String) session.getAttribute("user_grade");
		String user = (String) session.getAttribute("user");
		ActionForward forward = null;
		
		int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
		String nowPage = request.getParameter("page");
		NoticeDeleteProService noticeDeleteProService = new NoticeDeleteProService();

		if (!(user_grade.equals("A") || user_grade.equals("B"))) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}

		else{
			
			boolean isDeleteSuccess = noticeDeleteProService.removeArticle(post_serial_number);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("noticeList.notice?page=" + nowPage);
			}
			
		}


		return forward;
	}

}
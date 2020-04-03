package customer.action;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;

import action.Action;
import customer.svc.CustomerDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class CustomerReplyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 	ActionForward forward = new ActionForward();
	   		String nowPage = request.getParameter("page");
	   		System.out.println("리플라이 폼 액션: 현재페이지"+nowPage);
	   		
	   		int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
	   		CustomerDetailService boardDetailService = new CustomerDetailService();
	   		BoardBean article=boardDetailService.getArticle(post_serial_number);	
	   		request.setAttribute("article", article);
	   		System.out.println("리플라이 폼 액션 아티클: "+article);
	   		request.setAttribute("page", nowPage);
	   		forward.setPath("/customerBoard/customer_board_reply.jsp");
	   		return forward;
	   		
	}
	 
}
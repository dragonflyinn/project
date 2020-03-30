package customer.action;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import action.Action;
import customer.svc.CustomerDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class CustomerModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int post_serial_number=Integer.parseInt(request.getParameter("post_serial_number"));
			CustomerDetailService boardDetailService
			= new CustomerDetailService();	
			BoardBean article =boardDetailService.getArticle(post_serial_number);
			System.out.println("11"+post_serial_number);
		   	request.setAttribute("article", article);
	   		forward.setPath("/customerBoard/customer_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}
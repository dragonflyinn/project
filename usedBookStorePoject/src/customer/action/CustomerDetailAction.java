package customer.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import Common.getId;
import action.Action;
import customer.svc.CustomerDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class CustomerDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int post_serial_number = Integer.parseInt(request.getParameter("post_serial_number"));
		String page = request.getParameter("page");
		System.out.println("커스토머 디테일 페이지:"+page);
		
		CustomerDetailService boardDetailService = new CustomerDetailService();
		BoardBean article = boardDetailService.getArticle(post_serial_number);
		
		getId getIdService = new getId();
		String user_id = getIdService.getIdBySerial(article.getWriting_user_serial_number());
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		request.setAttribute("writingUserID", user_id);
		System.out.println("커스토머 디테일 포스트넘버:" + article.getPost_serial_number());
		forward.setPath("/customerBoard/customer_board_view.jsp");
		return forward;

	}

}
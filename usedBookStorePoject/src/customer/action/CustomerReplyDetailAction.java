package customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

import Common.getId;
import customer.svc.CustomerReplyDetailService;

import vo.BoardBean;

public class CustomerReplyDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int post_serial_number = Integer.parseInt(request.getParameter("post_serial_number"));
		String page = request.getParameter("page");
		
		CustomerReplyDetailService boardReplyDetailService = new CustomerReplyDetailService();
		BoardBean article = boardReplyDetailService.getArticle(post_serial_number);
		
		getId getIdService = new getId();
		String user_id = getIdService.getIdBySerial(article.getWriting_user_serial_number());
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		request.setAttribute("writingUserID", user_id);
		forward.setPath("/customerBoard/customer_board_reply_view.jsp");
		return forward;

	}

}

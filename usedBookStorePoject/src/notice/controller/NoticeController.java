package notice.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import notice.action.NoticeDeleteProAction;
import notice.action.NoticeDetailAction;
import notice.action.NoticeListAction;
import notice.action.NoticeModifyFormAction;
import notice.action.NoticeModifyProAction;
import notice.action.NoticeViewAction;
import notice.action.NoticeWriteProAction;
import vo.ActionForward;

@WebServlet("*.notice")
public class NoticeController extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("/noticeWriteForm.notice")) {
			forward = new ActionForward();
			forward.setPath("/noticeBoard/notice_board_write.jsp");
		} else if (command.equals("/noticeWritePro.notice")) {
			action = new NoticeWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/noticeList.notice")) {
			action = new NoticeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/noticeDetail.notice")) {
			action = new NoticeDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/noticeModifyForm.notice")) {
			action = new NoticeModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/noticeModifyPro.notice")) {
			action = new NoticeModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/noticeDeleteForm.notice")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int post_serial_number = Integer.parseInt(request.getParameter("post_serial_number"));
			request.setAttribute("post_serial_number", post_serial_number);
			forward = new ActionForward();
			forward.setPath("/noticeBoard/notice_board_delete.jsp");
		} else if (command.equals("/noticeDeletePro.notice")) {
			action = new NoticeDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
System.out.println("에러잡자"+forward.getPath());
		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
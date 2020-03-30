package customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import customer.action.CustomerDeleteProAction;
import customer.action.CustomerDetailAction;
import customer.action.CustomerListAction;
import customer.action.CustomerModifyFormAction;
import customer.action.CustomerModifyProAction;
import customer.action.CustomerReplyFormAction;
import customer.action.CustomerReplyProAction;
import customer.action.CustomerWriteProAction;
import vo.ActionForward;

@WebServlet("*.board")
public class CustomerFrontController extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		
		if (command.equals("/boardWriteForm.board")) {
			forward = new ActionForward();
			forward.setPath("/customerBoard/customer_board_write.jsp");
		
		} else if (command.equals("/customer.board")) {
			action = new CustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardWritePro.board")) {
			action = new CustomerWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardList.board")) {
			action = new CustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.board")) {
			action = new CustomerDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.board")) {
			action = new CustomerReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyPro.board")) {
			action = new CustomerReplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyForm.board")) {
			action = new CustomerModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyPro.board")) {
			action = new CustomerModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeleteForm.board")) {
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int post_serial_number = Integer.parseInt(request.getParameter("post_serial_number"));
			request.setAttribute("post_serial_number", post_serial_number);
			forward = new ActionForward();
			forward.setPath("/customerBoard/customer_board_delete.jsp");
		} else if (command.equals("/boardDeletePro.board")) {
			action = new CustomerDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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
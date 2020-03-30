package admin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import admin.action.AdminDeleteAction;
import admin.action.AdminInfoModifyAction;
import admin.action.AdminInfoModifyProAction;
import admin.action.AdminListAction;
import admin.action.AdminViewAction;
import vo.ActionForward;

@WebServlet("*.admin")
public class AdminController extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		if (command.equals("/main.admin")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/main.jsp");
		} else if (command.equals("/loginForm.admin")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/loginForm.jsp");
		} else if (command.equals("/adminModify.admin")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/adminModifyForm.jsp");
		} else if (command.equals("/adminListAction.admin")) {
			action = new AdminListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminViewAction.admin")) {
			action = new AdminViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminDeleteAction.admin")) {
			action = new AdminDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminInfoModifyAction.admin")) {
			action = new AdminInfoModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/adminInfoModifyProAction.admin")) {
			action = new AdminInfoModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(forward.getPath());
		
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
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
}
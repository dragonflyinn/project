package User.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import User.action.UserDeleteAction;
import User.action.UserInfoModifyAction;
import User.action.UserInfoModifyProAction;
import User.action.UserJoinAction;
import User.action.UserListAction;
import User.action.UserLoginAction;
import User.action.UserViewAction;
import vo.ActionForward;

@WebServlet("*.me")
public class UserFrontController extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		if (command.equals("/userLogin.me")) {
			forward = new ActionForward();
			forward.setPath("/loginForm.jsp");
		} else if (command.equals("/userLogout.me")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.jsp");
		} else if (command.equals("/userJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/joinForm.jsp");
		} else if (command.equals("/userModify.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/modifyForm.jsp");
		} else if (command.equals("/main.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/main.jsp");
		} else if (command.equals("/userLoginAction.me")) {
			action = new UserLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userJoinAction.me")) {
			action = new UserJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userListAction.me")) {
			action = new UserListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userViewAction.me")) {
			action = new UserViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userDeleteAction.me")) {
			action = new UserDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userInfoModifyAction.me")) {
			action = new UserInfoModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userInfoModifyProAction.me")) {
			action = new UserInfoModifyProAction();
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
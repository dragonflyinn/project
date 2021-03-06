package customer.action;

import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import customer.svc.CustomerListService;
import customer.svc.CustomerReplyListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class CustomerListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		CustomerListService boardListService = new CustomerListService();

		int listCount = boardListService.getListCount();
		System.out.println(listCount);

		articleList = boardListService.getArticleList(page, limit);
		
		int maxPage = (int) ((double)listCount/limit+0.95);

		int startPage = (((int) ((double) page/10+0.9)) -1) * 10+1;
		
		int endPage = startPage+10-1;
		
		if(endPage> maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		System.out.println("커스토머 리스트 액션 엔드 페이지:" + pageInfo.getEndPage());
		System.out.println("커스토머 리스트 액션 리스트 카운트:" + pageInfo.getListCount());
		System.out.println("커스토머 리스트 액션 리스트 겟 페이지:" + pageInfo.getPage());
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("customer.jsp");

		return forward;

	}

}
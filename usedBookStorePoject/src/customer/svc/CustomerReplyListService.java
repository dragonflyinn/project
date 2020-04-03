package customer.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardReplyDAO;
import vo.BoardBean;

public class CustomerReplyListService {

	public int getListCount() {
		// TODO Auto-generated method stub
		int listCount = 0;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		listCount = boardReplyDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<BoardBean> getReplyList(int post_serial_number) {
		// TODO Auto-generated method stub
		ArrayList<BoardBean> replyList = null;
		Connection con = getConnection();
		BoardReplyDAO boardReplyDAO = BoardReplyDAO.getInstance();
		boardReplyDAO.setConnection(con);
		replyList = boardReplyDAO.selectReplyList(post_serial_number);
		close(con);
		return replyList;
	}

}

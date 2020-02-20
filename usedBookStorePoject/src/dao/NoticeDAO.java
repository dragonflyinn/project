package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.NoticeBean;

public class NoticeDAO {

	DataSource ds;
	Connection con;
	private static NoticeDAO noticeDAO;

	private NoticeDAO() {
		// TODO Auto-generated constructor stub
	}

	public static NoticeDAO getInstance(){
		if(noticeDAO == null){
			noticeDAO = new NoticeDAO();
		}
		return noticeDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	//글의 개수 구하기.
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{


			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from customer_board");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	//글 목록 보기.	
	public ArrayList<NoticeBean> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="SELECT * FROM customer_board ORDER BY board_re_ref DESC,board_re_seq ASC LIMIT ?,10";
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		NoticeBean board = null;
		int startrow=(page-1)*10; //읽기 시작할 row 번호..	

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				board = new NoticeBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
				articleList.add(board);
			}

		}catch(Exception ex){
			System.out.println("getBoardList 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	//글 내용 보기.
	public NoticeBean selectArticle(int board_num){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBean noticeBean = null;

		try{
			pstmt = con.prepareStatement(
					"SELECT * FORM customer_board WHERE board_num = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();

			if(rs.next()){
				noticeBean = new NoticeBean();
				noticeBean.setBoard_num(rs.getInt("board_num"));
				noticeBean.setBoard_subject(rs.getString("board_subject"));
				noticeBean.setBoard_content(rs.getString("board_content"));
				noticeBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				noticeBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				noticeBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				noticeBean.setBoard_readcount(rs.getInt("board_readcount"));
				noticeBean.setBoard_date(rs.getDate("board_date"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return noticeBean;

	}

	//글 등록.
	public int insertArticle(NoticeBean article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			pstmt=con.prepareStatement("SELECT MAX(board_num) FROM customer_board");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="INSERT INTO customer_board (board_num,board_subject,board_content";
			sql+="board_re_ref,board_re_lev,board_re_seq,board_readcount"+
					"board_date) VALUES(?,?,?,?,?,?,?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(4, article.getBoard_subject());
			pstmt.setString(5, article.getBoard_content());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);

			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("boardInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 답변.
	public int insertReplyArticle(NoticeBean article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql="SELECT MAX(board_num) FROM customer_board";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref=article.getBoard_re_ref();
		int re_lev=article.getBoard_re_ref();
		int re_seq=article.getBoard_re_seq();

		try{
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			sql="UPDATE customer_board SET board_re_seq=board_re_seq+1 WHERE board_re_ref=? ";
			sql+="AND board_re_seq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0){
				commit(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			sql="INSERT INTO customer_board (board_num,board_subject,board_content";
			sql+="board_re_ref,board_re_lev,board_re_seq,board_readcount";
			sql+="board_date) VALUES(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(4, article.getBoard_subject());
			pstmt.setString(5, article.getBoard_content());
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("boardReply 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 수정.
	public int updateArticle(NoticeBean article){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="UPDATE customer_board SET board_subject=?,board_content=? WHERE board_num=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBoard_subject());
			pstmt.setString(2, article.getBoard_content());
			pstmt.setInt(3, article.getBoard_num());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	//글 삭제.
	public int deleteArticle(int board_num){

		PreparedStatement pstmt = null;
		String board_delete_sql="DELETE FROM customer_board WHERE board_num=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}

	//조회수 업데이트.
	public int updateReadCount(int board_num){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="UPDATE customer_board SET board_readcount = "+
				"board_readcount+1 WHERE board_num = "+board_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	//글쓴이인지 확인.
	public boolean isArticleBoardWriter(int board_num,String pass){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="SELECT * FROM customer_board WHERE board_num=?";
		boolean isWriter = false;

		try{
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("BOARD_PASS"))){
				isWriter = true;
			}
		}catch(SQLException ex){
			System.out.println("isBoardWriter 에러 : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}

}
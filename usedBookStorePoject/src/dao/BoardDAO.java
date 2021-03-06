package dao;

import static db.JdbcUtil.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import Common.getId;
import vo.BoardBean;
import vo.UserBean;

public class BoardDAO {

	DataSource ds;
	Connection con;
	
	private static BoardDAO noticeDAO;

	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getInstance(){
		if(noticeDAO == null){
			noticeDAO = new BoardDAO();
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
			pstmt=con.prepareStatement("select count(*) from board");
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
	public ArrayList<BoardBean> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="SELECT * FROM board ORDER BY post_serial_number DESC LIMIT ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow=(page-1)*10; //읽기 시작할 row 번호..	

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				board = new BoardBean();
				
				board.setPost_serial_number(rs.getInt("post_serial_number"));
				board.setUser_serial_number(rs.getInt("user_serial_number"));
				getId getIdService = new getId();
				String user_id = getIdService.getIdBySerial(board.getUser_serial_number());
				board.setUser_id(user_id);
				board.setPost_title(rs.getString("post_title"));
				board.setPost_content(rs.getString("post_content"));
				board.setPost_readcount(rs.getInt("post_readcount"));
				board.setPost_date(rs.getDate("post_date"));
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
	public BoardBean selectArticle(int post_serial_number){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try{
			pstmt = con.prepareStatement(
					"SELECT * FROM board WHERE post_serial_number = ?");
			pstmt.setInt(1, post_serial_number);
			rs= pstmt.executeQuery();

			if(rs.next()){
				boardBean = new BoardBean();
				boardBean.setPost_serial_number(rs.getInt("post_serial_number"));
				System.out.println(rs.getInt("post_serial_number"));
				boardBean.setUser_serial_number(rs.getInt("user_serial_number"));
				System.out.println(rs.getInt("user_serial_number"));
				boardBean.setPost_title(rs.getString("post_title"));
				System.out.println(rs.getString("post_title"));
				boardBean.setPost_content(rs.getString("post_content"));
				System.out.println(rs.getString("post_content"));
				boardBean.setPost_readcount(rs.getInt("post_readcount"));
				System.out.println(rs.getInt("post_readcount"));
				boardBean.setPost_date(rs.getDate("post_date"));
			}
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	//글 등록.
	public int insertArticle(BoardBean article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			sql="INSERT INTO board (user_serial_number,post_title,post_content,";
			sql+="post_readcount,post_date) VALUES(?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getUser_serial_number());
			pstmt.setString(2, article.getPost_title());
			pstmt.setString(3, article.getPost_content());
			pstmt.setInt(4, 0);
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("boardInsert 에러 : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 수정.
	public int updateArticle(BoardBean article){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="UPDATE board SET post_title=?,post_content=? WHERE post_serial_number=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getPost_title());
			pstmt.setString(2, article.getPost_content());
			pstmt.setInt(3, article.getPost_serial_number());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	//글 삭제.
	public int deleteArticle(int post_serial_number){

		PreparedStatement pstmt = null;
		String board_delete_sql="DELETE FROM board WHERE post_serial_number=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, post_serial_number);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("boardDelete 에러 : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}

	//조회수 업데이트.
	public int updateReadCount(int post_serial_number){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="UPDATE board SET post_readcount = "+
				"post_readcount+1 WHERE post_serial_number = "+post_serial_number;

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

	public boolean isArticleBoardWriter(int post_serial_number, UserBean loginuser) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="SELECT * FROM board WHERE post_serial_number=?";
		boolean isWriter = false;
		
		try {
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1,post_serial_number);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(loginuser.equals(rs.getString("loginuser"))) {
				isWriter = true;
			}
		}catch(SQLException ex) {
			System.out.println("isBoardWriter 에러: "+ex);
		}
		finally {
			close(pstmt);
		}
		return isWriter;
	}
}
	//글쓴이인지 확인. 세션이 있으니까 괜찮다. 비로그인 상태에서 적는 게시판일 경우 확인이 필요하니까 isArticleBoardWriter(int porst_serial_number,string pass)부분이 필요하다.
package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;



public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		// TODO Auto-generated method stub
		try {
			//1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jspuserc", "jsp1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {				// finally : try, catch 중 하나가 실행 되지만, 둘중 무엇이 실행되어도 finally는 실행된다.
			
		}
	}
	
	
	
	
	
	//기능 추가
	//글쓰기
	public int insertBoard(Board board) {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, default, default, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getAttachment());
			
			int result = pstmt.executeUpdate();	//실행
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	//리스트
	public List<Board> selectAllBoards() {
		String sql = "select * from board order by num desc";
		
		List<Board> list = new ArrayList<Board>();	
		
			try {
				pstmt = con.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Board board = new Board();
					
					board.setNum(rs.getInt("num"));
					board.setTitle(rs.getString("title"));
					board.setName(rs.getString("name"));
					board.setWdate(rs.getDate("wdate"));
					board.setHits(rs.getInt("hits"));
					
					//리스트에 값을 담는 것.
					list.add(board);
				}				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return list;
	}
	
	
	
	
	
	
	
	// 상세보기
	public Board seletOnBoardByNum(int num) {
		String sql = "select * from board where num=?";
		Board board = new Board();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//표시해줄 것 입력
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setAttachment(rs.getString("attachment"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	
	
	
	
	
	
	
	// 조회수 증가
	public void updateHits(int num) {
		String sql = "update board set hits = hits + 1 where num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	public int deleteBoard(int num) {
		return num;
	}
	
	
	
	public int updateBoard(Board board) {
		
		return 0;

	}
	
	
	/*
	 
	- 수정하기
	  2가지 기능해야 한다.
	  업데이트폼 액션
 	  업데이트 액션
 	  따라서 write와 같지만, sql문장이 달라진다. update로
 	  
 	  또한, 이미 입력된 정보가 써 있어야 되 
 	  update.jsp 에서
	
	*/
	
	

}

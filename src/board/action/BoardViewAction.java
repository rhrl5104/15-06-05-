package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("BoardViewAction 도착");
		
		
		// 컨트롤러에서 num 받아오기
		String num = request.getParameter("num");
		
		
		
		// DB에서 데이터 가져오기
		BoardDAO dao = new BoardDAO();
		Board board = dao.seletOnBoardByNum(Integer.parseInt(num));

		
		// 조회수 증가
		dao.updateHits(Integer.parseInt(num));
		
		
		request.setAttribute("board", board);
		
		
		//해당하는 페이지로 이동
		String url = "./board/view.jsp";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); //예외처리 하자, throws
	}

	
	

}

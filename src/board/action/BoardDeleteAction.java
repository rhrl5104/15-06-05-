package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardDeleteAction 도착");
		
		// 컨트롤러에서 num 받아오기
		String num = request.getParameter("num");
	
		// DB에서 데이터 가져오기
		BoardDAO dao = new BoardDAO();
		int board = dao.deleteBoard(Integer.parseInt(num));
		
		
		/*//해당하는 페이지로 이동
		String url = "./board/list.jsp";	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); //예외처리 하자, throws
		*/
		

	}

}

package board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardListAction 도착");
		
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.selectAllBoards(); 
		
		request.setAttribute("list", list);
		
		
		//url을 변경하지 않으면서 이동시키는 것. => 포워드 방식
		System.out.println("excute 도착");
		
		String url = "./board/list.jsp";	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response); //예외처리 하자, throws
	}


}

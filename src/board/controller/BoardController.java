package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardDeleteAction;
import board.action.BoardListAction;
import board.action.BoardUpdateAction;
import board.action.BoardViewAction;
import board.action.BoardWriteAction;
import board.action.BoardWriteFormAction;

/**
 * Servlet implementation class BoardController
 */
//@WebServlet("/BoardController")		
@WebServlet("*.board")		//앞에 상관없이 .board 면 실행.
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("GG");
		doProcess(request, response);
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("GG");
		
		
		//contextPath = 프로젝트 기본 이름
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		//uri = 주소이름
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//uri를 잘라주는 것.
		String command = uri.substring(contextPath.length());
		//System.out.println("command : " + command);
		
		
		
		
		//글쓰기 폼
		if(command.equals("/writeForm.board")) {
			//해당 클레스를 사용하기 위해 객체를 생성해준것.  
			//자식으로 만들어 부모로 담는다. (동적 바인딩 -> 실행시간에 어떤 메소드로 할지 결정하는 것)
			Action action = new BoardWriteFormAction();
			//excute메소드를 사용하기 위함.
			action.execute(request, response);
		}

		
		
		
		//글쓰기
		else if(command.equals("/write.board")) {
			System.out.println("BoardController 글쓰기 도착");
			Action action = new BoardWriteAction();
			action.execute(request, response);
		}
		
		
		
		
		//리스트
		else if(command.equals("/list.board")) {
			System.out.println("BoardController 리스트 도착");
			Action action = new BoardListAction();
			action.execute(request, response);

		}
		
		//뷰
		else if(command.equals("/view.board")) {
			System.out.println("BoardController 뷰 도착");
			Action action = new BoardViewAction();
			action.execute(request, response);
			
		}		
		
		
		//딜리트
		else if(command.equals("/delete.board")) {
			System.out.println("BoardController 딜리트 도착");
			Action action = new BoardDeleteAction();
			action.execute(request, response);
			
		}		
		
		
		//업데이트
		else if(command.equals("/update.board")) {
			System.out.println("BoardController 업데이트 도착");
			Action action = new BoardUpdateAction();
			action.execute(request, response);
			
		}				
		
	}

}

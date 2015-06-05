//비지니스 계층

package board.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardWriteAction 도착");
		
/*		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");*/
		
	
		ServletContext context = request.getServletContext();
		String uploadpath = context.getRealPath("upload");
		//System.out.println(uploadpath);
		
		//파일 업로드 하기위해...
		MultipartRequest multi = new MultipartRequest(request, uploadpath, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String fileName = multi.getFilesystemName("file");
		
		//System.out.println(fileName);
		

     	//Board 사용 위해 객체 생성
		Board board = new Board();	
		
		//dto과정으로 DAO로 보내자
		board.setName(name);
		board.setTitle(subject);
		board.setContent(content);
		board.setAttachment(fileName);
		
		//BoardDAO 사용 위해 객체 생성
		BoardDAO dao = new BoardDAO();
		
		
		
		//list.board로 가기 위해
		int result = dao.insertBoard(board);
		
		if(result != 0) {
			String url = "list.board";
			response.sendRedirect(url);
		}
	}

}

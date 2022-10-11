package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentDeleteDAOImpl;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardCommentDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//session
		HttpSession session = request.getSession();
		String gCommentID = request.getParameter("gCommentID") == null ? "" : request.getParameter("gCommentID");
		String gPostingID = request.getParameter("gPostingID") == null ? "" : request.getParameter("gPostingID");
	
		/*-----------------------comment delete impl----------------------------*/
		BoardService boardService = new BoardConmentDeleteDAOImpl();
		boardService.conmentDeleteBoard(Integer.parseInt(gCommentID));
		
		request.setAttribute("gPostingID", Integer.parseInt(gPostingID));
			
		return "/gboardview.do";
	}

}

package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardDeleteDAOImpl;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardDeleteBoardProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qPostingID = request.getParameter("qPostingID") == null ? "" : request.getParameter("qPostingID");
		
		/*--------------------------delete----------------------------*/ 
		BoardService boardService = new BoardDeleteDAOImpl();
		boardService.deleteQboard(Integer.parseInt(qPostingID));
		request.setAttribute("boardService", boardService);
		
		return "/qboardlist.do";
	}

}

package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardDeleteDAOImpl;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String gPostingID = request.getParameter("gPostingID") == null ? "" : request.getParameter("gPostingID");
		
		/*----------------------gbaord delete impl----------------------*/
		BoardService boardService = new BoardDeleteDAOImpl();
		boardService.deleteBoard(Integer.parseInt(gPostingID));
		
		request.setAttribute("boardService", boardService);
		
		return "/gboardlist.do";
	}

}

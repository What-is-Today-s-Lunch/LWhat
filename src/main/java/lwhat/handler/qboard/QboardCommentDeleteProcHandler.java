package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentDeleteDAOImpl;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardCommentDeleteProcHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// session
		HttpSession session = request.getSession();
		String qCommentID = request.getParameter("qCommentID") == null ? "" : request.getParameter("qCommentID");
		String qPostingID = request.getParameter("qPostingID") == null ? "" : request.getParameter("qPostingID");
		
		/*-----------------------commentDelete-------------------------------*/
		BoardService boardService = new BoardConmentDeleteDAOImpl();
		boardService.conmentDeleteQboard(Integer.parseInt(qCommentID));
		
		request.setAttribute("qPostingID", Integer.parseInt(qPostingID));

		return "/qboardview.do";
	}
}

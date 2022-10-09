package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardUpdateDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GbaordUpdateProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//session
		HttpSession session = request.getSession();
		
		String memberID = (String) session.getAttribute("memberID");
		String gPostingID = request.getParameter("gPostingID") == null ? "" : (String)request.getParameter("gPostingID");
		
		GboardDTO gboardDTO = new GboardDTO();
	    gboardDTO.setTitle(request.getParameter("title") == null ? "" : request.getParameter("title"));
	    gboardDTO.setContent(request.getParameter("content") == null ? "" : request.getParameter("content"));
	    gboardDTO.setBoardCategory(request.getParameter("boardCategory") == null ? "" : request.getParameter("boardCategory"));
		
	    BoardService boardService = new BoardUpdateDAOImpl();
	    gboardDTO.setgPostingID(Integer.parseInt(gPostingID));
	    boardService.updateBoard(gboardDTO, memberID);
	    request.setAttribute("boardService", boardService);
	    
	    return "/gboardlist.do";
	}

}

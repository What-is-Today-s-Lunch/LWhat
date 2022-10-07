package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentWrtieDAOImpl;
import lwhat.dto.GeneralcommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardCommentWriteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");

		String content = request.getParameter("content");
		String boardCategory = null;
		int gPostingID = 0;
		if (request.getParameter("gPostingID") != null) {
			gPostingID = Integer.parseInt(request.getParameter("gPostingID"));
		}
		BoardService boardService = new BoardConmentWrtieDAOImpl();
		GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
		generalcommentDTO.setContent(content);

		boardService.conmentWriteBoard(generalcommentDTO, memberID, boardCategory, gPostingID);
		request.setAttribute("boardService", boardService);
		request.setAttribute("gPostingID", gPostingID);
		
		return "/gboardview.do";
	}

}

package lwhat.handler.gboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentUpdateDAOImpl;
import lwhat.dto.GeneralcommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardCommentUpdateProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		
		String gCommentID = request.getParameter("gCommentID") == null ? "" : request.getParameter("gCommentID");
		String content = request.getParameter("content");

		int gPostingID = 0;
		if(request.getParameter("gPostingID") != null){
			gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
		}
		
		BoardService boardService = new BoardConmentUpdateDAOImpl();
		GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
		generalcommentDTO.setContent(content);
		generalcommentDTO.setgCommentID((Integer.parseInt(gCommentID)));


		boardService.conmentUpdateBoard(generalcommentDTO, memberID);
		request.setAttribute("boardService", boardService);
		
		request.setAttribute("gPostingID", gPostingID);
		request.setAttribute("gCommentID", gCommentID);
		 
			
		return "/gboardview.do";
	}

}

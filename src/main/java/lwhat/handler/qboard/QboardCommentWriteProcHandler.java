package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentWrtieDAOImpl;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardCommentWriteProcHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");

		String content = request.getParameter("content");
		int qPostingID = 0;
		if (request.getParameter("qPostingID") != null) {
			qPostingID = Integer.parseInt(request.getParameter("qPostingID"));
		}
		/* ------------------------------- comment write ----------------------------------------------*/
		BoardService boardService = new BoardConmentWrtieDAOImpl();
		QuestioncommentDTO questioncommentDTO = new QuestioncommentDTO();
		questioncommentDTO.setContent(content);

		boardService.conmentWriteQboard(questioncommentDTO, memberID, qPostingID);
		request.setAttribute("boardService", boardService);
		request.setAttribute("qPostingID", qPostingID);
		
		return "/qboardview.do";
	}
}

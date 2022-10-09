package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentUpdateDAOImpl;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardCommentUpdateProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		
		String qCommentID = request.getParameter("qCommentID") == null ? "" : request.getParameter("qCommentID");
		String content = request.getParameter("content");

		int qPostingID = 0;
		if(request.getParameter("qPostingID") != null){
			qPostingID =Integer.parseInt(request.getParameter("qPostingID"));
		}
		
		BoardService boardService = new BoardConmentUpdateDAOImpl();
		QuestioncommentDTO questioncommentDTO = new QuestioncommentDTO();
		questioncommentDTO.setContent(content);
		questioncommentDTO.setqCommentID((Integer.parseInt(qCommentID)));


		boardService.conmentUpdateQboard(questioncommentDTO, memberID);
		request.setAttribute("boardService", boardService);
		
		request.setAttribute("qPostingID", qPostingID);
		request.setAttribute("qCommentID", qCommentID);
		 
			
		return "/qboardview.do";
	}

}

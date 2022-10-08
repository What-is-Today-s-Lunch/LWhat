package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardUpdateDAOImpl;
import lwhat.dto.QboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardUpdateBoardProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		//session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		String qPostingID = request.getParameter("qPostingID") == null ? "" : (String)request.getParameter("qPostingID");
		QboardDTO qboardDTO = new QboardDTO();
		qboardDTO.setTitle(request.getParameter("title") == null ? "" : request.getParameter("title"));
		qboardDTO.setContent(request.getParameter("content") == null ? "" : request.getParameter("content"));
		qboardDTO.setboardCategory(request.getParameter("boardCategory") == null ? "" : request.getParameter("boardCategory"));
		
	    BoardService boardService = new BoardUpdateDAOImpl();
	    qboardDTO.setqPostingID(Integer.parseInt(qPostingID));
	    boardService.updateQboard(qboardDTO, memberID);
	    request.setAttribute("boardService", boardService);
		return "/qboardlist.do";
	}

}

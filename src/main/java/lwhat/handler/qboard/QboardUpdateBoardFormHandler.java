package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.board.QboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardUpdateBoardFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//session
				HttpSession session = request.getSession();
				String memberID = (String) session.getAttribute("memberID");
				int qPostingID = 0;
				if(request.getParameter("qPostingID") != null){
					qPostingID =Integer.parseInt(request.getParameter("qPostingID"));
				}
				
				BoardService boardService = new BoardViewDAOImpl();
				QboardDTO qboardDTO = new QboardDTO();
				qboardDTO.setqPostingID(qPostingID);
				qboardDTO = boardService.viewQboard(qPostingID);
				
				request.setAttribute("qPostingID", qboardDTO.getqPostingID());
				request.setAttribute("qboardDTO", qboardDTO);
		return "/jsp/board/qboard/QboardUpdate.jsp";
	}

}

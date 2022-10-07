package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GbaordUpdateFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		int gPostingID = 0;
		if(request.getParameter("gPostingID") != null){
			gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
		}
		BoardService boardService = new BoardViewDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		gboardDTO.setgPostingID(gPostingID);
		System.out.println("여기---->"+gboardDTO.getgPostingID());
		gboardDTO = boardService.viewBoard(gPostingID);
		System.out.println("여기---->"+gboardDTO.getgPostingID());
		request.setAttribute("gPostingID", gboardDTO.getgPostingID());
		request.setAttribute("gboardDTO", gboardDTO);
		return "/jsp/GboardUpdate.jsp";
	}

}

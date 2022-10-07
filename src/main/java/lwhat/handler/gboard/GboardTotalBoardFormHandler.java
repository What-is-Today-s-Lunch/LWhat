package lwhat.handler.gboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardTotalBoardFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		BoardService boardService = new BoardListDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		ArrayList<GboardDTO> list = boardService.listBoard(pageNumber);
		request.setAttribute("list", list);
		
		
		BoardListDAOImpl boardServiceNextPage = new BoardListDAOImpl();
		if(pageNumber != 1) {
		 String pn1 = "a";
		 request.setAttribute("pn1", pn1);
		}
		if(boardServiceNextPage.nextPage(pageNumber + 1)) {
			String pn2 = "b";
			request.setAttribute("pn2", pn2);
		}
		request.setAttribute("pageNumber", pageNumber);
		
		return "/jsp/totalBoardForm.jsp";
	}

}

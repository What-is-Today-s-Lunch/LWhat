package lwhat.handler.gboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dao.impl.code.CodeDAOImpl;
import lwhat.dto.CodeTableDTO;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;
import lwhat.service.code.CodeService;

public class GboardListBoardFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		BoardService boardService = new BoardListDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		ArrayList<GboardDTO> list = boardService.listBoard(pageNumber);
		request.setAttribute("list", list);
		
		/* -------------------------codetable 값 변환-----------------------------------------------*/
		CodeTableDTO code = null;
		CodeService findcodename = new CodeDAOImpl();
		
		for (int i = 0; i < list.size(); i++) {
			code = findcodename.codeView(list.get(i).getBoardCategory());
			String boardCategory = code.getCodeName();//코드값에 해당하는 코드이름을 보여줌 
			list.get(i).setBoardCategory(boardCategory);
		}
		/*----------------------------------------------------------------------------------------*/
		
		
		int numBer = 1;
		for (int i = 0; i < list.size(); i++) {
			numBer++;
			request.setAttribute("nemBer", numBer);
		}
		
		BoardListDAOImpl boardServiceNextPage = new BoardListDAOImpl();
		if (pageNumber != 1) {
			String pageBefore = "pageBefore";
			request.setAttribute("pageBefore", pageBefore);
		}
		if (boardServiceNextPage.nextPage(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}
		request.setAttribute("pageNumber", pageNumber);

		return "/jsp/board/gboard/GboardListForm.jsp";
	}
}

package lwhat.handler.gboard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		BoardService boardService = new BoardListDAOImpl();
		ArrayList<GboardDTO> list = boardService.listBoard(pageNumber);
		request.setAttribute("list", list);

		/*-------------------------codetable 값변환 닉네임 가져오기----------------------------------------------- */
		CodeTableDTO code = null;
		CodeService findcodename = new CodeDAOImpl();
		BoardListDAOImpl getter = new BoardListDAOImpl();

		for (int i = 0; i < list.size(); i++) {
			code = findcodename.codeView(list.get(i).getBoardCategory());
			String boardCategory = code.getCodeName();
			list.get(i).setBoardCategory(boardCategory);
			list.get(i).setMemberID_FK(getter.getNickName(list.get(i).getMemberID_FK()));
		}
		/*----------------------------------------------------------------------------------------*/

		int numBer = 1;
		for (int i = 0; i < list.size(); i++) {
			numBer++;
			request.setAttribute("nemBer", numBer);
		}

		if (pageNumber != 1) {
			String pageBefore = "pageBefore";
			request.setAttribute("pageBefore", pageBefore);
		}
		if (getter.nextPage(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}
		request.setAttribute("pageNumber", pageNumber);

		request.setAttribute("postsCount", getter.getPostsCount("generalposting"));

		return "/jsp/board/gboard/GboardListForm.jsp";
	}
}

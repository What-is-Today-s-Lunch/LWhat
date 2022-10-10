package lwhat.handler.qboard;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dao.impl.code.CodeDAOImpl;
import lwhat.dto.CodeTableDTO;
import lwhat.dto.board.QboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;
import lwhat.service.code.CodeService;

public class QboardListBoardFormHandler implements CommandHandler {

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
		QboardDTO qboardDTO = new QboardDTO();
		ArrayList<QboardDTO> list = boardService.listQboard(pageNumber);
		request.setAttribute("list", list);

		/* -------------------------codetable 값변환 닉네임 가져오기-----------------------------------------------*/
		CodeTableDTO code = null;
		CodeService findcodename = new CodeDAOImpl();
		BoardListDAOImpl getter = new BoardListDAOImpl();
		
		for (int i = 0; i < list.size(); i++) {
			code = findcodename.codeView(list.get(i).getboardCategory());
			String boardCategory = code.getCodeName();//코드값에 해당하는 코드이름을 보여줌 
			list.get(i).setboardCategory(boardCategory);
			//list.get(i).setMemberID_FK(getter.getNickName(list.get(i).getMemberID_FK()));
		}
		/*----------------------------------------------------------------------------------------*/
		

		/*-------------------------------------- pageNext --------------------------------------*/
		if (pageNumber != 1) {
			String pageBefore = "pageBefore";
			request.setAttribute("pageBefore", pageBefore);
		}
		if (getter.qboardNextPage(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}
		request.setAttribute("pageNumber", pageNumber);
		/*----------------------------------------------------------------------------------------*/
		
		/* ---------------------------------------검색기능-----------------------------------------*/
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}

		String searchDomain = request.getParameter("searchDomain") == null ? "" : request.getParameter("searchDomain");
		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");

		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchDomain", searchDomain);
		searchMap.put("searchText", searchText);
		/*----------------------------------------------------------------------------------------*/

		request.setAttribute("postsCount", getter.getPostsCount("generalposting"));

		return "/jsp/board/qboard/QboardListForm.jsp";
	}

}

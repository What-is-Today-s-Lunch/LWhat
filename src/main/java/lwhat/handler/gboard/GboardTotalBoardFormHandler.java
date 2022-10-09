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
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		BoardService boardService = new BoardListDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		ArrayList<GboardDTO> list = boardService.listBoard(pageNumber);
		request.setAttribute("list", list);

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

		// 검색기능	
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException uee) {
//			uee.printStackTrace();
//		}
//
//		String searchDomain = request.getParameter("searchDomain") == null ? "" : request.getParameter("searchDomain");
//		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
//	
//		Map<String, String> searchMap = new HashMap<String, String>();
//		searchMap.put("searchDomain", searchDomain);
//		searchMap.put("searchText", searchText);
//
//		ArrayList<GboardDTO> GboardDTOList = null;
//		try {
//			GboardDTOList = new BoardListDAOImpl().listSearchBoard(searchDomain, searchText);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		request.setAttribute("GboardDTOList", GboardDTOList);
	

		return "/jsp/totalBoardForm.jsp";
	}
}

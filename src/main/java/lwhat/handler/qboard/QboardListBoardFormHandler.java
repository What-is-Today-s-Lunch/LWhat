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
import lwhat.dto.QboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardListBoardFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// session
		HttpSession session = request.getSession();
		
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		String memberPass = (String) session.getAttribute("memberPW");

		BoardService boardService = new BoardListDAOImpl();
		QboardDTO qboardDTO = new QboardDTO();
		ArrayList<QboardDTO> list = boardService.listQboard(pageNumber);
		request.setAttribute("list", list);

		BoardListDAOImpl boardServiceNextPage = new BoardListDAOImpl();
		if (pageNumber != 1) {
			String pn1 = "a";
			request.setAttribute("pn1", pn1);
		}
		if (boardServiceNextPage.qboardNextPage(pageNumber + 1)) {
			String pn2 = "b";
			request.setAttribute("pn2", pn2);
		}
		request.setAttribute("pageNumber", pageNumber);

		// 검색기능	
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

		List<QboardDTO> QboardDTOList = null;
		try {
			//QboardDTOList = new BoardListDAOImpl().listQboard(searchDomain, searchText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//request.setAttribute("GboardDTOList", GboardDTOList);
		
		
		return "/jsp/QboardListForm.jsp";
	}

}

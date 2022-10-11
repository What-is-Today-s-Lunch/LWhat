package lwhat.handler.gboard;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;

public class GboardSearchListFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		 
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}

		String searchDomain = request.getParameter("searchDomain") == null ? "" : request.getParameter("searchDomain");
		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
	
		/*------------------------------search-----------------------------------------*/
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchDomain", searchDomain);
		searchMap.put("searchText", searchText);
		
		ArrayList<GboardDTO> GboardSearchDTOList = null;
		try {
			GboardSearchDTOList = new BoardListDAOImpl().listSearchBoard(searchDomain, searchText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		request.setAttribute("GboardSearchDTOList", GboardSearchDTOList);
		
		return "/jsp/board/gboard/GboardSearchListForm.jsp";
	}
}

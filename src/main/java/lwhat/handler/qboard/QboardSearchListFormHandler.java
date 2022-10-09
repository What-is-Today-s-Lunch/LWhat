package lwhat.handler.qboard;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dto.board.QboardDTO;
import lwhat.handler.CommandHandler;

public class QboardSearchListFormHandler implements CommandHandler {

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

		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchDomain", searchDomain);
		searchMap.put("searchText", searchText);

		ArrayList<QboardDTO> QboardSearchDTOList = null;
		try {
			QboardSearchDTOList = new BoardListDAOImpl().listSearchQBoard(searchDomain, searchText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(QboardSearchDTOList);
		request.setAttribute("QboardSearchDTOList", QboardSearchDTOList);

		return "/jsp/board/qboard/QboardSearchListForm.jsp";
	}
}

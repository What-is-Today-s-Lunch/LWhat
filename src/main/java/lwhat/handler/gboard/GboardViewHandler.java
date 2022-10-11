package lwhat.handler.gboard;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentListDAOImpl;
import lwhat.dao.impl.board.BoardListDAOImpl;
import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.GeneralcommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");// object
		request.setAttribute("memberID", memberID);

		int gPostingID = 0;
		if (request.getParameter("gPostingID") != null) {
			gPostingID = Integer.parseInt(request.getParameter("gPostingID"));
		}

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		BoardService boardService = new BoardViewDAOImpl();
		BoardListDAOImpl boardlist = new BoardListDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		
		/*----------------gboard update delete check------------------------------*/
		gboardDTO = boardService.viewBoard(gPostingID);
		if (memberID.equals(gboardDTO.getMemberID_FK())) {
			request.setAttribute("isSameWriter", "true");
		}
		/*----------------------------------------------------------------------------*/
		gboardDTO.setMemberID_FK(boardlist.getNickName(gboardDTO.getMemberID_FK()));
		request.setAttribute("gboardDTO", gboardDTO);

		// 이미지
		String real = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/GboardImage";
		File viewFile = new File(real + "/" + gPostingID + "file.jpg");
		if (viewFile.exists()) {
			String imgExists = "imgExists";
			request.setAttribute("imgExists", imgExists);
		}

		/*---------------------------- comment ------------------------------------------*/
		BoardService boardListService = new BoardConmentListDAOImpl();
		ArrayList<GeneralcommentDTO> list = boardListService.conmentListBoard(pageNumber);
		ArrayList<GeneralcommentDTO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (gPostingID == list.get(i).getPostingID_FK()) {
				list1.add(list.get(i));
				request.setAttribute("list1", list1);
			} // if
		}
		/*----------------------------------------------------------------------------------*/

		/*---------------------------- comment page ---------------------------------------*/
		BoardConmentListDAOImpl boardCommentServiceNextPage = new BoardConmentListDAOImpl();
		if (pageNumber != 1) {
			String pageBefore = "pageBefore";
			request.setAttribute("pageBefore", pageBefore);
		}
		if (boardCommentServiceNextPage.nextPage(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}

		/*-----------------------------------------------------------------------------------*/
		request.setAttribute("pageNumber", pageNumber);

		return "/jsp/board/gboard/GboardView.jsp";
	}
}

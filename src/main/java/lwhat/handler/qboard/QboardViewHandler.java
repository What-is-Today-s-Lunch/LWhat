package lwhat.handler.qboard;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentListDAOImpl;
import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.board.QboardDTO;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");// object
		request.setAttribute("memberID", memberID);

		int qPostingID = 0;
		if (request.getParameter("qPostingID") != null) {
			qPostingID = Integer.parseInt(request.getParameter("qPostingID"));
		}

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// boardview
		BoardService boardService = new BoardViewDAOImpl();
		QboardDTO qboardDTO = new QboardDTO();
		qboardDTO = boardService.viewQboard(qPostingID);
		request.setAttribute("qboardDTO", qboardDTO);

		// 이미지
		String real = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/QboardImage";
		File viewFile = new File(real + "/" + qPostingID + "file.jpg");
		File viewFiles = new File(real + "/" + qPostingID + "files.jpg");
		if (viewFile.exists()) {
			String imgExistsFile = "imgExistsFile";
			request.setAttribute("imgExistsFile", imgExistsFile);
		}
		if (viewFiles.exists()) {
			String imgExistsFiles = "imgExistsFiles";
			request.setAttribute("imgExistsFiles", imgExistsFiles);
		}

		/*---------------------------- comment ------------------------------------------*/
		BoardService boardListService = new BoardConmentListDAOImpl();
		ArrayList<QuestioncommentDTO> list = boardListService.conmentListQboard(pageNumber);
		ArrayList<QuestioncommentDTO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (qPostingID == list.get(i).getqPostingID()) {
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
		if (boardCommentServiceNextPage.nextPageq(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}
		request.setAttribute("pageNumber", pageNumber);
		/*-----------------------------------------------------------------------------------*/
		// qboard update delete check
		if (memberID.equals(qboardDTO.getMemberID_FK())) {
			request.setAttribute("isSameWriter", "true");
		}

		return "/jsp/board/qboard/QboardView.jsp";
	}

}

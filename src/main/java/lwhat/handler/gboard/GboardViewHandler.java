package lwhat.handler.gboard;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentListDAOImpl;
import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.GeneralcommentDTO;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");// object

		int gPostingID = 0;
		if (request.getParameter("gPostingID") != null) {
			gPostingID = Integer.parseInt(request.getParameter("gPostingID"));
		}

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// boardview
		BoardService boardService = new BoardViewDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		gboardDTO = boardService.viewBoard(gPostingID);
		request.setAttribute("gboardDTO", gboardDTO);

		// 이미지
		String real = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/upload";
		File viewFile = new File(real + "/" + gPostingID + "file.jpg");
		if (viewFile.exists()) {
			String pn1 = "a";
			request.setAttribute("pn1", pn1);
		}

		// comment
		BoardService boardListService = new BoardConmentListDAOImpl();
		GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
		ArrayList<GeneralcommentDTO> list1 = boardListService.conmentListBoard(pageNumber);
		ArrayList<GeneralcommentDTO> list = new ArrayList<>();
		//System.out.println("---------------------" + gPostingID);
		//System.out.println("---------------------" + request.getParameter("gPostingID_FK"));
		for(int i = 0 ; i < list1.size(); i++) {    
			if (gPostingID == list1.get(i).getPostingID_FK()) {
				System.out.println("-------------" + gPostingID);
				System.out.println("-------------" + list1.get(i).getPostingID_FK());
				list.add(list1.get(1));
				request.setAttribute("list", list);
				if (memberID.equals(list1.get(i).getMemberID_FK())) {
					String pn2 = "b";
					request.setAttribute("pn2", pn2);
				} // if
			}// if
		}

		// comment page
		BoardConmentListDAOImpl boardCommentServiceNextPage = new BoardConmentListDAOImpl();
		if (pageNumber != 1) {
			String pn3 = "c";
			request.setAttribute("pn3", pn3);
		}
		if (boardCommentServiceNextPage.nextPage(pageNumber + 1)) {
			String pn4 = "d";
			request.setAttribute("pn4", pn4);
		}
		request.setAttribute("pageNumber", pageNumber);

		// gboard update delete check
		if (memberID.equals(gboardDTO.getMemberID_FK())) {
			String pn5 = "f";
			request.setAttribute("pn5", pn5);
		}

		return "/jsp/GboardView.jsp";
	}
}

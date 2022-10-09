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
		request.setAttribute("memberID", memberID);

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
			String imgExists = "imgExists";
			request.setAttribute("imgExists", imgExists);
		}

		// comment
		BoardService boardListService = new BoardConmentListDAOImpl();
		GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
		ArrayList<GeneralcommentDTO> list = boardListService.conmentListBoard(pageNumber);
		ArrayList<GeneralcommentDTO> list1 = new ArrayList<>();
		for(int i = 0 ; i < list.size(); i++) {    
			// 전체 리스트를 받아 게시물 댓글번호와 게시물번호가 같은것만 list1에 추가
			if (gPostingID == list.get(i).getPostingID_FK()) {
				list1.add(list.get(i));
				//특정게시물에 표시될 댓글 (list1)
				System.out.println("---------------------"+list.get(i));
				request.setAttribute("list1", list1);
				// 세션의 memberID와 list1의 memberID_FK가 같을때만 수정삭제 버튼 표시
			}// if
		}

		// comment page
		BoardConmentListDAOImpl boardCommentServiceNextPage = new BoardConmentListDAOImpl();
		if (pageNumber != 1) {
			String pageBefore = "pageBefore";
			request.setAttribute("pageBefore", pageBefore);
		}
		if (boardCommentServiceNextPage.nextPage(pageNumber + 1)) {
			String pageAfter = "pageAfter";
			request.setAttribute("pageAfter", pageAfter);
		}
		
		request.setAttribute("pageNumber", pageNumber);

		// gboard update delete check
		if (memberID.equals(gboardDTO.getMemberID_FK())) {
            request.setAttribute("isSameWriter", "true");
         }

		return "/jsp/GboardView.jsp";
	}
}

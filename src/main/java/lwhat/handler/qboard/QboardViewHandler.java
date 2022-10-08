package lwhat.handler.qboard;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.board.BoardConmentListDAOImpl;
import lwhat.dao.impl.board.BoardViewDAOImpl;
import lwhat.dto.QboardDTO;
import lwhat.dto.QuestioncommentDTO;
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
		String real = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/qupload";
		File viewFile = new File(real + "/" + qPostingID + "file.jpg");
		if (viewFile.exists()) {
			String pn1 = "a";
			request.setAttribute("pn1", pn1);
		}
		
		// comment
		BoardService boardListService = new BoardConmentListDAOImpl();
		QuestioncommentDTO questioncommentDTO = new QuestioncommentDTO();
		ArrayList<QuestioncommentDTO> list = boardListService.conmentListQboard(pageNumber);
		ArrayList<QuestioncommentDTO> list1 = new ArrayList<>();
		for(int i = 0 ; i < list.size(); i++) {    
			// 전체 리스트를 받아 게시물 댓글번호와 게시물번호가 같은것만 list1에 추가
			if (qPostingID == list.get(i).getqPostingID()) {
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
			String pn3 = "c";
			request.setAttribute("pn3", pn3);
		}
		if (boardCommentServiceNextPage.nextPageq(pageNumber + 1)) {
			String pn4 = "d";
			request.setAttribute("pn4", pn4);
		}
		request.setAttribute("pageNumber", pageNumber);

		// qboard update delete check
		if (memberID.equals(qboardDTO.getMemberID_FK())) {
            request.setAttribute("isSameWriter", "true");
         }
		
		
		return "/jsp/QboardView.jsp";
	}

}

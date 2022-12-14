package lwhat.handler.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class GboardCommentUpdateFormcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");

		int gCommentID = 0;
		if (request.getParameter("gCommentID") != null) {
			gCommentID = Integer.parseInt(request.getParameter("gCommentID"));
		}
		int gPostingID = 0;
		if (request.getParameter("gPostingID") != null) {
			gPostingID = Integer.parseInt(request.getParameter("gPostingID"));
		}
		
		String content = request.getParameter("content");
		
		request.setAttribute("gPostingID", gPostingID);
		request.setAttribute("gCommentID", gCommentID);
		request.setAttribute("content", content);
		 
		
		return "/jsp/board/gboard/GboardUpdateComment.jsp";
	}

}

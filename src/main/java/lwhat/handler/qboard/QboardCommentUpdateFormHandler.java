package lwhat.handler.qboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class QboardCommentUpdateFormHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");

		int qCommentID = 0;
		if (request.getParameter("qCommentID") != null) {
			qCommentID = Integer.parseInt(request.getParameter("qCommentID"));
		}
		
		int qPostingID = 0;
		if (request.getParameter("qPostingID") != null) {
			qPostingID = Integer.parseInt(request.getParameter("qPostingID"));
		}
		
		String content = request.getParameter("content");


		request.setAttribute("qPostingID", qPostingID);
		request.setAttribute("qCommentID", qCommentID);
		request.setAttribute("content", content);

		return "/jsp/board/qboard/QboardUpdateComment.jsp";
	}

}

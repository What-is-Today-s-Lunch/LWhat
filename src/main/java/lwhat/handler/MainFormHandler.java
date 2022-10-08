package lwhat.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("memberID")=="megaZ"|| session.getAttribute("memberID")=="megaZ1"||session.getAttribute("memberID")=="megaZ2"||(int)session.getAttribute("memberID")==125) {
//			request.setAttribute("user", "manager");
//		}else {
//			request.setAttribute("user", "client");
//		}
//		
//		
		return "/jsp/mainForm.jsp";
	}
}

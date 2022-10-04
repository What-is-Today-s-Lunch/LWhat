package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class MemberLoginFormHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		return "/jsp/loginForm.jsp";
	}
}

package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.handler.CommandHandler;

public class MemberSearchFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return "/jsp/member/memberSearchForm.jsp";
	}
}

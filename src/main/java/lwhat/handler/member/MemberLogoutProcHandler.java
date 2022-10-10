package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class MemberLogoutProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  HttpSession session = request.getSession();
	  
      session.invalidate();
      String rst1 = "logout";
      request.setAttribute("rst1", rst1);
      return "/jsp/member/memberLoginForm.jsp";
   }
}
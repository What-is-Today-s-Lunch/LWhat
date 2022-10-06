package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.handler.CommandHandler;

public class MemberLogoutProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
      request.getSession().invalidate();
   
      
      return "/jsp/loginForm.jsp";
   }
}
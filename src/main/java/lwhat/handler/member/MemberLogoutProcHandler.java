package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class MemberLogoutProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	  HttpSession session = request.getSession();
	  //로그아웃할때는 회원아이디 세션 없애줌
      session.invalidate();
      String rst1 = "logout";
      request.setAttribute("rst1", rst1);
      return "/jsp/member/memberLoginForm.jsp";
   }
}
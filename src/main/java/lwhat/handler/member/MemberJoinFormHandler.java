package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.handler.CommandHandler;

public class MemberJoinFormHandler implements CommandHandler{

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) {
      return "/jsp/joinForm.jsp";
   }
      
}
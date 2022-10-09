package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberDeleteDAOImpl;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberDeleteProcHandler implements CommandHandler{
   
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();

       String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
       System.out.println(memberID);
      // String memberID = (String)request.getSession().getAttribute("memberID");
      
      MemberService memberService = new MemberDeleteDAOImpl();
      memberService.deleteMember(memberID);
      session.invalidate();
      
      return "/jsp/member/memberLoginForm.jsp";
   }
}
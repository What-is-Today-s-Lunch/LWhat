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
	  // 세션 불러오기
      HttpSession session = request.getSession();
      // memberID에 세션값 저장
       String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
//       System.out.println(memberID);
      // String memberID = (String)request.getSession().getAttribute("memberID");
      
      // MemberDeleteDAOImpl 의 deleteMember 실행
      MemberService memberService = new MemberDeleteDAOImpl();
      memberService.deleteMember(memberID);
      // 멤버 삭제 후 세션 초기화
      session.invalidate();
      
      return "/jsp/member/memberLoginForm.jsp";
   }
}
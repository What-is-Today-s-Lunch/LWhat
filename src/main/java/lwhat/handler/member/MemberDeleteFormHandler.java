package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberDeleteFormHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
       HttpSession session = request.getSession();

       String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
       //2. 회원정보 가져오는 메서드생성
       MemberService memberService = new MemberViewDAOImpl();
       MemberDTO memberDTO = new MemberDTO();
       memberDTO = memberService.viewMembers(memberID);
       request.setAttribute("memberDTO", memberDTO);
       return "/jsp/memberDeleteForm.jsp";
   }
}
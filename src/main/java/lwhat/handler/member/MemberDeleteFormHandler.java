package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberDeleteFormHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
       HttpSession session = request.getSession();
       
       // memberID에 세션 ID 저장
       String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
       // 회원정보 가져오는 메서드생성
       MemberService memberService = new MemberViewDAOImpl();
       MemberDTO memberDTO = new MemberDTO();
       
       // 회원삭제 화면에 회원 정보 표시
       memberDTO = memberService.viewMembers(memberID);
       // request에 memberDTO 저장
       request.setAttribute("memberDTO", memberDTO);
       return "/jsp/member/memberDeleteForm.jsp";
   }
}
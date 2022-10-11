package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberUpdateDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberUpdateProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
       //세션으로 회원아이디 가져옴
	   HttpSession session = request.getSession();
       String memberID = (String) session.getAttribute("memberID");
       //수정된회원정보를 DTO에 넣는다
       MemberDTO memberDTO = new MemberDTO();
         memberDTO.setMemberID(memberID);
         memberDTO.setMemberPW(request.getParameter("upass") == null ? "" : request.getParameter("upass"));
         memberDTO.setNickName(request.getParameter("unick") == null ? "" : request.getParameter("unick"));
         memberDTO.setName(request.getParameter("uname") == null ? "" : request.getParameter("uname"));
         memberDTO.setEmail(request.getParameter("uemail") == null ? "" : request.getParameter("uemail"));
       //수정된 정보 DB에 저장
         MemberService memberService = new MemberUpdateDAOImpl();
         memberService.updateMember(memberDTO);
       //회원정보를 view사용
         memberService.viewMembers(memberID);
         request.setAttribute("memberDTO", memberDTO);

         return "/jsp/member/mypageForm.jsp";
   }
}
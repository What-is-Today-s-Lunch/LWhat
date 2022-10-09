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
       HttpSession session = request.getSession();
       String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
       
       MemberDTO memberDTO = new MemberDTO();
          memberDTO.setMemberID(memberID);
         memberDTO.setMemberPW(request.getParameter("upass") == null ? "" : request.getParameter("upass"));
         memberDTO.setNickName(request.getParameter("unick") == null ? "" : request.getParameter("unick"));
         memberDTO.setName(request.getParameter("uname") == null ? "" : request.getParameter("uname"));
         memberDTO.setEmail(request.getParameter("uemail") == null ? "" : request.getParameter("uemail"));
         
         MemberService memberService = new MemberUpdateDAOImpl();
         memberService.updateMember(memberDTO);
         
         memberService.viewMembers(memberID);
         request.setAttribute("memberDTO", memberDTO);
         //MemberUpdateDAOImpl memberUpdateDAOImpl = new MemberUpdateDAOImpl();
         //memberUpdateDAOImpl.updateMember(memberDTO);
         return "/jsp/member/mypageForm.jsp";
   }
}
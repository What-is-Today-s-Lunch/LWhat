package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.member.MemberJoinDAOImpl;
import lwhat.dto.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberJoinProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response)throws Exception{
      MemberDTO memberDTO = new MemberDTO();
      
      memberDTO.setMemberID(request.getParameter("uid") == null ? "" : request.getParameter("uid"));
      memberDTO.setMemberPW(request.getParameter("upass") == null ? "" : request.getParameter("upass"));
      memberDTO.setNickName(request.getParameter("unick") == null ? "" : request.getParameter("unick"));
      memberDTO.setEmail(request.getParameter("uemail") == null ? "" : request.getParameter("uemail"));
      memberDTO.setName(request.getParameter("uname") == null ? "" : request.getParameter("uname"));

      MemberService memberService = new MemberJoinDAOImpl();
      
   
      memberService.joinMember(memberDTO);

      return "/jsp/loginForm.jsp";
   }
}
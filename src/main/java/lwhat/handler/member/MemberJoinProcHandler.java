package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.member.MemberJoinDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberJoinProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response)throws Exception{
	  
	  //MemberDTO 생성
	  MemberDTO memberDTO = new MemberDTO();
      
	  // memberDTO에 memberjoinform에서 썻던 각 데이터값 지정
      memberDTO.setMemberID(request.getParameter("uid") == null ? "" : request.getParameter("uid"));
      memberDTO.setMemberPW(request.getParameter("upass") == null ? "" : request.getParameter("upass"));
      memberDTO.setNickName(request.getParameter("unick") == null ? "" : request.getParameter("unick"));
      memberDTO.setEmail(request.getParameter("uemail") == null ? "" : request.getParameter("uemail"));
      memberDTO.setName(request.getParameter("uname") == null ? "" : request.getParameter("uname"));
      
      // MemberJoinDAOImpl 에서 데이터 처리
      int result = 0;
      MemberService memberService = new MemberJoinDAOImpl();
      result = memberService.joinMember(memberDTO);
      request.setAttribute("result", result);
      // 아이디 중복
      if(result == -1) {
    	  return "/jsp/member/memberJoinForm.jsp";
      }
      // 회원가입 성공
      String rst ="sucess";
      request.setAttribute("rst", rst);
      return "/jsp/member/memberLoginForm.jsp";
   }
}
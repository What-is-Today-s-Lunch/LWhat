package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberLoginDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;

public class MemberLoginProcHandler implements CommandHandler{
   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{

      HttpSession session = request.getSession();
      MemberDTO memberDTO = new MemberDTO();
      memberDTO.setMemberID(request.getParameter("memberID") == null ? "" : request.getParameter("memberID"));
      memberDTO.setMemberPW(request.getParameter("memberPW") == null ? "" : request.getParameter("memberPW"));
      response.setContentType("text/html; charset=utf-8");
      
      
      String memberID = null;
      if (session.getAttribute("memberID") != null) {
         memberID = (String) session.getAttribute("memberID");
      }

      MemberLoginDAOImpl memberLoginDAOImpl = new MemberLoginDAOImpl();
      int result = 0;
      result = memberLoginDAOImpl.loginMember(memberDTO.getMemberID(), memberDTO.getMemberPW());
      request.setAttribute("result", result);
      
      // result 1일경우 로그인 성공
      if (result == 1) {
    	  	session.setAttribute("memberID", memberDTO.getMemberID());
         
      //관리자 아이디 일 경우 true 값을 받아서 식당등록 페이지에 들어 갈 수 있게 함 
         if(memberDTO.getMemberID().equals("megaZ")||memberDTO.getMemberID().equals("megaZ1")
        		 ||memberDTO.getMemberID().equals("megaZ2")) {
        	 request.setAttribute("manager", true);
        	 return "/jsp/mainForm.jsp";
 		}else {
 			request.setAttribute("manager", false);
 		}
         return "/jsp/mainForm.jsp";
      }
      
         return "/jsp/member/memberLoginForm.jsp";
   }
}
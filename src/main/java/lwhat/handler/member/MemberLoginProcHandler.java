package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberLoginDAOImpl;
import lwhat.dto.MemberDTO;
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
      // 세션을 확인해서 세션이 존재 할때 String memberID에게 세션값 부여
      if (session.getAttribute("memberID") != null) {
         memberID = (String) session.getAttribute("memberID");
      }

      // memberID 에 세션값이 부여 되어 있다면 (중복 로그인 방지)
//      if (memberID != null) {
//         script.println("<script>");
//         script.println("alert('이미 로그인이 되어 있습니다!')");
//         script.println("</script>");
 //        return "/jsp/mainForm.jsp"; 
 //     }

      // MemberDAOImpl 인스턴스 생성
      MemberLoginDAOImpl memberLoginDAOImpl = new MemberLoginDAOImpl();
      // 로그인시도 함수실행
      // 로그인 페이지에서 가져온 값 member.~, -> MemberDAO의 result에서 실행 후 result 반환
      int result = 0;
      result = memberLoginDAOImpl.loginMember(memberDTO.getMemberID(), memberDTO.getMemberPW());
      request.setAttribute("result", result);
      if (result == 1) { // 로그인 성공
         // 세션 생성
         session.setAttribute("memberID", memberDTO.getMemberID());
//         script.println("<script>");
//         script.println("alert('로그인 성공!')");
//         script.println("</script>");
       
         //관리자 아이디 일 경우 true 값을 받아서 식당등록 페이지에 들어 갈 수 있게 함 
         if(memberID.equals("megaZ")||memberID.equals("megaZ1")||memberID.equals("megaZ2")) {
        	 request.setAttribute("user", true);
 		}else {
 			request.setAttribute("user", false);
 		};
         
         return "/jsp/mainForm.jsp";
      }
      if (result == 0) { // 비밀번호 불일치
//         script.println("<script>");
//        script.println("alert('비밀번호가 틀립니다.')");
//         script.println("</script>");
         return "/jsp/loginForm.jsp";
      }

      else { // ID가 없음
//         script.println("<script>");
     //    script.println("alert('존재하지 않는 ID입니다.')");
//         script.println("</script>");
         return "/jsp/loginForm.jsp";
      }
   }
}
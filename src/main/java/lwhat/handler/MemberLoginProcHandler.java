package lwhat.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberLoginDAOImpl;
import lwhat.dto.MemberDTO;

public class MemberLoginProcHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setMemberID(request.getParameter("memberID"));
	memberDTO.setMemberPW(request.getParameter("memberPW"));

	PrintWriter script = null;
	try {
		script = response.getWriter();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	
	String memberID = null;
	// 세션을 확인해서 세션이 존재 할때 String memberID에게 세션값 부여
	if(session.getAttribute("memberID") != null) {
		memberID = (String)session.getAttribute("memberID");
	}
	
	// memberID 에 세션값이 부여 되어 있다면 (중복 로그인 방지)
	if (memberID != null){
		script.println("<script>");
		script.println("alert('이미 로그인이 되어 있습니다!')");
		script.println("location.href = 'mainForm.jsp'");
		script.println("</script>");
	}

	// MemberDAOImpl 인스턴스 생성
	MemberLoginDAOImpl memberLoginDAOImpl = new MemberLoginDAOImpl();
	// 로그인시도 함수실행
	// 로그인 페이지에서 가져온 값 member.~, -> MemberDAO의 result에서 실행 후 result 반환
	int result = 0;
	try {
		result = memberLoginDAOImpl.loginMember(memberDTO.getMemberID(), memberDTO.getMemberPW());
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	if(result ==1){ // 로그인 성공
		// 세션 생성
		session.setAttribute("memberID", memberDTO.getMemberID());
		script.println("<script>");
		script.println("alert('로그인 성공!')");
		script.println("location.href = 'mainForm.jsp'");
		script.println("</script>");
	}
	
	if(result ==0){ // 비밀번호 불일치
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("location.href = 'loginForm.jsp'");
		script.println("</script>");
	}
	
	if(result ==-1){ // ID가 없음
		script.println("<script>");
		script.println("alert('존재하지 않는 ID입니다.')");
		script.println("location.href = 'loginForm.jsp'");
		script.println("</script>");
	}
		return "/index.do";
	}
}

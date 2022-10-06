<%@page import="lwhat.dao.impl.member.MemberLoginDAOImpl"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%
request.setCharacterEncoding("utf-8");
%>
<!-- 자바빈즈 사용 -->
<!-- member 생성, 자바빈즈위치, 현재페이지에서만 빈즈 사용 -->
<jsp:useBean id="member" class="lwhat.dto.MemberDTO" scope="page" />
<!-- 디비에서 ID와 PW를 가져옴 -->
<jsp:setProperty name="member" property="memberID" />
<jsp:setProperty name="member" property="memberPW" />

<%
	PrintWriter script = response.getWriter();
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
	int result = memberLoginDAOImpl.loginMember(member.getMemberID(), member.getMemberPW());
	
	if(result ==1){ // 로그인 성공
		// 세션 생성
		session.setAttribute("memberID", member.getMemberID());
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
%>





















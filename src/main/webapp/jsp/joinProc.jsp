<%@page import="lwhat.dao.impl.member.MemberJoinDAOImpl"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("utf-8"); %>
<!-- 자바빈즈 사용 -->
<!-- member 생성, 자바빈즈위치, 현재페이지에서만 빈즈 사용 -->
<jsp:useBean id="member" class="lwhat.dto.MemberDTO" scope="page" />
<jsp:setProperty name="member" property="memberID" />
<jsp:setProperty name="member" property="memberPW" />
<jsp:setProperty name="member" property="email" />
<jsp:setProperty name="member" property="nickName" />
<jsp:setProperty name="member" property="name" />

<%
	MemberJoinDAOImpl memberJoinDAOImpl = new MemberJoinDAOImpl();
	int result = memberJoinDAOImpl.joinMember(member);
	// 받아오는 정보에 값이 입력 되지 않는다면
	if(member.getMemberID() == null || member.getMemberPW() == null || member.getEmail() == null 
			|| member.getNickName() == null || member.getName() == null) { 
		// 스크립트 문장 삽입
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('작성하지 않은 회원정보가 있습니다!')");
		script.println("history.back()");
		script.println("</script>");
	}else { 
		// 스크립트 문장 삽입
		if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입이 완료 되었습니다.')");
		script.println("location.href = 'loginForm.jsp'");
		script.println("</script>");
		}
		else if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디 입니다.')");
		script.println("history.back()");
		script.println("</script>");
		}
	}
%>


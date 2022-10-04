<%@page import="java.io.PrintWriter"%>
<%@page import="lwhat.service.member.MemberService"%>
<%@page import="lwhat.dao.impl.member.MemberUpdateDAOImpl"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Object memberID_ = session.getAttribute("memberID");
	String memberID = (String)memberID_;
	MemberDTO memberDTO = new MemberDTO();
 	memberDTO.setMemberID(memberID);
	memberDTO.setMemberPW(request.getParameter("password") == null ? "" : request.getParameter("password"));
	memberDTO.setNickName(request.getParameter("nickName") == null ? "" : request.getParameter("nickName"));
	memberDTO.setName(request.getParameter("name") == null ? "" : request.getParameter("name"));
	memberDTO.setEmail(request.getParameter("email") == null ? "" : request.getParameter("email"));
	MemberUpdateDAOImpl memberUpdateDAOImpl = new MemberUpdateDAOImpl();
	memberUpdateDAOImpl.updateMember(memberDTO);
	
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('회원정보 수정이 완료 되었습니다.')");
	script.println("location.href = 'mainForm.jsp'");
	script.println("</script>");
%>
<body>
</body>
</html>
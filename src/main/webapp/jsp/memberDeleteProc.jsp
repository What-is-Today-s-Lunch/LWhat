<%@page import="java.io.PrintWriter"%>
<%@page import="lwhat.dao.impl.member.MemberDeleteDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% 
String memberID = (String) session.getAttribute("memberID");
MemberDeleteDAOImpl memberdeleteDAOImpl = new MemberDeleteDAOImpl();
memberdeleteDAOImpl.deleteMember(memberID);

PrintWriter script = response.getWriter();
script.println("<script>");
script.println("alert('회원탈퇴가 완료 되었습니다.')");
script.println("location.href = 'loginForm.jsp'");
script.println("</script>");
%>
</head>
</html>
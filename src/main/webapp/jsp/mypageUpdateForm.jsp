<%@page import="java.util.ArrayList"%>
<%@page import="lwhat.service.member.MemberService"%>
<%@page import="lwhat.util.ConnectionManager"%>
<%@page import="lwhat.dao.member.MemberDAO"%>
<%@page import="lwhat.dto.MemberDTO"%>
<%@page import="lwhat.dao.impl.member.MemberViewDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/join.css">

<title>회원가입 화면</title>
<%
	//1. 한글설정 & 변수생성
	String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
	//1-1.id값확인 -없으면 로그인페이지로 이동
	if(memberID == null){
		response.sendRedirect("loginForm.jsp");
	}
	//2. 회원정보 가져오는 메서드생성
	MemberService memberService = new MemberViewDAOImpl();
	MemberDTO memberDTO = new MemberDTO();
	memberDTO = memberService.viewMembers(memberID);
	//3. 데이터처리 : 테이블로 표현
	if(memberDTO != null){
%>
</head>
<body>
<div id="top">
   <br>
   <h1>회원정보 수정</h1>
   </div>
<br><br>
    <div id="bottom">
        <form method="post" action="mypageUpdateProc.jsp">
        회원아이디<br><%=memberDTO.getMemberID()%><br>
        회원비밀번호 변경<br><input type="text" class="in" name="password" value="<%=memberDTO.getMemberPW()%>"><br>
        회원이름 변경<br><input type="text" class="in" name="name" value="<%=memberDTO.getMemberPW()%>"><br>
        회원이메일 변경<br><input type="text" class="in" name="email" value="<%=memberDTO.getMemberPW()%>"><br>
        회원닉네임 변경<br><input type="text" class="in" name="nickName" value="<%=memberDTO.getMemberPW()%>"><br>
            가입일<br><%=memberDTO.getjoinDate() %><br>
             <input type = "submit" value="회원정보 수정"><br>
             <a href="javascript:history.back();">뒤로가기</a>
        </form>
    </div>
<% 
} 
%>
    </div>
</body>
</html>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="lwhat.service.member.MemberService"%> --%>
<%-- <%@page import="lwhat.util.ConnectionManager"%> --%>
<%-- <%@page import="lwhat.dao.member.MemberDAO"%> --%>
<%-- <%@page import="lwhat.dto.member.MemberDTO"%> --%>
<%-- <%@page import="lwhat.dao.impl.member.MemberViewDAOImpl"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LWhat/css/member.css">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">

<title>마이페이지</title>
<%-- <%
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
%> --%>
</head>
<body>
<div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
    <h1>정말 탈퇴 하시겠습니까?</h1>
   </div>
<br><br>
    <div id="bottom">
        <form method ="post" action = "${webapproot}/memberdeleteproc.do">
            회원아이디 : ${memberDTO.memberID}<br><br>
            회원비밀번호 : ${memberDTO.memberPW}<br><br>
            회원이름 : ${memberDTO.name}<br><br>
            회원이메일 : ${memberDTO.email}<br><br>
            회원닉네임 : ${memberDTO.nickName}<br><br>
            회원가입일 : ${memberDTO.joinDate}<br><br>
             <input type="submit" class="in" id="button" value="탈퇴하기"><br>
             <input type="button" class="in" id = "button" value="뒤로가기"
             onclick="location.href='javascript:history.back();'">
        </form>
    </div>
</body>
</html>
<%@page import="java.io.PrintWriter"%>
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

<title>마이페이지</title>
<%
	//1. 한글설정 & 변수생성
	String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
	//1-1.id값확인 -없으면 로그인페이지로 이동
	if(memberID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인이 되어있지 않습니다!')");
		script.println("location.href = 'loginForm.jsp'");
		script.println("</script>");
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
   <h1>회 원 가 입</h1>
   </div>
<br><br>
    <div id="bottom">
        <form>
            회원아이디<br><%=memberDTO.getMemberID()%></br>
            회원비밀번호<br><%=memberDTO.getMemberPW() %></br>
            회원이름<br><%=memberDTO.getName() %></br>
            회원이메일<br><%=memberDTO.getEmail() %></br>
            회원닉네임<br><%=memberDTO.getNickName() %><br>
            회원가입일<br><%=memberDTO.getjoinDate() %><br>
             <a href="../jsp/mypageUpdateForm.jsp" id="create">회원정보수정하기</a><br>
             <a href="javascript:history.back();">뒤로가기</a>
             <a href="../jsp/logoutProc.jsp">로그아웃</a><br>
             <a href="../jsp/memberDeleteForm.jsp">회원탈퇴하기</a>
        </form>
    </div>
<% 
} 
%>
    </div>
</body>
</html>
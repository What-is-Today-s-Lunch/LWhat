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
<title>Insert title here</title>
</head>
<body>
<div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h2>회원정보 찾기 페이지</h2>
  </div>
<br>
    <div id="bottom">
        <form>
            회원아이디 : ${memberDTO.memberID}<br><br>
            회원비밀번호 : ${memberDTO.memberPW}<br><br>
            회원이름 : ${memberDTO.name}<br><br>
            회원이메일 : ${memberDTO.email}<br><br>
            회원닉네임 : ${memberDTO.nickName}<br><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/membersearchform.do'" 
             id="button" value="뒤로가기"><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/memberloginform.do'" 
             id="button" value="로그인페이지"><br>
        </form>
    </div>
</body>
</html>
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
</head>
<body>
<div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h2>마 이 페 이 지</h2>
  </div>
<br>
    <div id="bottom">
        <form>
            회원아이디 : ${memberDTO.memberID}<br><br>
            회원비밀번호 : ${memberDTO.memberPW}<br><br>
            회원이름 : ${memberDTO.name}<br><br>
            회원이메일 : ${memberDTO.email}<br><br>
            회원닉네임 : ${memberDTO.nickName}<br><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/memberupdateform.do'" 
             id="button" value="회원정보수정하기"><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/memberlogoutproc.do'" 
             id="button" value="로그아웃"><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/mainform.do'" 
             id="button" value="메인으로"><br>
             <input type="button" class="in" onclick="location.href='${webapproot}/memberdeleteform.do'" 
             id="button" value="회원탈퇴하기"><br>
        </form>
    </div>
</body>
</html>
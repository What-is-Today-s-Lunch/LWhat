<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/member.css">
<title>로그인 페이지</title>
</head>
<body>
   <div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h3>우리만의 점심 커뮤니티</h3>
   </div>
    <div>
        <form method="post" action="loginProc.jsp">
            <input type="text" placeholder="아이디" class="in" name="memberID">
            <input type="password" placeholder="비밀번호" class="in" name="memberPW">
            <input type="submit" id="button" value="로그인"><br>
            <input type="button" id="button" class="in"
            onclick="location.href='../jsp/joinForm.jsp'" value="회원가입하기"><br>
            <!-- <input type="button" id="button" onclick="location.href='../jsp/pwFind.jsp'" value="비밀번호 찾기"><br> -->
        </form>
    </div>
</body>
</html>
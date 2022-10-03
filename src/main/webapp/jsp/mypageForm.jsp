<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/join.css">
<title>회원가입 화면</title>
</head>
<body>
   <div id="top">
   <br>
   <h1>마 이 페 이 지</h1>
   </div>
   <br><br>
    <div id="bottom">
        <form method="post" action="joinProc.jsp">
            아이디<br><input type="text" name="memberID"></br>
            이름<br><input type="text" name="name"></br>
            이메일<br><input type="text" name="email"></br>
            닉네임<br><input type="text" name="nickName"><br>
             <input type="submit" value="회원정보 수정">
             <a href="javascript:window.history.back();">뒤로가기</a>
             <a href="../jsp/logoutProc.jsp" id="create">로그아웃하기</a>
        </form>
    </div>
</body>
</html>
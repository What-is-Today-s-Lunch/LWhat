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
   <h1>회 원 가 입</h1>
   </div>
   <br><br>
    <div id="bottom">
        <form method="post" action="joinProc.jsp">
            아이디<br><input type="text" name="memberID"></br>
            비밀번호<br><input type="password" name="memberPW"></br>
            이름<br><input type="text" name="name"></br>
            이메일<br><input type="text" name="email"></br>
            닉네임<br><input type="text" name="nickName"><br>
             <input type="submit" value="등록">
        </form>
    </div>

</body>
</html>
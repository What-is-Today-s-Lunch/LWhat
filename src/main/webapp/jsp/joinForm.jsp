<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/member.css">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<title>회원가입 화면</title>
<script type="text/javascript">
    function confirmForm(form) {
      var p1 = document.getElementById('password1').value;
      var p2 = document.getElementById('password2').value;
      
           if (!p1) {
              alert("비밀번호를 입력해 주세요!");
              p1.focus();
            //  return false;
           }
           if (!p2) {
              alert("비밀번호확인은 입력해 주세요!");
              p2.focus();
             // return false;
           }
          
          if( p1 != p2 ) {
            alert("비밀번호가 일치하지 않습니다!");
            p2.focus();
           // return false;
          } 
      form.submit();
    }
  </script>
</head>
<body>
   <div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h2>회 원 가 입</h2>
   </div>
   <br>
    <div id="bottom">
        <form method="post" action="joinProc.jsp">
            <br><input type="text" placeholder="아이디" class="in"
            name="memberID"><br>
           	<br><input type="password" placeholder="비밀번호" class="in"
           	id="password1" name="memberPW"></br>
           	<br><input type="password" placeholder="비밀번호확인" class="in"
           	id="password2" name="memberPW1"></br>
            <br><input type="text" placeholder="이름" class="in"
            name="name"><br>
            <br><input type="text" placeholder="이메일" class="in"
            name="email"><br>
            <br><input type="text" placeholder="닉네임" class="in"
            name="nickName"><br><br>
             <input type="button" class="in" id=button value="회원가입" 
             onclick="javascript:confirmForm(this.form);">
             <input type="button" class="in" onclick="location.href='../jsp/loginForm.jsp'" 
             id="button" value="로그인으로"><br>
        </form>
    </div>
</body>
</html>
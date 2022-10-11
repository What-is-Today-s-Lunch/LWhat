<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="/LWhat/js/memberJoinJquery.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="/LWhat/css/member.css">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<meta charset="UTF-8">
<title>회원가입 화면</title>
</head>
<body>
<c:if test="${result eq '-1'}">
<script>
alert("이미 등록된 아이디 입니다!")
</script>
</c:if>
   <div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h2>회 원 가 입</h2>
   </div>
   <br>
    <div id="bottom">
        <form method="post" name = "frm" action="${webapproot}/memberjoinproc.do">
      * 아이디 <input type="text" name="uid" placeholder="4~12글자 " />
            <label for="uid" class="validation_error"></label><br />
      * 비밀번호 <input type="password" name="upass" placeholder="8~15글자 (문자, 숫자, 특수문자 포함)"/><label for="upass" class="validation_error"></label><br />
      * 비밀번호확인 <input type="password" name="upassre" placeholder="8~15글자 (문자, 숫자, 특수문자 포함)"/><label for="upassre" class="validation_error"></label><br />
      * 이름 <input type="text" name="uname" placeholder="2글자 이상"/><label for="uname" class="validation_error"></label><br />
      * 이메일주소 <input type="text" name="uemail" placeholder="a@a.com"/><label for="uemail" class="validation_error"></label><br />
      * 닉네임 <input type="text" name="unick" placeholder="2~6글자 (문자, 숫자)"/><label for="unick" class="validation_error"></label><br />
      <input type="submit" value="회원가입" id="button"/>
                <input type="button" class="in" onclick="location.href='${webapproot}/memberloginform.do';" 
             id="button" value="로그인으로"><br>
   </form>
    </div>
</body>
</html>
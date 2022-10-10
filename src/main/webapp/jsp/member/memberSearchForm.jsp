<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/LWhat/css/member.css">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<title>회원정보찾기 페이지</title>
</head>
<body>
<c:if test="${result eq 'null'}">
<script>
alert("입력되지 않은 문항이 있습니다!")
</script>
</c:if>
<c:if test="${rst eq 'null'}">
<script>
alert("회원 정보가 틀렸습니다!")
</script>
</c:if>
   <div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h3>회원 정보 찾기</h3>
   </div>
    <div>
   		<form method="post" action="${webapproot}/memberinfsearchform.do"> <!-- ??????? -->
            <input type="text" placeholder="등록된 이름을 입력해주세요" class="in" name="name">
            <input type="text" placeholder="등록된 이메일을 입력해주세요" class="in" name="email">
            <input type="submit" id="button" value="찾기"><br>
            <input type="button" id="button" class="in"
            onclick="location.href='${webapproot}/memberloginform.do'" value="로그인으로"><br>
            <!-- <input type="button" id="button" onclick="location.href='../jsp/pwFind.jsp'" value="비밀번호 찾기"><br> -->
      	</form>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_banner_slide.css">
<script type="text/javascript" src="/LWhat/js/slide.js"></script>
<script type="text/javascript" src="/LWhat/js/upBtn.js"></script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
<c:if test="${result eq '1'}">
<script>
	alert("로그인 성공!")
</script>
</c:if>
   <div class="wrap">
      <div class="header">
         <div class="searchArea">
			<form action="${webapproot}/restaurantform.do" method="get">
				<input type="hidden" name="code" value="A1"> 
				<input type="search" name="restaurantID" placeholder="음식점 검색">
				<button type="submit" class="searchBtn">검색</button>
			</form>
		</div>
         <ul class="nav">
            <li><a href="${webapproot}/mainform.do">오늘뭐먹지</a></li>
            <li><a href="${webapproot}/gboardlist.do">종합게시판</a></li>
            <li><a href="${webapproot}/game.do">돌려돌려 돌림판</a></li>
            <li><a href="${webapproot}/qboardlist.do">1:1 문의</a></li>
			<c:if test="${manager}">
            <li><a href="${webapproot}/restaurantjoinform.do">식당 등록</a></li>
			</c:if>
            <li><a href="${webapproot}/membermypageform.do">마이페이지</a></li>
         </ul>
      </div>
      <div class="slide">
         <div class="container">
            <div class="inner">
               <image src="/LWhat/image/배민1.jpg">
            </div>
            <div class="inner">
               <image src="/LWhat/image/요기요1.jpg">
            </div>
            <div class="inner">
               <image src="/LWhat/image/쿠팡이츠1.jpg">
            </div>
         </div>
      </div>
      <p id="slidebutton" align="right">
      <button class="버튼1" onclick="slideOne();">1</button>
      <button class="버튼2" onclick="slideTwo();">2</button>
      <button class="버튼3" onclick="slideThree();">3</button>
   </div>
   <!-- intro end-->

   <div class="main_text0">
      <h1>Category</h1>
      <div class="contents1"></div>
      <ul class="icons">
         <li>
            <div class="icon_img">
               <img src="/LWhat/image/koreafood.png">

            </div>
            <div class="contents1_bold">한식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AA'">MORE</a></div>
         </li>

         <li>
            <div class="icon_img">
               <img src="/LWhat/image/hamfood.png">
            </div>
            <div class="contents1_bold">양식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AC'">MORE</a></div>         
         </li>

         <li>
            <div class="icon_img">
               <img src="/LWhat/image/chafood.png">
            </div>
            <div class="contents1_bold">중식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AB'">MORE</a></div>         
            </li>

         <li>
            <div class="icon_img">
               <img src="/LWhat/image/japanfood.png">
            </div>
            <div class="contents1_bold">일식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AE'">MORE</a></div>
         </li>
      
         <li>
            <div class="icon_img">
               <img src="/LWhat/image/coffee.png">
            </div>
            <div class="contents1_bold">카페</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AD'">MORE</a></div>
         </li>

         <li>
            <div class="icon_img">
               <img src="/LWhat/image/etc.png">
            </div>
            <div class="contents1_bold">기타</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AZ'">MORE</a></div>
         </li>
      </ul>
   </div>
   <div class="up-btn" onclick="scrollToTop();">↑</div>
   <div class="footer">
      <div>PROJECT</div>
      <div>
         TEAM. Sixth Sense <br> Addr. 부산광역시 해운대구 우동 1475 센텀벤처타운 5층<br>
         TEL. 010 - 8028 - 5978 <br> COPYRIGHT 2022. Sixth Sense. ALL
         RIGHT RESERVED.
      </div>
   </div>
</body>
</html>
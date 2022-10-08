<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_banner_slide.css">
<script type="text/javascript" src="../js/slide.js"></script>
<script type="text/javascript" src="../js/upBtn.js"></script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
   <div class="wrap">
      <div class="header">
         <div class="searchArea">
             <form action="../jsp/restaurantSearchProc.jsp" method="get">
            	<input type = "hidden" name ="code" value="A1">      
 				<input type="search" name="restaurantID" placeholder="search">
 				<button type="submit">전송</button>
            </form>
         </div>
         <ul class="nav">
            <li><a href="${webapproot}/mainform.do">오늘뭐먹지</a></li>
            <li><a href="${webapproot}/gboardlist.do">종합게시판</a></li>
            <li><a href="${webapproot}/game.do">돌려돌려 돌림판</a></li>
            <li><a href="../jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
            
            <li><a href="${webapproot}/restaurantjoinform.do">식당등록</a></li>
            <li><a href="${webapproot}/membermypageform.do">마이페이지</a></li>
         </ul>
      </div>
      <div class="slide">
         <div class="container">
            <div class="inner">
               <image src="../image/배민1.jpg">
            </div>
            <div class="inner">
               <image src="../image/요기요1.jpg">
            </div>
            <div class="inner">
               <image src="../image/쿠팡이츠1.jpg">
            </div>
         </div>
      </div>
      <p id="slidebutton" align="right">
      <button class="버튼1" onclick="slideOne();">1</button>
      <button class="버튼2" onclick="slideTwo();">2</button>
      <button class="버튼3" onclick="slideThree();">3</button>
   </div>
   <!-- intro end-->
   <ul class="amount">
      <li>
         <div>
            <div class="contents1">contents</div>

         </div>
      </li>
      <li>
         <div>
            <div class="contents1">contents</div>

         </div>
      </li>
      <li>
         <div>
            <div class="contents1">contents</div>

         </div>
      </li>
      <li>
         <div>
            <div class="contents1">contents</div>

         </div>
      </li>
   </ul>
   <!-- amount end -->

   <div class="main_text0">
      <h1>Category</h1>
      <div class="contents1"></div>
      <ul class="icons">
         <li>
            <div class="icon_img">
               <img src="../image/koreafood.png">

            </div>
            <div class="contents1_bold">한식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AA'">MORE</a></div>
         </li>

         <li>
            <div class="icon_img">
               <img src="../image/hamfood.png">
            </div>
            <div class="contents1_bold">양식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AC'">MORE</a></div>         
         </li>

         <li>
            <div class="icon_img">
               <img src="../image/chafood.png">
            </div>
            <div class="contents1_bold">중식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AB'">MORE</a></div>         
            </li>

         <li>
            <div class="icon_img">
               <img src="../image/japanfood.png">
            </div>
            <div class="contents1_bold">일식</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AE'">MORE</a></div>
         </li>
      
         <li>
            <div class="icon_img">
               <img src="../image/coffee.png">
            </div>
            <div class="contents1_bold">카페</div>
            <div class="contents2">contents</div>
            <div class="more"><a href="#" onclick="location.href='${webapproot}/restaurantform.do?category=A1AD'">MORE</a></div>
         </li>

         <li>
            <div class="icon_img">
               <img src="../image/etc.png">
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
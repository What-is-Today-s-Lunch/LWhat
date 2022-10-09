<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/foodListStyle.css">
<script type="text/javascript" src="../js/slide.js"></script>
<script type="text/javascript" src="../js/upBtn.js"></script>
<title>${codename}</title>

</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="searchArea">
					<div class="search-box">
						<form action="${webapproot}/restaurantform.do" method="get">
						<input type="hidden" name="code" value="A1"> 
						<input class = "search-txt"type="search" name="restaurantID" placeholder="search">
						<button type="submit" class="search-btn">찾기</button>
						</form>
					</div>
				</div>
				<ul class="nav">
					<li><a href="${webapproot}/mainform.do">오늘뭐먹지</a></li>
					<li><a href="${webapproot}/gboardlist.do">종합게시판</a></li>
					<li><a href="${webapproot}/game.do">돌려돌려 돌림판</a></li>
					<li><a href="../jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
					<li><a href="${webapproot}/membermypageform.do">마이페이지</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="main_text0">
		<h1>${codename}</h1>
		<div class="contents1">
			<ul class="icons">
			
				<!--	<c:set var="listSize" value="${rslist.size()}" /> -->
					<c:forEach var="restaurantlist"  items="${rslist}" varStatus="c" >
				<!--	<c:set var="bno" value="${rslistSize-stat.count+1}" />-->
				<li>
					<div class="icon_img">
						<img src="/LWhat/image/koreafood.png">
					</div>

					<div class="contents1_bold">
					<a href="#" onclick="location.href='${webapproot}/restaurantformtest.do?restaurantID=${restaurantlist.restaurantID}'">
					${restaurantlist.restaurantID}</a>
					</div>
					<div class="contents2">★${restaurantlist.scoreAvg}</div>
					<div class="contents3">(${rLDAO.listCountRestaurantReview(restaurantlist.restaurantID)})</div>
				</li>
					</c:forEach>
				

			</ul>
		</div>

		<!-- 들어가야할 내용ㅁㄴㅇㅁㄴㅇ  -->
	</div>


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
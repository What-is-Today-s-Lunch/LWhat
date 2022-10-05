<%@page import="java.util.List"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantListDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Map"%>
	
<%
	String gPostingIDParam = request.getParameter("restaurantID")==null?"":request.getParameter("restaurantID");
	RestaurantService restaurantService = new RestaurantListDAOImpl();
	
	List<RestaurantDTO> restaurantDTO = restaurantService.listRestaurant();
	pageContext.setAttribute("rslist", restaurantDTO);
%>


	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/foodListStyle.css">
<title><%=request.getParameter("category") %></title>
</head>
<body>
	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="searchArea">
					<form>
						<input type="search" placeholder="search"> <span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="../jsp/mainForm.jsp">오늘뭐먹지</a></li>
					<li><a href="../jsp/totalBoardForm.jsp">종합게시판</a></li>
					<li><a href="../jsp/gameForm.jsp">돌려돌려 돌림판</a></li>
					<li><a href="../jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
					<li><a href="../jsp/loginForm.jsp">LOGIN</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="main_text0">
		<h1><%=request.getParameter("category") %></h1>
		<div class="contents1">
			<ul class="icons">
			
					<c:set var="listSize" value="${rslist.size()}" />
					<c:forEach var="rstaurantlist"  items="${rslist}" varStatus="c" >
					<c:set var="bno" value="${rslistSize-stat.count+1}" />
				<li>
					<div class="icon_img">
						<img src="../image/koreafood.png">
					</div>
					
					
					<div class="contents1_bold">
					<a href="#" onclick="location.href='restaurantFormTest.jsp?restaurantID=${rstaurantlist.restaurantID}';" >
					${rstaurantlist.restaurantID}</a>
					</div>
					<div class="contents2">별점</div>
					<div class="contents3">후기 카운트</div>
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
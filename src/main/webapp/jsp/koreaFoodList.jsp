<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Map"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/foodListStyle.css">
<title>한식</title>
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
		<h1>한식</h1>
		<div class="contents1">
			<ul class="icons">
			
				<li>
					<div class="icon_img">
						<img src="../image/koreafood.png">
					</div>
					<div class="contents1_bold">제주돈가</div>
					<div class="contents2">별점</div>
					<div class="contents3">후기 카운트</div>
				</li>
				
				<li>123</li>
				<li>123</li>
				<li>123</li>
			</ul>
		</div>

		<div class="contents0">/</div>
		<div class="contents1">
			<ul class="icons">
				<li>123</li>
				<li>123</li>
				<li>123</li>
				<li>123</li>
			</ul>
		</div>
		<!-- 들어가야할 내용  -->
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
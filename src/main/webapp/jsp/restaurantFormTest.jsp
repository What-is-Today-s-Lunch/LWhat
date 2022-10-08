<%@page import="lwhat.dto.ReviewDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantViewDAOImpl"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="java.util.List"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantListDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--레스토랑ID와 매칭되는 리스트 가져오기 --%>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<!-- 지도를 그리는  JS API -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=21afcb7bc526fdabb51cbdd812b8c6ec"></script>
<script type="text/javascript" src="/LWhat/js/locationService.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/foodListStyle.css">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style2.css">

<title>${rsIDDTO.restaurantID}</title>
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
					<li><a href="/LWhat/jsp/mainForm.jsp">오늘뭐먹지</a></li>
					<li><a href="/LWhat/jsp/totalBoardForm.jsp">종합게시판</a></li>
					<li><a href="/LWhat/jsp/gameForm.jsp">돌려돌려 돌림판</a></li>
					<li><a href="/LWhat/jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
					<li><a href="/LWhat/jsp/loginForm.jsp">LOGIN</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="main_text0" style="height: 1250px">
		<div class="contents1">.</div>
		<!-- 들어가야할 내용 div 시작점  -->
		<!-- 들어가야할 내용  -->

		<!-- 지도 그려주기 -->
		<div class="contents2">
			<div id="map">
				<input type="hidden" id="longtitude" value="${rsIDDTO.longitude}" />
				<input type="hidden" id="latitude" value="${rsIDDTO.latitude}" /> <input
					type="hidden" id="resID" value="${rsIDDTO.restaurantID}" />
			</div>

			<div id="roadview"></div>
			<div class="restinfo">
				<h1>${rsIDDTO.restaurantID}</h1>
				주소 : ${rsIDDTO.addressDetail} <br /> 연락처 : ${rsIDDTO.rTelNum}<br /> 위도
				: ${rsIDDTO.longitude}<br /> 경도 : ${rsIDDTO.latitude}
			</div>
				<c:if test="${'imagefiles' eq 'imagefiles'}">
					<div class="resimage">
				            	<img src="/LWhat/jsp/restaurantupload/${rsIDDTO.restaurantID}1.jpg">
					</div>
					<div class="resimage">
				            	<img src="/LWhat/jsp/restaurantupload/${rsIDDTO.restaurantID}2.jpg">
					</div>
     		 	</c:if>
		</div>
		<div class="contents4">
			<div class="text">
				<p>후기쓰기</p>
			</div>
			<form action="${webapproot}/restaurantreviewwriteproc.do" name="review" method="post">
				<input type="hidden" name="restaurantID" value="${rsIDDTO.restaurantID}"/>
				<div class="bt_wrap">
					<div id="score" align="right">
						<select id="select_value" name="score" onchange="ChangeValue()">
							<option value="0">--별점선택--</option>
							<option value="1">★</option>
							<option value="2">★★</option>
							<option value="3">★★★</option>
							<option value="4">★★★★</option>
							<option value="5">★★★★★</option>
						</select><br />
					</div>
					<textarea name="content" placeholder="정성스런 후기를 작성해주세요~~!"></textarea>
					<input type="button" value="등록" onclick="this.form.submit()">
				</div>
			</form>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="writer">작성자</div>
					<div class="review">후기내용</div>
					<div class="date">작성시간</div>
					<div class="score">별점</div>
					<div class="dd">수정</div>
				</div>
				<div>
					<c:set var="listSize" value="${revDTO.size()}" />
					<c:forEach var="reviewDTO" items="${revDTO}" varStatus="i">
						<c:set var="bno" value="${revDTOSize-stat.count+1}" />
						<div class="num">${i.count}</div>
						<div class="writer">${reviewDTO.memberID_FK}</div>
						<div class="review">${reviewDTO.content}</div>
						<div class="date">${reviewDTO.wDate}</div>
						<div class="score">${reviewDTO.score}</div>
						<div class="dd">
						<c:if test="${sessionScope.memberID eq reviewDTO.memberID_FK}">
							<button onclick="location.href='restaurantreviewupdateform.do?revID=${reviewDTO.revID}'">[수정]</button>
							<button onclick="location.href='restaurantreviewdeleteproc.do?revID=${reviewDTO.revID}&&restaurantID=${rsIDDTO.restaurantID}';">[삭제]</button>
						</c:if>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="board_page">
				<a class="bt prev"><</a> <a class="bt next">></a>
			</div>
		</div>
	</div>


	<!-- 들어가야할 내용 div 끝점  -->


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
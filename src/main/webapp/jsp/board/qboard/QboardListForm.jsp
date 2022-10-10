<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
System.out.println(request.getAttribute("memberID"));
System.out.println(session.getAttribute("memberID"));
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/LWhat/css/style_category.css">
<link rel="stylesheet" href="/LWhat/css/css.css">
<title>종합 게시판</title>
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
					<li><a href="${webapproot}/mainform.do">오늘뭐먹지</a></li>
					<li><a href="${webapproot}/gboardlist.do">종합게시판</a></li>
					<li><a href="${webapproot}/game.do">돌려돌려 돌림판</a></li>
					<li><a href="${webapproot}/qboardlist.do">1:1 문의</a></li>
					<li><a href="${webapproot}/membermypageform.do">마이페이지</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="main_text0">
		<!-- <h2 align="center">종합 게시판</h2>
		
		<div class="contents2">-->
		<!-- 들어가야할 내용  -->
		<div class="board_wrap">
			<div class="board_title">
				<strong>문의 게시판</strong>
				<p>모든 문의는 여기로~</p>
			</div>
			<div class="board_list_wrap">
				<div class="board_list">
					<div class="top">
						<div class="num">번호</div>
						<div class="category">카테고리</div>
						<div class="title">제목</div>
						<div class="write">글쓴이</div>
						<div class="date">작성일</div>
						<div class="count">조회</div>
					</div>
					<div>
						<c:set var="listSize" value="${list.size()}"></c:set>
						<c:forEach var="qboardDTO" items="${list}" varStatus="stat">
							<div class="num">${postsCount - ((pageNumber*5)+stat.count-5)+2}</div>
<%-- 							<div class="num">${qboardDTO.qPostingID}</div> --%>
							<div class="category">${qboardDTO.boardCategory}</div>
							<div class="title">
								<c:if test="${qboardDTO.memberID_FK eq memberID}">
										<a href="${webapproot}/qboardview.do?qPostingID=${qboardDTO.qPostingID}
										&postnum=${postsCount - ((pageNumber*5)+stat.count-5)+2}">${qboardDTO.title}</a>
								</c:if>
								<c:if test="${qboardDTO.memberID_FK ne memberID }">타인이 작성한 글입니다</c:if>
							</div>
							<div class="write">${qboardDTO.memberID_FK}</div>
							<div class="date">${qboardDTO.mDate}</div>
							<div class="count">${qboardDTO.clickCount}</div>

						</c:forEach>
					</div>
				</div>

				<div class="board_page">

					<c:if test="${pageBefore eq 'pageBefore'}">
						<a href="${webapproot}/qboardlist.do?pageNumber=${pageNumber-1}"
							class="bt prev"><</a>
					</c:if>
					<c:if test="${pageAfter eq 'pageAfter' }">
						<a href="${webapproot}/qboardlist.do?pageNumber=${pageNumber+1}"
							class="bt next">></a>
					</c:if>
				</div>
				<div class="bt_wrap">
					<a href="${webapproot}/qboardwriteform.do" class="on">등록</a>
					<!--<a href="#" >수정</a>-->
				</div>
			</div>
			<!-- </div> -->
			<!-- 검색기능 -->
		</div>
		<div class="contents1">
			<form name="searchDomain" method="post"
				action="${webapproot}/qboardsearchlistform.do">
				<select name="searchDomain">
					<!-- <option value="">전체</option> -->
					<option value="title">제목</option>
					<option value="memberID_FK">작성자</option>
				</select>&nbsp; <input type="text" name="searchText" placeholder="검색">&nbsp;
				<input type="button" value="검색" onclick="this.form.submit()"><br />
				<br />
			</form>
		</div>
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
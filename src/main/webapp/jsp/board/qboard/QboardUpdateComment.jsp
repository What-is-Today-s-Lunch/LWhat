<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_category.css">
<link rel="stylesheet" href="/LWhat/css/css.css">
<title>글쓰기</title>
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

	<div class="main_text0" style="height: 830px">
		<!-- <h2 align="center">종합 게시판</h2>
      
      <div class="contents2">-->
		<!-- 들어가야할 내용  -->
		<div class="board_wrap">
			<div class="board_title">
				<strong>댓글 수정</strong>
			</div>
			<form method="post" action="${webapproot}/qboardcommentupdateproc.do?qCommentID=${qCommentID}&qPostingID=${qPostingID}">
				<div class="board_write_wrap">
						<div class="board_write">
							<div class="cont">
								<textarea name="content" rows="2" cols="80">${content}</textarea>
							</div>
						</div>
					
						<div class="bt_wrap">
							<input type="submit" value="댓글수정하기" />
							 <input type="button" value="취소" onclick="window.history.back();"/> 
						</div>
					</div>
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
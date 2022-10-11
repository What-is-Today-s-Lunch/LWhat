<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

	<div class="main_text0">
		<!-- <h2 align="center">종합 게시판</h2>
      
      <div class="contents2">-->
		<!-- 들어가야할 내용  -->
		<div class="board_wrap">
			<div class="board_title">
				<strong>게시판 글 보기</strong>
			</div>

			<div class="board_view_wrap">
				<div class="board_view">
					<div class="title">제목 : ${gboardDTO.title}</div>
					<div class="info">
						<dl>
							<dt>번호</dt>
							<dd>${param.postnum}</dd>
						</dl>
						<dl>
							<dt>글쓴이</dt>
							<dd>${gboardDTO.memberID_FK}</dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd>${gboardDTO.mDate}</dd>
						</dl>
						<dl>
							<dt>조회</dt>
							<dd>${gboardDTO.clickCount}</dd>
						</dl>
					</div>
					<div class="cont">${gboardDTO.content}
						<div id="contentImage">
							<c:if test="${imgExists eq 'imgExists' }">
								<img src="/LWhat/jsp/GboardImage/${gboardDTO.gPostingID}file.jpg">
							</c:if>
						</div>
					</div>

					<div class="board_list">
						<!-- Comment -->
						<div class="top">
							<!-- 댓글 표시  -->
							<div class="writer">작성자</div>
							<div class="content">내용</div>
							<div class="writetime">작성일시</div>
							<div class="md">수정/삭제</div>
						</div>
						<div>
							<c:set var="listSize" value="${list1.size()}"></c:set>
							<c:forEach var="generalcommentDTO" items="${list1}"
								varStatus="stat">
								<div class="writer">${generalcommentDTO.memberID_FK}</div>
								<div class="content">${generalcommentDTO.content}</div>
								<div class="writetime">${generalcommentDTO.mDate}</div>
								<!-- 댓글 수정, 삭제 표시 -->
								<div class="md">
									<c:if test="${generalcommentDTO.memberID_FK eq memberID}">
										<a
											href="${webapproot}/gboardcommentupdateform.do?gCommentID=
											${generalcommentDTO.gCommentID}&gPostingID=${gboardDTO.gPostingID}&content=${generalcommentDTO.content}&postnum=${param.postnum}">수정</a>
										<a
											href="${webapproot}/gboardcommentdelete.do?gCommentID=
											${generalcommentDTO.gCommentID}&gPostingID=${gboardDTO.gPostingID}&postnum=${param.postnum}">삭제</a>
									</c:if>
								</div>
							</c:forEach>
						</div>
					</div>

					<div class="board_page">
						<c:if test="${pageBefore eq 'pageBefore' }">
							<a
								href="${webapproot}/gboardview.do?pageNumber=${pageNumber-1}&&gPostingID=${gboardDTO.gPostingID}"
								class="bt prev"><</a>
						</c:if>
						<c:if test="${pageAfter eq 'pageAfter'}">
							<a
								href="${webapproot}/gboardview.do?pageNumber=${pageNumber+1}&&gPostingID=${gboardDTO.gPostingID}"
								class="bt next">></a>
						</c:if>

					</div>
						<br />
					<div>
						<form class="commentInput" onsubmit="return false;" method="post"
							action="${webapproot}/gboardcommentwrite.do?gPostingID=${gboardDTO.gPostingID}&postnum=${param.postnum}">
							<input type="text" style="display:none;" /> <!-- 새로나 백신 -->
							<table class="commentTable">
								<tr>
									<td>${memberID}</td>
									<td><textarea rows="3" cols="100" placeholder="상대방을 존중하는 댓글을 남깁시다!" name="content"></textarea></td>
									<td><input type="button" value="댓글 작성" onclick="this.form.submit()"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>

			<div class="bt_wrap">
				<a href="${webapproot}/gboardlist.do" class="on">목록</a>
				<c:if test="${isSameWriter}">
					<a
						href="${webapproot}/gboardupdateform.do?gPostingID=${gboardDTO.gPostingID}">수정하기</a>
					<a
						href="${webapproot}/gboarddelete.do?gPostingID=${gboardDTO.gPostingID}">삭제하기</a>
				</c:if>
			</div>
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
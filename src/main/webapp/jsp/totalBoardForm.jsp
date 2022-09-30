<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/style_category.css">
<link rel="stylesheet" href="../css/css.css">
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
					<li><a href="../jsp/mainForm.jsp">오늘뭐먹지</a></li>
					<li><a href="../jsp/totalBoardForm.jsp">종합게시판</a></li>
					<li><a href="../jsp/gameForm.jsp">돌려돌려 돌림판</a></li>
					<li><a href="../jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
					<li><a href="../jsp/loginForm.jsp">LOGIN</a></li>
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
						<strong>종합 게시판</strong>
						<p>모든것을 찾아보세요</p>
					</div>
					<div class="board_list_wrap">
						<div class="board_list">
							<div class="top">
								<div class="num">번호</div>
								<div class="title">제목</div>
								<div class="write">글쓴이</div>
								<div class="date">작성일</div>
								<div class="count">조회</div>
							</div>
							<div>
								<div class="num">5</div>
								<div class="title"><a href="#">글 제목</a></div>
								<div class="write">이름</div>
								<div class="date">날짜</div>
								<div class="count">0</div>
							</div>
							<div>
								<div class="num">4</div>
								<div class="title"><a href="#">글 제목</a></div>
								<div class="write">이름</div>
								<div class="date">날짜</div>
								<div class="count">0</div>
							</div>
							<div>
								<div class="num">3</div>
								<div class="title"><a href="#">글 제목</a></div>
								<div class="write">이름</div>
								<div class="date">날짜</div>
								<div class="count">0</div>
							</div>
							<div>
								<div class="num">2</div>
								<div class="title"><a href="#">글 제목</a></div>
								<div class="write">이름</div>
								<div class="date">날짜</div>
								<div class="count">0</div>
							</div>
							<div>
								<div class="num">1</div>
								<div class="title"><a href="#">글 제목</a></div>
								<div class="write">이름</div>
								<div class="date">날짜</div>
								<div class="count">0</div>
							</div>
						</div>
						<div class="board_page">
							<a href="#" class="bt first"><<</a>
							<a href="#" class="bt prev"><</a>
							
							<a href="#" class="num on">1</a>
							<a href="#" class="num">2</a>
							<a href="#" class="num">3</a>
							<a href="#" class="num">4</a>
							<a href="#" class="num">5</a>
							
							<a href="#" class="bt next">></a>
							<a href="#" class="bt last">>></a>
						</div>
						<div class="bt_wrap">
							<a href="#" class="on">등록</a>
							<!--<a href="#" >수정</a>-->
						</div>
					</div>
				<!-- </div> -->
		<!-- 들어가야할 내용  -->
		</div>
		<div class="contents1">
			<select name="searchDomain">
				<option value="">전체</option>
				<option value="">제목</option>
				<option value="">작성자</option>
			</select>&nbsp; <input type="text" placeholder="검색">&nbsp; <input
				type="button" value="검색"><br /> <br />
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
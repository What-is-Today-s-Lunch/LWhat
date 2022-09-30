<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!Doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>오늘 뭐 먹지?</title>
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
					<li><a href="../jsp/loginForm.jsp">회원정보수정</a></li>
				</ul>
			</div>
			<div class="intro_text">
				<h1>오늘 뭐먹지 ?</h1>
				<h4 class="contents1">우리만의 점심 커뮤니티</h4>
			</div>
		</div>
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
				<div class="more"><a href="../jsp/koreaFoodList.jsp">MORE</a></div>
			</li>

			<li>
				<div class="icon_img">
					<img src="../image/hamfood.png">
				</div>
				<div class="contents1_bold">양식</div>
				<div class="contents2">contents</div>
				<div class="more"><a href="../jsp/koreaFoodList.jsp">MORE</a></div>
			</li>

			<li>
				<div class="icon_img">
					<img src="../image/chafood.png">
				</div>
				<div class="contents1_bold">중식</div>
				<div class="contents2">contents</div>
				<div class="more"><a href="../jsp/koreaFoodList.jsp">MORE</a></div>
			</li>

			<li>
				<div class="icon_img">
					<img src="../image/etc.png">
				</div>
				<div class="contents1_bold">기타</div>
				<div class="contents2">contents</div>
				<div class="more"><a href="../jsp/koreaFoodList.jsp">MORE</a></div>
			</li>

		</ul>

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

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
						<strong>식당 등록</strong>
						<p>등록은 항상 정확하게!!</p>
					</div>
					<div class="board_write_wrap">
						<div class="board_write">
							<div class="title">
								<dl>
									<dt>식당 ID</dt>
									<dd><input type = "text" placeholder ="식당 ID 입력"/></dd>
								</dl>
							</div>
							<div class="info">
								<dl>
									<dt>관리자 ID</dt>
									<dd><input type = "text" placeholder ="관리자 ID 입력"/></dd>
								</dl>
								<dl>
									<dt>비밀번호</dt>
									<dd><input type = "password" placeholder ="비밀번호 입력"/></dd>
								</dl>
							</div>
							
							<div class= "info">
								<dl>
									<dt>전화번호</dt>
									<dd><input type = "text" placeholder = "전화번호 입력"/></dd>
								</dl>
							</div>
							<div class= "info">
								<dl>
									<dt>주소입력</dt>
									<dd><input type = "text" placeholder = "주소 입력"/></dd>
								</dl>
							</div>
							<div class= "info">
								<dl>
									<dt>위도</dt>
									<dd><input type = "text" placeholder = "위도 입력"/></dd>
								</dl>
								<dl>
									<dt>경도</dt>
									<dd><input type = "text" placeholder = "경도 입력"/></dd>
								</dl>
							</div>
							<div class= "info">
								<div class="cont">
									<dl>
										<dt>식당 소개글</dt>
									</dl>
										<textarea placeholder="식당 소개글을 쓰세요"></textarea>
								</div>
							</div>
						</div>
					
						<div class="bt_wrap">
							<a href="totalBoardView.jsp" class="on">등록</a>
							<a href="totalBoardForm.jsp" >취소</a>
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
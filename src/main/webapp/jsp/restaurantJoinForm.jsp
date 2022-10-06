<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type ="text/javascript" src="../js/kakaoAdressAPI.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/style_category.css">
<link rel="stylesheet" href="../css/css.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
					<form method="post" action="restaurantJoinProc.jsp" enctype="multipart/form-data" accept-charset="UTF-8">
					<div class="board_write_wrap">
						<div class="board_write">
							<div class="title">
								<dl>
									<dt>식당 ID</dt>
									<dd><input type = "text" name="restaurantID" placeholder ="식당 ID 입력"/></dd>
								</dl>
							</div>
							
							<div class= "info">
								<dl>
									<dt>전화번호</dt>
									<dd><input type = "text" name= "telNum"placeholder = "전화번호 입력"/></dd>
								</dl>
								 <dl>
			                        <dt>카테고리</dt>
			                        <dd>
			                           <select id="select_value" name="foodcategory" onchange="ChangeValue()">
			                              <option value="">ex) 한식, 양식, ...</option>
			                              <option value="A1AA">한식</option>
			                              <option value="A1AC">양식</option>
			                              <option value="A1AB">중식</option>
			                              <option value="A1AE">일식</option>
			                              <option value="A1AD">카페</option>
			                              <option value="A1AZ">기타</option>
			                              </select>
			                        </dd>
			                    </dl>
							</div>
							<div class= "info">
								<dl>
									<dt>식당 외관 사진</dt>
									<dd><input type = "file" name="file1" placeholder = "대표메뉴"/></dd>
									
								</dl>
								<dl>
									<dt>메뉴판 사진</dt>
									<dd><input type = "file" name= "file2"placeholder = "메뉴판"/></dd>
								</dl>
							</div>
							<div class= "info">
								<dl>
									<dt>주소입력</dt>
									<dd><input type="text" id="address_kakao" name="address" placeholder="주소입력" readonly /></dd>
								</dl>
								<dl>
									<dt>상세주소입력</dt>
									<dd><input type="text" name="address_detail" placeholder="상세주소입력" /></dd>
								</dl>
							</div>
							<div class= "info">
								<dl>
									<dd>위도(정확하게 쓰지않으면 다른곳을 표시합니다.)</dd>
									<dd><input type = "text" name ="lat" placeholder = "위도 입력"/></dd>
								</dl>
								<dl>
									<dd>경도(정확하게 쓰지않으면 다른곳을 표시합니다.)</dd>
									<dd><input type = "text" name ="long" placeholder = "경도 입력"/></dd>
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
							<input type ="submit" class ="on" value ="등록" />
							<a href="mainForm.jsp" >취소</a>
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
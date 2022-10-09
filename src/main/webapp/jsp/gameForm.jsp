<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/game.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;500&display=swap"
	rel="stylesheet">
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/LWhat/js/game.js" charset="utf-8"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>돌려돌려 돌림판</title>
<style>
{ /*브라우저마다 스타일 설정이 조금씩 다르기 때문에 디자인을 위한 기본 스타일을 정의함*/
font-family:'Noto Sans KR', sans-serif; box-sizing :border-box;
} /*html과 body 태그의 기본 설정 여백을 제거함*/
html, body {
	margin: 0;
	padding: 0;
}
</style>
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
		<div class='left-box'>
			<div class="contents1"></div>
			<div id="app">
				<!-- 지금 만드는 app이라는 id영역은 후에 Vue JS에서 제어할 영역임 -->
				<h1>돌려돌려 돌림판!</h1>
				<div class="roulette-outer">
					<!-- 룰렛의 가장 바깥쪽 영역을 생성합니다, 이 안에는 룰렛판과 룰렛핀이 위치합니다.-->
					<div class="roulette-pin"></div>
					<div class="roulette">
						<!-- 룰렛값 -->
						<div class="item-wrapper">
							<div class="item">
								<input type="text" id="output1" size="15"
									style="width: 70px; height: 70px; text-align:center; border: none; background: transparent;"><br>
							</div>
							<div class="item">
								<input type="text" id="output2" size="15"
									style="width: 70px; height: 70px; text-align:center; border: none; background: transparent;">
							</div>
							<div class="item">
								<input type="text" id="output3" size="15"
									style="width: 70px; height: 70px; text-align:center; border: none; background: transparent;">
							</div>
							<div class="item">
								<input type="text" id="output4" size="15"
									style="width: 70px; height: 70px; text-align:center; border: none; background: transparent;">
							</div>
						</div>
						<!-- 룰렛선 -->
						<div class="line-wrapper">
							<div class="line"></div>
							<div class="line"></div>
							<div class="line"></div>
							<div class="line"></div>
						</div>

						<div class="item-line"></div>
					</div>
				</div>
			</div>
		</div>
		<div class='right-box'>
			<h2
				style="background-color:local; color: black; text-align: center">값을 입력 해 주세요.</h2><br>
			<input style="text-align:center; display:block; margin: 0 auto;" type="text" id="input1" size="30"><br><br> 
			<input style="text-align:center; display:block; margin: 0 auto;" type="text" id="input2" size="30"><br> <br> 
			<input style="text-align:center; display:block; margin: 0 auto;" type="text" id="input3" size="30"><br><br> 
			<input style="text-align:center; display:block; margin: 0 auto;" type="text" id="input4" size="30"><br><br> 
			<button onclick="output()" style="WIDTH: 60pt; HEIGHT: 30pt; display:block; margin: 0 auto;" >입력</button><br> 
			<button id="run" style="WIDTH: 60pt; HEIGHT: 30pt; display:block; margin: 0 auto;" >시작</button><br> 
			<button onclick="window.location.reload()" style="WIDTH: 60pt; HEIGHT: 30pt; display:block; margin: 0 auto;">초기화</button>
			<br>
			<!-- jquery -->
			<script>
			var swing = (Math.random()*3000)+1000;
			var swing2 = Math.random()*30;
			var swing3 = Math.random()*10;
			//	css, html로 제작한 class roulette 디자인 이미지 회전
			var target = $(".roulette");
			// id=run 버튼 클릭 하면 이벤트 함수 실행
			$("#run").on("click", function() {
				// .roulette 애니메이션 실시
				target.animate({
				  now: '+=' + swing
				  }, {
					//애니메이션 단계 실행 (끝난직후 실행)
				  step: function(now, fx) {
					  // 현재 위치에서 회전 실행
				   $(this).css('transform', 'rotate('+ now +'deg)');
				   },
				   // 애니메이션 효과 완료 시간
				   duration: 6000
				   // 2번째 짧은 회전 (반시계 방향)
				  }).animate({
				   now: '-=' + swing2
				  }, {
					   step: function(now, fx) {
					    $(this).css('transform', 'rotate('+ now +'deg)');
					   },
					   duration: 1000
					   //3번째 짧은 회전 (시계 방향)
					  }).animate({
					   now: '+=' + swing3
					  }, {
						   step: function(now, fx) {
						   $(this).css('transform', 'rotate('+ now +'deg)');
						   },
						   duration: 2000
						  });
						})
			</script>
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
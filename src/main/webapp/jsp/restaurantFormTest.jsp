<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<!-- 지도를 그리는  JS API -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=21afcb7bc526fdabb51cbdd812b8c6ec"></script>
<script type="text/javascript" src="../js/locationService.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/foodListStyle.css">
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

	<div class="main_text0" style="height: 1250px">
		<div class="contents1">.</div>
		<!-- 들어가야할 내용 div 시작점  -->
		<!-- 들어가야할 내용  -->

		<!-- 지도 그려주기 -->
		<div class="contents2">
			<div id="map"></div>
			<div id="roadview"></div>
			<div class="restinfo">
				<h1>제주돈가</h1>
				주소 : 부산광역시 해운대구 센텀5로 55 1층 <br /> 연락처 : 051 - 742 - 8992
			</div>
			<div id="resimage">이미지</div>
		</div>
		<div class="contents3"></div>
		<div class="contents4">
			<div class="text">후기쓰기</div>
			<textarea>정성스런 후기를 작성해 주세요~</textarea>
			<button>등록</button>
		</div>
		<!-- 지도를 띄우는 js 
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new kakao.maps.LatLng(35.17280112492927, 129.13146732394424), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapCenter = new kakao.maps.LatLng(35.17280112492927, 129.13146732394424), // 지도의 중심 좌표
		    mapOption = {
		        center: mapCenter, // 지도의 중심 좌표
		        level: 4 // 지도의 확대 레벨
		    };

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 지도에 올릴 마커를 생성합니다.
		var mMarker = new kakao.maps.Marker({
		    position: mapCenter, // 지도의 중심좌표에 올립니다.
		    map: map // 생성하면서 지도에 올립니다.
		});

		// 지도에 올릴 장소명 인포윈도우 입니다.
		var mLabel = new kakao.maps.InfoWindow({
		    position: mapCenter, // 지도의 중심좌표에 올립니다.
		    content: '제주돈가' // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
		});
		mLabel.open(map, mMarker); // 지도에 올리면서, 두번째 인자로 들어간 마커 위에 올라가도록 설정합니다.


		var rvContainer = document.getElementById('roadview'); // 로드뷰를 표시할 div
		var rv = new kakao.maps.Roadview(rvContainer); // 로드뷰 객체 생성
		var rc = new kakao.maps.RoadviewClient(); // 좌표를 통한 로드뷰의 panoid를 추출하기 위한 로드뷰 help객체 생성
		var rvResetValue = {} //로드뷰의 초기화 값을 저장할 변수
		rc.getNearestPanoId(mapCenter, 50, function(panoId) {
		    rv.setPanoId(panoId, mapCenter);//좌표에 근접한 panoId를 통해 로드뷰를 실행합니다.
		    rvResetValue.panoId = panoId;
		});

		// 로드뷰 초기화 이벤트
		kakao.maps.event.addListener(rv, 'init', function() {

		    // 로드뷰에 올릴 마커를 생성합니다.
		    var rMarker = new kakao.maps.Marker({
		        position: mapCenter,
		        map: rv //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라갑니다.
		    });

		    // 로드뷰에 올릴 장소명 인포윈도우를 생성합니다.
		    var rLabel = new kakao.maps.InfoWindow({
		        position: mapCenter,
		        content: '제주돈가'
		    });
		    rLabel.open(rv, rMarker);

		    // 로드뷰 마커가 중앙에 오도록 로드뷰의 viewpoint 조정 합니다.
		    var projection = rv.getProjection(); // viewpoint(화면좌표)값을 추출할 수 있는 projection 객체를 가져옵니다.
		    
		    // 마커의 position과 altitude값을 통해 viewpoint값(화면좌표)를 추출합니다.
		    var viewpoint = projection.viewpointFromCoords(rMarker.getPosition(), rMarker.getAltitude());
		    rv.setViewpoint(viewpoint); //로드뷰에 뷰포인트를 설정합니다.

		    //각 뷰포인트 값을 초기화를 위해 저장해 놓습니다.
		    rvResetValue.pan = viewpoint.pan;
		    rvResetValue.tilt = viewpoint.tilt;
		    rvResetValue.zoom = viewpoint.zoom;
		});

		//지도 이동 이벤트 핸들러
		function moveKakaoMap(self){
		    
		    var center = map.getCenter(), 
		        lat = center.getLat(),
		        lng = center.getLng();

		    self.href = 'https://map.kakao.com/link/map/' + encodeURIComponent('제주돈가') + ',' + lat + ',' + lng; //Kakao 지도로 보내는 링크
		}

		//지도 초기화 이벤트 핸들러
		function resetKakaoMap(){
		    map.setCenter(mapCenter); //지도를 초기화 했던 값으로 다시 셋팅합니다.
		    map.setLevel(mapOption.level);
		}

		//로드뷰 이동 이벤트 핸들러
		function moveKakaoRoadview(self){
		    var panoId = rv.getPanoId(); //현 로드뷰의 panoId값을 가져옵니다.
		    var viewpoint = rv.getViewpoint(); //현 로드뷰의 viewpoint(pan,tilt,zoom)값을 가져옵니다.
		    self.href = 'https://map.kakao.com/?panoid='+panoId+'&pan='+viewpoint.pan+'&tilt='+viewpoint.tilt+'&zoom='+viewpoint.zoom; //Kakao 지도 로드뷰로 보내는 링크
		}

		//로드뷰 초기화 이벤트 핸들러
		function resetRoadview(){
		    //초기화를 위해 저장해둔 변수를 통해 로드뷰를 초기상태로 돌립니다.
		    rv.setViewpoint({
		        pan: rvResetValue.pan, tilt: rvResetValue.tilt, zoom: rvResetValue.zoom
		    });
		    rv.setPanoId(rvResetValue.panoId);
		}
		</script>
-->
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
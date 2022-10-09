var address      = document.getElementById("address");
var mapContainer = document.getElementById("map");
var coordXY   = document.getElementById("coordXY");
var mapOption;
var map;
var x,y          = "";

if (address.value=="") {

 mapOption = {
  center: new daum.maps.LatLng(33.450701, 126.570667), // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
        level: 4            // 지도의 확대 레벨

 };
}

// 지도 생성
map = new daum.maps.Map(mapContainer, mapOption);


function addressChk() {
 var gap = address.value; // 주소검색어
 if (status == daum.maps.services.Status.OK) {
	   
	   var coords = new daum.maps.LatLng(result[0].y, result[0].x);

	   y = result[0].x;
	   x = result[0].y;
	   alert(x+", "+y);
	  }
 
 // 주소-좌표 변환 객체를 생성
 var geocoder = new daum.maps.services.Geocoder();



 // 주소로 좌표를 검색
 geocoder.addressSearch(gap, function(result, status) {
  
  // 정상적으로 검색이 완료됐으면,
  if (status == daum.maps.services.Status.OK) {
   
   var coords = new daum.maps.LatLng(result[0].y, result[0].x);

   y = result[0].x;
   x = result[0].y;
   alert(x+", "+y);
  }

/*    // 결과값으로 받은 위치를 마커로 표시합니다.
   var marker = new daum.maps.Marker({
    map: map,
    position: coords
   });



   // 인포윈도우로 장소에 대한 설명표시
   var infowindow = new daum.maps.InfoWindow({
    content: '<div style="width:150px;text-align:center;padding:5px 0;">좌표위치</div>'
   });

   infowindow.open(map,marker);
   
   // 지도 중심을 이동
   map.setCenter(coords);
 */
  
 });
}
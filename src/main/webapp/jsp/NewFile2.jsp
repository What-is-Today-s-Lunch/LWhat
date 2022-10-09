<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type ="text/javascript" src="../js/kakaoAdressAPI.js"></script>
<script type ="text/javascript" src="../js/latlng.js"></script>
<title>다음지도 - 주소로 위도/경도 좌표값 얻기</title>
</head>
<body>
<p style="text-align:center;">[주소로 위도, 경도 좌표값 얻기]</p>

<input type="text" id="address" value="" size="70"> <input type="button" value="좌표값 검색" onclick="addressChk()">

<div id="map" style="width:100%;height:450px;"></div>

<div id="coordXY"></div>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=21afcb7bc526fdabb51cbdd812b8c6ec&libraries=services"></script>


</script>
</body>
</html>


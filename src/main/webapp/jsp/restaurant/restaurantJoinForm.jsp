<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type ="text/javascript" src="/LWhat/js/kakaoAdressAPI.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_category.css">
<link rel="stylesheet" href="/LWhat/css/css.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>종합 게시판</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script>
$(function(){

   // 입력상자 클릭시 내용 비우기
   $("input[type='text'], input[type='password']").click(function() {
      this.value = '';
   });

    // 유효성검사 메세지 (한국어)
    $.extend($.validator.messages, {
      required: "필수 입력 항목입니다!",
      email: "유효하지 않은 이메일주소 입니다!",
      url: "유효하지 않은 URL 입니다!",
      date: "유효하지 않은 날짜형식 입니다!",
      dateISO: "유효하지 않은 날짜형식(ISO) 입니다!",
      number: "숫자(기호포함)만 입력해 주세요!",
      digits: "숫자만 입력해 주세요!",
      creditcard: "유효하지 않은 신용카드번호 입니다!",
      equalTo: "비밀번호와 비밀번호확인이 일치하지 않습니다!",
      maxlength: jQuery.validator.format("최대 {0}자로 입력해 주세요!"),
      minlength: jQuery.validator.format("최소 {0}자를 입력해 주세요!"),
      rangelength: jQuery.validator.format("{1}글자 이하로 입력해 주세요!"),
      max: jQuery.validator.format("{0}이상 입력해 주세요!"),
      min: jQuery.validator.format("{0}이하로 입력해 주세요!"),
      range: jQuery.validator.format("{0}이상 {1}이하 숫자를 입력해 주세요!")
   });

   // 정규표현식 유효성검사를 위한 메소드 추가
   $.validator.addMethod("regex", 
      function(value, element, regexpr) {
         return regexpr.test(value); 
      }
   );

   // 유효성검사 (form엘리먼트의 name속성 값을 사용함)
   $("form[name='frm']").validate({

      // debug: true, // true인 경우 서밋을 수행하지 않음 (디버그 모드),

      errorPlacement: function(error, element) { // 유효성검사 실패시 에러 표시
         var errorSelector = '.validation_error[for="' + element.attr('name') + '"]';
         var $element = $(errorSelector);
         $(errorSelector).html(error.html());
      },

      success: function(element){ // 유효성검사 성공시 에러 제거
         element.html();                        
      },

      rules: { // 유효성 검사 규칙
    	  telNum: { // 필수, 1~16글자
            required: true,
            rangelength: [1, 16]
         },
         address: {
          	required: true,
          	rangelength: [1, 512]
       },
      address_detail: { 
         	required: true,
          	rangelength: [1, 512]
       },
 	  foodcategory: {
 			 required: true
  	  },
  	  restaurantID: {
			 required: true
	  }
      },

      messages: { // 유효성검사가 실패했을 때 메세지
    	  telNum: {
            required: "전화번호를 입력해 주세요!"
    	  },    	  
    	  address: {
            required: "주소를 입력해 주세요!"
    	  },
    	  address_detail: {
    		required: "상세주소를 입력해 주세요!"
    	  },
    	  foodcategory: {
    		required: "카테고리를 선택해 주세요!"
    	  },
    	  restaurantID: {
      		required: "식당이름을 입력해 주세요!"
      	  }
      }

   });
});
</script>

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
						<strong>식당 등록</strong>
						<p>등록은 항상 정확하게!!</p>
					</div>
					<form method="post" action="restaurantJoinProc.do" name="frm" enctype="multipart/form-data" accept-charset="UTF-8">
					<div class="board_write_wrap">
						<div class="board_write">
							<div class="title">
								<dl>
									<dt>식당 ID*</dt>
									<dd><input type = "text" name="restaurantID" placeholder ="식당 ID 입력(필수)"/>
									<label for="restaurantID" class="validation_error"></label><br /></dd>
								</dl>
							</div>
							
							<div class= "info">
								<dl>
									<dt>전화번호*</dt>
									<dd><input type = "text" name= "telNum" placeholder = "전화번호 최대16개 입력(필수)"/>
									 <label for="telNum" class="validation_error"></label><br /></dd>
								</dl>
								 <dl>
			                        <dt>카테고리*</dt>
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
			                              <label for="foodcategory" class="validation_error"></label><br />
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
									<dd><input type = "file" name= "file2" placeholder = "메뉴판"/></dd>
								</dl>
							</div>
							<div class= "info">
								<dl>
									<dt>주소입력*</dt>
									<dd><input type="text" id="address_kakao" name="address" placeholder="주소입력(필수)" readonly />
									<label for="address" class="validation_error"></label><br /></dd>
								</dl>
								<dl>
									<dt>상세주소입력*</dt>
									<dd><input type="text" name="address_detail" placeholder="상세주소입력(필수)" />
									<label for="address_detail" class="validation_error"></label><br /></dd>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.validation_error {
  font-size: 14px;
  font-weight: bold;
  color: #ff0000;
  padding: 0 0 0 20px;
}
</style>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="/LWhat/css/member.css">
<link
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
   rel="stylesheet">
<title>회원가입 화면</title>
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
      rangelength: jQuery.validator.format("{0}글자 이상 {1}글자 이하로 입력해 주세요!"),
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
           uid: { // 필수, 4~12글자
            required: true,
            rangelength: [4, 12]
         },
         upass: { // 필수, 8~15글자 (문자,숫자,특수문자 포함)
            required: true,
            regex: /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/,
            rangelength: [8, 15]
         },
         upassre: { // 필수, 8~15글자 (문자,숫자,특수문자 포함)
            required: true,
            regex: /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/,
            rangelength: [8, 15],
            equalTo: "input[name='upass']" // 비밀번호와 같으지 확인
         },
         uname: { // 필수, 최소 2글자
            required: true,
            minlength: 2
         },
         uemail: { // 필수, 이메일 형식
            required: true,
            regex: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i
         }, 
         unick: { //필수, 2~6글자 닉네임 형식 (문자,숫자)
            required: true,
            regex: /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|a-zA-Z\d]{2,6}$/
         }

      },

      messages: { // 유효성검사가 실패했을 때 메세지
         uid: {
            required: "아이디를 입력해 주세요!"
         },
         upass: {
            required: "비밀번호를 입력해 주세요!",
            regex: "비밀번호확인 형식에 맞지 않습니다! (형식 : 문자,숫자,특수문자 포함 8~15글자)"
         },
         upassre: {
            required: "비밀번호확인을 입력해 주세요!",
            regex: "비밀번호확인 형식에 맞지 않습니다! (형식 : 문자,숫자,특수문자 포함 8~15글자)"
         },
         uname: {
            required: "이름을 입력해 주세요!"
         },
         uemail: {
            required: "이메일주소를 입력해 주세요!",
            regex: "이메일주소 형식에 맞지 않습니다!"
         },
         unick: {
            required: "닉네임을 입력해 주세요!",
            regex: "닉네임 형식에 맞지 않습니다!"
         }

      }
      
/*       ,

      submitHandler: function() { // 폼을 서밋하지 않고 AJAX로 처리할 때 사용, 실제 폼 서밋은 일어나지 않음
         alert("유효성 검사 완료!");
      } */

   });
});
</script>
</head>
<body>
   <div id="top">
   <br>
   <h1>오 늘 뭐 먹 지 ?</h1>
   <h2>회 원 가 입</h2>
   </div>
   <br>
    <div id="bottom">
        <form method="post" name = "frm" action="${webapproot}/memberjoinproc.do">
            * 아이디 <input type="text" name="uid" placeholder="4~12글자 " />
            <label for="uid" class="validation_error"></label><br />
      * 비밀번호 <input type="password" name="upass" placeholder="8~15글자 (문자, 숫자, 특수문자 포함)"/><label for="upass" class="validation_error"></label><br />
      * 비밀번호확인 <input type="password" name="upassre" placeholder="8~15글자 (문자, 숫자, 특수문자 포함)"/><label for="upassre" class="validation_error"></label><br />
      * 이름 <input type="text" name="uname" placeholder="2글자 이상"/><label for="uname" class="validation_error"></label><br />
      * 이메일주소 <input type="text" name="uemail" placeholder="a@a.com"/><label for="uemail" class="validation_error"></label><br />
      * 닉네임 <input type="text" name="unick" placeholder="2~6글자 (문자, 숫자)"/><label for="unick" class="validation_error"></label><br />
      <input type="submit" value="회원가입" id="button"/>
                <input type="button" class="in" onclick="location.href='${webapproot}/memberloginform.do';" 
             id="button" value="로그인으로"><br>
   </form>
          
    </div>
</body>
</html>
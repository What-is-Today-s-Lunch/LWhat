$(function(){

   // 입력상자 클릭시 내용 비우기
   $("input[type='text'], input[type='password']").click(function() {
      this.value = '';
   });

    // 유효성검사 메세지 (한국어)
    $.extend($.validator.messages, {
      required: "필수 입력 항목입니다!",
      email: "유효하지 않은 이메일주소 입니다!",
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
   });
});
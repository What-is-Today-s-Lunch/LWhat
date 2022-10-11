
			$(function() {
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
			});
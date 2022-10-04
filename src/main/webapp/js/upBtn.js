function upScroll(){
	//애니메이션 효과가 없어서 뚝 끊기는 것처럼 보임.
	window.scrollTo(0, 0);
}

function scrollToTop(){
  //스크롤 속도를 빠르게 하려면 이동 간격 시간을 줄이거나, 이동 크기 픽셀을 늘리기.
  var between = 10; // 이동 간격 시간
  var scroll = window.setInterval(function() {
    var pos = window.pageYOffset;
    var step = 25; // 이동 크기 픽셀
    if ( pos > 0 ) {
        window.scrollTo( 0, pos - step );
    } else {
        window.clearInterval( scroll );
    }
  }, between);
}
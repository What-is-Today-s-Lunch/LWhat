<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_category.css">
<link rel="stylesheet" type="text/css" href="/LWhat/css/style3.css">

<title>Review 수정</title>
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
	<div class="board_wrap">
			<div class="board_title">
				<strong>리뷰 수정</strong>
			</div>
			<span>리뷰 내용</span>
			<form method="post" action="${webapproot}/restaurantreviewupdateproc.do">
           		  		<input type="hidden" name="revID" value="${review.revID}" />
           		  		<input type="hidden" name="restaurantID" value="${RID}" />
			<div class="board_write_wrap">
			<div class="board_write">
							<div class="cont">
			<textarea name="content" rows="2" cols="80">${review.content}</textarea>
			<span class="star">원래별점: ${review.score}</span>
			<div id="score" align="right">
						<select id="select_value" name="score">
							<option value="1" ${review.score=='1' ? 'selected' : ''}>★</option>
							<option value="2" ${review.score=='2' ? 'selected' : ''}>★★</option>
							<option value="3" ${review.score=='3' ? 'selected' : ''}>★★★</option>
							<option value="4" ${review.score=='4' ? 'selected' : ''}>★★★★</option>
							<option value="5" ${review.score=='5' ? 'selected' : ''}>★★★★★</option>
							<option disabled>1~5점까지</option>
						</select><br />
					</div>
				</div>
						</div>
			<div class="bt_wrap">
							<input type="submit" value="리뷰수정하기" />
							 <input type="button" value="취소" onclick="window.history.back();"/> 
						</div>
			</div>
			</form>
		</div>
		</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
<!-- 				<div class="board_review"> -->
<!--        				<div class="rev1">후기내용</div> -->
<!--        				<div class="rev2">작성자</div> -->
<!--        				<div class="rev3">작성시간</div> -->
<!--        				<div class="rev4">별점</div> -->
<!--        				<div class="rev5">수정</div> -->
<!--            		</div> -->
<!--            		<div class="board_review2"> -->
<%--            			<form method="post" action="${webapproot}/restaurantreviewupdateproc.do"> --%>
<%--            		  		<input type="hidden" name="revID" value="${review.revID}" /> --%>
<%--            		  		<input type="hidden" name="restaurantID" value="${RID}" /> --%>
<%--             				<div><input name="content" value='${review.content}'></div> --%>
<%--             				<div><a>${review.memberID_FK}</a></div> --%>
<%--             				<div><a>${mDate}</a></div> --%>
<%--             				<div><input name="score" value='${review.score}' /></div> --%>
<!--             				<div><button type="submit">[수정]</button></div> -->
<!--        				</form> -->
<!--        			</div> -->
<!-- 				</div> -->
<!-- <!--  						board_wrap입니다 --> -->
<!--  						</div> -->
<!-- 						main_text0입니다 -->
 		
 		
 		
 		
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
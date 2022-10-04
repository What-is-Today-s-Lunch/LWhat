<%@page import="lwhat.dto.Review"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantViewDAOImpl"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="java.util.List"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantListDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%--레스토랑ID와 매칭되는 리스트 가져오기 --%>
<%
   String restaurantIDParam = 
   request.getParameter("restaurantID")==null?"":request.getParameter("restaurantID");
   
   
   RestaurantService restaurantViewService = new RestaurantViewDAOImpl();
   
   RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
   out.print(restautantIDDTO);
   pageContext.setAttribute("rsIDlist", restautantIDDTO);
   
   
   session.setAttribute("restaurantID", restaurantIDParam);
   
   RestaurantService reviewListService = new RestaurantReviewListDTOImpl();
   
   List<Review>reviewList = reviewListService.listLReview();
   pageContext.setAttribute("rvlist", reviewList);
   
%>

   
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
         <div class="restinfo" >
            <h1>${rsIDlist.restaurantID}</h1>
            주소 : ${rsIDlist.address} <br /> 
            연락처 : ${rsIDlist.rTelNum}
         </div>
         <div id="resimage">
         이미지
         </div>
      </div>
      <div class="contents4">
            <div class="text">
               <p>후기쓰기</p>
            
            </div>
         
         <form action="restaurantReviewProc.jsp" name="review" method="post" >
            <div class="bt_wrap">
            <textarea name="content" placeholder="정성스런 후기를 작성해주세요~~!"></textarea>
            <input type="button" value="버튼"  onclick="this.form.submit()" >
            </div>
         </form>
         
         <div>
            
         </div>
      </div>
      
   
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
<%@page import="lwhat.dto.ReviewDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewWriteDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@page import="lwhat.dto.ReviewDTO"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String strmemID = (String)session.getAttribute("memberID");
	String strresID = (String)session.getAttribute("restaurantID");
	String strcontent = request.getParameter("content");
	int strscore = Integer.parseInt(request.getParameter("score"));
	
	
	ReviewDTO reviewDTO = new ReviewDTO();
	
	reviewDTO.setMemberID_FK(strmemID);
	reviewDTO.setRestaurantID_FK(strresID);
	reviewDTO.setScore(strscore);
	reviewDTO.setContent(strcontent);	
	RestaurantService restaurantService = new RestaurantReviewWriteDAOImpl();
	restaurantService.writeRestaurantReview(reviewDTO);
	
%>
<body>
<script>alert('후기 등록완료'); window.history.back(); </script>
</body>
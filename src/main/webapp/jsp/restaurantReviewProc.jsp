<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewWriteDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@page import="lwhat.dto.Review"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String strmemID = (String)session.getAttribute("memberID");
	String strresID = (String)session.getAttribute("restaurantID");
	String strcontent = request.getParameter("content");

	
	Review reviewDTO = new Review();
	
	reviewDTO.setMemberID_FK(strmemID);
	reviewDTO.setRestaurantID_FK(strresID);
	reviewDTO.setScore(4);
	reviewDTO.setContent(strcontent);
	
	RestaurantService restaurantService = new RestaurantReviewWriteDAOImpl();
	restaurantService.writeReview(reviewDTO);
%>

<jsp:forward  page="restaurantFormTest.jsp">
	<jsp:param value="<%=strresID%>" name="restaurantID"/>
</jsp:forward>
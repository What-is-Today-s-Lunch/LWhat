<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewDeleteDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int revID = Integer.parseInt(request.getParameter("revID"));
out.print("-----------------------------"+revID);

RestaurantService restaurantService = new RestaurantReviewDeleteDAOImpl();
restaurantService.deleteRestaurantReview(revID);


%>
<script>history.go(-1);</script>
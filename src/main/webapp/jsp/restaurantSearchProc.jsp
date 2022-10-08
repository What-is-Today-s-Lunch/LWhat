<%@page import="lwhat.dao.impl.restaurant.RestaurantSearchDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@page import="lwhat.dao.restaurant.RestaurantDAO"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String codevalue = request.getParameter("code");
	String searchText = request.getParameter("restaurantID");
	
	RestaurantService restayrantService = new RestaurantSearchDAOImpl();
	List<RestaurantDTO>findrestarantlist = restayrantService.searchRestaurant(searchText);
	
	
%>
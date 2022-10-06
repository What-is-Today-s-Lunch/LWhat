<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewUpdateDAOImpl"%>
<%@page import="java.awt.Window"%>
<%@page import="org.apache.catalina.ha.backend.Sender"%>
<%@page import="lwhat.dto.ReviewDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantUpdateDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!DOCTYPE html>
<html lang="ko"> 
    
<%

request.setCharacterEncoding("utf-8");

response.setCharacterEncoding("utf-8");

String url= "restaurantFormTest.jsp?restaurantID="+request.getParameter("restaurantID");

request.setAttribute("restaurantID", request.getParameter("restaurantID"));
String content = request.getParameter("content");
int score = Integer.parseInt(request.getParameter("score"));
int revID = Integer.parseInt(request.getParameter("revID"));


ReviewDTO reviewDTO = new ReviewDTO();
reviewDTO.setContent(content);
reviewDTO.setScore(score);
out.print(reviewDTO.getContent());
out.print(reviewDTO.getScore());

RestaurantService restaurantService = new RestaurantReviewUpdateDAOImpl();
restaurantService.updateRestaurantReview(revID, reviewDTO);



RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/restaurantFormTest.jsp");
dispatcher.forward(request, response);

%>

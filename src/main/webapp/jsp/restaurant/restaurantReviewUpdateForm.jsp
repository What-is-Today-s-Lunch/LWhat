<%@page import="java.text.SimpleDateFormat"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewViewDAOImpl"%>
<%@page import="org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantViewDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl"%>
<%@page import="lwhat.dto.ReviewDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantReviewUpdateDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8" />

<%-- <% 
String seMemID = (String)session.getAttribute("memberID");
int revID = Integer.parseInt(request.getParameter("revID"));

out.print(session.getAttribute("restaurantID"));
String rID = (String)session.getAttribute("restaurantID");

out.print("///////변환"+rID);
pageContext.setAttribute("RID", session.getAttribute("restaurantID"));



RestaurantService restaurantService = new RestaurantReviewViewDAOImpl();
ReviewDTO reviewDTO = restaurantService.viewRestaurantReview(revID);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


pageContext.setAttribute("review", restaurantService.viewRestaurantReview(revID));

 %> --%>

<title>Review 수정</title>
		<table>
            		<colgroup>
            			<col width="700px" />
            			<col width="100px" />
            			<col width="150px" />
            			<col width="100px" />
            			<col width="150px" />
            		</colgroup>
            		<thead>
            			<tr>
            				<th>후기내용</th>
            				<th>작성자</th>
            				<th>작성시간</th>
            				<th>별점</th>
            				<th>수정</th>
            			</tr>
            		</thead>
           </table> 		
            			<form method="post" action="${webapproot}/restaurantreviewupdateproc.do">
            		  		<input type="hidden" name="revID" value="${review.revID}" />
            		  		<input type="hidden" name="restaurantID" value="${RID}" />
            		  		<input name="content" value='${review.content}'>
            		  		<a>${review.memberID_FK}</a>
            		  		<a>${mDate}</a>
            		  		<input name="score" value='${review.score}' />
							<button type="submit">[수정]</button> 
 						</form>
 						</html>
 						
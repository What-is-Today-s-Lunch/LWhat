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
<%

String seMemID = (String)session.getAttribute("memberID");
int revID = Integer.parseInt(request.getParameter("revID"));
out.print("파라미터 변환"+revID+"//");
out.print("로그인 아이디"+seMemID+"//");

RestaurantService restaurantService = new RestaurantReviewViewDAOImpl();

ReviewDTO reviewDTO = restaurantService.viewRestaurantReview(revID);
out.print("리뷰 작성인"+reviewDTO.getMemberID_FK()+"//");
pageContext.setAttribute("review", restaurantService.viewRestaurantReview(revID));

//restaurantService.updateRestaurantReview(revID, restaurantService.viewRestaurantReview(revID));

if(seMemID!=reviewDTO.getMemberID_FK()){
	out.print("alert('남의 댓글은 수정하지 마라탕.')");
}else{

}



out.println("후기 아이디"+request.getParameter("revID"));
out.println("멤버 아이디"+request.getParameter("memberID"));
out.print("<br />");
String restaurantIDParam = 
request.getParameter("restaurantID")==null?"":request.getParameter("restaurantID");
out.println(restaurantIDParam);



%>
${review }

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
            		<tbody>
            			<tr>
            		  		<td>${review.content}</td>
            				<td>${review.memberID_FK}</td>
            				<td>${review.wDate}</td>
            				<td>${review.score}</td>
            				<td><button onclick="location.href='restaurantReviewUpdateProc.jsp?revID=${reviewlist.revID}&&memberID=${reviewlist.memberID_FK}'">[수정]</button></td>
            			</tr>
            		</tbody>
            	</table>
</html>
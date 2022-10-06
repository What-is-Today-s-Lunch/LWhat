<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="javax.swing.plaf.multi.MultiOptionPaneUI"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String realFolder = "";
	String saveFolder = "jsp\\upload";
	String encType = "UTF-8";
	int maxSize = 5*1024*1024;
	ServletContext context = this.getServletContext();
	realFolder = context.getRealPath(saveFolder);
	MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	//파라미터 받음
	String resID=multipartRequest.getParameter("restaurantID");//식당명
	String foodCat=multipartRequest.getParameter("");//식당카테고리
	String TelNum=multipartRequest.getParameter("telNum");//식당전화번호
	String adreAPI=multipartRequest.getParameter("address");//식당주소API
	String adre=multipartRequest.getParameter("address_detail");//상세식당주소
	String latitu = multipartRequest.getParameter("lat");//위도등록
	String longti = multipartRequest.getParameter("long");//경도등록
	
	String file = multipartRequest.getOriginalFileName("file1");//대표사진
	String filename = multipartRequest.getFilesystemName("file1");
	
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID(resID);
	restaurantDTO.setFoodCategory(foodCat);
	restaurantDTO.setrTelNum(TelNum);
	restaurantDTO.setAddresssAPI(adreAPI);
	restaurantDTO.setAddressDetail(adre);
	restaurantDTO.setLatitude(latitu);
	restaurantDTO.setLongitude(longti);
	
	
	
	out.print(resID);
%>


























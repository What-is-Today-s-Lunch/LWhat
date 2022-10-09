<%@page import="java.util.Collection"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantFileListDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.oreilly.servlet.MultipartResponse"%>
<%@page import="lwhat.dto.FoodimageDTO"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantWriteDAOImpl"%>
<%@page import="lwhat.dao.impl.restaurant.RestaurantFileUploadDAOImpl"%>
<%@page import="lwhat.service.restaurant.RestaurantService"%>
<%@page import="lwhat.dao.impl.board.BoardFileUploadDAOImpl"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@page import="java.io.File"%>
<%@page import="lwhat.dto.RestaurantDTO"%>
<%@page import="javax.swing.plaf.multi.MultiOptionPaneUI"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
	String realFolder = "";
	String saveFolder = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/restaurantupload";
	String encType = "UTF-8";
	int maxSize = 5*1024*1024;
	
	//저장경로 지정해줌 
	
	
	//애초에 생성하면 저장되버림 
	MultipartRequest multipartRequest = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	//레스토랑파라미터 받음
	String resID = multipartRequest.getParameter("restaurantID");//식당명
	String restaurantCat = multipartRequest.getParameter("foodcategory");//식당카테고리
	String TelNum = multipartRequest.getParameter("telNum");//식당전화번호
	String adreAPI = multipartRequest.getParameter("address");//식당주소API
	String adre = multipartRequest.getParameter("address_detail");//상세식당주소
	String latitu = multipartRequest.getParameter("lat");//위도등록
	String longti = multipartRequest.getParameter("long");//경도등록
	
	//레스토랑 이미지 파라미터 받음

	
	String foodname = multipartRequest.getParameter("foodname");
	
	//이름변경
	
	//restaurantDTO 설정 
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID(resID);
	restaurantDTO.setFoodCategory(restaurantCat);
	restaurantDTO.setrTelNum(TelNum);
	restaurantDTO.setAddressAPI(adreAPI);
	restaurantDTO.setAddressDetail(adre);
	restaurantDTO.setLatitude(latitu);
	restaurantDTO.setLongitude(longti);
	
	//식당 업로드 Impl
	RestaurantService restaurantService = new RestaurantWriteDAOImpl();
	restaurantService.writeRestaurant(restaurantDTO);
	
	List<RestaurantFoodimageDTO> foodImageList = new ArrayList<RestaurantFoodimageDTO>();
	
	for(int i=1;i<=2;i++){
		String number = String.valueOf(i);//숫자를 문자로 바꿈
		String fileStringname = "file".concat(number);//파일+1, 파일+2 스트링으로 변환
		
		
		String file = multipartRequest.getOriginalFileName(fileStringname);//대표사진
		String filename = multipartRequest.getFilesystemName(fileStringname);
		
		//foodImageDTO 설정
		RestaurantFoodimageDTO foodimageDTO = new RestaurantFoodimageDTO();
		foodimageDTO.setRestaurantID_FK(resID);
		foodimageDTO.setImageCategory(restaurantCat);//사진의 카테고리?? 
		foodimageDTO.setContent(foodname);//사진의 음식이름 	
		foodimageDTO.setCImage(file);	
		
		if(filename!=null){
	File oldFile = new File(saveFolder+"\\"+filename);
	File newFile = new File(saveFolder+"\\"+resID.concat(number.concat(".jpg")));
	oldFile.renameTo(newFile);
	foodimageDTO.setSImage(filename);
	foodImageList.add(foodimageDTO); //DTO 를 리스트에 설정 + 파일명을 db에 저장 
	}
	}
	try{
		RestaurantService restaurantService2 = new RestaurantFileUploadDAOImpl(); //파일 업로드 Impl
		restaurantService2.filesUploadRestaurant(resID, foodImageList);
	}catch(Exception e){
		e.printStackTrace();
	}

	
	response.sendRedirect("mainForm.jsp");
%>


























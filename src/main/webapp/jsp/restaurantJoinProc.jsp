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
	String file1 = multipartRequest.getOriginalFileName("file1");//대표사진
	//String filename1 = multipartRequest.getFilesystemName("file1");
	
	String file2 = multipartRequest.getOriginalFileName("file2");//대표사진
	//String filename2 = multipartRequest.getFilesystemName("file2");
	
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
	/*
	//foodImageDTO 설정
	FoodimageDTO foodimageDTO1 = new FoodimageDTO();
	foodimageDTO1.setRestaurantID_FK(resID);
	foodimageDTO1.setImageCategory(restaurantCat);//사진의 카테고리?? 
	foodimageDTO1.setContent(foodname);//사진의 음식이름 	
	foodimageDTO1.setCImage(file1);	
	//foodimageDTO.setSImage(filename1);	
	
	
	//foodImageDTO2 설정
	FoodimageDTO foodimageDTO2 = new FoodimageDTO();
	foodimageDTO2.setRestaurantID_FK(resID);
	foodimageDTO2.setImageCategory(restaurantCat);//사진의 카테고리?? 
	foodimageDTO2.setContent(foodname);//사진의 음식이름 	
	foodimageDTO2.setCImage(file2);	
	//sfoodimageDTO2.setSImage(filename2);
	// 식당에 따라 사진 등록되는건 바로 보여줄 필요가 없어서 재귀등록 필요 X 
	
	
	//파일 업로드 Impl
	//RestaurantService restaurantServiceFile= new RestaurantFileUploadDAOImpl();
	//restaurantServiceFile.fileUploadRestaurant(restaurantDTO.getRestaurantID(), foodimageDTO);
	
	//받아온 파일 이름 바꿔서 저장하려고함. 여기서 이미지 파일이 경로에 저장됨 
	*/
	List<FoodimageDTO> foodImageList = new ArrayList<FoodimageDTO>();
	
	for(int i=1;i<=2;i++){
		String number = String.valueOf(i);//숫자를 문자로 바꿈
		String fileStringname = "file".concat(number);//파일+1, 파일+2 스트링으로 변환
		
		
		String file = multipartRequest.getOriginalFileName(fileStringname);//대표사진
		String filename = multipartRequest.getFilesystemName(fileStringname);
		
		FoodimageDTO foodimageDTO = new FoodimageDTO();
		foodimageDTO.setRestaurantID_FK(resID);
		foodimageDTO.setImageCategory(restaurantCat);//사진의 카테고리?? 
		foodimageDTO.setContent(foodname);//사진의 음식이름 	
		foodimageDTO.setCImage(file);	
		
		if(filename!=null){
			File oldFile = new File(saveFolder+"\\"+filename);
			File newFile = new File(saveFolder+"\\"+resID.concat(number.concat(".jpg")));
			oldFile.renameTo(newFile);
			foodimageDTO.setSImage(filename);
			foodImageList.add(foodimageDTO);
			}
	}
	try{
		RestaurantService restaurantService2 = new RestaurantFileUploadDAOImpl();
		restaurantService2.filesUploadRestaurant(resID, foodImageList);
	}catch(Exception e){
		e.printStackTrace();
	}

	/*
	if(filename1!=null){
		File oldFile1 = new File(saveFolder+"\\"+filename1);
		File newFile1 = new File(saveFolder+"\\"+resID+"1.jpg");
		oldFile1.renameTo(newFile1);
	}
	if(filename2!=null){
		File oldFile2 = new File(saveFolder+"\\"+filename2);
		File newFile2 = new File(saveFolder+"\\"+resID+"2.jpg");
		oldFile2.renameTo(newFile2);
	}
	
	
	//DTO 를 리스트에 설정 + 파일명을 db에 저장 
	
	foodImageList.add(foodimageDTO);
	foodImageList.add(foodimageDTO2);
	
	try{
		RestaurantService restaurantService2 = new RestaurantFileUploadDAOImpl();
		restaurantService2.filesUploadRestaurant(resID, foodImageList);
	}catch(Exception e){
		e.printStackTrace();
	}
	*/
	
	response.sendRedirect("mainForm.jsp");
%>


























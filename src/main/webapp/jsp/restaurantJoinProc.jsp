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
	
	//restaurantDTO 설정 
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID(resID);
	restaurantDTO.setFoodCategory(foodCat);
	restaurantDTO.setrTelNum(TelNum);
	restaurantDTO.setAddresssAPI(adreAPI);
	restaurantDTO.setAddressDetail(adre);
	restaurantDTO.setLatitude(latitu);
	restaurantDTO.setLongitude(longti);
	
	//foodImageDTO 설정
	FoodimageDTO foodimageDTO = new FoodimageDTO();
	foodimageDTO.setRestaurantID_FK(restaurantID_FK);
	foodimageDTO.setImageCategory(imageCategory);
	foodimageDTO.setContent(content);//사진의 음식이름 	
	foodimageDTO.setCImage(clmage);	
	foodimageDTO.setSImage(sImage);	
	// 식당에 따라 사진 등록되는건 바로 보여줄 필요가 없어서 재귀등록 필요 X 
	
	//식당 업로드 Impl
	RestaurantService restaurantService = new RestaurantWriteDAOImpl();
	restaurantService.writeRestaurant(restaurantDTO);
	
	
	//파일 업로드 Impl
	RestaurantService restaurantServiceFile= new RestaurantFileUploadDAOImpl();
	restaurantServiceFile.fileUploadRestaurant(restaurantDTO.getRestaurantID(), foodimageDTO);
	
	
	//받아온 파일 이름 바꿔서 저장하려고함.
	if(filename!=null){
		File oldFile = new File(saveFolder+"\\"+filename);
		File newFile = new File(saveFolder+"\\"+resID+".jpg");
		oldFile.renameTo(newFile);
	}
	
	out.println("<script>");
	out.println("location.href = '../jsp/mainForm.jsp'");
	out.println("</script>");
	
%>


























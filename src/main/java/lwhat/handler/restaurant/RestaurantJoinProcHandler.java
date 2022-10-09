package lwhat.handler.restaurant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lwhat.dao.impl.restaurant.RestaurantFileUploadDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantWriteDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantJoinProcHandler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		
		//저장경로 지정해줌 
	String realFolder = "";
	String saveFolder = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/restaurantupload";
	String encType = "UTF-8";
	int maxSize = 5*1024*1024;
	
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
	
	//restaurantDTO 설정 
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID(resID);
	restaurantDTO.setFoodCategory(restaurantCat);
	restaurantDTO.setTelNum(TelNum);
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
	
	//메인 페이지 갈 때 매니저일 경우 식당등록을 할 수 있게.
	request.getParameter("memberID");
	
	if(request.getSession().getAttribute("memberID").equals("megaZ")||request.getSession().getAttribute("memberID").equals("megaZ1")
   		 ||request.getSession().getAttribute("memberID").equals("megaZ2")) {
   	 request.setAttribute("manager", true);
   	 return "/jsp/mainForm.jsp";
	}else {
		request.setAttribute("manager", false);
	}
	
	return "/jsp/mainForm.jsp";
	}//process 
	
}//class 

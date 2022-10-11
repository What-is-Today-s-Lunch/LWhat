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

public class RestaurantJoinProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		// 저장경로 지정해줌
		String saveFolder = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/restaurantimage";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;

		MultipartRequest multipartRequest = new MultipartRequest(request, saveFolder, maxSize, encType,
				new DefaultFileRenamePolicy());

		// 레스토랑파라미터 받음
		String resID = multipartRequest.getParameter("restaurantID");// 식당명
		String restaurantCat = multipartRequest.getParameter("foodcategory");// 식당카테고리
		String TelNum = multipartRequest.getParameter("telNum");// 식당전화번호
		String adreAPI = multipartRequest.getParameter("address");// 식당주소API
		String adre = multipartRequest.getParameter("address_detail");// 상세식당주소

		// 레스토랑 이미지 파라미터 받음
		String foodname = multipartRequest.getParameter("foodname");

		// restaurantDTO 설정
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setRestaurantID(resID);
		restaurantDTO.setFoodCategory(restaurantCat);
		restaurantDTO.setTelNum(TelNum);
		restaurantDTO.setAddressAPI(adreAPI);
		restaurantDTO.setAddressDetail(adre);

		// 식당 업로드 Impl
		RestaurantService restaurantService = new RestaurantWriteDAOImpl();
		restaurantService.writeRestaurant(restaurantDTO);

		List<RestaurantFoodimageDTO> restaurantFoodImageList = new ArrayList<RestaurantFoodimageDTO>();

		for (int i = 1; i <= 2; i++) {
			String number = String.valueOf(i);// 숫자를 문자로 바꿈
			String fileStringname = "file".concat(number);// 파일+1, 파일+2 스트링으로 변환

			String file = multipartRequest.getOriginalFileName(fileStringname);// 대표사진
			String filename = multipartRequest.getFilesystemName(fileStringname);

			// foodImageDTO 설정
			RestaurantFoodimageDTO restaurantFoodImageDTO = new RestaurantFoodimageDTO();
			restaurantFoodImageDTO.setRestaurantID_FK(resID);
			restaurantFoodImageDTO.setImageCategory(restaurantCat);// 사진의 카테고리??
			restaurantFoodImageDTO.setContent(foodname);// 사진의 음식이름
			restaurantFoodImageDTO.setCImage(file);
			// 폴더를 만들고 그안에 저장시켜주게끔 mkdir() 써주기

			if (filename != null) {
				File oldFile = new File(saveFolder + "/" + filename);// 이미지 파일 타입으로 지정, cImage 이름
				File saveArc = new File(saveFolder + "/" + resID);// 사진 분류 폴더 생성
				saveArc.mkdir();
				File newFile = new File(saveFolder + "/" + resID + "/" + resID.concat(number.concat(".jpg")));// 사진파일 저장
				oldFile.renameTo(newFile);// sImage 로 변경
				restaurantFoodImageDTO.setSImage(filename);
				restaurantFoodImageList.add(restaurantFoodImageDTO); // DTO 를 리스트에 설정 + 파일명을 db에 저장
			}
		}

		try {
			RestaurantService restaurantService2 = new RestaurantFileUploadDAOImpl(); // 파일이름을 DB에 업로드 Impl
			restaurantService2.filesUploadRestaurant(restaurantFoodImageList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 메인 페이지 갈 때 매니저일 경우 식당등록을 할 수 있게.
		String user = (String) request.getSession().getAttribute("memberID");
		if (user.equals("megaZ") || user.equals("megaZ1") || user.equals("megaZ2")) {
			request.setAttribute("manager", true);
			return "/jsp/mainForm.jsp";
		} else {
			request.setAttribute("manager", false);
		}

		return "/jsp/mainForm.jsp";
	}// process

}// class

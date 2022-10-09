package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;

public class RestaurantFileUploadDAOImpl extends AbstractRestaurantDAOImpl {
// =이미지 사진 여러개 저장
//	private ResultSet rs; 하나만 db에 저장하는거라 의미 x
//	   @Override
//	   public int fileUploadRestaurant(String restaurantID, RestaurantFoodimageDTO foodimageDTO) throws Exception {
//	      String SQL = RestaurantConstants.restaurant.getProperty("FOOD_IMAGE_UPLOAD_SQL");
//	      
//	      try {
//	         PreparedStatement pstmt = getConnection().prepareStatement(SQL);
//	         pstmt.setString(1, restaurantID); // 구지? 라서 바로 박아줌 
//	         pstmt.setString(2, foodimageDTO.getImageCategory());
//	         pstmt.setString(3, foodimageDTO.getCImage());
//	         pstmt.setString(4, foodimageDTO.getSImage());
//	         int result = pstmt.executeUpdate();
//	         closeConnection(pstmt, getConnection());
//	         return result;
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	      }
//	      
//	      return -1;
//	   }
//	   
	   @Override
	   public int filesUploadRestaurant(List<RestaurantFoodimageDTO> list) throws Exception {
	   Connection conn = getConnection();
	   String SQL = " INSERT INTO restaurantfoodimage (restaurantID_FK, imageCategory,cImage, sImage) VALUES (?, ? ,? ,?) ";
	   PreparedStatement pstmt = conn.prepareStatement(SQL);
	   int result = 0;
	   int imgNum = 1;
	   if(list!=null) {
		   for(RestaurantFoodimageDTO restaurantFoodImageDTO : list) {
			   pstmt.setString(1,restaurantFoodImageDTO.getRestaurantID_FK());
			   pstmt.setString(2,restaurantFoodImageDTO.getImageCategory() );
			   pstmt.setString(3,restaurantFoodImageDTO.getCImage() );
			   pstmt.setString(4,restaurantFoodImageDTO.getRestaurantID_FK()+imgNum);
			   result = pstmt.executeUpdate();
			   result = result*result;
			   imgNum++;
		   }//for
	   }//if
	   
	   closeConnection(pstmt, conn);
	   return result;
	   }

}//  class

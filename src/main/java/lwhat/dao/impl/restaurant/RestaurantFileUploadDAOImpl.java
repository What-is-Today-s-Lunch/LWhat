package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;

public class RestaurantFileUploadDAOImpl extends AbstractRestaurantDAOImpl {

	   @Override
	   public int filesUploadRestaurant(List<RestaurantFoodimageDTO> list) throws Exception {
	   Connection conn = getConnection();
	   String SQL = RestaurantConstants.restaurant.getProperty("FOOD_IMAGE_UPLOAD_SQL");
	   //restaurantfoodimage테이블에 새로운 내용을 추가하는 쿼리문
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

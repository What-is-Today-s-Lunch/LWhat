package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lwhat.dto.FoodimageDTO;

public class RestaurantFileUploadDAOImpl extends AbstractRestaurantDAOImpl {
// =Write
	private ResultSet rs;
	   @Override
	   public int fileUploadRestaurant(String restaurantID, FoodimageDTO foodimageDTO) throws Exception {
	      String SQL = " INSERT INTO foodimage (restaurantID_FK, imageCategory,cImage, sImage) VALUES (?, ? ,? ,?) ";
	      
	      try {
	         PreparedStatement pstmt = getConnection().prepareStatement(SQL);
	         pstmt.setString(1, restaurantID); // 구지? 라서 바로 박아줌 
	         pstmt.setString(2, foodimageDTO.getImageCategory());
	         pstmt.setString(3, foodimageDTO.getCImage());
	         pstmt.setString(4, foodimageDTO.getSImage());
	         int result = pstmt.executeUpdate();
	         closeConnection(pstmt, getConnection());
	         return result;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return -1;
	   }
	   
	   @Override
	   public int filesUploadRestaurant(String restaurantID, List<FoodimageDTO> list) throws Exception {
	   Connection conn = getConnection();
	   String SQL = " INSERT INTO foodimage (restaurantID_FK, imageCategory,cImage, sImage) VALUES (?, ? ,? ,?) ";
	   PreparedStatement pstmt = conn.prepareStatement(SQL);
	   int result = 0;
	   if(list!=null) {
		   for(FoodimageDTO foodimageDTO : list) {
			   pstmt.setString(1, foodimageDTO.getRestaurantID_FK());
			   pstmt.setString(2,foodimageDTO.getImageCategory() );
			   pstmt.setString(3,foodimageDTO.getCImage() );
			   pstmt.setString(4,foodimageDTO.getSImage() );
			   result = pstmt.executeUpdate();
			   result = result*result;
		   }//for
	   }//if
	   
	   closeConnection(pstmt, conn);
	   return result;
	   }

}//  class

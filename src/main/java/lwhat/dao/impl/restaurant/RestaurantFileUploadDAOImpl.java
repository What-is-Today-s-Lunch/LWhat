package lwhat.dao.impl.restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	         pstmt.setString(3, foodimageDTO.getClmage());
	         pstmt.setString(4, foodimageDTO.getsImage());
	         int result = pstmt.executeUpdate();
	         closeConnection(pstmt, getConnection());
	         return result;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return -1;
	   }
	   
	   // 게시판에서 밑에껄 써줘야 등록하면서 생기는 글의 아이디를 얻어 올 수 있다. 근데 레스토랑에서는 구지? 
/*	   public int getRestaurantID(String restaurantID) {
	       String sql = " SELECT restaurantID FROM restaurant WHERE restaurantID= ? ";
	       try {
	   
	          PreparedStatement pstmt = getConnection().prepareStatement(sql);
	          pstmt.setString(1,restaurantID );
	          rs = pstmt.executeQuery();
	          if(rs.next()) {
	             return rs.getInt(1);
	          }
	       } catch (SQLException e) {
	         e.printStackTrace();
	      }
	       return 0;
	    }

*/


}//  class

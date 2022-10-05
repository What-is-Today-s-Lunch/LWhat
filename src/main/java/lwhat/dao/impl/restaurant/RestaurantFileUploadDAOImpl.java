package lwhat.dao.impl.restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantFileUploadDAOImpl extends AbstractRestaurantDAOImpl {

	private ResultSet rs;
	   @Override
	   public int fileUploadRestaurant(String cImage, String sImage, String restaurantID) throws Exception {
	      String SQL = " INSERT INTO foodimage (restaurantID_FK, imageCategory,cImage, sImage) VALUES (?, ? ,? ,?) ";
	      
	      try {
	         PreparedStatement pstmt = getConnection().prepareStatement(SQL);
	         pstmt.setInt(1, getRestaurantID(restaurantID));
	         pstmt.setString(2, "testCategory");
	         pstmt.setString(3, cImage);
	         pstmt.setString(4, sImage);
	         int result = pstmt.executeUpdate();
	         closeConnection(pstmt, getConnection());
	         return result;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return -1;
	   }
	   
	   public int getRestaurantID(String restaurantID) {
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




}

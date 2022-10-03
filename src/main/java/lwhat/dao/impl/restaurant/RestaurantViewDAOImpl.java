package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.LwhatConstants;
import lwhat.dto.RestaurantDTO;

public class RestaurantViewDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception {
		Connection conn = getConnection();
		String vIEWSQL = " select * from restaurant where restaurantID=?";

		PreparedStatement pstmt = conn.prepareStatement(vIEWSQL);
		pstmt.setString(1, restaurantID);
		ResultSet rs = pstmt.executeQuery();
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		if (rs != null && rs.next()) {
			restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
			restaurantDTO.setfoodCategory(rs.getString("foodCategory"));
			restaurantDTO.setrTelNum(rs.getString("rTelNum"));
			restaurantDTO.setAddress(rs.getString("address"));
			restaurantDTO.setAddresssAPI(rs.getString("addressAPI"));
			restaurantDTO.setlatitude(rs.getString("latitude"));
			restaurantDTO.setLongitude(rs.getString("longitude"));
		}// if
		closeConnection(rs, pstmt, conn);
		System.out.println("closeConnection, R-DTO Loaded");
		return restaurantDTO;
	}//viewRestaurant

}//class

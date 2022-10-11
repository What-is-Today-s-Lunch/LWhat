package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantViewDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception {
		Connection conn = getConnection();
		String vIEWSQL = RestaurantConstants.restaurant.getProperty("RESTAURANT_VIEW_SQL");
		//restaurant테이블에서 restaurantID와 전달인자가 일치하는것에 대해서 찾아주는 쿼리문

		PreparedStatement pstmt = conn.prepareStatement(vIEWSQL);
		pstmt.setString(1, restaurantID);
		ResultSet rs = pstmt.executeQuery();
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		if (rs != null && rs.next()) {
			restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
			restaurantDTO.setFoodCategory(rs.getString("foodCategory"));
			restaurantDTO.setTelNum(rs.getString("telNum"));
			restaurantDTO.setAddressDetail(rs.getString("addressDetail"));
			restaurantDTO.setAddressAPI(rs.getString("addressAPI"));
			restaurantDTO.setContent(rs.getString("content"));
		}// if
		closeConnection(rs, pstmt, conn);
		System.out.println("closeConnection, R-DTO Loaded");
		return restaurantDTO;
	}//viewRestaurant

}//class

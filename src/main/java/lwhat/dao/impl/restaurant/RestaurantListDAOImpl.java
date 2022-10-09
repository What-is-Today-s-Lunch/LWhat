package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantListDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public List<RestaurantDTO> listRestaurant(String code) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt =  conn.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_LIST_SEARCH_SQL"));
		PreparedStatement pstmt2 =  conn.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_SCORE_SQL"));
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		List<RestaurantDTO>list = new ArrayList<RestaurantDTO>();
		while(rs.next()) {
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
			pstmt2.setString(1, rs.getString("restaurantID"));
			ResultSet rs2 = pstmt2.executeQuery();
			restaurantDTO.setFoodCategory(rs.getString("foodCategory"));
			restaurantDTO.setTelNum(rs.getString("telNum"));
			restaurantDTO.setAddressDetail(rs.getString("addressDetail"));
			restaurantDTO.setAddressAPI(rs.getString("addressAPI"));
			restaurantDTO.setLatitude(rs.getString("latitude"));
			restaurantDTO.setLongitude(rs.getString("longitude"));
			restaurantDTO.setContent(rs.getString("content"));
			while(rs2.next()) {
			restaurantDTO.setScoreAvg(rs2.getDouble(1));
			}
			list.add(restaurantDTO);
		}
		
		closeConnection(rs, pstmt, conn);
		return list;
	}


	

}

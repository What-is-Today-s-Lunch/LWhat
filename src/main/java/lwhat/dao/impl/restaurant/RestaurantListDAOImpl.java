package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.LwhatConstants;
import lwhat.dto.RestaurantDTO;

public class RestaurantListDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public List<RestaurantDTO> listLRestaurant() throws Exception {
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("RESTAURANT_LIST_SEARCH_SQL_PREPEND");
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<RestaurantDTO>list = new ArrayList<RestaurantDTO>();
		while(rs.next()) {
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
			restaurantDTO.setfoodCategory(rs.getString("foodCategory"));
			restaurantDTO.setrTelNum(rs.getString("rTelNum"));
			restaurantDTO.setAddress(rs.getString("address"));
			restaurantDTO.setAddresssAPI(rs.getString("addressAPI"));
			restaurantDTO.setlatitude(rs.getString("latitude"));
			restaurantDTO.setLongitude(rs.getString("longitude"));
		}
		closeConnection(rs, pstmt, conn);
		return list;
	}


	

}

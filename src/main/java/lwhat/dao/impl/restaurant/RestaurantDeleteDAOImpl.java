package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.RestaurantConstants;

public class RestaurantDeleteDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int deleteRestaurant(String restaurantID) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn
				.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_DELETE_SQL"));
		pstmt.setString(1, restaurantID);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return result;
	}

}

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.RestaurantConstants;

public class RestaurantReviewDeleteDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public void deleteRestaurantReview(int revID) throws Exception {
		Connection conn = getConnection();

		PreparedStatement pstmt = conn
				.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_DELETE_SQL"));
		pstmt.setInt(1, revID);
		pstmt.executeUpdate();
		closeConnection(pstmt, conn);

	}// deleteRR

}// class

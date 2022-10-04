package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;

public class RestaurantReviewDeleteDAOImpl extends AbstractRestaurantDAOImpl{
	@Override
	public int deleteRestaurantReview(int revID) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(LwhatConstants.querys.getProperty("REVIEW_DELETE_SQL"));
		pstmt.setInt(1, revID);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return result;
	}
}//class

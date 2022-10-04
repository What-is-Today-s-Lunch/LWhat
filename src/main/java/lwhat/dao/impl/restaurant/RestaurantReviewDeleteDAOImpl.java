package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;

import lwhat.dto.Review;

public class RestaurantReviewWriteDAOImpl extends AbstractRestaurantDAOImpl{
	@Override
	public int deleteRestaurantReview(String revID) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(LwhatConstants.querys.getProperty("REVIEW_DELETE_SQL"));
		pstmt.setString(1, revID);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return result;
	}
}//class

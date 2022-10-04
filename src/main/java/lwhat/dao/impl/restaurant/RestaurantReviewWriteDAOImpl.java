package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;

import lwhat.dto.Review;

public class RestaurantReviewWriteDAOImpl extends AbstractRestaurantDAOImpl{
	@Override
	public int writeReview(Review review) throws Exception {
		
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("REVIEW_WRITE_SQL");
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, review.getRevID());
		pstmt.setString(2,review.getMemberID_FK());
		pstmt.setString(3, review.getRestaurantID_FK());
		pstmt.setInt(4, review.getScore());
		pstmt.setString(5, review.getContent());
		
		int result = pstmt.executeUpdate();
		closeConnection(pstmt,conn);
		System.out.println("Close Connection / Write Completed.");
		return result;
	}
}

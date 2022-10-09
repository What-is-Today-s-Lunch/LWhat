package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;
import lwhat.dto.restaurant.RestaurantReviewDTO;

public class RestaurantReviewWriteDAOImpl extends AbstractRestaurantDAOImpl{
	@Override
	public int writeRestaurantReview(RestaurantReviewDTO reviewDTO) throws Exception {
		
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("REVIEW_WRITE_SQL");
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setString(1,reviewDTO.getMemberID_FK());
		pstmt.setString(2, reviewDTO.getRestaurantID_FK());
		pstmt.setInt(3, reviewDTO.getScore());
		pstmt.setString(4, reviewDTO.getContent());
		
		int result = pstmt.executeUpdate();
		closeConnection(pstmt,conn);
		System.out.println("Close Connection / Write Completed.");
		return result;
	}
}

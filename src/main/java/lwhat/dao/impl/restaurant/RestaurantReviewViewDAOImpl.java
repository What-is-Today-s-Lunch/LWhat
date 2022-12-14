package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantReviewDTO;

public class RestaurantReviewViewDAOImpl extends AbstractRestaurantDAOImpl {

	public RestaurantReviewDTO viewRestaurantReview(int revID) throws Exception {

		Connection conn = getConnection();
		Timestamp t = new Timestamp(System.currentTimeMillis());

		PreparedStatement pstmt = conn
				.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_VIEW_SQL"));
		pstmt.setInt(1, revID);
		ResultSet rs = pstmt.executeQuery();
		RestaurantReviewDTO reviewDTO = new RestaurantReviewDTO();
		if (rs != null && rs.next()) {
			reviewDTO.setRevID(rs.getInt("revID"));
			reviewDTO.setMemberID_FK(rs.getString("memberID_FK"));
			reviewDTO.setContent(rs.getString("content"));
			reviewDTO.setScore(rs.getInt("score"));
			reviewDTO.setmDate(t);
		}
		// 수정시간을 null 값으로 주고 리뷰 업데이트 할 때, now 를 받게끔 함.

		closeConnection(rs, pstmt, conn);
		return reviewDTO;
	}// view

}// class

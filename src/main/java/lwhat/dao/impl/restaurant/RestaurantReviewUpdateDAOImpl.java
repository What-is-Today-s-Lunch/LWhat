package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantReviewDTO;

public class RestaurantReviewUpdateDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int updateRestaurantReview(int revID, RestaurantReviewDTO reviewDTO) throws Exception {
		Connection conn = getConnection();

		String sqlU = RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_UPDATE_SQL");
		// restaurantreview테이블에서 revID와 전달인자(revID)가 일치하는것을 찾아 각각의 컬럼의 값을 바꿔주는 쿼리문

		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		pstmtU.setInt(1, reviewDTO.getScore());
		pstmtU.setString(2, reviewDTO.getContent());
		pstmtU.setInt(3, revID);
		int result = pstmtU.executeUpdate();
		closeConnection(pstmtU, conn);
		return result;
	}//updatereview
} // class

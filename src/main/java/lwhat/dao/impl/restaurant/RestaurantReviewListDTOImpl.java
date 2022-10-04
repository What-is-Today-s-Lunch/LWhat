package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.LwhatConstants;
import lwhat.dto.Review;

public class RestaurantReviewListDTOImpl extends AbstractRestaurantDAOImpl{
	
	public List<Review> listLReview() throws Exception {
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("REVIEW_LIST_SEARCH_SQL_PREPEND");
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Review>list = new ArrayList<Review>();
		while(rs.next()) {
			Review reviewDTO = new Review();
			reviewDTO.setMemberID_FK(rs.getString("memberID_FK"));
			reviewDTO.setRestaurantID_FK(rs.getString("restaurantID_FK"));
			reviewDTO.setContent(rs.getString("content"));
			reviewDTO.setScore(rs.getInt("score"));
			reviewDTO.setwDate(rs.getTimestamp("wdate"));
			reviewDTO.setMdate(rs.getTimestamp("mdate"));
			reviewDTO.setRevID(rs.getInt("revID"));
			list.add(reviewDTO);
		}
		
		closeConnection(rs, pstmt, conn);
		return list;
	}
}

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.LwhatConstants;
import lwhat.dto.ReviewDTO;

public class RestaurantReviewListDTOImpl extends AbstractRestaurantDAOImpl{
	@Override
	public List<ReviewDTO> listRestaurantReview(String restaurantID) throws Exception {
		System.out.println("리뷰의 레스토랑 아이디 : "+restaurantID);
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("REVIEW_LIST_SEARCH_SQL_PREPEND");
		System.out.println(sql);PreparedStatement pstmt =  conn.prepareStatement(sql);
		
		pstmt.setString(1, restaurantID);
		ResultSet rs = pstmt.executeQuery();
		List<ReviewDTO>list = new ArrayList<ReviewDTO>();
		while(rs.next()) {
			ReviewDTO reviewDTO = new ReviewDTO();
			reviewDTO.setRevID(rs.getInt("revID"));
			reviewDTO.setMemberID_FK(rs.getString("memberID_FK"));
			reviewDTO.setRestaurantID_FK(rs.getString("restaurantID_FK"));
			reviewDTO.setScore(rs.getInt("score"));
			reviewDTO.setContent(rs.getString("content"));
			reviewDTO.setwDate(rs.getTimestamp("wDate"));
			reviewDTO.setMdate(rs.getTimestamp("mDate"));
			list.add(reviewDTO);
		}
		
		closeConnection(rs, pstmt, conn);
		return list;
	}
}

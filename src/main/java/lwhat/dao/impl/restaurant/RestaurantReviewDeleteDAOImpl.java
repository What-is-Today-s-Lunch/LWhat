package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RestaurantReviewDeleteDAOImpl extends AbstractRestaurantDAOImpl{

	@Override
	public void deleteRestaurantReview(int revID) throws Exception {
Connection conn = getConnection();
String sql = " delete from review where revID=? ";

PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, revID);
pstmt.executeUpdate();
closeConnection(pstmt, conn);

	}//deleteRR

	
	
}//class

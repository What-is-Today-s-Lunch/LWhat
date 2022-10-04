package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.Review;

public class RestaurantReviewUpdateDAOImpl extends AbstractRestaurantDAOImpl{

	@Override 
	public int updateRestaurantReview(String revID,RestaurantDTO restaurantDTO) throws Exception {
		Connection conn = getConnection();
		
		String sqlU = LwhatConstants.querys.getProperty("REVIEW_UPDATE_SQL");
		System.out.println("rev-U 쿼리 로딩"+sqlU);
		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		
		if (revID==restaurantDTO.getRestaurantID()){
		pstmtU.setString(1,restaurantDTO.getfoodCategory());
		pstmtU.setString(2,restaurantDTO.getrTelNum() );
		pstmtU.setString(3,restaurantDTO.getAddress() );
		pstmtU.setString(4,restaurantDTO.getlatitude() );
		pstmtU.setString(5,restaurantDTO.getLongitude() );
		pstmtU.setString(6,restaurantDTO.getAddresssAPI() );
		pstmtU.setString(7,restaurantDTO.getRestaurantID() );
		
		int result = pstmtU.executeUpdate(); 
		closeConnection(pstmtU, conn);
		System.out.println("close Connection / return Update int result");
		return result;
		}else {
			closeConnection(pstmtU, conn);
			System.out.println("ERROR ERUPTION , WRONG revID");
			return 0;}
	}
} //class 

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.LwhatConstants;
import lwhat.dto.RestaurantDTO;

public class RestaurantUpdateDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int updateRestaurant(String restaurantID,RestaurantDTO restaurantDTO) throws Exception {
		Connection conn = getConnection();
		String sql = " select * from restaurant where restaurantID = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		String sqlU = LwhatConstants.querys.getProperty("RESTAURANT_UPDATE_SQL");
		
		System.out.println("U 쿼리 로딩"+sqlU);
		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		pstmt.setString(1, sqlU);
		
		pstmtU.setString(1,restaurantDTO.getfoodCategory());
		pstmtU.setString(2,restaurantDTO.getrTelNum() );
		pstmtU.setString(3,restaurantDTO.getAddress() );
		pstmtU.setString(4,restaurantDTO.getlatitude() );
		pstmtU.setString(5,restaurantDTO.getLongitude() );
		pstmtU.setString(6,restaurantDTO.getAddresssAPI() );
		pstmtU.setString(7,restaurantDTO.getRestaurantID() );
		// 완료 : 쿼리 수정됨에 따라 순서 바꿔줘야함 
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		System.out.println("close Connection / return Update int result");
		return result;
	}// updateR


}//class

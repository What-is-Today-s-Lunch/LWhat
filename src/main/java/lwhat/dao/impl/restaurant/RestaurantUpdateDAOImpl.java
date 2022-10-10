package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantUpdateDAOImpl extends AbstractRestaurantDAOImpl {

	@Override 
	public int updateRestaurant(String restaurantID,RestaurantDTO restaurantDTO) throws Exception {
		Connection conn = getConnection();
		
		String sqlU = RestaurantConstants.restaurant.getProperty("RESTAURANT_UPDATE_SQL");
		System.out.println("U 쿼리 로딩"+sqlU);
		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		
		if (restaurantID==restaurantDTO.getRestaurantID()){
		pstmtU.setString(1,restaurantDTO.getFoodCategory());
		pstmtU.setString(2,restaurantDTO.getTelNum() );
		pstmtU.setString(3,restaurantDTO.getAddressDetail() );
		pstmtU.setString(4,restaurantDTO.getAddressAPI() );
		pstmtU.setString(5,restaurantDTO.getContent());
		pstmtU.setString(6,restaurantDTO.getRestaurantID() );
		
		int result = pstmtU.executeUpdate(); 
		closeConnection(pstmtU, conn);
		System.out.println("close Connection / return Update int result");
		return result;
		}else {
			closeConnection(pstmtU, conn);
			System.out.println("ERROR ERUPTION , WRONG ID");
			return 0;}
		
	}// updateR


}//class

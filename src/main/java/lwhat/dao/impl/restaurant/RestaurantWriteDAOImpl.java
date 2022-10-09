package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantWriteDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int writeRestaurant(RestaurantDTO restaurantDTO) throws Exception {
		
		Connection conn = getConnection();
		String sql =" insert into restaurant (restaurantID, foodCategory, telNum, addressDetail, addressAPI, latitude, longitude, content) values (?, ?, ?, ?, ?, ?, ?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, restaurantDTO.getRestaurantID());
		pstmt.setString(2, restaurantDTO.getFoodCategory());
		pstmt.setString(3, restaurantDTO.getTelNum());
		pstmt.setString(4, restaurantDTO.getAddressDetail());
		pstmt.setString(5, restaurantDTO.getAddressAPI());
		pstmt.setString(6, restaurantDTO.getLatitude());
		pstmt.setString(7, restaurantDTO.getLongitude());
		pstmt.setString(8, restaurantDTO.getContent());
			
		int result = pstmt.executeUpdate();
		closeConnection(pstmt,conn);
		System.out.println("Close Connection / Write Completed.");
		return result;
	}



}

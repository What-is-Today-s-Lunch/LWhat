package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.dto.RestaurantDTO;

public class RestaurantWriteDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int writeRestaurant(RestaurantDTO restarauntDTO) throws Exception {
		
		Connection conn = getConnection();
		String sql =" insert into restaurant (restaurantID, foodCategory, rTelNum, address, addressAPI, latitude, longitude, content) values (?, ?, ?, ?, ?, ?, ?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, restarauntDTO.getRestaurantID());
		pstmt.setString(2, restarauntDTO.getFoodCategory());
		pstmt.setString(3, restarauntDTO.getrTelNum());
		pstmt.setString(4, restarauntDTO.getAddressDetail());
		pstmt.setString(5, restarauntDTO.getAddresssAPI());
		pstmt.setString(6, restarauntDTO.getLatitude());
		pstmt.setString(7, restarauntDTO.getLongitude());
		pstmt.setString(8, restarauntDTO.getContent());
			
		int result = pstmt.executeUpdate();
		closeConnection(pstmt,conn);
		System.out.println("Close Connection / Write Completed.");
		return result;
	}



}

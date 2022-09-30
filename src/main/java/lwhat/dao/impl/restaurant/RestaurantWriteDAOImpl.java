package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.dto.RestaurantDTO;

public class RestaurantWriteDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int writeRestaurant(RestaurantDTO restarauntDTO) throws Exception {
		
		Connection conn = getConnection();
		String sql =" insert into restaurant (restaurantID, foodCategory, rTelNum, address, addressAPI, latitude, longitude) values (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, restarauntDTO.getRestaurantID());
		pstmt.setString(2, restarauntDTO.getfoodCategory());
		pstmt.setString(3, restarauntDTO.getrTelNum());
		pstmt.setString(4, restarauntDTO.getAddress());
		pstmt.setString(5, restarauntDTO.getAddresssAPI());
		pstmt.setString(6, restarauntDTO.getlatitude());
		pstmt.setString(7, restarauntDTO.getLongitude());
			
		int result = pstmt.executeUpdate();
		closeConnection(pstmt,conn);
		System.out.println("Close Connection / Write Completed.");
		return result;
	}



}

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.dto.RestaurantDTO;

public class RestaurantSearchDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public List<RestaurantDTO>searchRestaurant(String searchText) throws Exception{
			Connection conn = getConnection();
			String sql = " select * from restaurant where restaurantID like '%?%' ";
			String sql2 = " select round(avg(score),1) from review r  inner join restaurant r2  on r.restaurantID_FK = r2.restaurantID where restaurantID_FK = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 =  conn.prepareStatement(sql2);
			pstmt.setString(1, searchText);
			ResultSet rs = pstmt.executeQuery();
			List<RestaurantDTO>list = new ArrayList<RestaurantDTO>();
			while(rs.next()) {
				RestaurantDTO restaurantDTO = new RestaurantDTO();
				restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
				pstmt2.setString(1, rs.getString("restaurantID"));
				ResultSet rs2 = pstmt2.executeQuery();
				restaurantDTO.setFoodCategory(rs.getString("foodCategory"));
				restaurantDTO.setrTelNum(rs.getString("rTelNum"));
				restaurantDTO.setAddressDetail(rs.getString("addressDetail"));
				restaurantDTO.setAddressAPI(rs.getString("addressAPI"));
				restaurantDTO.setLatitude(rs.getString("latitude"));
				restaurantDTO.setLongitude(rs.getString("longitude"));
				restaurantDTO.setContent(rs.getString("content"));
				while(rs2.next()) {
				restaurantDTO.setScoreAvg(rs2.getDouble(1));
				}
				list.add(restaurantDTO);
			}
			
			closeConnection(rs, pstmt, conn);
			return list;
	}
}

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantSearchDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public List<RestaurantDTO>searchRestaurant(String searchText) throws Exception{
			Connection conn = getConnection();
			String sql = RestaurantConstants.restaurant.getProperty("RESTAURANT_SEARCH_SQL");
			sql += ("like '%" + searchText + "%' ");//restaurant테이블에 restaurantID컬럼에 전달인자가 포함된것을 찾아주는 쿼리문
			String sql2 = RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_SCORE_SQL");
			//레스토랑의 평점을 뽑아주는 쿼리문
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 =  conn.prepareStatement(sql2);
			//pstmt.setString(1, searchText);
			ResultSet rs = pstmt.executeQuery();
			List<RestaurantDTO>list = new ArrayList<RestaurantDTO>();
			while(rs.next()) {
				RestaurantDTO restaurantDTO = new RestaurantDTO();
				restaurantDTO.setRestaurantID(rs.getString("restaurantID"));
				pstmt2.setString(1, rs.getString("restaurantID"));
				ResultSet rs2 = pstmt2.executeQuery();
				restaurantDTO.setFoodCategory(rs.getString("foodCategory"));
				restaurantDTO.setTelNum(rs.getString("telNum"));
				restaurantDTO.setAddressDetail(rs.getString("addressDetail"));
				restaurantDTO.setAddressAPI(rs.getString("addressAPI"));
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

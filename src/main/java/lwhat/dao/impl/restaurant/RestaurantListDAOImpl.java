package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantDTO;

public class RestaurantListDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public List<RestaurantDTO> listRestaurant(String code) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt =  conn.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_LIST_SEARCH_SQL"));
		//restaurant테이블에서 foodCategory와 전달인자(code)가 일치 하는것을 찾아주는 쿼리문
		PreparedStatement pstmt2 =  conn.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_SCORE_SQL"));
		//restaurantreview테이블에서 restaurant테이블을 참조하여 restaurantID와 일치 하는것에 대해서 찾아 평균을 구해주는 쿼리문
		pstmt.setString(1, code);
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

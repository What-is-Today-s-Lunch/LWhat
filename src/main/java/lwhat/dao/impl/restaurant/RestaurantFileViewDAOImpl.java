package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.dto.restaurant.RestaurantFoodimageDTO;

public class RestaurantFileViewDAOImpl extends AbstractRestaurantDAOImpl {
	
	@Override
	public RestaurantFoodimageDTO fileViewRestaurant(int fImageID) throws Exception{
		Connection conn = getConnection();
		String sql = " select * from foodimage where fImageID=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, fImageID);
		ResultSet rs = pstmt.executeQuery();
		RestaurantFoodimageDTO foodimageDTO = null;
		if(rs!=null&& rs.next()) {
				foodimageDTO = new RestaurantFoodimageDTO();
				foodimageDTO.setfImageID(rs.getInt("fImageID"));
				foodimageDTO.setRestaurantID_FK(rs.getString("restaurantID_FK"));
				foodimageDTO.setImageCategory(null);
				foodimageDTO.setContent(null);
				foodimageDTO.setCImage(rs.getString("cImage"));
				foodimageDTO.setSImage(rs.getString("sImage"));
				System.out.println("View Loading...");
		}//if	
		closeConnection(rs, pstmt, conn);
		return foodimageDTO;
		}//view
	}//class

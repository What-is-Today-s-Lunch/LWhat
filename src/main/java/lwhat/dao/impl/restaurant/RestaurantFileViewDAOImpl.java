package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;

public class RestaurantFileViewDAOImpl extends AbstractRestaurantDAOImpl {
	
	@Override
	public RestaurantFoodimageDTO fileViewRestaurant(int fImageID) throws Exception{
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(RestaurantConstants.restaurant.getProperty("RESTAURANT_FILE_VIEW_SQL"));
		//restaurantfoodimage테이블에서 fImageID(파일에 저장된 사진의 아이디)와 전달인자가 일치하는것을 찾아주는 쿼리문
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

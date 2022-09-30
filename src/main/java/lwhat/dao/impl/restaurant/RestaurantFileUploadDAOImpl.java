package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import lwhat.constants.LwhatConstants;
import lwhat.dto.FoodimageDTO;
import lwhat.dto.RestaurantDTO;

public class RestaurantFileUploadDAOImpl extends AbstractRestaurantDAOImpl {

	@Override
	public int fileUploadRestaurant(String restaurantID, List<FoodimageDTO>list ) throws Exception {
		Connection conn = getConnection();
		String sql = LwhatConstants.querys.getProperty("FOOD_IMAGE_WRITE_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,restaurantID);
		int result = 0;
		if(list!=null) {
			for(FoodimageDTO foodimageDTO : list) {
				pstmt.setInt(1, foodimageDTO.getfImageID());
				pstmt.setString(2, foodimageDTO.getRestaurantID_FK());
				pstmt.setString(3, foodimageDTO.getImageCategory());
				pstmt.setString(4, foodimageDTO.getContent());
				pstmt.setString(5, foodimageDTO.getClmage());
				pstmt.setString(6, foodimageDTO.getsImage());
				result = pstmt.executeUpdate();
				result = result * result;
			}
		}
		closeConnection(pstmt, conn);
		return result;
		
	}


}

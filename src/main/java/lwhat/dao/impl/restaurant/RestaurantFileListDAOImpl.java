package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lwhat.dto.restaurant.RestaurantFoodimageDTO;

public class RestaurantFileListDAOImpl extends AbstractRestaurantDAOImpl {
	
	public List<RestaurantFoodimageDTO>fileListRestaurant(String restaurantID) throws Exception{
		Connection conn = getConnection();
		String sql = " select * from foodimage where restaurantID=? order by bfid desc ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, restaurantID);
		ResultSet rs = pstmt.executeQuery();
		List<RestaurantFoodimageDTO> list = new ArrayList<RestaurantFoodimageDTO>();
		if(rs!=null) {
			while(rs.next()) {
				RestaurantFoodimageDTO foodimageDTO = new RestaurantFoodimageDTO();
				foodimageDTO.setfImageID(rs.getInt("fImageID"));
				foodimageDTO.setRestaurantID_FK(rs.getString("restaurantID_FK"));
				foodimageDTO.setContent(rs.getString("content"));
				foodimageDTO.setImageCategory(rs.getString("imageCategory"));
				foodimageDTO.setCImage(rs.getString("cImage"));
				foodimageDTO.setSImage(rs.getString("sImage"));
				list.add(foodimageDTO);
				System.out.println("이미지 리스트 등록"+list);
			}//inner while
		}// outter if
		closeConnection(rs,pstmt,conn);
		return list;
	}//fileList
}//class

package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import lwhat.constants.LwhatConstants;
import lwhat.dto.ReviewDTO;

public class RestaurantReviewViewDAOImpl extends AbstractRestaurantDAOImpl{

	public ReviewDTO viewRestaurantReview(int revID) throws Exception {
		
	Connection conn = getConnection();
	
	String sql = " select memberID_FK, score, content, mDate from review where revID=? ";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt.setInt(1, revID);
	 ResultSet rs = pstmt.executeQuery();
	 ReviewDTO reviewDTO = new ReviewDTO();
	 if(rs!=null && rs.next()) {
		 reviewDTO.setMemberID_FK(rs.getString("memberID_FK"));
		reviewDTO.setContent(rs.getString("content"));
		reviewDTO.setScore(rs.getInt("score"));
	 }
	 // System.out.println(rs.getString("memberID_FK"));
	//수정시간을 null 값으로 주고 리뷰 업데이트 할 때, now 를 받게끔 함. 
	
	 closeConnection(rs, pstmt, conn);
	 return reviewDTO;
	}//view

}//class

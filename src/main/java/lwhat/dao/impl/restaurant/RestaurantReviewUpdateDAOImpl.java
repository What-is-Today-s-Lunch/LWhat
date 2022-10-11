package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.RestaurantConstants;
import lwhat.dto.restaurant.RestaurantReviewDTO;

public class RestaurantReviewUpdateDAOImpl extends AbstractRestaurantDAOImpl{

	@Override 
	public int updateRestaurantReview(int revID,RestaurantReviewDTO reviewDTO) throws Exception {
		Connection conn = getConnection();
		
		String sqlU = RestaurantConstants.restaurant.getProperty("RESTAURANT_REVIEW_UPDATE_SQL");
		//restaurantreview테이블에서 revID와 전달인자(revID)가 일치하는것을 찾아 각각의 컬럼의 값을 바꿔주는 쿼리문
		
		System.out.println("rev-U 쿼리 로딩"+sqlU);
		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		// TODO : 로그인한 사람의 멤버아이디를 받아오고 멤버아이디가 가진 리뷰아이디를 연결시켜줘야함. 일단은 메소드테스트
		//if (revID==session.getRevID()){
		pstmtU.setInt(1, reviewDTO.getScore());
		pstmtU.setString(2, reviewDTO.getContent());
		pstmtU.setInt(3, revID);
		int result = pstmtU.executeUpdate(); 
		closeConnection(pstmtU, conn);
		System.out.println("close Connection / return REV-Update int result");
		return result;
//		}else {
//			closeConnection(pstmtU, conn);
//			System.out.println("ERROR ERUPTION , WRONG revID");
//			return 0;}
	}
} //class 

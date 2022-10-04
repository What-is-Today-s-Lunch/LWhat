package lwhat.dao.impl.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import lwhat.constants.LwhatConstants;
import lwhat.dto.ReviewDTO;

public class RestaurantReviewUpdateDAOImpl extends AbstractRestaurantDAOImpl{

	@Override 
	public int updateRestaurantReview(int revID,ReviewDTO reviewDTO) throws Exception {
		Connection conn = getConnection();
		
		String sqlU = LwhatConstants.querys.getProperty("REVIEW_UPDATE_SQL");
		System.out.println("rev-U 쿼리 로딩"+sqlU);
		PreparedStatement pstmtU = conn.prepareStatement(sqlU);
		System.out.println(reviewDTO.getRevID());
		// TODO : 로그인한 사람의 멤버아이디를 받아오고 멤버아이디가 가진 리뷰아이디를 연결시켜줘야함. 일단은 메소드테스트
		//if (revID==session.getRevID()){
		pstmtU.setString(1, reviewDTO.getMemberID_FK());
		pstmtU.setString(2, reviewDTO.getRestaurantID_FK());
		pstmtU.setInt(3, reviewDTO.getScore());
		pstmtU.setString(4, reviewDTO.getContent());
		pstmtU.setInt(5, revID);
		
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

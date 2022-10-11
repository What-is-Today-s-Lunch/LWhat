package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.MemberConstants;
import lwhat.dto.member.MemberDTO;
import lwhat.service.member.MemberService;
import lwhat.util.ConnectionManager;

public class MemberJoinDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
		int result;
		try {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(MemberConstants.props.getProperty("JOIN_SQL"));
		pstmt.setString(1, memberDTO.getMemberID());
		pstmt.setString(2, memberDTO.getMemberPW());
		pstmt.setString(3, memberDTO.getNickName());
		pstmt.setString(4, memberDTO.getEmail());
		pstmt.setString(5, memberDTO.getName());
		result = pstmt.executeUpdate(); // 결과값 return =1 이라면 정상적으로 전송
		closeConnection(pstmt, conn);
		return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류 (memberID가 pk이기 때문에 데이터 베이스 오류)
	}
}

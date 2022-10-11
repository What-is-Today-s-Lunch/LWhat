package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.MemberConstants;
import lwhat.service.member.MemberService;

public class MemberLoginDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	@Override
	public int loginMember(String memberID, String memberPW)throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(MemberConstants.props.getProperty("LOGIN_SQL"));
		pstmt.setString(1, memberID);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			// 쿼리문으로 가져온 데이터베이스 패스워드와 입력한 패스워드가 같을때 return 1
			if (rs.getString(1).equals(memberPW)) {
				closeConnection(rs, pstmt, conn);
				return 1; // 로그인 성공
			} else
				return 0; // PW 불일치
		}
		return -1; // ID가 없음
	}
}
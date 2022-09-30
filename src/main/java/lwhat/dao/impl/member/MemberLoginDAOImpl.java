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
		// 정해진 SQL 문장을 데이터 베이스에 삽입
		PreparedStatement pstmt = conn.prepareStatement(MemberConstants.props.getProperty("LOGIN_SQL"));
		// 쿼리문에 ?에 들어갈 변수 = 쿼리문은 멤버id에 있는 멤버pw를 셀렉트하는것
		pstmt.setString(1, memberID);
		// 실행한 결과를 담아주기
		ResultSet rs = pstmt.executeQuery();
		// 결과가 존재할때 실행,
		// 멤버id 가 없어서 rs에 결과가 없을때
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
package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.MemberConstants;
import lwhat.dto.MemberDTO;
import lwhat.service.member.MemberService;

public class MemberViewDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	@Override
	public MemberDTO viewMembers(String memberID) throws Exception {
		
		String sql = "select * from memberinfo where memberID = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Members members = new Members();
		}
	}
}

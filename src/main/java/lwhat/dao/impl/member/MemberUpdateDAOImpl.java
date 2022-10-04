package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.MemberConstants;
import lwhat.dto.MemberDTO;
import lwhat.service.member.MemberService;

public class MemberUpdateDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	@Override
	public void updateMember(MemberDTO memberDTO) throws Exception {
		/*
		 * String sql =
		 * "update memberinfo set memberPW=?, nickName=?, email=?, name=? where memberID=?"
		 * ;
		 */
		Connection conn = getConnection();
		PreparedStatement pstmt 
		= conn.prepareStatement(MemberConstants.props.getProperty("MEMBER_UPDATE_SQL"));
		pstmt.setString(1, memberDTO.getMemberPW());
		pstmt.setString(2, memberDTO.getNickName());
		pstmt.setString(3, memberDTO.getEmail());
		pstmt.setString(4, memberDTO.getName());
		pstmt.setString(5, memberDTO.getMemberID());
		pstmt.executeUpdate();
		closeConnection(pstmt, conn);
	}
}

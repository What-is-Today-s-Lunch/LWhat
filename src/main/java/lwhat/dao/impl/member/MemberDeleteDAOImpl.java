package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.MemberConstants;
import lwhat.service.member.MemberService;

public class MemberDeleteDAOImpl extends AbstractMemberDAOImpl implements MemberService {
	//멤버삭제 메소드
	   @Override
	   public void deleteMember(String memberID) throws Exception {
		   Connection conn = getConnection();
	         PreparedStatement pstmt 
	         = conn.prepareStatement(MemberConstants.props.getProperty("DELETE_SQL"));
	         pstmt.setString(1, memberID);
	         pstmt.executeUpdate();
	         closeConnection(pstmt, conn);
	      }
}

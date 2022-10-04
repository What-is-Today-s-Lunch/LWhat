package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import lwhat.constants.MemberConstants;
import lwhat.service.member.MemberService;

public class MemberDeleteDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	   @Override
	   public void deleteMember(String memberID) throws Exception {
			/* String sql = "delete from memberinfo where memberID=?"; */
		   Connection conn = getConnection();
	         PreparedStatement pstmt 
	         = conn.prepareStatement(MemberConstants.props.getProperty("DELETE_SQL"));
	         pstmt.setString(1, memberID);
	         pstmt.executeUpdate();
	         closeConnection(pstmt, conn);
	         //System.out.println(result);
	      } // deleteMember
}

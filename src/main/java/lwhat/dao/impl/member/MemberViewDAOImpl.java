package lwhat.dao.impl.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.MemberConstants;
import lwhat.dto.member.MemberDTO;
import lwhat.service.member.MemberService;
import lwhat.util.ConnectionManager;

public class MemberViewDAOImpl extends AbstractMemberDAOImpl implements MemberService {

	@Override
	public MemberDTO viewMembers(String memberID) throws Exception {
		MemberDTO memberDTO =null;
		Connection conn = getConnection();
		/* String sql = "select * from memberinfo where memberID=?"; */
		PreparedStatement pstmt 
		= conn.prepareStatement(MemberConstants.props.getProperty("MEMBER_VIEW_SQL"));
		pstmt.setString(1, memberID);
		
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setMemberID(rs.getString("memberID"));
			memberDTO.setMemberPW(rs.getString("memberPW"));
			memberDTO.setNickName(rs.getString("nickName"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setName(rs.getString("Name"));
			memberDTO.setjoinDate(rs.getTimestamp("joinDate"));
		}
		System.out.println("---------------"+memberDTO+"---------------");
		ConnectionManager.closeConnection(rs, pstmt, conn);
		return memberDTO;
	}
	
	@Override
	public MemberDTO viewMember(String Name, String email) throws Exception {
		MemberDTO memberDTO =null;
		Connection conn = getConnection();
		String sql = "select * from memberinfo where name=? AND email=?";
		PreparedStatement pstmt 
		= conn.prepareStatement(sql);
		pstmt.setString(1, Name);
		pstmt.setString(2, email);
		
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setMemberID(rs.getString("memberID"));
			memberDTO.setMemberPW(rs.getString("memberPW"));
			memberDTO.setNickName(rs.getString("nickName"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setName(rs.getString("Name"));
			memberDTO.setjoinDate(rs.getTimestamp("joinDate"));
		}
		closeConnection(rs, pstmt, conn);
//		System.out.println("---------------"+memberDTO+"---------------");
		return memberDTO;
	}
}

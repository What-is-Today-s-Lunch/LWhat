package lwhat.dao.impl.member;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.MemberDTO;
import lwhat.service.member.MemberService;

public abstract class AbstractMemberDAOImpl extends LWhatConnectionDAOImpl implements MemberService {

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteMember(String MemberID) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public MemberDTO viewMembers(String memberID) throws Exception {
		return null;
		// TODO Auto-generated method stub
		
	}
	public MemberDTO viewMember(String Name, String email) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int loginMember(String memberID, String memberPW) throws Exception {
		return 0;
		// TODO Auto-generated method stub
	}
}

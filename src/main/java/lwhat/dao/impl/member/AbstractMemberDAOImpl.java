package lwhat.dao.impl.member;

import java.util.ArrayList;

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
	public void deleteMember() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO viewMembers(String memberID) throws Exception {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int loginMember(String memberID, String memberPW) throws Exception {
		return 0;
		// TODO Auto-generated method stub
	}
}

package lwhat.dao.member;

import lwhat.service.member.MemberService;

public interface MemberDAO extends MemberService{

	@Override
	default void joinMember() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteMember() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void updateMember() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void viewMembers() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	default int loginMember(String memberID, String memberPW) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

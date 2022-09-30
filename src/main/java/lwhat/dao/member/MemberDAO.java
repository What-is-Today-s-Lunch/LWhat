package lwhat.dao.member;

import lwhat.service.member.MemberService;

public interface MemberDAO extends MemberService{

	public void joinMember() throws Exception;

	public void deleteMember() throws Exception;

	public void updateMember() throws Exception;

	public void viewMembers() throws Exception;
	
	public int loginMember(String memberID, String memberPW) throws Exception;

}

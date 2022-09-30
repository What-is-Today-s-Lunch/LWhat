package lwhat.service.member;

import lwhat.service.LWhatService;

public interface MemberService extends LWhatService {

	public void joinMember() throws Exception;

	public void deleteMember() throws Exception;

	public void updateMember() throws Exception;

	public void viewMembers() throws Exception;
	
	public int loginMember(String memberID, String memberPW) throws Exception;
}

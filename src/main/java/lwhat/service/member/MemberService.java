package lwhat.service.member;

import lwhat.dto.MemberDTO;
import lwhat.service.LWhatService;

public interface MemberService extends LWhatService {

	public int joinMember(MemberDTO memberDTO) throws Exception;

	public void deleteMember(String MemberID) throws Exception;

	public void updateMember(MemberDTO memberDTO) throws Exception;

	public MemberDTO viewMembers(String memberID) throws Exception;
	
	public MemberDTO viewMember(String Name, String email) throws Exception;
	
	public int loginMember(String memberID, String memberPW) throws Exception;
}

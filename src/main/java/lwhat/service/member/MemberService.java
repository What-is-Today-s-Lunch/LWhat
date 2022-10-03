package lwhat.service.member;

import java.util.ArrayList;

import lwhat.dto.MemberDTO;
import lwhat.service.LWhatService;

public interface MemberService extends LWhatService {

	public int joinMember(MemberDTO memberDTO) throws Exception;

	public void deleteMember() throws Exception;

	public void updateMember() throws Exception;

	public MemberDTO viewMembers(String memberID) throws Exception;
	
	public int loginMember(String memberID, String memberPW) throws Exception;
}

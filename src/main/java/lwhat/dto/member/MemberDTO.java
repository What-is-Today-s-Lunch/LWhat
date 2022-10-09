package lwhat.dto.member;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberDTO implements Serializable{
	public static final long serialVersionUID = 328478938942843984L;
	
	private String memberID;
	private String memberPW;
	private String nickName;
	private String email;
	private String name;
	private Timestamp joinDate;
	
	public MemberDTO() {
		
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPW() {
		return memberPW;
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getjoinDate() {
		return joinDate;
	}
	public void setjoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberID=" + memberID + ", memberPW=" + memberPW + ", nickName=" + nickName + ", email="
				+ email + ", name=" + name + ", joinDate=" + joinDate + "]";
	}
	
	
}

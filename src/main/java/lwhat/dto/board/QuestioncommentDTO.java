package lwhat.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

public class QuestioncommentDTO implements Serializable{
	public static final long serialVersionUID = 321118118941113583L;
	private int qCommentID;
	private String content;
	private int qPostingID; // questionposting의 qPostingID 와 연결(외래키)
	private String memberID_FK;// questionposting의 memberID_FK 와 연결(외래키)
	private String wDate;
	
	public QuestioncommentDTO() {
		
	}

	public int getqCommentID() {
		return qCommentID;
	}

	public void setqCommentID(int qCommentID) {
		this.qCommentID = qCommentID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getqPostingID() {
		return qPostingID;
	}

	public void setqPostingID_FK(int qPostingID) {
		this.qPostingID = qPostingID;
	}

	public String getMemberID_FK() {
		return memberID_FK;
	}

	public void setMemberID_FK(String memberID_FK) {
		this.memberID_FK = memberID_FK;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	@Override
	public String toString() {
		return "QuestioncommentDTO [qCommentID=" + qCommentID + ", content=" + content + ", qPostingID_FK="
				+ qPostingID + ", memberID_FK=" + memberID_FK + ", wDate=" + wDate + "]";
	}

	
	
}

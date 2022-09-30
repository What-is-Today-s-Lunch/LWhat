package lwhat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class GeneralcommentDTO implements Serializable{
	public static final long serialVersionUID = 321118118942113983L;
	private int gCommentID;
	private String memberID_FK;
	private int postingID_FK; //genralposting의 gPostingID에 연결 (외래키)
	private String boardCategory;
	private String content;
	private Timestamp wDate;
	private Timestamp mDate;
	
	public GeneralcommentDTO() {}
	
	
	public int getgCommentID() {
		return gCommentID;
	}
	public void setgCommentID(int gCommentID) {
		this.gCommentID = gCommentID;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	public Timestamp getmDate() {
		return mDate;
	}
	public void setmDate(Timestamp mDate) {
		this.mDate = mDate;
	}
	public String getMemberID_FK() {
		return memberID_FK;
	}
	public void setMemberID_FK(String memberID_FK) {
		this.memberID_FK = memberID_FK;
	}
	public int getPostingID_FK() {
		return postingID_FK;
	}
	public void setPostingID_FK(int postingID_FK) {
		this.postingID_FK = postingID_FK;
	}
	@Override
	public String toString() {
		return "GeneralcommentDTO [gCommentID=" + gCommentID + ", boardCategory=" + boardCategory + ", content="
				+ content + ", wDate=" + wDate + ", mDate=" + mDate + ", memberID_FK=" + memberID_FK + ", postingID_FK="
				+ postingID_FK + "]";
	}
	
	
	
}

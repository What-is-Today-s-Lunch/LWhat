package lwhat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class GboardDTO implements Serializable{
	public static final long serialVersionUID = 321118118942543983L;
	private int gPostingID;
	private String memberID_FK;
	private String boardCategory;
	private String imageCategory;
	private String title;
	private String content;
	private int clickCount;
	private Timestamp wDate;
	private Timestamp mDate;
	public GboardDTO() {
		
	}
	public int getgPostingID() {
		return gPostingID;
	}
	public void setgPostingID(int gPostingID) {
		this.gPostingID = gPostingID;
	}
	public String getMemberID_FK() {
		return memberID_FK;
	}
	public void setMemberID_FK(String memberID_FK) {
		this.memberID_FK = memberID_FK;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getImageCategory() {
		return imageCategory;
	}
	public void setImageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
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
	@Override
	public String toString() {
		return "GeneralpostingDTO [gPostingID=" + gPostingID + ", memberID_FK=" + memberID_FK + ", boardCategory="
				+ boardCategory + ", imageCategory=" + imageCategory + ", title=" + title + ", content=" + content
				+ ", clickCount=" + clickCount + ", wDate=" + wDate + ", mDate=" + mDate + "]";
	}
	
	
}

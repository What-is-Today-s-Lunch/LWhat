package lwhat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class QboardDTO implements Serializable{
	public static final long serialVersionUID = 321478118942543983L;

	private int qPostingID;
	private String memberID_FK;// MemberDTO에서 memberID와 연결 (외래키)
	private String boardCategory;
	private String imageCategory;
	private String title;
	private String content;
	private int clickCount;
	private String wDate;
	private String mDate;
	
	public int getClickCount() {
		return clickCount;
	}
	
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public QboardDTO() {
		
	}

	public int getqPostingID() {
		return qPostingID;
	}

	public void setqPostingID(int qPostingID) {
		this.qPostingID = qPostingID;
	}

	public String getMemberID_FK() {
		return memberID_FK;
	}

	public void setMemberID_FK(String memberID_FK) {
		this.memberID_FK = memberID_FK;
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

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getboardCategory() {
		return boardCategory;
	}

	public void setboardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getimageCategory() {
		return imageCategory;
	}

	public void setimageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}

	@Override
	public String toString() {
		return "QuestionpostingDTO [qPostingID=" + qPostingID + ", memberID_FK=" + memberID_FK + ", title=" + title
				+ ", content=" + content + ", wDate=" + wDate + ", mDate=" + mDate + ", boardCategory=" + boardCategory
				+ ", imageCategory=" + imageCategory + "]";
	}
	
}

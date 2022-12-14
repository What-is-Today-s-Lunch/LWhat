package lwhat.dto.board;

import java.io.Serializable;
import java.sql.Timestamp;

public class GboardDTO implements Serializable{
	public static final long serialVersionUID = 354843468462158L;
	
	private int gPostingID;
	private String memberID_FK;
	private String boardCategory;
	private String title;
	private String content;
	private int clickCount;
	private String wDate;
	private String mDate;
	private int rownum;
	
	public GboardDTO() {}

	public int getgPostingID() {
		return gPostingID;
	}

	public void setgPostingID(int gPostingID) {
		this.gPostingID = gPostingID;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
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

	@Override
	public String toString() {
		return "GboardDTO [gPostingID=" + gPostingID + ", memberID_FK=" + memberID_FK + ", boardCategory="
				+ boardCategory + ", rownum=" + rownum + ", title=" + title + ", content=" + content
				+ ", clickCount=" + clickCount + ", wDate=" + wDate + ", mDate=" + mDate + "]";
	}
	
	
}

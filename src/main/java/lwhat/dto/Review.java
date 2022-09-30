package lwhat.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review implements Serializable{
	public static final long serialVersionUID = 321478938942543983L;
	private int revID;
	private String memberID_FK;
	private String restaurantID_FK;
	private int score;
	private String content;
	private Timestamp wDate;
	private Timestamp mdate;
	
	public Review() {
		
	}

	public int getRevID() {
		return revID;
	}

	public void setRevID(int revID) {
		this.revID = revID;
	}

	public String getMemberID_FK() {
		return memberID_FK;
	}

	public void setMemberID_FK(String memberID_FK) {
		this.memberID_FK = memberID_FK;
	}

	public String getRestaurantID_FK() {
		return restaurantID_FK;
	}

	public void setRestaurantID_FK(String restaurantID_FK) {
		this.restaurantID_FK = restaurantID_FK;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getwDate() {
		return wDate;
	}

	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}

	public Timestamp getMdate() {
		return mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "Review [revID=" + revID + ", memberID_FK=" + memberID_FK + ", restaurantID_FK=" + restaurantID_FK
				+ ", content=" + content + ", score=" + score + ", wDate=" + wDate + ", mdate=" + mdate + "]";
	}
	
}

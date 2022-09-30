package lwhat.dto;

import java.io.Serializable;

public class QuestionimageDTO implements Serializable {
	public static final long serialVersionUID = 321118118942213583L;
	private int qImageID;
	private int qPostingID_FK;
	private String imagecategory;
	private String content;
	private String cImage;
	private String sImage;
	
	public QuestionimageDTO() {}
	
	
	public int getqImageID() {
		return qImageID;
	}
	public void setqImageID(int qImageID) {
		this.qImageID = qImageID;
	}
	public int getqPostingID_FK() {
		return qPostingID_FK;
	}
	public void setqPostingID_FK(int qPostingID_FK) {
		this.qPostingID_FK = qPostingID_FK;
	}
	public String getImagecategory() {
		return imagecategory;
	}
	public void setImagecategory(String imagecategory) {
		this.imagecategory = imagecategory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getcImage() {
		return cImage;
	}
	public void setcImage(String cImage) {
		this.cImage = cImage;
	}
	public String getsImage() {
		return sImage;
	}
	public void setsImage(String sImage) {
		this.sImage = sImage;
	}
	@Override
	public String toString() {
		return "QuestionimageDTO [qImageID=" + qImageID + ", qPostingID_FK=" + qPostingID_FK + ", imagecategory="
				+ imagecategory + ", content=" + content + ", cImage=" + cImage + ", sImage=" + sImage + "]";
	}
	
	
	
}

package lwhat.dto;

import java.io.Serializable;

public class GeneralimageDTO implements Serializable{
	public static final long serialVersionUID = 321118118941113583L;
	private int gImageID;
	private int gPostingID_FK;
	private String imageCategory;
	private String content;
	private String cImage;
	private String sImage;
	
	
	public GeneralimageDTO() {
		
	}

	public int getgImageID() {
		return gImageID;
	}

	public void setgImageID(int gImageID) {
		this.gImageID = gImageID;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getimageCategory() {
		return imageCategory;
	}

	public void setimageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}

	public int getgPostingID_FK() {
		return gPostingID_FK;
	}

	public void setgPostingID_FK(int gPostingID_FK) {
		this.gPostingID_FK = gPostingID_FK;
	}

	@Override
	public String toString() {
		return "GeneralimageDTO [gImageID=" + gImageID + ", cImage=" + cImage + ", sImage=" + sImage + ", content="
				+ content + ", imageCategory=" + imageCategory + ", gPostingID_FK=" + gPostingID_FK + "]";
	}
	
	
}

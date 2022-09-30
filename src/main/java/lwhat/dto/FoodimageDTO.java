package lwhat.dto;

import java.io.Serializable;

public class FoodimageDTO implements Serializable{
	public static final long serialVersionUID = 321478938942843983L;
	private int fImageID;
	private String restaurantID_FK; // restaurant의 restaurantID와 연결(외래키)	
	private String imageCategory; // 카테고리 테이블에서 값 받아오기
	private String content;
	private String clmage;
	private String sImage;
	
	public FoodimageDTO() {}
	
	public int getfImageID() {
		return fImageID;
	}
	public void setfImageID(int fImageID) {
		this.fImageID = fImageID;
	}
	public String getRestaurantID_FK() {
		return restaurantID_FK;
	}
	public void setRestaurantID_FK(String restaurantID_FK) {
		this.restaurantID_FK = restaurantID_FK;
	}
	public String getImageCategory() {
		return imageCategory;
	}
	public void setImageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getClmage() {
		return clmage;
	}
	public void setClmage(String clmage) {
		this.clmage = clmage;
	}
	public String getsImage() {
		return sImage;
	}
	public void setsImage(String sImage) {
		this.sImage = sImage;
	}
	@Override
	public String toString() {
		return "FoodimageDTO [fImageID=" + fImageID + ", restaurantID_FK=" + restaurantID_FK + ", imageCategory="
				+ imageCategory + ", content=" + content + ", clmage=" + clmage + ", sImage=" + sImage + "]";
	}
	
	
	
}

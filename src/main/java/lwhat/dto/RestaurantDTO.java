package lwhat.dto;

import java.io.Serializable;

public class RestaurantDTO implements Serializable{
	public static final long serialVersionUID = 328478938942843983L;
	private String restaurantID;
	private String foodCategory;
	private String rTelNum;
	private String addressDetail;
	private String addresssAPI;
	private String latitude;
	private String longitude;
	private double scoreAvg;
	private String content;
	
	public RestaurantDTO() {
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getScoreAvg() {
		return scoreAvg;
	}
	public void setScoreAvg(double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}
	public String getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(String restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getrTelNum() {
		return rTelNum;
	}
	public void setrTelNum(String rTelNum) {
		this.rTelNum = rTelNum;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAddresssAPI() {
		return addresssAPI;
	}
	public void setAddresssAPI(String addresssAPI) {
		this.addresssAPI = addresssAPI;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [restaurantID=" + restaurantID + ", foodCategory=" + foodCategory + ", rTelNum=" + rTelNum
				+ ", addressDetail=" + addressDetail + ", addresssAPI=" + addresssAPI + ", latitude=" + latitude + ", longitude="
				+ longitude + ", scoreAvg=" + scoreAvg + ", content=" + content + "]";
	}

	
	
}

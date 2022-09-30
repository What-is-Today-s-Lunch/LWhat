package lwhat.dto;

import java.io.Serializable;

public class RestaurantDTO implements Serializable{
	public static final long serialVersionUID = 328478938942843983L;
	private String restaurantID;
	private String foodCategory;
	private String rTelNum;
	private String address;
	private String addresssAPI;
	private String latitude;
	private String longitude;
	
	public RestaurantDTO() {
		
	}
	public String getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(String restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getrTelNum() {
		return rTelNum;
	}
	public void setrTelNum(String rTelNum) {
		this.rTelNum = rTelNum;
	}
	public String getfoodCategory() {
		return foodCategory;
	}
	public void setfoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public String getlatitude() {
		return latitude;
	}
	public void setlatitude(String latitude) {
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
		return "RestaurantDTO [restaurantID=" + restaurantID + ", address=" + address + ", rTelNum=" + rTelNum
				+ ", foodCategory=" + foodCategory + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", addresssAPI=" + addresssAPI + "]";
	}
	
	
}

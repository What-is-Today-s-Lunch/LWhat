package lwhat.service.restaurant;

import lwhat.service.LWhatService;

public interface RestaurantService extends LWhatService{
	
	public void writeRestaurant() throws Exception; 
	
	public void deleteRestaurant() throws Exception; 
	
	public void updateRestaurant() throws Exception; 
	
	public void listRestaurant() throws Exception; 
	
	public void viewRestaurant() throws Exception; 
	
	public void fileUploadRestaurant() throws Exception; 

}

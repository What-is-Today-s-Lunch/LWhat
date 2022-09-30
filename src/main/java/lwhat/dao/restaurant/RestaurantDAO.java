package lwhat.dao.restaurant;

import lwhat.service.restaurant.RestaurantService;

public interface RestaurantDAO extends RestaurantService{

	public void writeRestaurant() throws Exception; 

	public void deleteRestaurant() throws Exception; 
	
	public void updateRestaurant() throws Exception; 
	
	public void listRestaurant() throws Exception; 
	
	public void viewRestaurant() throws Exception; 
	
}

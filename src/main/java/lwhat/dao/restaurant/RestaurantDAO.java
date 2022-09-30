package lwhat.dao.restaurant;

import java.util.List;

import lwhat.dto.RestaurantDTO;
import lwhat.service.restaurant.RestaurantService;

public interface RestaurantDAO extends RestaurantService{

	public int writeRestaurant() throws Exception; 

	public int deleteRestaurant() throws Exception; 
	
	public int updateRestaurant() throws Exception; 
	
	public int listRestaurant() throws Exception; 
	
	public int viewRestaurant() throws Exception; 
	
	public List<RestaurantDTO> listLRestaurant(int bid) throws Exception;
	
}

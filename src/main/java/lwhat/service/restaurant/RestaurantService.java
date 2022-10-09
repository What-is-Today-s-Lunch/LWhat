package lwhat.service.restaurant;

import java.util.List;

import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.service.LWhatService;

public interface RestaurantService extends LWhatService {

	public List<RestaurantDTO>searchRestaurant(String searchText) throws Exception;
	
	public int writeRestaurant( RestaurantDTO restarauntDTO) throws Exception;

	public int deleteRestaurant(String restaurantID) throws Exception;

	public int updateRestaurant(String restaurantID, RestaurantDTO restaurantDTO) throws Exception;

	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception;

	public int fileUploadRestaurant(String restaurantID, List<RestaurantFoodimageDTO>list) throws Exception;

	public List<RestaurantDTO> listRestaurant(String code) throws Exception;
	
	public int writeRestaurantReview(RestaurantReviewDTO review) throws Exception;
	
	public List<RestaurantReviewDTO> listRestaurantReview(String restaurantID) throws Exception;

	public void deleteRestaurantReview(int revID) throws Exception;

	public int updateRestaurantReview(int revID,RestaurantReviewDTO reviewDTO) throws Exception;

	public RestaurantReviewDTO viewRestaurantReview(int revID) throws Exception;
	
	 public int fileUploadRestaurant(String restaurantID, RestaurantFoodimageDTO foodimageDTO) throws Exception; 

	 public RestaurantFoodimageDTO fileViewRestaurant(int fImageID) throws Exception;
	 
	 public List<RestaurantFoodimageDTO>fileListRestaurant(String restaurantID) throws Exception;
	 
	 public int listCountRestaurantReview(String restaurandID) throws Exception;

	 public int filesUploadRestaurant(String restaurantID, List<RestaurantFoodimageDTO> list) throws Exception;
}

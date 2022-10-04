package lwhat.service.restaurant;

import java.util.List;

import lwhat.dto.FoodimageDTO;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.Review;
import lwhat.service.LWhatService;

public interface RestaurantService extends LWhatService {

	public int writeRestaurant( RestaurantDTO restarauntDTO) throws Exception;

	public int deleteRestaurant(String restaurantID) throws Exception;

	public int updateRestaurant(String restaurantID, RestaurantDTO restaurantDTO) throws Exception;

	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception;

	public int fileUploadRestaurant(String restaurantID, List<FoodimageDTO>list) throws Exception;

	public List<RestaurantDTO> listLRestaurant() throws Exception;
	
	public int writeReview(Review review) throws Exception;
	
	public List<Review> listLReview(String restaurantID) throws Exception;

}

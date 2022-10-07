package lwhat.service.restaurant;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

import lwhat.dto.FoodimageDTO;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.ReviewDTO;
import lwhat.service.LWhatService;

public interface RestaurantService extends LWhatService {

	public int writeRestaurant( RestaurantDTO restarauntDTO) throws Exception;

	public int deleteRestaurant(String restaurantID) throws Exception;

	public int updateRestaurant(String restaurantID, RestaurantDTO restaurantDTO) throws Exception;

	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception;

	public int fileUploadRestaurant(String restaurantID, List<FoodimageDTO>list) throws Exception;

	public List<RestaurantDTO> listRestaurant(String code) throws Exception;
	
	public int writeRestaurantReview(ReviewDTO review) throws Exception;
	
	public List<ReviewDTO> listRestaurantReview(String restaurantID) throws Exception;

	public void deleteRestaurantReview(int revID) throws Exception;

	public int updateRestaurantReview(int revID,ReviewDTO reviewDTO) throws Exception;

	public ReviewDTO viewRestaurantReview(int revID) throws Exception;
	
	 public int fileUploadRestaurant(String restaurantID, FoodimageDTO foodimageDTO) throws Exception; 

	 public FoodimageDTO fileViewRestaurant(int fImageID) throws Exception;
	 
	 public List<FoodimageDTO>fileListRestaurant(String restaurantID) throws Exception;
	 
	 public int listCountRestaurantReview(String restaurandID) throws Exception;

	 public int filesUploadRestaurant(String restaurantID, List<FoodimageDTO> list) throws Exception;
}

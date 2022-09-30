package lwhat.service.restaurant;

import java.util.List;

import lwhat.dto.FoodimageDTO;
import lwhat.dto.RestaurantDTO;
import lwhat.service.LWhatService;

public interface RestaurantService extends LWhatService {

	public int writeRestaurant(int restaurantID, RestaurantDTO restarauntDTO) throws Exception;

	public int deleteRestaurant(String restaurantID) throws Exception;

	public int updateRestaurant() throws Exception;

	public int viewRestaurant() throws Exception;

	public int fileUploadRestaurant(String restaurantID, List<FoodimageDTO>list) throws Exception;

	public List<RestaurantDTO> listLRestaurant() throws Exception;

}

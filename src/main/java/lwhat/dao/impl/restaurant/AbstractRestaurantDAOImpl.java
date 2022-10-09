package lwhat.dao.impl.restaurant;

import java.util.List;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantFoodimageDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.service.restaurant.RestaurantService;

public abstract class AbstractRestaurantDAOImpl extends LWhatConnectionDAOImpl implements RestaurantService {

	
	@Override
	public List<RestaurantDTO>searchRestaurant(String searchText) throws Exception{
		return null;
	}
	@Override
	public List<RestaurantDTO> listRestaurant(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeRestaurant( RestaurantDTO restarauntDTO) throws Exception {
		return 0;
	}

	@Override
	public int deleteRestaurant(String restaurantID) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRestaurant(String restaurantID,RestaurantDTO restaurantDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public RestaurantDTO viewRestaurant(String restaurantID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fileUploadRestaurant(String restaurantID, List<RestaurantFoodimageDTO>list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int writeRestaurantReview(RestaurantReviewDTO reviewDTO) throws Exception{
		return 0;
	}
	@Override
	public List<RestaurantReviewDTO> listRestaurantReview(String restaurantID) throws Exception{
		return null;
	}

	@Override
	public void deleteRestaurantReview(int revID) throws Exception {
	}

	@Override
	public int updateRestaurantReview(int revID, RestaurantReviewDTO reviewDTO) throws Exception {
		return 0;
	}

	@Override
	public RestaurantReviewDTO viewRestaurantReview(int revID) throws Exception {
		return null;
	}

	@Override
	public int fileUploadRestaurant(String restaurantID, RestaurantFoodimageDTO foodimageDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RestaurantFoodimageDTO fileViewRestaurant(int fImageID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantFoodimageDTO> fileListRestaurant(String restaurantID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listCountRestaurantReview(String restaurandID) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int filesUploadRestaurant(String restaurantID, List<RestaurantFoodimageDTO> list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	
}

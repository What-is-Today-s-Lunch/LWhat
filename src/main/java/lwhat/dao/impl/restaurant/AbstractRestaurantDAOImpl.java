package lwhat.dao.impl.restaurant;

import java.util.List;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.FoodimageDTO;
import lwhat.dto.RestaurantDTO;
import lwhat.service.restaurant.RestaurantService;

public abstract class AbstractRestaurantDAOImpl extends LWhatConnectionDAOImpl implements RestaurantService {

	@Override
	public List<RestaurantDTO> listLRestaurant() throws Exception {
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
	public int fileUploadRestaurant(String restaurantID, List<FoodimageDTO>list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}

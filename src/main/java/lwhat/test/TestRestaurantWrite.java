package lwhat.test;

import lwhat.dao.impl.restaurant.RestaurantDeleteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantListDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantWriteDAOImpl;
import lwhat.dto.RestaurantDTO;
import lwhat.service.restaurant.RestaurantService;

public class TestRestaurantWrite {
public static void main(String[] args) {
	RestaurantService restaurantService = new RestaurantWriteDAOImpl();
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID("잣콩반점");
	restaurantDTO.setfoodCategory("FF");
	restaurantDTO.setrTelNum("전화");
	restaurantDTO.setAddress("basic add");
	restaurantDTO.setAddresssAPI("API add");
	restaurantDTO.setlatitude("위도");
	restaurantDTO.setLongitude("경도");
	
	/*
	try {
		restaurantService.writeRestaurant(restaurantDTO);
		System.out.println("입력 완료");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		*/
	/*
	RestaurantService restaurantServiceD = new RestaurantDeleteDAOImpl();
try {
	restaurantServiceD.deleteRestaurant(restaurantDTO.getRestaurantID());
	System.out.println("삭제완료");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/
	
RestaurantService restaurantServiceU = new RestaurantUpdateDAOImpl();
try {
	restaurantServiceU.updateRestaurant("잣콩반점",restaurantDTO);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	
}// main
}//class

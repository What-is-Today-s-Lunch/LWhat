package lwhat.test;

import lwhat.dao.impl.restaurant.RestaurantDeleteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantListDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantWriteDAOImpl;
import lwhat.dto.RestaurantDTO;
import lwhat.service.restaurant.RestaurantService;

public class TestRestaurantWrite {
public static void main(String[] args) {
	RestaurantService restaurantService = new RestaurantWriteDAOImpl();
	RestaurantDTO restaurantDTO = new RestaurantDTO();
	restaurantDTO.setRestaurantID("잣콩반점");
	restaurantDTO.setfoodCategory("AA");
	restaurantDTO.setrTelNum("전화 투 ");
	restaurantDTO.setAddress("basic add 주소");
	restaurantDTO.setAddresssAPI("API add");
	restaurantDTO.setlatitude("23452346");
	restaurantDTO.setLongitude("1353512");
	
	/*
	try {
		restaurantService.writeRestaurant(restaurantDTO);
		System.out.println("입력 완료");
	} catch (Exception e) {
		e.printStackTrace();
	}
		*/
	/*
	RestaurantService restaurantServiceD = new RestaurantDeleteDAOImpl();
try {
	restaurantServiceD.deleteRestaurant(restaurantDTO.getRestaurantID());
	System.out.println("삭제완료");
} catch (Exception e) {
	e.printStackTrace();
}*/
	/*
RestaurantService restaurantServiceU = new RestaurantUpdateDAOImpl();
try {
	restaurantServiceU.updateRestaurant("잣콩반점",restaurantDTO);
} catch (Exception e) {
	e.printStackTrace();
}
	*/
	RestaurantService restaurantServiceV = new RestaurantViewDAOImpl();
	try {
		System.out.println(restaurantServiceV.viewRestaurant("잣콩반점"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}// main
}//class

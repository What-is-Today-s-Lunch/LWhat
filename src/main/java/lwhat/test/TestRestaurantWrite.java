package lwhat.test;

import java.sql.Timestamp;

import lwhat.dao.impl.restaurant.RestaurantDeleteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantListDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewDeleteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantWriteDAOImpl;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.ReviewDTO;
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
	/*
	RestaurantService restaurantServiceV = new RestaurantViewDAOImpl();
	try {
		System.out.println(restaurantServiceV.viewRestaurant("잣콩반점"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
//	RestaurantService restanurantServiceRe = new RestaurantReviewDeleteDAOImpl();
//	try {
//		restanurantServiceRe.deleteRestaurantReview(34);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
	ReviewDTO reviewDTO = new ReviewDTO();
	
	reviewDTO.setContent("무다무다무다무다무다무다");
	reviewDTO.setMemberID_FK("wjsalswo985");
	reviewDTO.setRestaurantID_FK("고봉민김밥");
	reviewDTO.setScore(5);
	
	RestaurantService restaurantServiceReUp = new RestaurantReviewUpdateDAOImpl();
	try {
		restaurantServiceReUp.updateRestaurantReview(35, reviewDTO);
	} catch (Exception e) {
		// TODO Auto-generated catch b lock
		e.printStackTrace();
	}
	
	
	
}// main
}//class

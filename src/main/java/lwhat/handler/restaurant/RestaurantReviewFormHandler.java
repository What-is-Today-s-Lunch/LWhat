package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewFormHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String restaurantIDParam = request.getParameter("restaurantID") == null ? ""
				: request.getParameter("restaurantID");
		session.setAttribute("restaurantID", restaurantIDParam);

		RestaurantService restaurantViewService = new RestaurantViewDAOImpl();

		RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
		request.setAttribute("rsIDDTO", restautantIDDTO);

		RestaurantService restaurantreviewService = new RestaurantReviewListDTOImpl();
		List<RestaurantReviewDTO> revlist = restaurantreviewService.listRestaurantReview(restaurantIDParam);
		request.setAttribute("revDTO", revlist);

		// restaurantReview update delete check 리뷰가 있을 때만 설정
		if(!revlist.isEmpty()) {
			if (session.getAttribute("memberID").equals(revlist.get(0).getMemberID_FK())) {
			request.setAttribute("isSameWriter", "true");
			}
		}
		// 미터(Meter) 단위
		// 식당 거리 계산하는 코드
	
		
		return "/jsp/restaurant/restaurantViewForm.jsp";
	}//process
	
	/**
	 * 두 지점간의 거리 계산
	 * 
	 * @param lat 식당 위도
	 * @param lon 식당 경도 
	 * @param unit 거리 표출단위 
	 * @return
	 */
	private static double distance(double lat, double lon, String unit) {
		
		double theta = 35.17282733090588 - lon;
		double dist = Math.sin(deg2rad(129.13074640994697)) * Math.sin(deg2rad(lat)) + Math.cos(deg2rad(129.13074640994697)) * Math.cos(deg2rad(lat)) * Math.cos(deg2rad(theta));
		
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1609.344;
		return (dist);
	}
	
	// This function converts decimal degrees to radians
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	// This function converts radians to decimal degrees
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}//class

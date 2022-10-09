package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewDeleteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewViewDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewDeleteProcHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int revID = Integer.parseInt(request.getParameter("revID"));
		
		String restaurantIDParam = request.getParameter("restaurantID") == null ? "" : request.getParameter("restaurantID");
		session.setAttribute("restaurantID", restaurantIDParam);

		RestaurantService restaurantViewService = new RestaurantViewDAOImpl();

		RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
		request.setAttribute("rsIDDTO", restautantIDDTO);

		RestaurantService restaurantreviewdeleteService= new RestaurantReviewDeleteDAOImpl();
		restaurantreviewdeleteService.deleteRestaurantReview(revID);
		
		RestaurantService restaurantreviewviewService = new RestaurantReviewViewDAOImpl();
		restaurantreviewviewService.viewRestaurantReview(revID);
		
		RestaurantService restaurantreviewService = new RestaurantReviewListDTOImpl();
		List<RestaurantReviewDTO> revlistDTO = restaurantreviewService.listRestaurantReview(restaurantIDParam);
		request.setAttribute("revDTO", revlistDTO);
		
		return "/jsp/restaurant/restaurantViewForm.jsp";
	}
}

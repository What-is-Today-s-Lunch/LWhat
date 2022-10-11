package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewUpdateProcHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String restaurantIDParam = request.getParameter("restaurantID") == null ? ""
				: request.getParameter("restaurantID");

		RestaurantService restaurantViewService = new RestaurantViewDAOImpl();
		RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
		request.setAttribute("rsIDDTO", restautantIDDTO);

		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("score"));

		RestaurantReviewDTO reviewDTO = new RestaurantReviewDTO();
		reviewDTO.setContent(content);
		reviewDTO.setScore(score);

		int revID = Integer.parseInt(request.getParameter("revID"));

		RestaurantService restaurantService = new RestaurantReviewUpdateDAOImpl();
		restaurantService.updateRestaurantReview(revID, reviewDTO);

		RestaurantService restaurantreviewService = new RestaurantReviewListDTOImpl();
		List<RestaurantReviewDTO> revlistDTO = restaurantreviewService.listRestaurantReview(restaurantIDParam);
		request.setAttribute("revDTO", revlistDTO);

		return "/jsp/restaurant/restaurantViewForm.jsp";
	}
}

package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewWriteDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewWriteProcHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String restaurantIDParam = (String) session.getAttribute("restaurantID");

		// 식당DTO
		RestaurantService restaurantViewService = new RestaurantViewDAOImpl();
		RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
		request.setAttribute("rsIDDTO", restautantIDDTO);

		String revMemID = (String) session.getAttribute("memberID");
		String revResID = (String) session.getAttribute("restaurantID");

		String revContent = request.getParameter("content");// 후기 내용
		int revScore = Integer.parseInt(request.getParameter("score"));// 후기 별점
		request.setAttribute("restaurantID", revResID);

		RestaurantReviewDTO reviewDTO = new RestaurantReviewDTO();
		reviewDTO.setMemberID_FK(revMemID);
		reviewDTO.setRestaurantID_FK(revResID);
		reviewDTO.setScore(revScore);
		reviewDTO.setContent(revContent);
		RestaurantService restaurantService = new RestaurantReviewWriteDAOImpl();
		restaurantService.writeRestaurantReview(reviewDTO);// db저장

		RestaurantService restaurantreviewService = new RestaurantReviewListDTOImpl();
		List<RestaurantReviewDTO> revlistDTO = restaurantreviewService.listRestaurantReview(restaurantIDParam);
		request.setAttribute("revDTO", revlistDTO);
		return "/jsp/restaurant/restaurantViewForm.jsp";
	}
}

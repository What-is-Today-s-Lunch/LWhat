package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.ReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantFormTestHandler implements CommandHandler {
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
		List<ReviewDTO> revlist = restaurantreviewService.listRestaurantReview(restaurantIDParam);
		request.setAttribute("revDTO", revlist);

		// restaurantReview update delete check
		if(!revlist.isEmpty()) {
			if (session.getAttribute("memberID").equals(revlist.get(0).getMemberID_FK())) {
			System.out.println("와안뜨노 로그인 아이디"+session.getAttribute("memberID"));
			System.out.println("왜안뜨노 리뷰 아이디"+revlist.get(0).getMemberID_FK());
			request.setAttribute("isSameWriter", "true");
			}
		}

		return "/jsp/restaurantFormTest.jsp";
	}//process
}//class

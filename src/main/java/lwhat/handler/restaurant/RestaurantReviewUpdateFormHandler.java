package lwhat.handler.restaurant;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewViewDAOImpl;
import lwhat.dto.restaurant.RestaurantReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewUpdateFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String seMemID = (String)session.getAttribute("memberID");
		
		int revID = Integer.parseInt(request.getParameter("revID"));	
		String rID = (String)session.getAttribute("restaurantID");

		request.setAttribute("RID", rID);

		RestaurantService restaurantService = new RestaurantReviewViewDAOImpl();
		RestaurantReviewDTO reviewDTO = restaurantService.viewRestaurantReview(revID);

		SimpleDateFormat mDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		request.setAttribute("mDate", mDate.format(reviewDTO.getmDate()));

		request.setAttribute("review", reviewDTO);

		
		return "/jsp/restaurant/restaurantReviewUpdateForm.jsp";
	}
}

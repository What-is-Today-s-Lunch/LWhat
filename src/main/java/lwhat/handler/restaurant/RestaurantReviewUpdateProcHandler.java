package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewUpdateDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantViewDAOImpl;
import lwhat.dto.RestaurantDTO;
import lwhat.dto.ReviewDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantReviewUpdateProcHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		//session.getAttribute("memberID");
		String restaurantIDParam = request.getParameter("restaurantID") == null ? "" : request.getParameter("restaurantID");
		session.setAttribute("restaurantID", restaurantIDParam);
		
		RestaurantService restaurantViewService = new RestaurantViewDAOImpl();
		
		RestaurantDTO restautantIDDTO = restaurantViewService.viewRestaurant(restaurantIDParam);
		request.setAttribute("rsIDDTO", restautantIDDTO);
		
		

request.setCharacterEncoding("utf-8");

response.setCharacterEncoding("utf-8");

//String url= "restaurantFormTest.jsp?restaurantID="+request.getParameter("restaurantID");
//request.setAttribute("restaurantID", request.getParameter("restaurantID"));


String content = request.getParameter("content");
int score = Integer.parseInt(request.getParameter("score"));

ReviewDTO reviewDTO = new ReviewDTO();
reviewDTO.setContent(content);
reviewDTO.setScore(score);
System.out.println("-------------"+content+score); 

int revID = Integer.parseInt(request.getParameter("revID"));


RestaurantService restaurantService = new RestaurantReviewUpdateDAOImpl();
restaurantService.updateRestaurantReview(revID, reviewDTO);



RestaurantService restaurantreviewService = new RestaurantReviewListDTOImpl();
List<ReviewDTO> revlistDTO = restaurantreviewService.listRestaurantReview(restaurantIDParam);
request.setAttribute("revDTO", revlistDTO);


return "/jsp/restaurantFormTest.jsp";
	}
}
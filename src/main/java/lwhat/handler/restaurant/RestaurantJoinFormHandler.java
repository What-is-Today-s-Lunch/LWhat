package lwhat.handler.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.handler.CommandHandler;

public class RestaurantJoinFormHandler implements CommandHandler{
		@Override
		public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

			return "/jsp/restaurant/restaurantJoinForm.jsp";
		}
}

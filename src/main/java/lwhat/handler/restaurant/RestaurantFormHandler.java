package lwhat.handler.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.code.CodeDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantListDAOImpl;
import lwhat.dao.impl.restaurant.RestaurantReviewListDTOImpl;
import lwhat.dao.impl.restaurant.RestaurantSearchDAOImpl;
import lwhat.dto.CodeTableDTO;
import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.code.CodeService;
import lwhat.service.restaurant.RestaurantService;

public class RestaurantFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String codevalue = request.getParameter("code"); // 검색기능
		String searchText = request.getParameter("restaurantID"); // 검색기능
		String restaurantTableCode = request.getParameter("category"); //넘어온 category로 구분하여 한식,중식,일식 등등 구분
		CodeTableDTO code = null;
		RestaurantReviewListDTOImpl rLDAO = null;
		
		//검색기능으로 페이지가 넘어갈때
		if(codevalue!=null) {
			RestaurantService restayrantService = new RestaurantSearchDAOImpl();
			List<RestaurantDTO>findrestarantlistDTO = restayrantService.searchRestaurant(searchText);
			
			CodeService findcodename = new CodeDAOImpl();
			code = findcodename.codeView(codevalue);//code에 codetable정보 담음,CodeTableDTO에 값들어간상태 
			
			request.setAttribute("codename", code.getCodeName());
			request.setAttribute("rslist", findrestarantlistDTO);
			//후기 개수 구하기 임플객체를 담아줘서 메소드 바로 실행하게함 
			rLDAO = new RestaurantReviewListDTOImpl();
			request.setAttribute("rLDAO", rLDAO);
		}
		//카테고리로 페이지가 넘어갈때
		else if(restaurantTableCode!=null) {
			CodeService findcodename = new CodeDAOImpl();
			code = findcodename.codeView(restaurantTableCode);//code에 codetable정보 담음,CodeTableDTO에 값들어간상태 
			
			RestaurantService restaurantService = new RestaurantListDAOImpl();
			List<RestaurantDTO> restaurantDTO = restaurantService.listRestaurant(restaurantTableCode);
			//카테고리에따른 restaurant테이블정보를 리스트로 저장, restaurantDTO에 값 들어가있는상태
			
			request.setAttribute("codename", code.getCodeName());
			request.setAttribute("rslist", restaurantDTO);
			//후기 개수 구하기 임플객체를 담아줘서 메소드 바로 실행하게함 
			rLDAO = new RestaurantReviewListDTOImpl();
			request.setAttribute("rLDAO", rLDAO);
		}
		
		
		return "/jsp/restaurant/restaurantListForm.jsp";
	}
}

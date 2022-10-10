package lwhat.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dto.restaurant.RestaurantDTO;
import lwhat.handler.CommandHandler;

public class LocationDistance implements CommandHandler{
		@Override
	   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
		// 미터(Meter) 단위
		double distanceMeter = distance(129.1263133043384, 35.175068016526794, "meter");
		System.out.println("--------------------------------"+distanceMeter);
		request.setAttribute("distanceMeter", distanceMeter);
		return "/jsp/restaurant/restaurantViewForm.jsp";
	}
	
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
}

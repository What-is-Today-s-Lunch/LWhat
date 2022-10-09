package lwhat.constants;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class RestaurantConstants {
	
	public static Properties restaurant;
	
	static {
		restaurant = new Properties();
		try {
			File file = new File("C:/eclipse_workspace/LWhat/src/main/webapp/WEB-INF/props/restaurant.properties");
			Reader reader = new FileReader(file);
			restaurant.load(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // static
 
} // class






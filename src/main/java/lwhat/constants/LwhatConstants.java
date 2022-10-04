package lwhat.constants;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class LwhatConstants {
	
	public static Properties querys;
	
	static {
		querys = new Properties();
		try {
			File file = new File("C:/eclipse_workspace/LWhat/src/main/webapp/WEB-INF/props/restaurant.properties");
			Reader reader = new FileReader(file);
			querys.load(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // static 초기화 블록
 
} // class






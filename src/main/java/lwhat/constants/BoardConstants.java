package lwhat.constants;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class BoardConstants {
	
	public static Properties board;
	
	static {
		board = new Properties();
		try {
			File file = new File("C:/eclipse_workspace/LWhat/src/main/webapp/WEB-INF/props/board.properties");
			Reader reader = new FileReader(file);
			board.load(reader);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // static
 
} // class






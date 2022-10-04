package lwhat.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface CommandHandler {
	
	public String process(HttpServletRequest request, HttpServletResponse response, HttpSession session);

}

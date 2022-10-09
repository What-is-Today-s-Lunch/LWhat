package lwhat.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		return "/jsp/mainForm.jsp";
	}
}

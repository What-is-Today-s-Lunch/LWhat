package lwhat.handler.gboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class GboardWriteFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
        String memberID = (String) session.getAttribute("memberID");//object
				
		if(memberID == null){
			return "/index.jsp";
		} 
		return "/jsp/board/gboard/GboardWrite.jsp";
	}
}

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
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('로그인이 되어있지 않습니다!')");
//			script.println("location.href = 'loginForm.jsp'");
//			script.println("</script>");
			return "/index.jsp";
		} 
		return "/jsp/GboardWrite.jsp";
	}
}

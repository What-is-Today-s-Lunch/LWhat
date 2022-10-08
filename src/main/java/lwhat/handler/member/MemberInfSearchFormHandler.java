package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.member.MemberUpdateDAOImpl;
import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberInfSearchFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//앞에서 입력된 이름과 이메일을 받아옴
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
	//이름과 이메일을 받아서 데이터 값 가져옴			
			MemberService memberService = new MemberViewDAOImpl();
			 MemberDTO memberDTO = new MemberDTO();
	         memberDTO = memberService.viewMember(name, email);
	 		request.setAttribute("memberDTO", memberDTO);			
			
	       return "/jsp/memberInfSearchForm.jsp";
	}
}

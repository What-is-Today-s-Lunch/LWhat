package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberInfSearchFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//앞에서 입력된 이름과 이메일을 받아옴
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			if(name.equals("") || email.equals("")) {
				String result = "null";
				request.setAttribute("result", result);
				return "/jsp/member/memberSearchForm.jsp";
			}
			//이름과 이메일을 받아서 데이터 값 가져옴			
			MemberService memberService = new MemberViewDAOImpl();
			 MemberDTO memberDTO = new MemberDTO();
	         memberDTO = memberService.viewMember(name, email);
	 		request.setAttribute("memberDTO", memberDTO);
	 		
	 		// memberDTO에 정보가 없을때 MemberSearchForm에 회원정보가 틀렸습니다! alert 표시
	 		if(memberDTO == null) {
	 			String rst = "null";
	 			request.setAttribute("rst", rst);
	 			return "/jsp/member/memberSearchForm.jsp";
	 		}
			
	       return "/jsp/member/memberInfSearchForm.jsp";
	}
}

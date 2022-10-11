package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.member.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberMypageFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		//1. id값확인하고 없으면 로그인페이지로 이동
		if(memberID == null){
			return "/jsp/member/loginForm.jsp";
		}
		//2. 회원정보 가져오는 메서드생성
		MemberService memberService = new MemberViewDAOImpl();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = memberService.viewMembers(memberID);
		request.setAttribute("memberDTO", memberDTO);
		return "/jsp/member/mypageForm.jsp";
	}
}

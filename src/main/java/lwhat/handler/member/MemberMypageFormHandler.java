package lwhat.handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.dao.impl.member.MemberViewDAOImpl;
import lwhat.dto.MemberDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.member.MemberService;

public class MemberMypageFormHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		//1. 한글설정 & 변수생성
		String memberID = (String) session.getAttribute("memberID");//object이기에 형변환필수
		//1-1.id값확인 없으면 로그인페이지로 이동
		if(memberID == null){
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('로그인이 되어있지 않습니다!')");
//			script.println("location.href = 'loginForm.jsp'");
//			script.println("</script>");
			return "/jsp/loginForm.jsp";
		}
		//2. 회원정보 가져오는 메서드생성
		MemberService memberService = new MemberViewDAOImpl();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = memberService.viewMembers(memberID);
		request.setAttribute("memberDTO", memberDTO);
		return "/jsp/mypageForm.jsp";
	}
}
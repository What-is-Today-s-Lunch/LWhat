<%@page import="lwhat.service.board.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lwhat.dto.GeneralcommentDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardUpdateDAOImpl"%>
<%@ page import="lwhat.dao.impl.board.BoardConmentUpdateDAOImpl"%>
<jsp:useBean id="conment" class="lwhat.dto.GeneralcommentDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="conment" property="content" />
<%
request.setCharacterEncoding("UTF-8");

String memberID_FK = (String) session.getAttribute("memberID");
String gCommentID = request.getParameter("gCommentID") == null ? "" : request.getParameter("gCommentID");
String content = request.getParameter("content");

%>

<%
BoardService boardService = new BoardConmentUpdateDAOImpl();
GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
generalcommentDTO.setContent(content);
generalcommentDTO.setgCommentID((Integer.parseInt(gCommentID)));


int result = boardService.conmentUpdateBoard(generalcommentDTO, memberID_FK);

if(result > 0){
	out.println("<script>");
	out.println("alert('정상적으로 입력 되었습니다')");
	out.println("location.href='../jsp/totalBoardForm.jsp'");
	out.println("</script> ");
}else{
	out.println("<script>");
	out.println("alert('오류가 발생했습니다')");
	out.println("location.href='../jsp/totalBoardForm.jsp'");
	out.println("</script> ");
}
%>
<%@page import="lwhat.service.board.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lwhat.dto.GeneralcommentDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardConmentDeleteDAOImpl"%>
<%
request.setCharacterEncoding("UTF-8");
String gCommentID = request.getParameter("gCommentID") == null ? "" : request.getParameter("gCommentID");
%>
<%
BoardService boardService = new BoardConmentDeleteDAOImpl();
int result = boardService.conmentDeleteBoard(Integer.parseInt(gCommentID));

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

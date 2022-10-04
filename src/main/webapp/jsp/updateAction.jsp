<%@page import="javax.swing.plaf.metal.MetalBorders.OptionDialogBorder"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="lwhat.dto.board.GboardDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardUpdateDAOImpl"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="gboard" class="lwhat.dto.board.GboardDTO" scope="request"></jsp:useBean>
<jsp:setProperty name="gboard" property="title" />
<jsp:setProperty name="gboard" property="content" />
<jsp:setProperty name="gboard" property="boardCategory" />
<%
String gPostingID = request.getParameter("gPostingID") == null ? "" : request.getParameter("gPostingID");
BoardService boardService = new BoardUpdateDAOImpl();
gboard.setgPostingID(Integer.parseInt(gPostingID));
int result = boardService.updateBoard(gboard);

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


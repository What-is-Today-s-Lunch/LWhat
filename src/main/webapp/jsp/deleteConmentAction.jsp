<%@page import="lwhat.service.board.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lwhat.dto.GeneralcommentDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardConmentDeleteDAOImpl"%>
<%
request.setCharacterEncoding("UTF-8");
String gCommentID = request.getParameter("gCommentID") == null ? "" : request.getParameter("gCommentID");

int gPostingID = 0;
if(request.getParameter("gPostingID") != null){
	gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
}
%>
<%
BoardService boardService = new BoardConmentDeleteDAOImpl();
int result = boardService.conmentDeleteBoard(Integer.parseInt(gCommentID));

if(result > 0){
	request.setAttribute("gPostingID", gPostingID);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/GboardView.jsp");
	dispatcher.forward(request, response);
}else{
	request.setAttribute("gPostingID", gPostingID);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/GboardView.jsp");
	dispatcher.forward(request, response);
}
%>
%>

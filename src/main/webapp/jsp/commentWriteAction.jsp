<%@page import="lwhat.dto.board.GboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="lwhat.dto.GeneralcommentDTO"%>
<%@ page import="lwhat.dto.board.GboardDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardConmentWrtieDAOImpl"%>
<jsp:useBean id="conment" class="lwhat.dto.GeneralcommentDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="conment" property="content" />

<%
request.setCharacterEncoding("UTF-8");
GboardDTO gboardDTO = new GboardDTO();
String memberID = (String) session.getAttribute("memberID");
String boardCategory = null;
String content = request.getParameter("content");
int gPostingID = 0;
if(request.getParameter("gPostingID") != null){
	gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
}
%>

<%
BoardService boardService = new BoardConmentWrtieDAOImpl();
GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();

generalcommentDTO.setContent(content);

boardService.conmentWriteBoard(generalcommentDTO, memberID, boardCategory, gPostingID);

//out.println("<script>");
//out.println("location.href = '../jsp/GboardView.jsp?gPostingID'");
//out.println("</script>");


%>
<body>
<script>alert('후기 등록완료'); window.history.back(); </script>
</body>
<%@page import="lwhat.dao.impl.board.BoardUpdateDAOImpl"%>
<%@page import="javax.swing.plaf.metal.MetalBorders.OptionDialogBorder"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="lwhat.dto.board.GboardDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardWriteDAOImpl"%>

<%@page import="lwhat.dto.GeneralimageDTO" %>
<%@page import="lwhat.dao.impl.board.BoardFileUploadDAOImpl" %>
<%@page import="java.io.File" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="gboard" class="lwhat.dto.board.GboardDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="gboard" property="title" />
<jsp:setProperty name="gboard" property="content" />
<jsp:setProperty name="gboard" property="boardCategory" />

<%
/* // write
BoardService boardService = new BoardWriteDAOImpl();
GboardDTO gboardDTO = new GboardDTO();
gboardDTO.setMemberID_FK(gboard.getMemberID_FK());
//gboard.getMemberID_FK()
gboardDTO.setBoardCategory(gboard.getBoardCategory());
gboardDTO.setImageCategory(gboard.getImageCategory());
gboardDTO.setTitle(gboard.getTitle());
gboardDTO.setContent(gboard.getContent());
boardService.writeBoard(gboardDTO); */

// upload
 String directory = application.getRealPath("/upload/");
int maxSize = 1024 * 1024 * 100;
String encoding = "UTF-8";

MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());

String fileName = multipartRequest.getOriginalFileName("file");
String fileRealName = multipartRequest.getFilesystemName("file");

BoardService boardService2 = new BoardFileUploadDAOImpl();
//boardService2.fileUploadBoard(fileName, fileRealName);
out.write("파일명 : " + fileName + "<br>");
out.write("실제 파일명 : " + fileRealName + "<br>");




out.println("<script>");
out.println("location.href = '../jsp/GboardWrite.jsp'");
out.println("</script>");
%>


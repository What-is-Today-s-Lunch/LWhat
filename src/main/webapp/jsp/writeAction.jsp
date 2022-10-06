<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Collection"%>
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
String memberID = (String) session.getAttribute("memberID"); 
%>
<jsp:useBean id="gboard" class="lwhat.dto.board.GboardDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="gboard" property="title" />
<jsp:setProperty name="gboard" property="content" />
<jsp:setProperty name="gboard" property="boardCategory" />
 
<%

//write
/* BoardService boardService = new BoardWriteDAOImpl();
GboardDTO gboardDTO = new GboardDTO();
gboardDTO.setMemberID_FK(gboard.getMemberID_FK());
//gboard.getMemberID_FK()
gboardDTO.setBoardCategory(gboard.getBoardCategory());
gboardDTO.setImageCategory(gboard.getImageCategory());
gboardDTO.setTitle(gboard.getTitle());
gboardDTO.setContent(gboard.getContent());
boardService.writeBoard(gboardDTO);  */
//upload
/* String directory = application.getRealPath("/upload/");
int maxSize = 1024 * 1024 * 100;
String encoding = "UTF-8";

MultipartRequest multipartRequest = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());

//file 변수
String fileName = multipartRequest.getOriginalFileName("file");
String fileRealName = multipartRequest.getFilesystemName("file"); */

String realFolder = "";
String saveFolder = "jsp\\upload";
String encType = "UTF-8";
int maxSize = 5*1024*1024;
ServletContext context = this.getServletContext();
realFolder = context.getRealPath(saveFolder);
MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

String file = multipartRequest.getOriginalFileName("filename");
String fileName = multipartRequest.getFilesystemName("filename");

//db 이미지 저장 테스트 imageFile, contentTest
/* File imageFile = new File("C:\\eclipse_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp9\\wtpwebapps\\LWhat\\jsp\\upload\\file1.png"); // 경로 지정 실패 
FileInputStream contentTest = new FileInputStream(imageFile); */

//write 변수
String title = multipartRequest.getParameter("title");
String content = multipartRequest.getParameter("content");
String boardCategory = multipartRequest.getParameter("boardCategory");
String imageCategory = multipartRequest.getParameter("imageCategory"); 

/* out.write("파일명 : " + fileName + "<br>");
out.write("실제 파일명 : " + fileRealName + "<br>");   */

BoardService boardService = new BoardWriteDAOImpl();
GboardDTO gboardDTO = new GboardDTO();
gboardDTO.setMemberID_FK(gboard.getMemberID_FK());

//gboard.getMemberID_FK()
gboardDTO.setBoardCategory(boardCategory);
gboardDTO.setImageCategory(imageCategory);
gboardDTO.setTitle(title);
gboardDTO.setContent(content);

if(title == null || content == null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('입력이 안 된 사항이 있습니다.')");
	script.println("history.back()");
	script.println("</script>");
}

 
int gPostingNum = boardService.writeBoard(gboardDTO, memberID); 

int gPostindID = gboardDTO.getgPostingID();
BoardService boardService2 = new BoardFileUploadDAOImpl();
boardService2.fileUploadBoard(file, fileName, gPostingNum);
//boardService2.fileUploadBoardDB(file, fileName, contentTest, gPostingNum);   // 파일 db저장 서비스  테스트 

if(fileName != null){
	File oldFile = new File(realFolder + "\\" + fileName);
	File newFile = new File(realFolder+ "\\" + (gPostingNum) + "file.jpg");
	oldFile.renameTo(newFile);
}

out.println("<script>");
out.println("location.href = '../jsp/totalBoardForm.jsp'");
out.println("</script>");
%>


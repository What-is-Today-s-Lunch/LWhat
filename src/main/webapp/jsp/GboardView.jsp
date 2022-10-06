<%@page import="java.util.ArrayList"%>
<%@page import="lwhat.dto.GeneralcommentDTO"%>
<%@page import="lwhat.dao.impl.board.BoardConmentListDAOImpl"%>
<%@page import="javax.swing.plaf.metal.MetalBorders.OptionDialogBorder"%>
<%@page import="java.io.File"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="lwhat.dto.board.GboardDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardViewDAOImpl"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/style_category.css">
<link rel="stylesheet" href="../css/css.css">
<title>글쓰기</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String memberID = (String) session.getAttribute("memberID");
	
	int gPostingID = 0;
	 if(request.getParameter("gPostingID") != null){
		gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
	} 
	
	
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null){
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	
	BoardService boardService = new BoardViewDAOImpl();
	GboardDTO gboardDTO = new GboardDTO();
		
	gboardDTO = boardService.viewBoard(gPostingID);
	%>

	<div class="wrap">
		<div class="intro_bg">
			<div class="header">
				<div class="searchArea">
					<form>
						<input type="search" placeholder="search"> <span>검색</span>
					</form>
				</div>
				<ul class="nav">
					<li><a href="../jsp/mainForm.jsp">오늘뭐먹지</a></li>
					<li><a href="../jsp/totalBoardForm.jsp">종합게시판</a></li>
					<li><a href="../jsp/gameForm.jsp">돌려돌려 돌림판</a></li>
					<li><a href="../jsp/inquiryBoardForm.jsp">1:1 문의</a></li>
					<li><a href="../jsp/loginForm.jsp">LOGIN</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="main_text0" style="height: 830px">
		<!-- <h2 align="center">종합 게시판</h2>
      
      <div class="contents2">-->
		<!-- 들어가야할 내용  -->
		<div class="board_wrap">
			<div class="board_title">
				<strong>게시판 글 보기</strong>
			</div>
			
			<div class="board_view_wrap">
				<div class="board_view">
					<div class="title">제목 :   <%=gboardDTO.getTitle()%></div>
					<div class="info">
						<dl>
							<dt>번호</dt>
							<dd><%=gboardDTO.getgPostingID()%></dd>
						</dl>
						<dl>
							<dt>글쓴이</dt>
							<dd><%=gboardDTO.getMemberID_FK() %></dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd><%=gboardDTO.getmDate()%></dd>
						</dl>
						<dl>
							<dt>조회</dt>
							<dd><%=gboardDTO.getClickCount() %></dd>
						</dl>
					</div>
					<div class="cont"><%=gboardDTO.getContent()%>
							<%
							String real = "C:\\eclipse_workspace\\LWhat\\src\\main\\webapp\\upload";
							File viewFile = new File(real+"\\"+gPostingID+"file.jpg");
							if(viewFile.exists()){
							%>
							<img src="../upload/<%=gPostingID%>file.jpg">
							<%} %>
					</div>
					
					<div>
						<div>
							<%
							BoardService boardListService = new BoardConmentListDAOImpl();
							GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
							ArrayList<GeneralcommentDTO> list = boardListService.conmentListBoard(pageNumber);
							for(int i =0; i < list.size(); i++){
								if(gPostingID == list.get(i).getPostingID_FK()){
							%>
							<div class="category"><%=list.get(i).getMemberID_FK() %></div>
							<div class="content"><%=list.get(i).getContent() %></div>
							<div class="date"><%=list.get(i).getmDate() %></div>
							<%if(memberID.equals(list.get(i).getMemberID_FK())){ %>
								<a href="GboardUpdateConment.jsp?gCommentID=<%=list.get(i).getgCommentID() %>&&gPostingID=<%=gPostingID%>">수정</a>
								<a href="deleteConmentAction.jsp?gCommentID=<%=list.get(i).getgCommentID() %>&&gPostingID=<%=gPostingID%>">삭제</a>
							<%		} %>
							<%	} %>
							<%} %>
						</div>
						<div class="board_page">
						<%
						BoardConmentListDAOImpl boardCommentServiceNextPage = new BoardConmentListDAOImpl();
							if(pageNumber != 1){
						%>
							<a href="GboardView.jsp?pageNumber=<%=pageNumber-1 %>&&gPostingID=<%=gboardDTO.getgPostingID() %>" class="bt prev"><</a>
						<% 
							} if(boardCommentServiceNextPage.nextPage(pageNumber + 1)){		
						%>
							<a href="GboardView.jsp?pageNumber=<%=pageNumber+1 %>&&gPostingID=<%=gboardDTO.getgPostingID() %>" class="bt next">></a>
						<%
							}
						%>
						
						</div>
						<div>
							<form method="post" action="commentWriteAction.jsp?gPostingID=<%=gboardDTO.getgPostingID()%>">
								<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
									<tr>
										<td style="border-bottom:none;" valign="middle"><br><br><%=memberID%></td>
										<td><input type="text" style="height:50px;" class="form-control" placeholder="상대방을 존중하는 댓글을 남깁시다." name = "content"></td>
										<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
									</tr>
								</table>
							</form>
						</div>
				</div>
				</div>
				
				<div class="bt_wrap">
					<a href="totalBoardForm.jsp" class="on">목록</a> 
					<%
					if(memberID.equals(gboardDTO.getMemberID_FK())){ %>
					<a href="GboardUpdate.jsp?gPostingID=<%=gboardDTO.getgPostingID()%>">수정하기</a>
					<a href="deleteAction.jsp?gPostingID=<%=gboardDTO.getgPostingID()%>">삭제하기</a>
					<%} %>
				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<div>PROJECT</div>
		<div>
			TEAM. Sixth Sense <br> Addr. 부산광역시 해운대구 우동 1475 센텀벤처타운 5층<br>
			TEL. 010 - 8028 - 5978 <br> COPYRIGHT 2022. Sixth Sense. ALL
			RIGHT RESERVED.
		</div>
	</div>
</body>
</html>
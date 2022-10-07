<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="lwhat.service.board.BoardService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="lwhat.dto.board.GboardDTO"%>
<%@ page import="lwhat.dto.GeneralcommentDTO"%>
<%@ page import="lwhat.dao.impl.board.BoardUpdateDAOImpl"%>
<%@ page import="lwhat.dao.impl.board.BoardViewDAOImpl"%>
<%@ page import="lwhat.dao.impl.board.BoardConmentUpdateDAOImpl"%>
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
<%-- <%
String memberID = (String) session.getAttribute("memberID"); 
//int gCommentID = (int)(session.getAttribute("gCommentID"));
int gCommentID = 0;
if(request.getParameter("gCommentID") != null){
	 gCommentID =Integer.parseInt(request.getParameter("gCommentID"));
}
//int gCommentID = 3;
int gPostingID = 0;
if(request.getParameter("gPostingID") != null){
	gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
}

BoardService boardService = new BoardViewDAOImpl();
GboardDTO gboardDTO = new GboardDTO();

gboardDTO = boardService.viewBoard(gPostingID);

GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
	
%> --%>
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
				<strong>댓글 수정</strong>
			</div>
			<form method="post" action="${webapproot}/gboardcommentupdateproc.do?gCommentID=${gCommentID}&gPostingID=${gPostingID}">
				<%-- <input type="hidden" name="gCommentID" value="${gCommentID}" />
				<input type="hidden" name="gPostingID" value="${gPostingID}" /> --%>
				<div class="board_write_wrap">
						<div class="board_write">
							<div class="cont">
								<textarea name="content" rows="2" cols="80">${content}</textarea>
							</div>
						</div>
					
						<div class="bt_wrap">
							<input type="submit" value="댓글수정하기" />
							 <input type="button" value="취소" onclick="window.history.back();"/> 
						</div>
					</div>
			</form>
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
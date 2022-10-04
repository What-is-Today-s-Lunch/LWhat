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
	String memberID = null;
	if(session.getAttribute("memberID") != null){
		memberID = (String) session.getAttribute("memberID");
	}
	
	
	int gPostingID = 0;
	if(request.getParameter("gPostingID") != null){
		gPostingID =Integer.parseInt(request.getParameter("gPostingID"));
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
		
					</div>
				</div>
				
				<div class="bt_wrap">
					<a href="totalBoardForm.jsp" class="on">목록</a> 
					<a href="GboardUpdate.jsp?gPostingID=<%=gboardDTO.getgPostingID() %>">수정하기</a>
					<a href="deleteAction.jsp?gPostingID=<%=gboardDTO.getgPostingID()%>">삭제하기</a>
				</div>
			</div>
			
			<!--  
			<div class="num">번호 :<%=gboardDTO.getgPostingID()%></div>
			<div class="boardCategory">카테고리 :<%=gboardDTO.getBoardCategory()%></div>
			<div class="title">제목 :<%=gboardDTO.getTitle()%></div>
			<div class="date">작성일자 :<%=gboardDTO.getmDate()%></div>
			<div class="content">내용 :<%=gboardDTO.getContent()%></div>

			<a href="totalBoardForm.jsp">글 목록</a>
			<a href="GboardUpdate.jsp?gPostingID=<%=gboardDTO.getgPostingID() %>">수정하기</a>
			<a href="deleteAction.jsp?gPostingID=<%=gboardDTO.getgPostingID()%>">삭제하기</a>
			-->

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
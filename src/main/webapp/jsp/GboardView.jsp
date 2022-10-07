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
<link rel="stylesheet" type="text/css" href="/LWhat/css/style_category.css">
<link rel="stylesheet" href="/LWhat/css/css.css">
<title>글쓰기</title>
</head>
<body>
	<%-- <%
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
				<strong>게시판 글 보기</strong>
			</div>
			
			<div class="board_view_wrap">
				<div class="board_view">
					<div class="title">제목 :   ${gboardDTO.title}</div>
					<div class="info">
						<dl>
							<dt>번호</dt>
							<dd>${gboardDTO.gPostingID}</dd>
						</dl>
						<dl>
							<dt>글쓴이</dt>
							<dd>${gboardDTO.memberID_FK}</dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd>${gboardDTO.mDate}</dd>
						</dl>
						<dl>
							<dt>조회</dt>
							<dd>${gboardDTO.clickCount}</dd>
						</dl>
					</div>
					<div class="cont">${gboardDTO.content}
							<%-- <%
							String real = "C:\\eclipse_workspace\\LWhat\\src\\main\\webapp\\upload";
							File viewFile = new File(real+"\\"+gPostingID+"file.jpg");
							if(viewFile.exists()){
							%> --%>
							<c:if test="${pn1 eq 'a' }">
							<img src="/LWhat/jsp/upload/${gboardDTO.gPostingID}file.jpg">
							</c:if>
					</div>
					
					<div>
					<!-- Comment -->
						<div>
							<!-- 댓글 표시  -->
							<c:set var="listSize" value="${list1.size()}"></c:set>
							<c:forEach var="generalcommentDTO" items="${list1}" varStatus="stat">
								<div class="category">${generalcommentDTO.memberID_FK}</div>
								<div class="content">${generalcommentDTO.content}</div>
								<div class="date">${generalcommentDTO.mDate}</div>
									<!-- 댓글 수정, 삭제 표시 -->
									<c:if test="${generalcommentDTO.memberID_FK eq memberID}">
										<a href="${webapproot}/gboardcommentupdate.do?gCommentID=
											${generalcommentDTO.gCommentID}&gPostingID=${gPostingID}">수정</a>
										<a href="${webapproot}/gboardcommentdelete.do?gCommentID=
											${generalcommentDTO.gCommentID}&gPostingID=${gPostingID}">삭제</a>
									</c:if>
							</c:forEach>
						</div>
						
						<div class="board_page">
						<c:if test="${pn3 eq 'c' }">
							<a href="${webapproot}/gboardview.do?pageNumber=${pageNumber-1}&&gPostingID=${gboardDTO.gPostingID}" class="bt prev"><</a>
						</c:if>
						<c:if test="${pn4 eq 'd'}">
							<a href="${webapproot}/gboardview.do?pageNumber=${pageNumber+1}&&gPostingID=${gboardDTO.gPostingID}" class="bt next">></a>
						</c:if>
						
						</div>
						
						<div>
							<form method="post" action="${webapproot}/gboardcommentwrite.do?gPostingID=${gboardDTO.gPostingID}">
								<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
									<tr>
										<td style="border-bottom:none;" valign="middle"><br><br><${memberID}</td>
										<td><input type="text" style="height:50px;" class="form-control" placeholder="상대방을 존중하는 댓글을 남깁시다." name = "content"></td>
										<td><br><br><input type="submit" class="btn-primary pull" value="댓글 작성"></td>
									</tr>
								</table>
							</form>
						</div>
				</div>
				</div>
				
				<div class="bt_wrap">
               <a href="${webapproot}/gboardlist.do" class="on">목록</a> 
               <c:if test="${isSameWriter}">
                  <a href="${webapproot}/gboardupdateform.do?gPostingID=${gboardDTO.gPostingID}">수정하기</a>
                  <a href="${webapproot}/gboarddelete.do?gPostingID=${gboardDTO.gPostingID}">삭제하기</a>
               </c:if>
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
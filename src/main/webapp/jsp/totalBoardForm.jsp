<%@page import="lwhat.dto.board.GboardDTO" %>
<%@page import="lwhat.dao.impl.board.BoardListDAOImpl" %>
<%@page import="lwhat.service.board.BoardService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/style_category.css">
<link rel="stylesheet" href="../css/css.css">
<title>종합 게시판</title>
</head>
<body>
<%
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null){
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	
	String bdomainParam = request.getParameter("memberID_FK") == null? "" : request.getParameter("memberID_FK");
    String searchDomainParam = request.getParameter("searchDomain") == null? "" : request.getParameter("searchDomain");
    String searchTextParam = request.getParameter("searchText") == null? "" : request.getParameter("searchText");
   
    // 검색을 버튼을 눌렀을 때, 어떤 기준으로 찾을 것인지 (제목, 작성자, 제목 + 작성자)의 값과 검색 내용을 map으로 묶어서 넘겨준다. 
    Map<String,String> map = new HashMap<>();
   // (제목, 작성자, 제목 + 작성자)
   map.put("searchDomain", searchDomainParam);
   // 검색 내용
   map.put("searchText", searchTextParam);
   
   // domain이 전체일 경우
    if(bdomainParam == null || bdomainParam.equals("")){
       // 검색 내용 X
       if(searchTextParam == null || searchTextParam.equals("")){
          pageContext.setAttribute("list", new BoardListDAOImpl().listBoard(pageNumber));   
       }
       else{   // 검색 내용 O
          pageContext.setAttribute("list", new BoardListDAOImpl().listBoard(bdomainParam, map));   
       }
   }else{   // domain이 특정 값일 경우
      // 검색 내용 X
      if(searchTextParam == null || searchTextParam.equals("")){
         pageContext.setAttribute("list", new BoardListDAOImpl().listBoard(pageNumber));
      }
      else{   // 검색 내용 O
         pageContext.setAttribute("list", new BoardListDAOImpl().listBoard(bdomainParam, map));
      }
   }
	
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
						<strong>종합 게시판</strong>
						<p>모든것을 찾아보세요</p>
					</div>
					<div class="board_list_wrap">
						<div class="board_list">
							<div class="top">
								<div class="num">번호</div>
								<div class="category">카테고리</div>
								<div class="title">제목</div>
								<div class="write">글쓴이</div>
								<div class="date">작성일</div>
								<div class="count">조회</div>
							</div>
							<div>
							<%
								BoardService boardService = new BoardListDAOImpl();
								GboardDTO gboardDTO = new GboardDTO();
								ArrayList<GboardDTO> list = boardService.listBoard(pageNumber);
								for(int i = 0; i < list.size(); i++){
							%>
								<div class="num"><%= list.get(i).getgPostingID() %></div>
								<div class="category"><%= list.get(i).getBoardCategory() %></div>
								<div class="title"><a href="GboardView.jsp?gPostingID=<%= list.get(i).getgPostingID() %>"><%= list.get(i).getTitle() %></a></div>
								<div class="write"><%= list.get(i).getMemberID_FK() %></div>
								<div class="date"><%= list.get(i).getmDate()%></div>
								<div class="count"><%= list.get(i).getClickCount() %></div>
							<% } %>
							
							</div>
						</div>
						
						<div class="board_page">
						<%
							BoardListDAOImpl boardServiceNextPage = new BoardListDAOImpl();
							if(pageNumber != 1){
						%>
							<a href="totalBoardForm.jsp?pageNumber=<%=pageNumber-1 %>" class="bt prev"><</a>
						<% 
							} if(boardServiceNextPage.nextPage(pageNumber + 1)){		
						%>
							<a href="totalBoardForm.jsp?pageNumber=<%=pageNumber+1 %>" class="bt next">></a>
						<%
							}
						%>
						</div>
						<div class="bt_wrap">
							<a href="GboardWrite.jsp" class="on">등록</a>
							<!--<a href="#" >수정</a>-->
						</div>
					</div>
				<!-- </div> -->
		<!-- 들어가야할 내용  -->
		</div>
		<div class="contents1">
		<form name="searchDomain" action="../jsp/totalBoardForm.jsp">
			<select name="searchDomain">
				<option value="">전체</option>
				<option value="">제목</option>
				<option value="">작성자</option>
			</select>&nbsp; 
			<input type="text" name="searchText" placeholder="검색">&nbsp; 
			<input type="button" value="검색" onclick="this.form.submit()"><br /> <br />
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
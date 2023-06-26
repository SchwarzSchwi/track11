<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao = new NewsDao();
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select ="n.title";
		search ="";
	}
	ArrayList<NewsDto> dtos = dao.getNewsList(select,search);
%>
<%@ include file="../common_session.jsp"%>
<%@ include file="../common_header.jsp"%>
<script type="text/javascript">
	function goSearch(){
		news.method="post";
		news.action="news_list.jsp";
		news.submit();
	}
	function goView(no){
		viewNews.t_no.value = no;
		viewNews.method="post";
		viewNews.action="news_view.jsp";
		viewNews.submit();
	}
</script>
<form name="viewNews">
	<input type="hidden" name="t_no">
</form>
<!-- sub contents -->
<div class="sub_title">
	<h2>뉴스</h2>
	<div class="container">
		<div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a></li>
				<li class="dropdown"><a href="">커뮤니티<i
						class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a> 
						<a href="allclass.html">학과및모집안내</a>
						<a href="portfolio.html">포트폴리오</a> 
						<a href="online.html">온라인접수</a>
						<a href="../notice/notice.jsp">커뮤니티</a>
					</div></li>
				<li class="dropdown">
					<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.jsp">공지사항</a> 
						<a href="qa.html">질문과답변</a> 
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<!-- container end -->
</div>
<div class="container">
	<div class="search_wrap">
		<div class="record_group">
			<p>
				총게시글<span><%=dtos.size()%></span>건
		</div>
		<div class="search_group">
			<form name="news">
				<select name="t_select" class="select">
					<option value="n.title"
						<%if(select.equals("n.title")) out.print("selected");%>>제목</option>
					<option value="n.content"
						<%if(select.equals("n.content")) out.print("selected");%>>내용</option>
				</select> 
				<input type="text" name="t_search" value="<%=search%>" class="search_word">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	</div><!-- search end -->
	<div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날짜,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<% for(int k=0; k<dtos.size(); k++){ %>
				<tr>
					<td><a href="javascript:goView('<%=dtos.get(k).getNo()%>')"><%=dtos.get(k).getNo()%></a></td>
					<td class="title"><a
						href="news_view.jsp?t_no=<%=dtos.get(k).getNo()%>"><%=dtos.get(k).getTitle()%></a></td>
					<td><%=dtos.get(k).getReg_name()%></td>
					<td><%=dtos.get(k).getReg_date()%></td>
					<td><%=dtos.get(k).getHit()%></td>
				</tr>
				<% }%>
			</tbody>
		</table>
		<div class="paging">
			<a href=""><i class="fa fa-angle-double-left"></i></a> <a href=""><i
				class="fa fa-angle-double-left"></i></a> <a href="" class="active">1</a>
			<a href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a> <a
				href=""><i class="fa fa-angle-right"></i></a> <a href=""><i
				class="fa fa-angle-double-right"></i></a>
			<% if(sessionLevel.equals("top")){ %>
			<a href="news_write.jsp" class="btn_write">글쓰기</a>
			<% } %>
		</div>
	</div>
</div>
<!-- end contents -->

<script>
	$(function(){
		$(".location .dropdown > a").on("click",function(e)){
			e.preventDefault();
			if($(this).next().is("visible")){
				$(".location .dropdown > a").next().hide();
			}else{
				$(".location.dropdown > a").next().hide();
				$(this).next().show();
			}
		});
	});
</script>

<%@ include file="../common_footer.jsp"%>

</body>
</html>
	
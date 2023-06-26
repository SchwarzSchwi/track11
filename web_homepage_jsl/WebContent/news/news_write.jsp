<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*"%>
<%@ include file="../common_session.jsp"%>
<%
	if(!sessionLevel.equals("top")){
%>
		<script type="text/javascript">
			alert("관리자 화면 입니다.");
			location.href="../index.jsp";
		</script>
<% } %>
<%@ include file="../common_header.jsp"%>
<script>
	function goSave(){
		if(checkValue(news.t_title,"제목입력!"))return;
		if(checkValue(news.t_content,"내용입력!"))return;
		news.method="post";
		news.action="db_news_save.jsp";
		news.submit();
	}
</script>

	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
			<div class="location">
				<ul>
					<li class="btn_home">
						<a href="../index.jsp"><i class="fa fa-plus btn_plus"></i></a>
					</li>
					<li class="dropdown">
						<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
						<div class="dropdown_menu">
							<a href="gratings.html">공지사항</a>
							<a href="allclass.html">학과및모집안내</a>
							<a href="portfolio.html">포트폴리오</a>
							<a href="online.html">온라인접수</a>
							<a href="notice.html">커뮤니티</a>
						</div>				
					</li>
					<li class="dropdown">
						<a href="">공지사항<i class="fa fa-plus btn_plus"></i></a>
						<div class="dropdown_menu">
							<a href="gratings.html">공지사항</a>
							<a href="gratings.html">DW인터뷰</a>
							<a href="gratings.html">취업실적</a>
						</div>	
					</li>		
				</ul>
			</div>
		</div><!-- container end -->
	</div>
	
	<div class="container">
		<div class="write_wrap">
		<h2 class="sr-only">공지사항 글쓰기</h2>
		<form name="news">
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"></textarea></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><%=sessionName%></td>
						<th>등록일자</th>
						<td><%=CommonUtil.getToday()%></td>
					</tr>
				</tbody>	
			</table>
			<div class="btn_wrap">
				<input type="button" onClick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='news_list.jsp'">
			</div>
		</form>
		</div>
	</div>
	<!-- end contents -->
	<script>
		$(function(){
			$(".location  .dropdown > a").on("click",function(e){
				e.preventDefault();
				if($(this).next().is(":visible")){
					$(".location .dropdown > a").next().hide();
				}else{
					$(".location .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
<%@ include file="../common_footer.jsp"%>
	</body>
</html>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*,dto.*,dao.*"%>  
<% 	
	QnaDao dao = new QnaDao();
	String no = request.getParameter("t_no");
	QnaDto dto = dao.getQnaView(no); 
%> 
<%@ include file="../common_session.jsp" %>

		
<%@ include file="../common_header.jsp"%>
<script>
	function goUpdate(){
		if(checkValue(write.t_title,"제목입력!"))return;
		if(checkValue(write.t_content,"내용입력!"))return;
		write.method="post";
		write.action="db_qa_update.jsp";
		write.submit();
	}
</script>
<!-- sub contents -->
	<div class="sub_title">
		<h2>질문답변</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.jsp"><i class="fa fa-home btn_plus"></i></a>
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
					<a href="">질문답변<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.html">공지사항</a>
						<a href="gratings.html">질문과답변</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="write">
	  <input name=t_no value="<%=dto.getNo()%>">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="t_content"><%=dto.getContent()%></textarea></td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td><%=sessionName%><td>
					</tr>
					<tr>
						<th>등록일시</th>
						<td><%=CommonUtil.getTodayTime()%></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" onClick="goUpdate()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='qa_list.jsp';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			if(write.t_title.value=="") {
				alert("제목을 입력");
				notice.title.focus();
				return false;
			}
			if(write.t_contents.value=="") {
				alert("내용을 입력");
				notice.contents.focus();
				return false;
			}
			return true;
		}
	</script>
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<%@ include file="../common_footer.jsp" %>

 </body>
</html>

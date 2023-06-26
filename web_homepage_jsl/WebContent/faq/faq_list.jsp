<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,java.util.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	FaqDao dao = new FaqDao();
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select ="n.title";
		search ="";
	}
	
	/* paging 설정 start*/
	int totalCount = dao.getTotalCount(select,search);
	int list_setup_count = 5;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
	String nowPage = request.getParameter("t_nowPage");
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	/* paging 설정 end*/	
	
	ArrayList<FaqDto> dtos = dao.getFaqListPage(select,search,start,end);
%>
<%@ include file="../common_session.jsp" %>	
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goSearch(){
		faq.method="post";
		faq.action="faq_list.jsp";
		faq.submit();
	}
	function goPage(pageNumber){
		pageForm.t_nowPage.value = pageNumber;
		pageForm.method="post"
		pageForm.action="faq_list.jsp"
		pageForm.submit();
	}	
	
</script>

<form name="pageForm">
	<input type="hidden" name="t_nowPage">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.html"><i class="fa fa-home btn_plus"></i></a>
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
					<a href="">자주하는질문<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="notice.html">공지사항</a>
						<a href="qa.html">질문과답변</a>
						<a href="faq.html">FAQ</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><%=totalCount%></span>건</p>
		</div>
		<div class="search_group">
			<form name="faq" action="">
				<select name="t_select" class="select">
					<option value="n.title"<%if(select.equals("n.title")) out.print("selected");%>>제목</option>
					<option value="n.content"<%if(select.equals("n.content")) out.print("selected");%>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search%>" class="search_word">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		
		<div class="faq-group">
			<%for(int k=0; k<dtos.size(); k++){ %>		
				<div class="accordion">
					<table class="table">
						<colgroup>
							<col width="5%">
							<col width="*">
							<col width="15%">
							<col width="10%">
						</colgroup>
						<tr>
							<td><%=dtos.get(k).getNo()%></td>
							<td><%=dtos.get(k).getTitle() %></td>
							<td><%=dtos.get(k).getReg_name() %></td>
							<td><%=dtos.get(k).getReg_date() %></td>
						</tr>	
				
					</table>
				</div>
				<div class="panel">
					<textarea readonly><%=dtos.get(k).getContent() %></textarea>
				</div>
			<%} %>	
		</div>

		<script>
			$(function() {
/*			
				$( '.accordion' ).click( function() {
				//$(".accordion").on("click",function() {	
					//$(".panel").slideUp();
					//$(this).next().slideToggle();
					//$(this).next().slideDown();
					$(".panel").not($(this).next().slideToggle()).slideUp();
					//$(this).next().slideDown();
					

				} );
		*/			
			
				$(".accordion").on("click",function() {
					$(".panel").not($(this).next().slideToggle()).slideUp();
					$(".accordion").not($(this)).removeClass("active");
					$(this).toggleClass("active");
				});
		
			});
		</script>
	

		<div class="paging">
<% 
			String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
			out.print(paging);
%>			
<!--		<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
			<a href="faq_write.html" class="btn_write">글쓰기</a>
-->
			<% if(sessionLevel.equals("top")){ %>
				<a href="faq_write.jsp" class="btn_write">글쓰기</a>
			<% } %>		
		</div>
	  </div>
	</div>
	<!-- end contents -->
	
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
	

<footer class="footer">
		<div class="container clearfix">
			<address class="address">
				<p class="title">본사</p>
				(우)12345 대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층,6층/고객센터: 042-242-4412 	사업자등록번호: 305-86-06709
			</address>
			<p class="copyright">Copyright &copy JSL 인재개발원주식회사. All rights reserved.</p>
		</div>
</footer>

 </body>
</html>










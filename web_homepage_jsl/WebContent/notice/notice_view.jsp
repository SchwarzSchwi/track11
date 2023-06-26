<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>    
<%
	NoticeDao dao = new NoticeDao();	
	String no = request.getParameter("t_no");
	
	dao.setHitCount(no);
	
	NoticeDto dto = dao.getNoticeView(no);
	
	NoticeDto preDto = dao.getPreNotice(no);
	NoticeDto nextDto = dao.getNextNotice(no);
	String attachName = "";
	if(dto.getAttach() != null){
		attachName = dto.getAttach();
	}
	
%>
<%@ include file="../common_session.jsp" %>
<%@ include file="../common_header.jsp"%>
<script type="text/javascript">
	function goView(no){
		notice.t_no.value = no;
		notice.method="post";
		notice.action="notice_view.jsp";
		notice.submit();
	}
	function goUpdateForm(no){
		notice.t_no.value = no;
		notice.method="post";
		notice.action="notice_update.jsp";
		notice.submit();
	}
	function goDelete(){
		if(confirm("정말 삭제하겠습니까?")){
			notice.method="post";
			notice.action="db_notice_delete.jsp";
			notice.submit();
		}
	}
</script>
<form name="notice">
	<input type="hidden" name="t_no" value="<%=no%>">
	<input type="text" name="t_attach" value="<%=attachName%>">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>공지사항</h2>
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
						<a href="gratings.html">질문답변</a>
						<a href="gratings.html">취업실적</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<div class="board_view">
			<h2>[공지]<%=dto.getTitle()%></h2>
			<p class="info"><span class="user"><%=dto.getReg_name()%></span> | <%=dto.getReg_date()%> | <i class="fa fa-eye"></i> <%=dto.getHit()%></p>
			<div class="board_body">
				<textarea readonly><%=dto.getContent()%></textarea>
				<%if(dto.getAttach() != null){ %>
					<p>
						<img src="../images/clip.png">
						<a href="../common/filedown.jsp?t_fileDir=notice&t_fileName=<%=dto.getAttach()%>"><%=dto.getAttach()%></a>
					</p>
				<%} %>
			</div>
			
			<div class="prev_next">
			<%	
				if(preDto != null){
					String preTitle = preDto.getTitle();
				if(preTitle.length() > 15){
					preTitle = preTitle.substring(0,15)+"...";
				}
            %>	
            
<!--get 방식		<a href="notice_view.jsp?t_no=<%=preDto.getNo()%>" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle%></span>
					</span>
				</a>
-->				
				<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev"><i class="fa fa-angle-left"></i>
					<span class="prev_wrap">
						<strong>이전글</strong><span><%=preTitle%></span>
					</span>
				</a>
			<%  } %>	
			<!-- goUpdateForm 매개변수 지움 -->
				<div class="btn_3wrap">
					<a href="notice_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")){ %>
					<a href="javascript:goUpdateForm('<%=dto.getNo()%>')">수정</a> 
					<a href="javascript:goDelete()">삭제</a>
					<% } %>
				</div>
			<%
				if(nextDto != null) {
					String nextTitle = nextDto.getTitle();
				if(nextTitle.length() > 15){
					nextTitle = nextTitle.substring(0,15)+"...";
				}
				
			%>	
				<a href="javascript:goView('<%=nextDto.getNo()%>')" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span><%=nextTitle%></span>
				</span>
				<i class="fa fa-angle-right"></i>
				</a>
			<%  } %>	
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
	

<%@ include file="../common_footer.jsp"%>

 </body>
</html>
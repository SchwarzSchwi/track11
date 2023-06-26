<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>    
<%
	PdsDao dao = new PdsDao();	
	String no = request.getParameter("t_no");
	
	dao.setHitCount(no);
	
	PdsDto dto = dao.getPdsView(no);
	
	PdsDto preDto = dao.getPrePds(no);
	PdsDto nextDto = dao.getNextPds(no);
	String attachName = "";
	if(dto.getAttach() != null){
		attachName = dto.getAttach();
	}
	
%>
<%@ include file="../common_session.jsp" %>
<%@ include file="../common_header.jsp"%>
<script type="text/javascript">
	function goView(no){
		pds.t_no.value = no;
		pds.method="post";
		pds.action="pds_view.jsp";
		pds.submit();
	}
	function goUpdateForm(no){
		pds.t_no.value = no;
		pds.method="post";
		pds.action="pds_update.jsp";
		pds.submit();
	}
	function goDelete(){
		if(confirm("정말 삭제하겠습니까?")){
			pds.method="post";
			pds.action="db_pds_delete.jsp";
			pds.submit();
		}
	}
</script>
<form name="pds">
	<input type="hidden" name="t_no" value="<%=no%>">
	<input type="text" name="t_attach" value="<%=attachName%>">
</form>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자료실</h2>
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
			<h2>[자료]<%=dto.getTitle()%></h2>
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
            
<!--get 방식		<a href="pds_view.jsp?t_no=<%=preDto.getNo()%>" class="btn_prev"><i class="fa fa-angle-left"></i>
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
					<a href="pds_list.jsp">목록</a> 
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
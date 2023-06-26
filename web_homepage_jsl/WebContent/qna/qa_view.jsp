<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<% 
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();
	
	
	String no   = request.getParameter("t_no");
	
	dao.setHitCount(no);
	
	QnaDto dto = dao.getQnaView(no);
	
	QnaDto preDto = dao.getPreQna(no);
	QnaDto nextDto = dao.getNextQna(no);
%>
<%@ include file="../common_session.jsp" %>	
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goView(no){
		qna.t_no.value = no;
		qna.method="post"
		qna.action="qa_view.jsp"
		qna.submit();
	}
	function goUpdateAnswer(){
		qna.method="post";
		qna.action="qa_update_reply.jsp"
		qna.submit();
	}	
	function goDeleteAnswer(){
	
		qna.method="post";
		qna.action="db_qa_delete_answer.jsp";
		qna.submit();
	}
	function goDelete(){
		if(confirm("정말 삭제하겠습니까?")){
			qna.method="post";
			qna.action="db_qa_delete.jsp";
			qna.submit();
		}
	}
	function goReply(){
		qna.method="post";
		qna.action="qa_reply.jsp";
		qna.submit();
	}
	function goDeleteQestion(){
		qna.method="post";
		qna.action="db_qa_delete_question.jsp";
		qna.submit();
	}
	function goUpdateQestion(){
		qna.method="post";
		qna.action="qa_update.jsp";
		qna.submit();
	}
</script>
<form name="qna">
	<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
</form>	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>질문답변</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
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
			<h2>[질문]<%=dto.getTitle()%></h2>
			<p class="info"><span class="user"><%=dto.getReg_id()%></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i><%=dto.getHit()%></p>
			<div class="board_body">
				<p><textarea readonly><%=dto.getContent()%></textarea></p>
				<%if(dto.getAnswer()!=null){ %>
				<p style="font-weight:bold">답변 | 답변일자 <%=dto.getQna_date()%> |</p>
				<p><textarea readonly><%=dto.getAnswer()%></textarea></p>
				<% } %>

<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){
	$(".answerButt").toggle(function(){
		$(".answerArea").slideDown(500);	
	}, function(){
		$(".answerArea").slideUp(500);
	})
});
//]]>
</script>
<style>
	.answerArea{display:none} 
	.btn_3wrap span {
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}
	.answerArea .textArea_H120{
		padding:5px;
		width:700px;
		height:120px;
	}	
	.answerArea .saveButt{
		float:right;
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}	
</style>
				
			<!-- 답변 -->
			<form name="answer">
				<div class="answerArea">
					<input type="hidden" name="t_no" value="">
					<textarea name="t_answer" class="textArea_H120"></textarea>
					<a href="javascript:goAnswerSave()" class="saveButt">Answer Save</a>
				</div>
			</form>					
			</div>
			
			<div class="prev_next">
			<%
				if(preDto != null){ 
					String preTitle = preDto.getTitle();
				if(preTitle.length() > 15){
					preTitle = preTitle.substring(0,15)+"...";
				}
			%>
				<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preTitle%></span>
				</span>
				</a>
			<% } %>	
				<div class="btn_3wrap">
					<a href="qa_list.jsp">목록</a>
					<%if(sessionLevel.equals("top") && dto.getAnswer()==null){ %>
					<a href="javascript:goReply()">답변작성</a>
					<a href="javascript:goDelete()">글삭제</a>  
					<% } %>
					<%if(sessionLevel.equals("top") && dto.getAnswer()!=null){ %>
					<a href="javascript:goUpdateAnswer()">답변수정</a> 
					<a href="javascript:goDeleteAnswer()">답변삭제</a>
					<a href="javascript:goDelete()">글삭제</a>  
					<% } %>
					
				 
					
					<span class="answerButt" style="cursor:pointer">Answer</span>
					
					<%if(sessionLevel.equals("member") && dto.getAnswer()==null){ %>
					<a href="javascript:goDeleteQestion()">질문삭제</a> 
					<a href="javascript:goUpdateQestion()">질문수정</a>
					<% } %>
					<%if(sessionLevel.equals("member") && dto.getAnswer()!=null){ %>
					<% } %>
				</div>
			<%
				if(nextDto != null){
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
	

<%@ include file="../common_footer.jsp" %>
 </body>
</html>










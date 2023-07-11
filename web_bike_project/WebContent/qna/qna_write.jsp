<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<c:if test="${sessionLevel ne 'member'}">
	<script>
		alert("회원 화면 입니다!");
		location.href="Qna";
	</script>
</c:if>
<script type="text/javascript">
	function goSave(){
		if(checkValue(qa.q_title,"제목 입력!")) return;
		if(checkValue(qa.q_content,"내용 입력!")) return;

		qa.method="post";
		qa.action="Qna?t_gubun=save";
		qa.submit();
		
				
	}
</script>
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<form name="qa">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="hidden" name="t_gubun">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="q_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="q_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${sessionId}</td>
						<th>QestionDate</th>
						<td>${t_today}</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>	
</body>
</html>






    
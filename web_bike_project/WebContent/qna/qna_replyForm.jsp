<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<c:if test="${sessionLevel ne 'admin'}">
	<script>
		alert("관리자 화면 입니다!");
		location.href="Qna";
	</script>
</c:if>
<script type="text/javascript">
	function goSave(no){
		if(checkValue(qa.a_content,"내용 입력!")) return;
		qa.t_no.value=no;
		qa.method="post";
		qa.action="Qna";
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
			<input type="hidden" name="t_gubun" value="reply">
			<table class="boardForm">
				<colgroup>
					<col width="50%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>QestionTitle</th>
 						<td colspan="2">${t_dto.getQ_title()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getViews()}</td>
					</tr>	
					<tr>
						<th>QestionContent</th>
						<td colspan="3"><textarea readonly cols="80" rows="20">${t_dto.getQ_content()}</textarea></td>
					</tr>	
					<tr>
						<th>QestionWriter</th>
						<td>${t_dto.getName()}</td>
						<th>QuestionDate</th>
						<td>${t_dto.getQ_date()}</td>
					</tr>
					<tr>
						<th>Reply</th>
						<td colspan="3"><textarea name="a_content" cols="80" rows="20"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td colspan="3">${sessionName}</td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave('${t_dto.getNo()}')" class="butt">Save</a>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>	
</body>
</html>





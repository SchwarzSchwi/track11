<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>  
<script type="text/javascript">
	function goDelete(){
		if(confirm("삭제하겠습니까?")){
			qa.t_gubun.value ="delete";
			qa.method="post";
			qa.action="Qna";
			qa.submit();
		}
	}
	function goReplyForm(no){
		qa.t_gubun.value ="replyForm";
		qa.t_no.value =no;
		qa.method="post";
		qa.action="Qna";
		qa.submit();
	}

	function goUpdateForm(no){
		qa.t_gubun.value ="updateForm";
		qa.t_no.value = no;
		qa.method="post";
		qa.action="Qna";
		qa.submit();
	}
	function goDeleteAnswer(no){
		if(confirm("답변삭제하겠습니까?")){
			qa.t_gubun.value ="deleteAnswer";
			qa.t_no.value = no;
			qa.method="post";
			qa.action="Qna";
			qa.submit();
		}
	}
	function goUpdateAnswerForm(no){
		qa.t_gubun.value="updateAnswerForm";
		qa.t_no.value = no;
		qa.method="post";
		qa.action="Qna";
		qa.submit();
	}
	
</script>
<form name="qa">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no" value="${t_dto.getNo()}">
</form> 
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>QestionTitle</th>
						<td colspan="2">${t_dto.getQ_title()}</td>
						<td> <i class="far fa-eye"></i>${t_dto.getViews()}</td>
					</tr>
<style>
	.viewImg{
		width:500px;
		height:300px;
	}
	.imgDiv{
		width:500px;
		height:300px;	
		padding: 10px;
		margin: 10px 90px;			
		border:1px solid gray;
	}
</style>				
					<c:if test="${t_dto.getPhotos() ne null}">
					<tr>
						<td colspan="4">
							<div class="imgDiv">
								<img src="attach/qna/${t_dto.getPhotos()} "class="viewImg">
							</div>
						</td>
					</tr>
					</c:if>
					<style>
						.viewContent{
							white-space:pre-wrap;
							padding:10px 0;						
						}
					</style>	
					<tr>
						<th>QestionContent</th>
						<td colspan="3">
							<div class="viewContent">${t_dto.getQ_content()}</div>
						</td>
					</tr>	
					<tr>
						<th>QestionWriter</th>
						<td>${t_dto.getName()}</td>
						<th>QuestionDate</th>
						<td>${t_dto.getQ_date()}</td>
					</tr>
					<c:if test="${t_dto.getA_content() ne null}">
					<tr>
						<th>Reply</th>
						<td colspan="3">
							<div class="viewContent">${t_dto.getA_content()}</div>
						</td>
					</tr>	
					<tr>
						<th>AnswerWriter</th>
						<td>${t_dto.getA_id()}</td>
						<th>AnswerDate</th>
						<td>${t_dto.getA_date()}</td>
					</tr>
					</c:if>		
				</tbody>
			</table>
			<div class="buttonGroup">
				<c:if test="${sessionLevel eq 'member' && sessionId eq t_dto.getQ_id() && t_dto.getA_content() eq null}">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				</c:if>	
				<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				</c:if>
				<c:if test="${sessionLevel eq 'admin' && t_dto.getA_content() eq null}">
				<a href="javascript:goReplyForm('${t_dto.getNo()}')" class="butt">Reply</a>
				</c:if>
				<c:if test="${sessionLevel eq 'admin' && t_dto.getA_content() ne null }">
				<a href="javascript:goDeleteAnswer('${t_dto.getNo()}')" class="butt">DeleteAns</a>
				<a href="javascript:goUpdateAnswerForm('${t_dto.getNo()}')" class="butt">UpdateAns</a>
				</c:if>
				<a href="Qna" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp"%>
</body>
</html>

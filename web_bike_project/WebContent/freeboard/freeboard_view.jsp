<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>
<script type="text/javascript">
	function goDelete(){
		if(confirm("삭제하겠습니까?")){
			fb.t_gubun.value ="delete"
			fb.method="post";
			fb.action="Freeboard";
			fb.submit();
		}
	}
	function goUpdateForm(no){
		fb.t_gubun.value ="updateForm";
		fb.t_no.value = no;
		fb.method="post";
		fb.action="Freeboard";
		fb.submit();
	}
	function goDownload(no){
		var count = Number($('.down_counter').val());
		$('.down_counter').val(count+1);
		fb.method="post";
		fb.action="FileDown?t_fileDir=freeboard&t_no=${t_dto.getNo()}&t_fileName=${t_dto.getAttach()}";
		fb.submit();
		
	}
</script>
<form name="fb">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no" value="${t_dto.getNo()}">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach()}">
</form> 
		<div id="b_left">
			<%@ include file="../common_menu.jsp" %>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				FREEBOARD
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
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> 
							<i class="far fa-eye"></i>${t_dto.getHit()}
						 	<i class="fa-solid fa-download"></i> <input type="text" class="down_counter" value="0" disabled style="border:none;width:10px;background-color:white;">
						</td> 
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
					<c:if test="${not empty t_dto.getAttach()}">	
					<tr>
						<td colspan="4">
							<div class="imgDiv">
								<img src="attach/freeboard/${t_dto.getAttach()} "class="viewImg">
							</div>
							
						</td>
						
						<!--<a href="Filedown?t_fileDir=freeboard&t_no=${t_dto.getNo()}&t_fileName=${t_dto.getAttach()}">${t_dto.getAttach()}</a>-->
					</tr>
					<tr>
						<th>Attach</th>
							<td colspan="4">
								<a href="javascript:goDownload()">${t_dto.getAttach()}</a>
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
						<th>Content</th>
						<td colspan="3">
							<div class="viewContent">${t_dto.getContent()}</div>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getName()}</td>
						<th>Date</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>
				</tbody>
			</table>
			<div class="buttonGroup">
				<c:if test="${sessionId ne t_dto.getReg_id() && sessionLevel eq 'admin'}">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				</c:if>
				<c:if test="${sessionId eq t_dto.getReg_id() && sessionLevel eq 'member'}">
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				<a href="javascript:goDelete()" class="butt">Delete</a>
				</c:if>	
				<c:if test="${sessionId eq t_dto.getReg_id() && sessionLevel eq 'admin'}">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm('${t_dto.getNo()}')" class="butt">Update</a>
				</c:if>
				<a href="Freeboard" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp"%>
</body>
</html>

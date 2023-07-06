<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script>
	function goDelete(){
		if(confirm("삭제하겠습니까?")){
			product.t_gubun.value="delete";
			product.method="post";
			product.action="Product";
			product.submit();
		}	
	}
	function goUpdateForm(){
		product.t_gubun.value ="updateForm";
		product.method="post";
		product.action="Product";
		product.submit();
	}
	function goPurchaseForm(){
		product.t_gubun.value ="purchaseForm";
		product.method="post";
		product.action="Product";
		product.submit();
	}
</script>
<form name="product">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no" value="${t_dto.getNo()}">
	<input type="hidden" name="t_photos" value="${t_dto.getPhotos()}">
</form>
	<div id="b_left">
		<c:if test="${sessionLevel eq 'admin'}">
			<%@ include file="../common_menu_admin.jsp" %>
		</c:if>
		<c:if test="${sessionLevel eq 'member'}">
			<%@ include file="../common_menu_member.jsp" %>
		</c:if>
		<c:if test="${empty sessionLevel}">
			<%@ include file="../common_menu_not_member.jsp" %>
		</c:if>
	</div>
		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
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
						<th>Serial_no</th>
						<td colspan="2">${t_dto.getSerial_no()}</td>
						<td> <i class="far fa-eye"></i> ${t_dto.getViews()}</td>
					</tr>
					<tr>
						<th>Name</th>
						<td colspan="3">${t_dto.getName()}</td>
					</tr>
					<tr>
						<th>Priority</th>
						<td colspan="3">${t_dto.getPriority()}</td>
					</tr>
					<tr>
						<th>Huge</th>
						<td colspan="3">${t_dto.getHuge()}</td>
					</tr>
					<tr>
						<th>Price</th>
						<td colspan="3">${t_dto.getPrice()}</td>
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
					<tr>
						<td colspan="4">
							<div class="imgDiv">
								<img src="attach/product/${t_dto.getPhotos()} "class="viewImg">
							</div>
						</td>
					</tr>
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
<!-- 					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>	
-->
					<tr>
						<th>Writer</th>
						<td>${t_dto.getRegistrant()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	

				</tbody>
			</table>
			<div class="buttonGroup">
			<c:if test="${sessionLevel eq 'admin'}">	
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
			</c:if>	
				<a href="Product" class="butt">List</a>
			<c:if test="${sessionLevel eq 'member'}">
				<a href="javascript:goPurchaseForm()" class="butt">Purchase</a>
			</c:if>	
			</div>	
		</div>	
	</div>
<%@ include file="../common_footer.jsp" %>
</body>
</html>
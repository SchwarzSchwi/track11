<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp"%>  
<script type="text/javascript"> 
	function goSearch(){
		product.method="post";
		product.action="Product";
		product.submit();
	}
	function goPage(pageNum){
		product.t_nowPage.value = pageNum;
		product.method="post";
		product.action="Product";
		product.submit();
	}
	function goView(no){
		productWork.t_gubun.value="view";
		productWork.t_no.value=no;
		productWork.method="post";
		productWork.action="Product";
		productWork.submit();
	}
	function goWriteForm(){
		productWork.t_gubun.value="writeForm";
		productWork.method="post";
		productWork.action="Product";
		productWork.submit();
	}
</script>
<form name="productWork">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
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
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount} </span>건</p>
			</div>	
			<form name="product">
			<input type="hidden" name="t_nowPage">		
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="serial_no" <c:if test="${t_select eq 'serial_no'}">selected</c:if> >제품번호</option>
					<option value="name" <c:if test="${t_select eq 'name'}">selected</c:if>>제품명</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="30%">
					<col width="20%">
					<col width="20%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Photo</th>
						<th>Serial_No</th>
						<th>Name</th>
						<th>Price</th>
						<th>views</th>
					</tr>
				</thead>
				<tbody>
				<style>
				.productimg{
					width : 100px;
				}
				</style>
				<c:set var="order" value="${t_order}"></c:set>
				<c:forEach items="${t_dtos}" var="dto">
					<tr>
						<td>
							${order}
							<c:set var="order" value="${order -1}"></c:set>
						</td>
						<td><a href="javascript:goView('${dto.getNo()}')"><img src="attach/product/${dto.getPhotos()}" class="productimg"></a></td>
						<td class="t_center"><a href="javascript:goView('${dto.getNo()}')">${dto.getSerial_no()}</a></td>
						<td>${dto.getName()}</td>
						<td>${dto.getPrice()}</td>
						<td>${dto.getViews()}</td>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
				<c:if test="${sessionLevel eq 'admin'}">
					<a href="javascript:goWriteForm()" class="write">글쓰기</a>
				</c:if>	
			</div>
		</div>	
<%@ include file="../common_footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goSearch(){
		manage.method="post";
		manage.action="Manage";
		manage.submit();
	}
	function goPage(pageNum){
		manage.t_nowPage.value = pageNum;
		manage.method="post";
		manage.action="Manage";
		manage.submit();
	}
	function goView(order_no){
		workManage.t_gubun.value="view";
		workManage.t_no.value=order_no;
		workManage.method="post";
		workManage.action="Manage";
		workManage.submit();
	}
</script>
	<div>
	<form name="workManage">
		<input type="hidden" name="t_gubun">
		<input type="hidden" name="t_no">
	</form>
	
		<div id="b_left">
			<%@ include file="../common_menu_admin.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				Manage
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 거래 수<span> ${t_totalCount} </span>건</p>
			</div>
			<form name="manage">
			<input type="hidden" name="t_nowPage">					
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="consumer_id" <c:if test="${t_select eq 'consumer_id'}"> selected</c:if> >Id</option>
					<option value="now_status" <c:if test="${t_select eq 'now_status'}">selected</c:if> >Now status</option>
				</select>
				<select name="t_displayCount" class="sel_box">
					<option value="5" <c:if test="${t_displayCount eq '5'}"> selected</c:if> >5명</option>
					<option value="10" <c:if test="${t_displayCount eq '10'}"> selected</c:if> >10명</option>
					<option value="20" <c:if test="${t_displayCount eq '20'}"> selected</c:if> >20명</option>
					<option value="50" <c:if test="${t_displayCount eq '50'}"> selected</c:if> >50명</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
					<col width="15%">
					<col width="30%">
				</colgroup>
				<thead>
					<tr>
						<th>Order_no</th>
						<th>now_status</th>
						<th>Serial_no</th>
						<th>Consumer_id</th>
						<th>Price</th>
						<th>Purchase_date</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="order" value="${t_order}"></c:set>
				<c:forEach items="${t_dtos}" var="dto">
					<tr>
						<td class="t_center"><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getOrder_no()}</a></td>
						<td><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getNow_status()}</a></td>
						<td><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getSerial_no()}</a></td>
						<td><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getConsumer_id()}</a></td>
						<td><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getPrice()}</a></td>
						<td><a href="javascript:goView('${dto.getOrder_no()}')">${dto.getPurchase_date()}</a></td>
					</tr>
				</c:forEach>
				<c:if test="${t_totalCount eq '0'}">
					데이터 없음
				</c:if>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
	
<%@ include file="../common_footer.jsp" %>
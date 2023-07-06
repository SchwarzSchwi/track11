<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goSearch(){
		order.method="post";
		order.action="Order";
		order.submit();
	}
	function goPage(pageNum){
		order.t_nowPage.value = pageNum;
		order.method="post";
		order.action="Order";
		order.submit();
	}
	function goView(order_no){
		workOrder.t_gubun.value="view";
		workOrder.t_no.value = order_no;
		workOrder.method="post";
		workOrder.action="Order";
		workOrder.submit();
	}
</script>
	<form name="workOrder">
		<input type="hidden" name="t_gubun">
		<input type="hidden" name="t_no">
	</form>
		<div id="b_left">
			<%@ include file="../common_menu_member.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				Order
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 거래 수<span> ${t_totalCount} </span>건</p>
			</div>
			<form name="order">
			<input type="hidden" name="t_nowPage">					
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="serial_no" <c:if test="${t_select eq 'serial_no'}"> selected</c:if> >Serial_no</option>
					<option value="now_status" <c:if test="${t_select eq 'now_status'}">selected</c:if> >Now status</option>
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
	</form>
	
	
<%@ include file="../common_footer.jsp" %>
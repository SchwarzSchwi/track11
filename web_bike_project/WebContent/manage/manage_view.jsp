<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
	function goUpdate(){
		workManage.method="post";
		workManage.action="Manage";
		workManage.submit();
	}
</script>
		<div id="b_left">
				<%@ include file="../common_menu_admin.jsp"%>
		</div>
		<div id="b_right">
			<p class="n_title">
				Manage Information
			</p>
			<form name="workManage">
				<input type="hidden" name="t_gubun" value="status">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>Order_no</th>
				  <td>
					<input type="hidden" value="${t_dto.getOrder_no()}" name="t_order_no" class="middleCheck" />${t_dto.getOrder_no()}
				  </td>
				</tr>
				<tr>
				  <th>Now_status</th>
				  <td>${t_dto.getNow_status()}</td>
				</tr>
				<tr>
					<th>->Select</th>
					<td colspan="3">
						<input type="radio" value="주문취소" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '주문취소'}"> checked</c:if>> 주문취소&nbsp;&nbsp;  
						<input type="radio" value="결제확인중" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '결제확인중'}"> checked</c:if>> 결제확인중&nbsp;&nbsp;  
						<input type="radio" value="배송준비중" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송준비중'}"> checked</c:if>> 배송준비중&nbsp;&nbsp;  
						<input type="radio" value="배송중"    name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송중'}"> checked</c:if>> 배송중&nbsp;&nbsp;  
						<input type="radio" value="배송완료"   name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송완료'}"> checked</c:if>> 배송완료
					</td>
					</tr>	
				<tr>
				  <th>Serial_no</th>
				  <td>${t_dto.getSerial_no()}</td>
				</tr>	
				<tr>
				  <th>Consumer_id</th>
				  <td>${t_dto.getConsumer_id()}</td>
				</tr>
				<tr>
				  <th>Name</th>
				  <td>${t_dto.getName()}</td>
				</tr>
				<tr>
				  <th>Payment</th>
				  <td>${t_dto.getPayment()}</td>
				</tr>
				<tr>
				  <th>Price</th>
				  <td>${t_dto.getPrice()}</td>
				</tr>
				<tr>
				  <th>Purchase_date</th>
				  <td>${t_dto.getPurchase_date()}</td>
				</tr>
				<tr>
				  <th>Post_no</th>
				  <td>${t_dto.getPost_no()}</td>
				</tr>
				<tr>
				  <th>Address</th>
				  <td>${t_dto.getAddress()}</td>
				</tr>
				<tr>
				  <th>Detail_address</th>
				  <td>${t_dto.getDetail_address()}</td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup">
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="Manage" class="butt">List</a>
			</c:if>	
			</div>	
	</div>
	
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>
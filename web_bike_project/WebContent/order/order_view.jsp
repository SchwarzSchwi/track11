<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
	function goCancel(){
		if(confirm("주문 취소하시겠습니까?")){
			workManage.method="post";
			workManage.action="Order";
			workManage.submit();
		}	
	}
</script>
		<div id="b_left">
				<%@ include file="../common_menu_member.jsp"%>
		</div>
		<div id="b_right">
			<p class="n_title">
				Order Information
			</p>
			<form name="workManage">
				<input type="hidden" name="t_gubun" value="cancel">
				<input type="hidden" name="t_no" value="${t_dto.getOrder_no()}">
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
			<c:if test="${sessionLevel eq 'member'}">'
			<c:if test="${t_dto.getNow_status() eq '입금확인중' || t_dto.getNow_status() eq '배송준비중'}">
				<a href="javascript:goCancel()" class="butt">Cancel</a>
			</c:if>	
				<a href="Order" class="butt">List</a>
			</c:if>	
			</div>	
	</div>
	
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>
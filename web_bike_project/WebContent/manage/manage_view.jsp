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
function checkID(){
	if(checkValue(workManage.t_now_status,"배송상태 입력 후 변경하시오!")) return;
	
	$.ajax({
		type : "POST",
		url : "ManageStatus",
		data: "t_now_status="+workManage.t_now_status.value+"&t_order_no="+workManage.t_order_no.value,
		dataType : "text",
		error : function(){
			alert('통신실패!!!!!');
		},
		success : function(data){
			
			var result = $.trim(data);
			alert(result);
			workManage.t_statusCheck.value = result;
			
			if(result =="변경성공"){
				workManage.t_statusCheckValue.value = workManage.t_now_status.value;
			}else{
				workManage.t_statusCheckValue.value ="";
			}	
		
		}
	});			
	
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
					<c:if test="${t_dto.getNow_status() ne '주문취소'}">
						<input type="radio" value="주문취소" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '주문취소'}"> checked</c:if>> 주문취소&nbsp;&nbsp;  
					</c:if>	
						<input type="radio" value="입금확인중" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '입금확인중'}"> checked</c:if>> 입금확인중&nbsp;&nbsp;  
						<input type="radio" value="배송준비중" name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송준비중'}"> checked</c:if>> 배송준비중&nbsp;&nbsp;  
						<input type="radio" value="배송중"    name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송중'}"> checked</c:if>> 배송중&nbsp;&nbsp;  
						<input type="radio" value="배송완료"   name="t_now_status"  <c:if test="${t_dto.getNow_status() eq '배송완료'}"> checked</c:if>> 배송완료
						<input type="button" onclick="checkID()" value="주문상태변경" class="checkB">
						<input type="text" name="t_statusCheck" style="border:none" readonly>
						<input type="hidden" name="t_statusCheckValue" >
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
			<c:if test="${sessionLevel eq 'admin'}">
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="Manage" class="butt">List</a>
			</c:if>	
			</div>	
	</div>
	
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>  
<script type="text/javascript">
	function goSave(){
		if(checkValue(product.t_serial_no,"제품번호 입력!")) return;
		if(checkValue(product.t_name,"제품명 입력!")) return;
		if(checkValue(product.t_content,"상세설명 입력!")) return;
		if(checkValue(product.t_priority,"우선순위 선택!!")) return;
		if(checkValue(product.t_huge,"사이즈 선택!")) return;
		if(checkValue(product.t_price,"가격 입력!")) return;
		
		product.method="post";
		product.action="Product?t_gubun=purchase";
		product.submit();
	}
</script>  
<div id="b_left">
	<c:if test="${sessionLevel eq 'admin'}">
		<%@ include file="../common_menu_admin.jsp" %>
	</c:if>
	<c:if test="${sessionLevel eq 'member'}">
		<%@ include file="../common_menu_member.jsp" %>
	</c:if>
	<c:if test="${empty sessionLevel}">
		<%@ include file="../common_menu_member.jsp" %>
	</c:if>
</div>		
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<form name="product" enctype="multipart/form-data">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>주문 번호</th>
						<td colspan="3"><input type="text" name="t_order_no" class="input600"  value=""></td>
					</tr>	
					<tr>
						<th>처리상태</th>
						<td colspan="3"><input type="text" name="t_now_status" class="input600" value="${t_dto.getName()}"></td>
					</tr>	
					<tr>
						<th>제품번호</th>
						<td colspan="3"><input type="text" name="t_product_no" class="input600" value="${t_dto.getSerial_no()}" readonly></td>
					</tr>
					<tr>
						<th>구매자 ID</th>
						<td colspan="3"><input type="text" name="t_consumer_id" class="input600" value="${sessionId}" readonly></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td colspan="3"><input type="text" name="t_post_no" class="input600" value="예) #####"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="3"><input type="text" name="t_address" class="input600" value="예) 동해시 중앙로, 여수 중앙동, 대전 현대아파트"></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td colspan="3"><textarea name="t_detail_address" class="textArea_H250" > 예) 읍/면/동/리 + 지번, 서린동 154-1 / 도로명 + 건물번호, 종로 6</textarea></td>
					</tr>
					<tr>
						<th>지불방법</th>
						<td colspan="3">
							<input type="radio" value="카드" name="t_payment" class="middleCheck" /> 카드&nbsp;&nbsp;  
							<input type="radio" value="무통장입금" name="t_payment" class="middleCheck" /> 무통장입금&nbsp;&nbsp;  
							<input type="radio" value="계좌이체" name="t_payment" class="middleCheck" /> 계좌이체
						</td>
					</tr>	
					<tr>
						<th>가격</th>
						<td colspan="3"><input type="text" name="t_price" class="input600" value="${t_dto.getPrice()}" readonly></td>
					</tr>	
					<tr>
						<th>구매일자</th>
						<td colspan="3">${t_todayTime}</td>
					</tr>
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
			<c:if test="${sessionLevel eq 'member'}">
				<a href="javascript:goSave()" class="butt">Purchase</a>
			</c:if> 
				<a href="Product" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="../common_footer.jsp" %>	
</body>
</html>




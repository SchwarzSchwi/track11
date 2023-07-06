<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>  
<script type="text/javascript">
	function goSave(){
	if(checkValue(product.t_payment,"결제수단 입력!")) return;
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
			<form name="product">
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
						<th>제품번호</th>
						<td>${t_dto.getSerial_no()}</td>
					</tr>
					<tr>
						<th>구매자 ID</th>
						<td>${sessionId}</td>
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
						<td colspan="3"><input type="text" name="t_detail_address" class="input600" value="예) 읍/면/동/리 + 지번, 서린동 154-1 / 도로명 + 건물번호, 종로 6"></td>
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
						<td>${t_dto.getPrice()}</td>
					</tr>	
					<tr>
						<th>구매일자</th>
						<td>${t_todayTime}</td>
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




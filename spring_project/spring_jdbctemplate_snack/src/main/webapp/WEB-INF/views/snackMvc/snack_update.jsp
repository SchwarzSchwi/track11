<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdate(){
			if(snack.t_p_name.value ==""){
				alert("제품명입력!");
				snack.t_p_name.focus();
				return;
			}
			if(snack.t_ori_price.value ==""){
				alert("가격입력!");
				snack.t_ori_price.focus();
				return;
			}
			
			var price = snack.t_ori_price.value; //"1,250"
			var newPrice = price.replaceAll(",","");
			newPrice = newPrice.trim();
			
			
			snack.t_price.value = newPrice;
			snack.t_gubun.value = "snackUpdate";
			snack.method="post";
			snack.action="Snack";
			//snack.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 최선우 SNACK</h1>
		</div>		
		<div class="write_wrap">
			<form name="snack">
			<input type="hidden" name="t_price">
			<input type="hidden" name="t_p_code" value="${t_dto.getP_code()}">
			<input type="hidden" name="t_gubun">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>제품번호</th>
							<td class="th_left">
								<input name="t_p_code" value="${t_dto.getP_code()}" class="input_300px" type="text" readonly>
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name" value="${t_dto.getP_name()}" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<input name="t_ori_price" value="${t_dto.getStrPrice()}" class="input_100px" style="text-align:right" type="text">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code"  class="select">
									<c:forEach items="${t_dtos}" var="dto">
										<option value="${dto.getM_code()}" <c:if test="${dto.getM_code() eq t_dto.getM_code()}">selected</c:if>>${dto.getM_name()}</option>
									</c:forEach>
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='Snack'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>




















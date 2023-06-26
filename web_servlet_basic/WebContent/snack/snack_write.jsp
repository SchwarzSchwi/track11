<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,java.util.*" %>    
<%
	SnackDao dao = new SnackDao();
	ArrayList<SnackDto> dtos = dao.getCompanyList();
%>    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">
		function goSave(){
			var p_code = mem.t_p_code.value;
			if(p_code == ""){
				alert("제품코드 입력!");
				mem.t_p_code.focus();
				return;
			}
			
			if(mem.t_p_name.value == ""){
				alert("제품명입력!");
				mem.t__p_name.focus();
				return;
			}
			
			if(mem.t_price.value == ""){
				alert("가격입력!");
				mem.t_price.focus();
				return;
				
			}
			if(mem.t_m_code.value == ""){
				alert("제조사 입력!");
				mem.t_m_code.focus();
				return;
				
			}
			mem.t_gubun.value="snackSave";
			mem.method="post";
			mem.action="Snack";
//			mem.action="DBSnackSave";
			mem.submit();
		
		}	
	</script>
	<style>
		.inputRight{
			text-align:right;
		}
	</style>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 최선우 SNACK</h1>
		</div>		
		<div class="write_wrap">
			<form name="mem">
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
								<input name="t_p_code"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name"  class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<input name="t_price"  class="input_100px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code" class="select">
									<% for(int k=0; k<dtos.size(); k++){ %>
									<option value="<%=dtos.get(k).getM_code()%>"><%=dtos.get(k).getM_name()%></option>
									<% } %>
									
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" onclick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Snack'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>




















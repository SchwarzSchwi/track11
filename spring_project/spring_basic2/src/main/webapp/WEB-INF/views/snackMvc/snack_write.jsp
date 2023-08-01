<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >
	<script type="text/javascript" src="js/common.js"></script>			
	<script type="text/javascript">
	function goSave(){
		if(checkValue(mem.t_p_code,"제품번호입력!"))return;
		if(checkValue(mem.t_p_name,"제품명입력!"))return;
		if(checkValue(mem.t_price,"가격입력!"))return;
		if(checkValue(mem.t_m_name,"제조사입력!"))return;
		mem.t_gubun.value="snackSave";
		mem.method="post";
		mem.action="Snack";
		mem.submit();
	}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 최선우 SNACK</h1>
		</div>		
		<div class="write_wrap">
			<form name="mem">
			<input type="hidden"  name="t_gubun">
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
								<input name="t_price"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_name" class="select">
								
									<option value="10">롯데</option>
									<option value="20">해태</option>
									<option value="30">농심</option>
									<option value="40">크라운</option>
									<option value="50">오리온</option>
									
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onclick="goSave()" value="등록" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Snack'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>




















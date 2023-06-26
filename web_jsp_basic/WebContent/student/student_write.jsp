<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우 성적관리</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">
		function goSave(){
			
			
//			var test = "팔십"
//			var tf = isNaN(test)
//			alert(tf);
			
			if(stu.t_syear.value == ""){
				alert("학년 선택하시오");
				return;
			}
			if(stu.t_sno.value ==""){
				alert("번호 입력!");
				stu.t_sno.focus();
				return;
			}
			if(stu.t_name.value ==""){
				alert("성명 입력!");
				stu.name.focus();
				return;
			}
			if(stu.t_kor.value ==""){
				alert("국어 입력!");
				stu.t_kor.focus();
				return;
			}else{
				if(isNaN(stu.t_kor.value)){
					alert("정수 점수가 아닙니다")
					stu.t_kor.focus();
					return;
				}else{
					if(stu.t_kor.value > 100 || stu.t_kor.value < 0){
						alert("점수 0~100 사이");
						stu.t_kor.focus();
						return;
					}
				}
			}
			if(stu.t_eng.value ==""){
				alert("영어 입력!");
				stu.t_eng.focus();
				return;
			}else{
				if(isNaN(stu.t_eng.value)){
					alert("정수 점수가 아닙니다")
					stu.t_eng.focus();
					return;
				}else{
					if(stu.t_eng.value > 100 || stu.t_eng.value < 0){
						alert("점수 0~100 사이");
						stu.t_eng.focus();
						return;
					}
				}
			}
			if(stu.t_mat.value ==""){
				alert("수학 입력!");
				stu.t_mat.focus();
				return;
			}else{
				if(isNaN(stu.t_mat.value)){
					alert("정수 점수가 아닙니다")
					stu.t_mat.focus();
					return;
				}else{
					if(stu.t_mat.value > 100 || stu.t_mat.value < 0){
						alert("점수 0~100 사이");
						stu.t_mat.focus();
						return;
					}
				}
			}
			stu.method="post";
			stu.action="db_student_save.jsp";
			stu.submit();
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
			<img src="../images/jsl_logo.png"><h1>TRACK11 최선우 성적관리</h1>
		</div>		
		<div class="write_wrap">
			<form name="stu">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>학년</th>
							<td class="th_left">
								<input type="radio" name="t_syear" value="1" >1학년&nbsp;&nbsp;
								<input type="radio" name="t_syear" value="2" >2학년&nbsp;&nbsp;
								<input type="radio" name="t_syear" value="3" >3학년	
															
							</td>
						</tr>
						<tr>
							<th>반</th>
							<td class="th_left">
								<select name="t_sclass" class="select" style="width:80px;height:32px">
								
									<option value="1">1반</option>
									<option value="2">2반</option>
									<option value="3">3반</option>
									<option value="4">4반</option>
									<option value="5">5반</option>
									
								</select>								
							</td>
						</tr>
						<tr>
							<th>번호</th>
							<td class="th_left">
								<input name="t_sno"  class="input_100px" type="text" >
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name"  class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>국어</th>
							<td class="th_left">
								<input value=0 name="t_kor"  class="input_100px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>영어</th>
							<td class="th_left">
								<input value=0 name="t_eng"  class="input_100px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>수학</th>
							<td class="th_left">
								<input value=0 name="t_mat"  class="input_100px inputRight" type="text">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" onclick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='student_list.jsp'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>




















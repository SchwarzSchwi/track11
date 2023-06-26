<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*"%>
<%
	StudentDao dao = new StudentDao();
	String syear   = request.getParameter("t_syear");
	String sclass  = request.getParameter("t_sclass");
	String sno     = request.getParameter("t_sno");
	
	StudentDto dto = dao.getStudentView(syear, sclass, sno);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function changeValue(){		
			var kor = stu.t_kor.value;
			var eng = stu.t_eng.value;
			var mat = stu.t_mat.value;
			
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
			
			var total = Number(kor) + Number(eng) + Number(mat);
			stu.t_total.value = total;
			var ave = total / 3;
			var ave = ave.toFixed(2);
			stu.t_ave.value = ave;		
		}
		function goUpdate(){
			if(stu.t_name.value ==""){
				alert("성명입력");
				stu.t_name.focus();
				return;
			}
			stu.method="post";
			stu.action="db_student_update.jsp";
			stu.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 최선우</h1>
		</div>		
		<div class="write_wrap">
		<form name="stu">
		<input type="hidden" name="t_syear" value="<%=syear%>">
		<input type="hidden" name="t_sclass" value="<%=sclass%>">
		<input type="hidden" name="t_sno" value="<%=sno%>">
		
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
								<%=dto.getSyear()%> 학년
							</td>
						</tr>
						<tr>
							<th>반</th>
							<td class="th_left">
								<%=dto.getSclass()%> 반
							</td>
						</tr>
						<tr>
							<th>번호</th>
							<td class="th_left">
								<%=dto.getSno()%> 번
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input style="text-align:right" name="t_name" value="<%=dto.getName()%>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>국어</th>
							<td class="th_left">
								<input style="text-align:right" name="t_kor" onchange="changeValue()" value="<%=dto.getKor()%>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>영어</th>
							<td class="th_left">
								<input style="text-align:right" name="t_eng" onchange="changeValue()" value="<%=dto.getEng()%>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>수학</th>
							<td class="th_left">
								<input style="text-align:right" name="t_mat" onchange="changeValue()" value="<%=dto.getMat()%>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>총점</th>
							<td class="th_left">
								<input style="border:0;text-align:right;" name="t_total" value="<%=dto.getTotal()%>" readonly class="input_100px" type="text" >
							</td>
						</tr>
						<tr>
							<th>평균</th>
							<td class="th_left">
								<input style="border:0;text-align:right;" name="t_ave" value="<%=dto.getAve()%>" readonly class="input_100px" type="text">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="student_list.jsp" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>





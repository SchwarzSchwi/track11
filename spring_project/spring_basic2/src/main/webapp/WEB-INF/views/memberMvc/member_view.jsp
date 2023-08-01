<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 최선우</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdateForm(id){
			view.t_gubun.value="memberUpdateForm";
			view.method="post";
			view.action="Member";
			view.submit();
		}
		function goDelete(){
			if(confirm("삭제?")){
				view.t_gubun.value="memberDelete";
				view.method="post";
				view.action="Member";
				view.submit();
			}
		}
	</script>
</head>
<body>
<form name="view">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_id" value="${t_dto.getId()}">
</form>
	<div class="container">
	
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 최선우 회원관리</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td class="th_left">
								${t_dto.getId()}
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								${t_dto.getName()}
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								${t_dto.getAge()}
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								${t_dto.getReg_date()}
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onclick="goList()" value="목록" class="btn_list">
			    <input type="button" onClick="goUpdateForm('${t_dto.getId()}')" value="수정" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>




















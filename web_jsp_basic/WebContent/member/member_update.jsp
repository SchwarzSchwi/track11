<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*, dao.*" %>    
<%
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	MemberDto dto = dao.getMemberView(id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 홍길동</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdate(){
			alert("1");
			if(mem.t_name.value ==""){
				alert("성명입력!");
				mem.t_name.focus();
				return;
			}
			if(mem.t_reg_date.value ==""){
				alert("가입일입력!");
				mem.t_reg_date.focus();
				return;
			}
			mem.method="post";
			mem.action="db_member_update.jsp";
			mem.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 최선우 회원관리</h1>
		</div>		
		<div class="write_wrap">
		<form name="mem">
		<input type="hidden" name="t_id" value="<%=dto.getId()%>">
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
								<%=dto.getId()%>
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name" value="<%=dto.getName()%>" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age" value="<%=dto.getAge()%>" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<input name="t_reg_date" value="<%=dto.getReg_date()%>" class="input_200px" type="date">							
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='member_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















    
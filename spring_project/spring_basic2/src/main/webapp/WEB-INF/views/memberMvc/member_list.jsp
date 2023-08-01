<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 최선우
	******************************************** 
 -->	
	<title>TRACK11 최선우</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goSearch(){
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
		function goView(id){
			view.t_gubun.value="memberView";
			view.t_id.value=id;
			view.method="post";
			view.action="Member";
			view.submit();
		}
		function goWriteForm(){
			view.t_gubun.value="writeForm";
			view.method="post";
			view.action="Member";
			view.submit();
		}
	</script>
</head>
<body>
<form name="view">
	<input type="hidden" name="t_id">
	<input type="hidden" name="t_gubun">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 최선우 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span>${t_dtos.size()}</span>명</p>
			</div>
			<form name="mem">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="id" <c:if test="${t_select eq 'id'}">selected</c:if>>id</option>
					<option value="name"<c:if test="${t_select eq 'name'}">selected</c:if>>name</option>
				</select>
				<input name="t_search" type="text" value="${t_search}" class="search_word">
				<button onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
					<th>나이</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${t_dtos}" var="dto"> 
				<tr>
					<td><a href="memberView?t_id=${dto.getId()}">${dto.getId()}</a></td>
					<td><a href="javascript:goView('${dto.getId()}')">${dto.getName()}</a></td>
					<td>${dto.getAge()}</td>
					<td>${dto.getReg_date()}</td>
				</tr>	
			</c:forEach>
			</tbody>
			
		</table>
		<div class="paging">
			<a href="javascript:goWriteForm()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>








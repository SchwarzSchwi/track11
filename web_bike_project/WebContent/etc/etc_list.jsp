<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
 
<script type="text/javascript">
	
	function goSearch(){
		et.method="post";
		et.action="Etc";
		et.submit();
	}
	function goPage(pageNumber){
		et.t_nowPage.value = pageNumber;
		et.method="post";
		et.action="Etc";
		et.submit();
	}
	function goWrite(){
		if(confirm("댓글 다시겠습니까?")){
			et.t_gubun.value ="reply";
			et.method="post";
			et.action="Etc";
			et.submit();
		}
	}
</script>
<form name="etc">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>
<div id="b_left">
			<%@ include file="../common_menu.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				ETC
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="et">	
			<input type="hidden" name="t_gubun">
			<input type="hidden" name="t_nowPage">	
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if>>Title</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			<table class="boardList">
				<colgroup>
					<col width="60%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>Title</th>
						<th>Regdate</th>
						<th>Regid</th>
					</tr>
				</thead>
				<tbody>
				
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_dtos}" var="dto">
					<tr>
						<td class="t_left">${dto.getTitle()}</td>
						<td>${dto.getRegdate()}</td>
						<td>${dto.getRegid()}
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			<c:if test="${sessionLevel=='member' || sessionLevel=='admin'}">
				<tr>
					<td colspan="2">
						<input type="text" name="t_reply">
					</td>	
					
					<td>
						<button type="button" onclick="goWrite()" class="sel_button"><i class="fa-solid fa-pen"></i>write</button>
					</td>	
				</tr>	
			</c:if>		
			</form>
			
			<div class="paging">
				${t_paging}
<!-- 			
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
-->				
 				
			</div>
		</div>	
	</div>
<%@ include file="../common_footer.jsp"%>	
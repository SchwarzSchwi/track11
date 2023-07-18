<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
 
<script type="text/javascript">
	
	function goSearch(){
		fb.method="post";
		fb.action="Freeboard";
		fb.submit();
	}
	function goPage(pageNumber){
		fb.t_nowPage.value = pageNumber;
		fb.method="post";
		fb.action="Freeboard";
		fb.submit();
	}
	function goWriteForm(){
		freeboard.t_gubun.value="writeForm";
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}
	function goView(no){
		freeboard.t_gubun.value="view";
		freeboard.t_no.value = no;
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();	
	}
</script>
<form name="freeboard">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>
<div id="b_left">
			<%@ include file="../common_menu.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				Freeboard
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="fb">	
			<input type="hidden" name="t_nowPage">	
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.title" <c:if test="${t_select eq 'title'}">selected</c:if>>Title</option>
					<option value="n.content"  <c:if test="${t_select eq 'content'}">selected</c:if>>Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="6%">
					<col width="10%">
                    <col width="30%">
					<col width="24%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Attach</th>
						<th>Title</th>
						<th>Reg_date</th>
						<th>Name</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
				
				<c:set var="number" value="${t_order}"></c:set>
				<c:forEach items="${t_dtos}" var="dto">
					<tr>
						<td>
							${number}
							<c:set var="number" value="${number-1}"></c:set>
						</td>
						<td>
						<c:if test="${not empty dto.getAttach()}">						
							<img src="images/clip.png">
						</c:if>
						</td>
						<td class="t_left"><a href="javascript:goView('${dto.getNo()}')">${dto.getTitle()}</a></td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getName()}
						<td>${dto.getHit()}</td>
					</tr>	
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
				<c:if test="${sessionLevel eq 'member' || sessionLevel eq 'admin'}">
				<a href="javascript:goWriteForm()" class="write">글쓰기</a>
				</c:if>			
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
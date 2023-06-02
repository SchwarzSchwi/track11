<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %> 
<script type="text/javascript">
	function goSearch(){
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	function goPage(pageNumber){
		noti.t_nowPage.value = pageNumber;
		noti.method="post";
		noti.action="Notice";
		noti.submit();
	}
	function goWriteForm(){
		notice.t_gubun.value="writeForm";
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}
</script>
<form name="notice">
	<input type="hidden" name="t_gubun">
</form>
<div id="b_left">
			<%@ include file="../common_menu.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="noti">	
			<input type="hidden" name="t_nowPage">	
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.title" <c:if test="${t_select eq 'n.title'}">selected</c:if>>Title</option>
					<option value="n.content"  <c:if test="${t_select eq 'n.content'}">selected</c:if>>Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="60%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
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
						<td class="t_left"><a href="notice_view.html">${dto.getTitle()}</a></td>
						<td>
							<c:if test="${not empty dto.getAttach()}">						
								<img src="images/clip.png">
							</c:if>
						</td>	
						<td>${dto.getReg_name()}</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getHit()}</td>
					</tr>	
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}==$ 
				<c:if test="${sessionLevel eq 'admin'}">
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
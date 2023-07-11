<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %> 
<script type="text/javascript">
	
	function goSearch(){
		qa.method="post";
		qa.action="Qna";
		qa.submit();
	}
	function goPage(pageNumber){
		qa.t_nowPage.value = pageNumber;
		qa.method="post";
		qa.action="Qna";
		qa.submit();
	}
	function goWriteForm(){
		qna.t_gubun.value="writeForm";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
	function goView(no){
		qna.t_gubun.value="view";
		qna.t_no.value = no;
		qna.method="post";
		qna.action="Qna";
		qna.submit();	
	}
</script>
<form name="qna">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_no">
</form>
<div id="b_left">
			<%@ include file="../common_menu.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QNA
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span>${t_totalCount}</span>건</p>
			</div>	
			<form name="qa">	
			<input type="hidden" name="t_nowPage">	
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="n.q_title" <c:if test="${t_select eq 'q_title'}">selected</c:if>>Title</option>
					<option value="n.q_content"  <c:if test="${t_select eq 'q_content'}">selected</c:if>>Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="6%">
                    <col width="40%">
					<col width="24%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Q_title</th>
						<th>Q_date</th>
						<th>Q_name</th>
						<th>Answer</th>
						<th>Views</th>
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
						<td class="t_left"><a href="javascript:goView('${dto.getNo()}')">${dto.getQ_title()}</a></td>
						<td>${dto.getQ_date()}</td>
						<td>${dto.getName()}
						<td>
							<c:if test="${dto.getA_title() ne null}">답변완료</c:if>
							<c:if test="${dto.getA_title() eq null}">답변대기</c:if>
						</td>
						<td>${dto.getViews()}</td>
					</tr>	
				</c:forEach>	
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
				<c:if test="${sessionLevel eq 'member'}">
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
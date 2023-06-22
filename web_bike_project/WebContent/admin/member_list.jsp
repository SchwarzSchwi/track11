<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
	function goSearch(){
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
	function goPage(pageNum){
		admin.t_nowPage.value = pageNum;
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
	function goView(id){
		workAdmin.t_gubun.value="view";
		workAdmin.t_id.value=id;
		workAdmin.method="post";
		workAdmin.action="Admin";
		workAdmin.submit();
	}
</script>
	<form name="workAdmin">
		<input type="hidden" name="t_gubun">
		<input type="hidden" name="t_id">
	</form>
	
		<div id="b_left">
			<%@ include file="../common_menu_admin.jsp"%>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 회원수<span> ${t_totalCount} </span>명</p>
			</div>
			<form name="admin">
			<input type="hidden" name="t_nowPage">					
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="id" <c:if test="${t_select eq 'id'}"> selected</c:if> >ID</option>
					<option value="name" <c:if test="${t_select eq 'name'}">selected</c:if> >Name</option>
					<option value="mobile_3" <c:if test="${t_select eq 'mobile_3'}">selected</c:if> >Mobile</option>
				</select>
				<select name="t_displayCount" class="sel_box">
					<option value="5" <c:if test="${t_displayCount eq '5'}"> selected</c:if> >5명</option>
					<option value="10" <c:if test="${t_displayCount eq '10'}"> selected</c:if> >10명</option>
					<option value="20" <c:if test="${t_displayCount eq '20'}"> selected</c:if> >20명</option>
					<option value="50" <c:if test="${t_displayCount eq '50'}"> selected</c:if> >50명</option>
				</select>
				<input type="text" name="t_search" value="${t_search}" class="sel_text">

				<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			</form>			
			
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="20%">
					<col width="15%">
					<col width="25%">
					<col width="5%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Id</th>
						<th>Name</th>
						<th>Area</th>
						<th>연락처</th>
						<th>가입일자</th>
						<th>로그인 정보</th>
						<th>탈퇴여부</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="order" value="${t_order}"></c:set>
				<c:forEach items="${t_dtos}" var="dto">
					<tr>
						<td>
							${order}
							<c:set var="order" value="${order -1}"></c:set>
						</td>
						<td class="t_center"><a href="javascript:goView('${dto.getId()}')">${dto.getId()}</a></td>
						<td>${dto.getName()}</td>
						<td>${dto.getArea()}</td>
						<td>${dto.getMobile_1()}-${dto.getMobile_2()}-${dto.getMobile_3()}</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getLast_login_date()}</td>
						<td>
							<c:if test="${not empty dto.getExit_date()}">
								탈퇴
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${t_totalCount eq '0'}">
					데이터 없음
				</c:if>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging}
			</div>
		</div>	
	</div>
	
<%@ include file="../common_footer.jsp" %>
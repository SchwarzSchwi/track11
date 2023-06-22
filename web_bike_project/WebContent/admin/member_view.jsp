<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
		<div id="b_left">
				<%@ include file="../common_menu_admin.jsp"%>
		</div>
		<div id="b_right">
			<p class="n_title">
				MEMBER Information
			</p>
				<input type="hidden" name="t_gubun">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					${t_dto.getId()}
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName()}</td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>${t_dto.getArea()}</td>
				</tr>	
				<tr>
				  <th>주소</th>
				  <td>${t_dto.getAddress()}</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>${t_dto.getMobile_1()}-
				  	  ${t_dto.getMobile_2()}-
					  ${t_dto.getMobile_3()}				
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
				  <c:if test="${t_dto.getGender() eq 'f'}">여성</c:if>
				  <c:if test="${t_dto.getGender() eq 'm'}">남성</c:if>	 
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
				  <c:if test="${t_dto.getHobby_travel() eq 'y'}">여행</c:if>
				  <c:if test="${t_dto.getHobby_reading() eq 'y'}">독서</c:if>
				  <c:if test="${t_dto.getHobby_sports() eq 'y'}">운동</c:if>	
				  </td>
				</tr>
				<tr>
				  <th>회원가입일</th>
				  <td>
				  ${t_dto.getReg_date()}
				  </td>
				</tr>
				<tr>
				  <th>최근로그인</th>
				  <td>
				  ${t_dto.getLast_login_date()}
				  </td>
				</tr>
				<tr>
				  <th>탈퇴 일자</th>
				  <td>
				  ${t_dto.getExit_date()}
				  </td>
				</tr>
			  </tbody>
			</table>
	</div>
	
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>
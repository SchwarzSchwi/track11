<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
	function goUpdateForm(){
		bike.t_gubun.value="memberUpdateForm";
		bike.method="post";
		bike.action="Member";
		bike.submit();
	}	
</script>
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="javascript:goWork('memberPasswordFind')">ID / PASSWORD</a></li>
				<li><a href=""><span class="fnt"><i class="fas fa-apple-alt"></i></span> MEMBER</a></li>
			</ul>
		</div>
		<div id="b_right">
			<p class="n_title">
				MEMBER Information
			</p>
			<form name="mem">
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
				  <th>비밀번호</th>
				  <td>
				  <c:forEach begin="1" end="${t_dto.getPassword_len()}">*</c:forEach>
				  </td>
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
				  <th>정보수정일</th>
				  <td>
				  ${t_dto.getUpdate_date()}
				  </td>
				</tr>
				<tr>
				  <th>최근로그인</th>
				  <td>
				  ${t_dto.getLast_login_date()}
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
		<div class="buttonGroup_center">
			<a href="javascript:goUpdateForm()" class="butt">정보수정</a>
			<a href="javascript:goExit()" class="butt">회원탈퇴</a>
		</div>	
	</div>
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>







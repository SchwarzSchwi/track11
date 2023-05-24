<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script type="text/javascript">
function goUpdate(){
	

	if(checkValue(mem.t_name,"성명입력!"))return;
	if(checkValue(mem.t_pw_confirm,"비밀번호확인입력!"))return;
	
	
/*	
	if(mem.t_pw_1.value != mem.t_pw_2.value){
		alert("비밀번호 일치 확인바람")
		mem.t_pw_2.focus();
		return;
	}
*/
	if(checkValue(mem.t_address,"주소입력!"))return;
	if(checkValue(mem.t_mobile_1,"연락처입력!"))return;
	if(checkValue(mem.t_mobile_2,"연락처입력!"))return;
	if(checkValue(mem.t_mobile_3,"연락처입력!"))return;
//	if(checkValue(mem.t_gender,"남녀구분입력!"))return;

	checkPassword();
	
	if(mem.t_password_check.value =="no"){
		alert("비밀번호를 확인하세요!");
		mem.t_pw_confirm.focus();
		return;
	}

	mem.t_gubun.value="memberUpdate";
	mem.method="post";
	mem.action="Member";
	mem.submit();
}
/*
	if(mem.t_id.value == ""){
		alert("id입력!")
		mem.t_id.fucus();
		return;
	}
}	
*/
function checkPassword(){
	$.ajax({
		type : "POST",
		url : "MemberCheckPassword",
		async : false,
		data: "t_id="+mem.t_id.value+"&t_pw="+mem.t_pw_confirm.value,
		dataType : "text",
		error : function(){
			alert('통신실패!!!!!');
		},
		success : function(data){
			var result = $.trim(data);
			mem.t_password_check.value = result;
//			alert(data);
		}
	});	
}	


</script>
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goWork('memberLogin')">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a ><span class="fnt"><i class="fas fa-apple-alt"></i></span> MEMBER</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER UPDATE
			</p>
			<form name="mem">
				<input type="hidden" name="t_gubun">
				<input type="hidden" name="t_id" value="${t_dto.getId()}">
				<input type="hidden" name="t_password_check">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId()}</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text"  name="t_name" value="${t_dto.getName()}" size="8" id="nana"></td>
				</tr>
				
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${t_dto.getArea() eq '서울'}">selected</c:if>>서울</option>
						<option value="대전" <c:if test="${t_dto.getArea() eq '대전'}">selected</c:if>>대전</option>
						<option value="부산" <c:if test="${t_dto.getArea() eq '부산'}">selected</c:if>>부산</option>
						<option value="대구" <c:if test="${t_dto.getArea() eq '대구'}">selected</c:if>>대구</option>
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" value="${t_dto.getAddress()}"name="t_address" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" name = "t_mobile_1" value="${t_dto.getMobile_1()}"size="2"> -
					<input type="text" name = "t_mobile_2" value="${t_dto.getMobile_2()}"size="3"> -
					<input type="text" name = "t_mobile_3" value="${t_dto.getMobile_3()}"size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" <c:if test="${t_dto.getGender() eq 'f'}">checked</c:if> name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" <c:if test="${t_dto.getGender() eq 'm'}">checked</c:if> name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_travel() eq 'y'}">checked</c:if> name="t_hobby_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_reading() eq 'y'}">checked</c:if>name="t_hobby_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" <c:if test="${t_dto.getHobby_sports() eq 'y'}">checked</c:if> name="t_hobby_sports" class="middleCheck" /> 운동
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
				<tr>
				  <th>비밀번호 확인</th>
				  <td><input type="text" name="t_pw_confirm" size="13"></td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goUpdate()" class="butt">UPDATE</a>
			</div>	
		</div>	
	</div>
	
<%@ include file="../common_footer.jsp" %>	
	
</body>
</html>







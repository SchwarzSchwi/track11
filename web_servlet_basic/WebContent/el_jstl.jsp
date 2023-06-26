<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<% 
//	String name = (String)request.getAttribute("t_name");
//	jstl
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>

</script>
</head>
<body>
=============================== el 표현 ===============================<br>
성명 : ${t_name}<br>
나이 : ${t_age}<br>
arr 사이즈 : ${t_arr.size()}<br>
arr 첫번째 : ${t_arr[0]}<br>
arr 두번째 : ${t_arr[1]}<br>
arr 세번째 : ${t_arr[2]}<br>
arr 네번째 : ${t_arr[3]}<br>

=============================== jstl 표현 =============================<br>
<c:if test="${t_name =='홍길동'}">
	1. 홍길동이다<br>
</c:if>
<c:if test="${t_name eq '홍길동'}">
	2. 홍길동이다<br>
</c:if>
<c:if test="${t_name != '홍길동44'}">
	3. 홍길동 아니다<br>
</c:if>
<c:if test="${t_name ne '홍길동44'}">
	4. 홍길동 아니다<br>
</c:if>
<c:if test="${t_age == 25}">
	5. 25와 같다<br>
</c:if>
<c:if test="${t_age != 25 }">
	6. 25와 같지않다<br>
</c:if>
<c:if test="${t_age > 20 }">
	7. 20보다 크다<br>
</c:if>
<c:if test="${t_age >= 25}">
	8. 25보다 크거나 같다<br>
</c:if>	

<c:if test="${t_name eq '홍길동' && t_age >20}">
	9. 홍길동이고 그리고 20보다 크다.<br>
</c:if>
<c:if test="${t_name eq '홍길동' and t_age >20}">
	10. 홍길동이고 그리고 20보다 크다.<br>
</c:if>
<c:if test="${t_name eq '홍길동' || t_age >30}">
	11. 홍길동이고 또는 30보다 크다.<br>
</c:if>
<c:if test="${t_name eq '홍길동' or t_age >30}">
	12. 홍길동이고 또는 30보다 크다.<br>
</c:if>

============ jstl 표현 if else======================<br>

<c:choose>
	<c:when test="${t_age > 40}">choose 40이상<br></c:when>
	<c:when test="${t_age > 30}">choose 30이상<br></c:when>
	<c:when test="${t_age > 20}">choose 20이상<br></c:when>
	<c:otherwise>나머지 모든 경우</c:otherwise>
</c:choose>
<br>
============ jstl 표현 반복 for ======================<br>
<c:forEach items="${t_arr}" var="area">
	${area}<br>
</c:forEach>
<c:forEach items="${t_dtos}" var="dto">
	${dto.getName()}${dto.getArea()}${dto.getAge()}
	<br>
</c:forEach>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중</title>
</head>
<body>

<c:set var="t_msg" value="${t_msg }"></c:set>
<c:if test="${empty t_msg }"><c:set var="t_msg" value="잘못된 접근입니다"></c:set></c:if>
<c:set var="t_url" value="${t_url }"></c:set>
<c:if test="${empty t_url }"><c:set var="t_url" value="Index"></c:set></c:if>
<c:set var="t_nextPage" value="${t_nextPage }"></c:set>
<c:if test="${empty t_nextPage }"><c:set var="t_nextPage" value="list"></c:set></c:if>

<form name="t_alert">
	<input type="hidden" name="t_requestPage" value="${t_nextPage }">
	
</form>
<script>
	alert("${t_msg}");
	t_alert.method="post";
	t_alert.action="${t_url}";
	t_alert.submit();
	
</script>
</body>
</html>
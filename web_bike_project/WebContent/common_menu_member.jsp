<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<p>ORDER</p>
<ul>
	<li><a href="Product"><c:if test="${t_nowPage eq 'product'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span> </c:if>PRODUCT</a></li>
	<li><a href="Order"><c:if test="${t_nowPage eq 'order'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span> </c:if>ORDER</a></li>
</ul>
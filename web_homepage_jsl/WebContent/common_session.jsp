<%@ page pageEncoding="UTF-8"%>
<%
	String sessionId    = (String)session.getAttribute("sessionId");
	String sessionName  = (String)session.getAttribute("sessionName");
	String sessionLevel = (String)session.getAttribute("sessionLevel");

	if(sessionId == null)    sessionId ="";
	if(sessionName == null)  sessionName ="";
	if(sessionLevel == null) sessionLevel ="";	
%>
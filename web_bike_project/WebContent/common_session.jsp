<%@ page pageEncoding="UTF-8"%>
<%
	String sId    = (String)session.getAttribute("sId");
	String sessionName  = (String)session.getAttribute("sessionName");
	int sLevel = (int)session.getAttribute("sLevel");

	if(sId == null)    sId ="";
	if(sessionName == null)  sessionName ="";
	if(sLevel == 0) sLevel = 0;	
%>
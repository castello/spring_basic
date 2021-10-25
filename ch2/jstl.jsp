<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>JSTL</title>
</head>
<body>
<c:set var="to"   value="10"/>
<c:set var="arr"  value="10,20,30,40,50,60,70"/> 
<c:forEach var="i" begin="1" end="${to}">
	${i}
</c:forEach>
<br>
<c:if test="${not empty arr}">
	<c:forEach var="elem" items="${arr}" varStatus="status">
		${status.count}. arr[${status.index}]=${elem}<BR>
	</c:forEach>
</c:if>	
<c:if test="${param.msg != null}">
	msg=${param.msg} 
	msg=<c:out value="${param.msg}"/>
</c:if>
<br>
<c:if test="${param.msg == null}">메시지가 없습니다.<br></c:if>
<c:set var="age" value="${param.age}"/>
<c:choose>
	<c:when test="${age >= 19}">성인입니다.</c:when>
	<c:when test="${0 <= age && age < 19}">성인이 아닙니다.</c:when>
	<c:otherwise>값이 유효하지 않습니다.</c:otherwise>
</c:choose>
<br>
<c:set var="now" value="<%=new java.util.Date() %>"/>
Server time is <fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd HH:mm:ss"/>	
</body>
</html>
	
	

<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error.jsp</title>
</head>
<body>
<h1>예외가 발생했습니다.</h1>
발생한 예외 : ${ex}<br>
예외 메시지 : ${ex.message}<br>
<ol>
<c:forEach items="${ex.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>



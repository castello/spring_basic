<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2.*" %>
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "남궁성");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
person.getCar().getColor()=${person.getCar().getColor()} <br>
person.getCar().getColor()=${person.car.color} <br>    
name=<%=request.getAttribute("name")%> <br>   
name=${requestScope.name} <br>
name=${name} <br>
id=<%=request.getParameter("id")%> <br>
id=${pageContext.request.getParameter("id")} <br>
id=${param.id} <br>
"1"+1 = ${"1"+1} <br>
"1"+="1" = ${"1"+="1"} <br>
"2">1 = ${"2">1} <br>   
null = ${null}<br>
null+1 = ${null+1} <br>
null+null = ${null+null} <br>
"" + null = ${""+null} <br>   
""-1 = ${""-1} <br> 
empty null=${empty null} <br>
empty list=${empty list} <br>
null==0 = ${null==0} <br>
null eq 0 = ${null eq 0} <br>
name == "남궁성"=${name=="남궁성"} <br>
name != "남궁성"=${name!="남궁성"} <br>
name eq "남궁성"=${name eq "남궁성"} <br>  
name ne "남궁성"=${name ne "남궁성"} <br>  
name.equals("남궁성")=${name.equals("남궁성")} <br>   
</body>
</html>

[실행결과]
person.getCar().getColor()=red
person.getCar().getColor()=red
person.car.color=red
name=남궁성
name=남궁성
name=남궁성
id=asdf
id=asdf
id=asdf
"1"+1 = 2
"1"+="1" = 11
"2">1 = true
null =
null+1 = 1
null+null = 0
"" + null = 0
""-1 = -1
empty null=true
empty list=true
null==0 = false
null eq 0 = false
name == "남궁성"=true
name != "남궁성"=false
name eq "남궁성"=true
name ne "남궁성"=false
name.equals("남궁성")=true

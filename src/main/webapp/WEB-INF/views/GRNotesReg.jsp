<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to GRNotes Register Page!!!</h3>
	
	<form:form action="save" method="POST" modelAttribute="gRNote">
	<pre>
	Goods Code:
	<form:input path="grnCode"/>
	Goods Type:
	<form:input path="grnType"/>
	Description:
	<form:textarea path="grnDesc"/>
	
	<input type="submit" value="Create GRN"/>
	</pre> 
	</form:form>
	${message }
</body>
</html>
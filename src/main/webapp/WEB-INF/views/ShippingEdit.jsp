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

	<h3>Welcome to Shipping Edit Page!!!</h3>
	<form:form action="update" method="POST" modelAttribute="shipping">
		<pre>
Shipping Id:
<form:input path="shipId" readOnly="true" />

Shipping Code:
<form:input path="shipCode" />

Shipping Ref.Number:
<form:input path="shipRefNum" />

Courier Ref.Number:
<form:input path="courRefNum" />

Contact Details:
<form:input path="contDetails" />

Description:
<form:textarea path="shipDesc" />
   
   <input type="submit" value="Update" />
</pre>
	</form:form>
</body>
</html>
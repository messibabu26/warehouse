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
<h3> Welcome to OrderMethod Edit Page!!! </h3>
<form:form action="update" method="POST" modelAttribute="orderMethod">
<pre>
Order Id:
<form:input path="ordId" readOnly="true"/>
Order Mode:
	<form:radiobutton path="ordMode" value="Sale"/>Sale
	<form:radiobutton path="ordMode" value="Purchase"/>Purchase
	Order Code:
	<form:input path="ordCode"/>
	Order Type:
	<form:select path="ordType">
	<form:option value="">---SELECT---</form:option>
	<form:option value="FIFO">FIFO</form:option>
	<form:option value="LIFO">LIFO</form:option>
	<form:option value="FEFO">FEFO</form:option>
	<form:option value="FCFO">FCFO</form:option>
	</form:select>
	Order Accept:
	<form:checkbox path="ordAccept" value="Multi-Model"/>MultiModel
	<form:checkbox path="ordAccept" value="Accept Return"/>Accept Return
	Description:
	<form:input path="ordDesc"/>
	<input type="submit" value="UPDATE"/>
</pre>
</form:form>
</body>
</html>
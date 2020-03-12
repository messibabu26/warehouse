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

	<h4>Welcome to OrderMethod Register Page!!!</h4>

	<%-- <form action="save" method="POST">
		<pre>
Order Mode:
<input type="radio" name="ordMode" value="Sale">Sale
<input type="radio" name="ordMode" value="Purchase">Purchase

Order Code:
<input type="text" name="ordCode">

Order Type:
<select name="ordType">
<option>-----select-----</option>
<option>FIFO</option>
<option>LIFO</option>
<option>FCFO</option>
<option>FEFO</option>
</select>

Order Accept:
<input type="checkbox" name="ordAccept" value="Multi-Model">MultiModel
<input type="checkbox" name="ordAccept" value="Accept Return">Accept Return

Description:
<textarea name="ordDesc"></textarea>
<input type="submit" value="CREATE Customer OrderMethod" />

</pre>
	</form>
	${message } --%>
	
	<form:form action="save" method="POST" modelAttribute="orderMethod">
	<pre>
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
	
	<input type="submit" value="CREATE"/>
	</pre>
	</form:form>
	${message }
</body>
</html>
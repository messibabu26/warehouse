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

	<h3>Welcome to Shipment Type Register Page!!!</h3>

	<%-- <form action="save" method="POST">
	<pre>
Shipment Mode:
<select name="shipMode">
<option>-----select-----</option>
<option>Air</option>
<option>Bus</option>
<option>Train</option>
<option>Ship</option>
</select>
Shipment Code:
<input type="text" name="shipCode">
Enable Shipment:
<select name="shipEnable">
<option>-----select-----</option>
<option>Yes</option>
<option>No</option>
</select>
Shipment Grade:
<input type="radio" name="shipGrade" value="A">A
<input type="radio" name="shipGrade" value="B">B
<input type="radio" name="shipGrade" value="C">C

Description:
<textarea name="shipDesc"></textarea>
<input type="submit" value="CREATE SHIPMENT"/>
</pre>
</form>
${message} --%>


	<form:form action="save" method="POST" modelAttribute="shipmentType">
		<pre>
Shipment Mode:
<form:select path="shipMode">
<form:option value="">---SELECT---</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
<form:option value="Bus">Bus</form:option>
</form:select>
Shipment Code:
<form:input path="shipCode" />
Enable Shipment:
<form:select path="shipEnable">
<form:option value="">---SELECT---</form:option>
<form:option value="YES">YES</form:option>
<form:option value="NO">NO</form:option>
</form:select>
Shipment Grade:
<form:radiobutton path="shipGrade" value="A" />A
<form:radiobutton path="shipGrade" value="B" />B
<form:radiobutton path="shipGrade" value="C" />C
Description:
<form:textarea path="shipDesc" />
<input type="submit" value="CREATE SHIPMENT" />
</pre>
	</form:form>
	${message }
</body>
</html>
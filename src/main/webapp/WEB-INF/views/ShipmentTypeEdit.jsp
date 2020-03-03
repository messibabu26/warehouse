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
<%@include file="AsifMenu.jsp" %>
<h3> Welcome to ShipmentType Edit Page!!! </h3>
<form:form action="update" method="POST" modelAttribute="shipmentType">
		<pre>
Shipment Id:
<form:input path="shipId" readOnly="true" />
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
<input type="submit" value="UPDATED" />
</pre>
	</form:form>
</body>
</html>
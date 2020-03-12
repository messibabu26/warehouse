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
	<h3>Welcome to UomType Edit Page!!!</h3>
	<form:form action="update" method="POST" modelAttribute="uomType">
		<pre>
Unit Id:
<form:input path="unitId" readOnly="true" />

Unit Type:
<form:select path="unitType">
<form:option value="">---SELECT---</form:option>
<form:option value="Packing">Packing</form:option>
<form:option value="No-Packing">No Packing</form:option>
<form:option value="-NA-">-NA-</form:option>
</form:select>

Unit Model:
<form:input path="unitModel" />

Description:
<form:textarea path="unitDesc" />

<input type="submit" value="Update" />
</pre>
	</form:form>
</body>
</html>
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

	<h3>Welcome to My Unit Page!!!</h3>

	<%-- <form action="save" method="POST">
		<pre>
Unit Type:
<select name="unitType">
<option>----select----</option>
<option>Packing</option>
<option>No-Packing</option>
<option>-NA-</option>
</select>
Unit Model:
<input type="text" name="unitModel" />
Description:
<textarea name="unitDesc"></textarea>

<input type="submit" value="CREATE UNIT"/>
</pre>
	</form>
	${message} --%>

	<form:form action="save" method="POST" modelAttribute="uomType">
		<pre>
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

<input type="submit" value="CREATE UOM" />
</pre>
	</form:form>
	${message }
</body>
</html>
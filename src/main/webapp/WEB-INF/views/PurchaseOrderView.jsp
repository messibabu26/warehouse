<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to PurchaseOrder View Page!!!</h3>

	<a href="excel?id=${ob.ordId }">Excel Export</a>|
	<a href="pdf?id=${ob.ordId }">PDF Export</a>

	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.ordId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.ordCode }</td>
		</tr>
		<tr>
			<th>REF.NUMBER</th>
			<td>${ob.refNumber }</td>
		</tr>
		<tr>
			<th>QUALITY CHECK</th>
			<td>${ob.quaCheck }</td>
		</tr>
		<tr>
			<th>DEFAULT STATUS</th>
			<td>${ob.defStatus }</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th>
			<td>${ob.ordDesc }</td>
		</tr>
	</table>

</body>
</html>
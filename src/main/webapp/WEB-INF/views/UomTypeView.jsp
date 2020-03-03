<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to UomType View Page!!!</h3>
	
	 <a href="excel?id=${ob.unitId }">Excel Export</a> |
	 <a href="pdf?id=${ob.unitId }">PdfExport</a>
	 
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.unitId }</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.unitType }</td>
		</tr>
		<tr>
			<th>MODEL</th>
			<td>${ob.unitModel }</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.unitDesc }</td>
		</tr>
	</table>
</body>
</html>
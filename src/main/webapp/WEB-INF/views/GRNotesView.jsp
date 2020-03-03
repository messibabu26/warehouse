<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to GRNotes View Page!!!</h3>
	
	<a href="excel?id=${ob.grnId }">Excel Export</a> |
	 <a href="pdf?id=${ob.grnId }">PdfExport</a>

	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.grnId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.grnCode }</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.grnType }</td>
		<tr>
			<th>DESCRIPTION</th>
			<td>${ob.grnDesc }</td>
		</tr>
	</table>
</body>
</html>
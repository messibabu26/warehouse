<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to OrderMethod Edit Page!!!</h3>
	
	 <a href="excel?id=${ob.ordId }">Excel Export</a> |
	 <a href="pdf?id=${ob.ordId }">PdfExport</a>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.ordId }</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${ob.ordMode }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.ordCode }</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.ordType }</td>
		</tr>
		<tr>
			<th>Accept</th>
			<td>${ob.ordAccept }</td>
		</tr>
		<tr>
			<th>DESCRIPTION</th>
			<td>${ob.ordDesc }</td>
		</tr>
	</table>
</body>
</html>
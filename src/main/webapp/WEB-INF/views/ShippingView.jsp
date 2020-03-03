<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3> Welcome to Shipping View Page!!! </h3>

<a href="excel?id=${ob.shipId }">Excel Export</a> |
	 <a href="pdf?id=${ob.shipId }">PdfExport</a>
	 
	 <table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.shipId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.shipCode }</td>
		</tr>
		<tr>
			<th>SHIP REF.NUMBER</th>
			<td>${ob.shipRefNum }</td>
		<tr>
		<tr>
			<th>COUR REF.NUMBER</th>
			<td>${ob.courRefNum }</td>
		<tr>
		<tr>
			<th>CONTACT DETAILS</th>
			<td>${ob.contDetails }</td>
		<tr>
			<th>DESCRIPTION</th>
			<td>${ob.shipDesc }</td>
		</tr>
	</table>

</body>
</html>
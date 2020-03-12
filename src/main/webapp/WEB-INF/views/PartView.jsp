<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>Welcome to View Part!!!</h4>
	
	<a href="excel?id=${ob.partId }">Excel Export</a>|
	<a href="pdf?id=${ob.partId }">PDF Export</a>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.partId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.partCode }</td>
		</tr>
		<tr>
			<th>LENGTH</th>
			<td>${ob.partLen }</td>
		</tr>
		<tr>
			<th>WIDTH</th>
			<td>${ob.partWidth }</td>
		</tr>
		<tr>
			<th>HEIGHT</th>
			<td>${ob.partHgt }</td>
		</tr>
		<tr>
			<th>COST</th>
			<td>${ob.partBaseCost }</td>
		</tr>
		<tr>
			<th>CURRENCY</th>
			<td>${ob.partBaseCurrency }</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.partDesc }</td>
			
		</tr>
	</table>
</body>
</html>
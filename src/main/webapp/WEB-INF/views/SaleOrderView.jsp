<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to SaleOrder View Page!!!</h3>

	<a href="excel?id=${ob.saleId }">Excel Export</a>|
	<a href="pdf?id=${ob.saleId }">PDF Export</a>

	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.saleId }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.saleCode }</td>
		</tr>
		<tr>
			<th>REF.NUMBER</th>
			<td>${ob.refNumber }</td>
		</tr>
		<tr>
			<th>STOCK MODE</th>
			<td>${ob.stockMode }</td>
		</tr>
		<tr>
			<th>STOCK SOURCE</th>
			<td>${ob.stockSource }</td>
		</tr>
		<tr>
			<th>DEFAULT STATUS</th>
			<td>${ob.defStatus }</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${ob.saleDesc }</td>
		</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to WhUserType View Page!!!</h3>
	
	<a href="excel?id=${ob.userId }">Excel Export</a> |
	 <a href="pdf?id=${ob.userId }">PdfExport</a>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${ob.userId }</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${ob.userType }</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${ob.userCode }</td>
		</tr>
		<tr>
			<th>FOR</th>
			<td>${ob.userFor }</td>
		</tr>
		<tr>
			<th>MAIL</th>
			<td>${ob.userMail }</td>
		</tr>
		<tr>
			<th>CONTACT</th>
			<td>${ob.userContact }</td>
		</tr>
		<tr>
			<th>ID TYPE</th>
			<td>${ob.userIdType }</td>
		</tr>
		<tr>
			<th>OTHER</th>
			<td>${ob.userOther }</td>
		</tr>
		<tr>
			<th>ID NUMBER</th>
			<td>${ob.idNumber }</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="excel">Excel Export</a> |
	    <a href="pdf">PdfExport</a>
	    
	<h3>Welcome to Unit Data Type!!!</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.unitId }</td>
						<td>${ob.unitType }</td>
						<td>${ob.unitModel }</td>
						<td>${ob.unitDesc }</td>
						<td><a href="delete?unid=${ob.unitId }">DELETED</a></td>
						<td><a href="edit?unid=${ob.unitId }">EDIT</a></td>
						<td><a href="view?unid=${ob.unitId }">VIEW</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4>No Data Found</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>
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

	<h3>Welcome to Shipping Data Page!!!</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>SHIP REF.NUMBER</th>
					<th>COUR REF.NUMBER</th>
					<th>CONTACT DETAILS</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.shipId }</td>
						<td>${ob.shipCode }</td>
						<td>${ob.shipRefNum }</td>
						<td>${ob.courRefNum }</td>
						<td>${ob.contDetails }</td>
						<td>${ob.shipDesc }</td>
						<td>
						    <a href="delete?sid=${ob.shipId}">DELETE</a>
						</td>
						<td>
						    <a href="edit?sid=${ob.shipId}">EDIT</a>
						</td>
						<td>
						    <a href="view?sid=${ob.shipId}">VIEW</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4>NO DATA FOUND</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>
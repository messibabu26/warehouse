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

	<h3>Welcome to GRNotes Data Page!!!</h3>

	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>TYPE</th>
					<th>PURCHASE ORDER</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.grnId }</td>
						<td>${ob.grnCode }</td>
						<td>${ob.grnType }</td>
						<td>${ob.purchaseOrder.ordCode }
						<td>${ob.grnDesc }</td>
						<td>
						   <a href="delete?gid=${ob.grnId }">DELETE</a>
						</td>
						<td>
						   <a href="edit?gid=${ob.grnId }">EDIT</a>
						</td>
						<td>
						   <a href="view?gid=${ob.grnId }">VIEW</a>
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
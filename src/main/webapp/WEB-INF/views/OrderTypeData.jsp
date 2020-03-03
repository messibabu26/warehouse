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
	    
	<h3>Welcome to Customer Order Data Receipt</h3>
	<c:choose>
		<c:when test="${! empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>MODE</th>
					<th>CODE</th>
					<th>TYPE</th>
					<th>ACCEPT</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.ordId }</td>
						<td>${ob.ordMode }</td>
						<td>${ob.ordCode }</td>
						<td>${ob.ordType }</td>
						<td>${ob.ordAccept }</td>
						<td>${ob.ordDesc }</td>
						<td>
						   <a href="delete?oid=${ob.ordId }">DELETE</a>
						</td>
						<td>
						   <a href="edit?oid=${ob.ordId }">EDIT</a>
						</td>
						<td>
						   <a href="view?oid=${ob.ordId }">VIEW</a>
						</td>
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
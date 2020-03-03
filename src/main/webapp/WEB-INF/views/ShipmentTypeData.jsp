<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<%-- <%@include file="AsifMenu.jsp" %> --%>

	<a href="excel">Excel Export</a> |
	<a href="pdf">PdfExport</a>

	<h3>Welcome to Shipment Type Data Page!!!</h3>

	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>MODE</th>
					<th>CODE</th>
					<th>ENABLE</th>
					<th>GRADE</th>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>

				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.shipId }</td>
						<td>${ob.shipMode }</td>
						<td>${ob.shipCode }</td>
						<td>${ob.shipEnable }</td>
						<td>${ob.shipGrade }</td>
						<td>${ob.shipDesc }</td>
						<td><a href="delete?sid=${ob.shipId}">DELETE</a></td>
						<td><a href="edit?sid=${ob.shipId}">EDIT</a></td>
						<td><a href="view?sid=${ob.shipId}">VIEW</a></td>
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
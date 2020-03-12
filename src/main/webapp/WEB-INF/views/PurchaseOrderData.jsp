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

	<a href="excel">Excel Export</a>|
	<a href="pdf">PDF Export</a>

	<h3>Welcome to PurchaseOrder Data Page!!!</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>SHIPMENT TYPE</th>
					<th>WHUSER TYPE</th>
					<th>REF.NUMBER</th>
					<th>QUALITY CHECK</th>
					<TH>DEFAULT STATUS</TH>
					<th>NOTE</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.ordId }</td>
						<td>${ob.ordCode }</td>
						<td>${ob.shipOb.shipEnable }</td>
						<td>${ob.whuserOb.userType }</td>
						<td>${ob.refNumber }</td>
						<td>${ob.quaCheck }</td>
						<td>${ob.defStatus }</td>
						<td>${ob.ordDesc }</td>
						<td><a href="delete?oid=${ob.ordId }">DELETE</a></td>
						<td><a href="edit?oid=${ob.ordId }">EDIT</a></td>
						<td><a href="view?oid=${ob.ordId }">VIEW</a></td>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h4>NO DATA FOUND</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>
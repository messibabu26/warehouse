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

	<h3>Welcome to Part Data!!!</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>CODE</th>
					<th>LENGTH</th>
					<th>WIDTH</th>
					<th>HEIGHT</th>
					<th>COST</th>
					<th>CURRENCY</th>
					<th>UOM</th>
					<th>ORDER METHODS</th>
					<th>ORDER METHODP</th>
					<th>NOTE</th>

					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.partId }</td>
						<td>${ob.partCode }</td>
						<td>${ob.partLen }</td>
						<td>${ob.partWidth }</td>
						<td>${ob.partHgt }</td>
						<td>${ob.partBaseCost }</td>
						<td>${ob.partBaseCurrency }</td>
						<td>${ob.uomOb.unitModel }</td>
						<td>${ob.ordObSale.ordCode }</td>
						<td>${ob.ordObPurchase.ordCode }</td>
						<td>${ob.partDesc }</td>

						<td><a href="delete?pid=${ob.partId }">DELETE</a></td>
						<td><a href="edit?pid=${ob.partId}">EDIT</a></td>
						<td><a href="view?pid=${ob.partId}">VIEW</a></td>
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
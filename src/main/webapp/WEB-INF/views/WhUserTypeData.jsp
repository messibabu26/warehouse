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
    
    
	<h3>Welcome to WareHouse User Type Data!!!</h3>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>CODE</th>
					<th>FOR</th>
					<th>MAIL</th>
					<th>CONTACT</th>
					<th>ID TYPE</th>
					<th>OTHER</th>
					<th>ID NUMBER</th>
					<th colspan="3">OPERATION</th>
				</tr>
				<c:forEach items="${list }" var="ob">
					<tr>
						<td>${ob.userId }</td>
						<td>${ob.userType }</td>
						<td>${ob.userCode }</td>
						<td>${ob.userFor }</td>
						<td>${ob.userMail }</td>
						<td>${ob.userContact }</td>
						<td>${ob.userIdType }</td>
						<td>${ob.userOther }</td>
						<td>${ob.idNumber }</td>
						<td>
						  <a href="delete?whuid=${ob.userId }">DELETED</a>
						</td>
						<td>
						  <a href="edit?whuid=${ob.userId }">EDIT</a>
						</td>
						<td>
						  <a href="view?whuid=${ob.userId }">VIEW</a>
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
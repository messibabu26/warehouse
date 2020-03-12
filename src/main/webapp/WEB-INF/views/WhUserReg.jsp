<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to WareHouse Page!!!</h3>

	<form:form action="save" method="POST"
		modelAttribute="whUserType">
		<pre>
	WareHouse UserType:
	<form:radiobutton path="userType" value="Vendor" />Vendor
	<form:radiobutton path="userType" value="Customer" />Customer
	
	WareHouse UserCode:
	<form:input path="userCode" />
	
	WareHouse UserFor:
	<form:input path="userFor" />
	
	WareHouse UserMail:
	<form:input path="userMail" />
	
	WareHouse UserContact:
	<form:input path="userContact" />
	
	WareHouse UserIdType:
	<form:select path="userIdType">
	<form:option value="">---SELECT---</form:option>
	<form:option value="PAN CARD">PAN CARD</form:option>
	<form:option value="AADHAR CARD">AADHAR CARD</form:option>
	<form:option value="VOTER ID">VOTER ID</form:option>
	<form:option value="OTHER">OTHER</form:option>
	</form:select>
	
	If Other:
	<form:input path="userOther" />
	
	WareHouse UserIdNumber:
	<form:input path="idNumber" />
	
	<input type="submit" value="CREATE WAREHOUSE" />
	</pre>
	</form:form>
	${message }
</body>
</html>
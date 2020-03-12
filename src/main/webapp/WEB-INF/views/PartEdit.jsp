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

	<h3>Welcome to Edit Part!!!</h3>
	<form:form action="update" method="POST" modelAttribute="part">
		<pre>
Part Id:
<form:input path="partId" readOnly="true" />

Code:
<form:input path="partCode" />

Dimension:
Width:
<form:input path="partWidth" />

Length:
<form:input path="partLen" />

Height:
<form:input path="partHgt" />

Base Cost:
<form:input path="partBaseCost" />

Base Currency:
<form:select path="partBaseCurrency">
<form:option value="">---SELECT---</form:option>
<form:option value="INR">INR</form:option>
<form:option value="USD">USD</form:option>
<form:option value="AUS">AUS</form:option>
<form:option value="ERU">ERU</form:option>
</form:select>

Description:
<form:input path="partDesc" />
    
<input type="submit" value="Update" />
  </pre>
	</form:form>
	${message }
</body>
</html>
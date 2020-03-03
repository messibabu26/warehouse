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

	<h3>Welcome to Part Register Page!!!</h3>
	<form:form action="save" method="POST" modelAttribute="part">

		<pre>
  Code:
  <form:input path="partCode" />
  Dimension:
  <form:checkbox path="partDimension" value="W" />W
  <form:checkbox path="partDimension" value="L" />L
  <form:checkbox path="partDimension" value="H" />H
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
    
    <input type="submit" value="Create Part" />
  </pre>
	</form:form>
	${message }

</body>
</html>
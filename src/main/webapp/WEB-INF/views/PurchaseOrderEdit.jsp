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

	<h3>Welcome to PurchaseOrder Edit Page!!!</h3>

	<form:form action="update" method="POST" modelAttribute="purchaseOrder">
		<pre>
Purchase Id:
<form:input path="ordId" readOnly="true" />

Purchase Code:
<form:input path="ordCode" />

Reference Number:
<form:input path="refNumber" />

Quality Check:
<form:radiobutton path="quaCheck" value="Required" />Required
<form:radiobutton path="quaCheck" value="Not Required" />Not Required

Default Status:
<form:input path="defStatus" readonly="true" />

Description:
<form:textarea path="ordDesc" />
    
<input type="submit" value="Update" /> 
	</pre>
	</form:form>
</body>
</html>
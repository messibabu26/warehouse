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

	<h3>Welcome to PurchaseOrder Register Page!!!</h3>

	<form:form action="save" method="POST" modelAttribute="purchaseOrder">
		<pre>
Order Code:
<form:input path="ordCode" />

Shipment Type:
<form:select path="shipOb.shipId" class="form-control">
<form:option value="">---SELECT----</form:option>
<form:options items="${shipMap }" />
</form:select>
  
WhUserType:
<form:select path="whuserOb.userId" class="form-control">
<form:option value="">---SELECT VENDOR----</form:option>
<form:options items="${whuserMap }" />
</form:select>

Reference Number:
<form:input path="refNumber" />

Quality Check:
<form:radiobutton path="quaCheck" value="Required" />Required
<form:radiobutton path="quaCheck" value="Not Required" />Not Required

Default Status:
<form:input path="defStatus" readonly="true" />

Description:
<form:textarea path="ordDesc" />

<input type="submit" value="Create Purchase" />
</pre>
	</form:form>
	${message }
</body>
</html>
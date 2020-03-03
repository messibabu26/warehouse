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

	<h3>Welcome to SaleOrder Edit Page!!!</h3>

	<form:form action="update" method="POST" modelAttribute="saleOrder">
		<pre>
	Sale Id:
	<form:input path="saleId" readOnly="true" />
	Sale Code:
	<form:input path="saleCode" />
	Ref.Number:
	<form:input path="refNumber" />
	Stock Mode:
	<form:radiobutton path="stockMode" value="GRADE" />GRADE
	<form:radiobutton path="stockMode" value="MARGIN" />MARGIN
	Stock Source:
	<form:select path="stockSource">
	<form:option value="">---SELECT---</form:option>
	<form:option value="OPEN">OPEN</form:option>
	<form:option value="AVAIL">AVAIL</form:option>
	<form:option value="REFUND">REFUND</form:option>
	</form:select>
	Default Status:
	<form:textarea path="defStatus" placeholder="SALE-OPEN" />
	Description:
	<form:textarea path="saleDesc" />
	
	<input type="submit" value="Update" />
	</pre>
	</form:form>
</body>
</html>
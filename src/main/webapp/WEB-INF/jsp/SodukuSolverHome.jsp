<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
table {
	border-collapse: collapse;
}

table, td {
	border: 1px solid black;
}

input[type=text] {
	width: 50px;
	height: 50px;
	font-size: 40px;
	text-align: center;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SodukuSolver Home</title>
</head>
<body>

	<h1>This is the SodukuSolver Home Page</h1>
	
<form:form method="POST" modelAttribute="grid">
	<table>
		<c:forEach items="${grid.gridSquareList}" var="gridSquare" varStatus="status">
			<c:choose>
				<c:when test="${gridSquare.x%3==0 && gridSquare.x!=size}">
					<c:set var="br" value="border-right: 5px solid black;" />
				</c:when>
				<c:otherwise>
					<c:set var="br" value="" />
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${gridSquare.y%3==0 && gridSquare.y!=size}">
					<c:set var="bb" value="border-bottom: 5px solid black;" />
				</c:when>
				<c:otherwise>
					<c:set var="bb" value="" />
				</c:otherwise>
			</c:choose>

			<!--<c:choose>
				<c:when test="${gridSquare.x==1}">
					<tr style="${bb}"><td><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td>
				</c:when>
				<c:when test="${gridSquare.x==size}">
					<td><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td></tr>
				</c:when>
				<c:otherwise>
					<td style="${br}"><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td>
				</c:otherwise>
			</c:choose>--->
			
			<c:choose>
				<c:when test="${gridSquare.x==1}">
					<tr style="${bb}"><td><c:out value="${gridSquare.initialSet}"/><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td>
				</c:when>
				<c:when test="${gridSquare.x==size}">
					<td><c:out value="${gridSquare.initialSet}"/><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td></tr>
				</c:when>
				<c:otherwise>
					<td style="${br}"><c:out value="${gridSquare.initialSet}"/><form:input path="gridSquareList[${status.index}].confirmedNumber" type="text" maxlength="1" /></td>
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
	</table>
	<!--<c:out value="${gridSquare.x}"/>,<c:out value="${gridSquare.y}"/>--->
	<!--<c:out value="${gridSquare.initialSet}"/>--->
	<br />

	<input type="Submit" name="Solve" />
</form:form>

</body>
</html>
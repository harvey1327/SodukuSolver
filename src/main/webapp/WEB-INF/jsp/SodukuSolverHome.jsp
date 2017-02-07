<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<table>
		<c:forEach items="${grid.gridList}" var="GridSquare">
			<c:choose>
				<c:when test="${GridSquare.x%3==0 && GridSquare.x!=size}">
					<c:set var="br" value="border-right: 5px solid black;"/>
				</c:when>
				<c:otherwise>
					<c:set var="br" value=""/>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${GridSquare.y%3==0 && GridSquare.y!=size}">
					<c:set var="bb" value="border-bottom: 5px solid black;"/>
				</c:when>
				<c:otherwise>
					<c:set var="bb" value=""/>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${GridSquare.x==1}">
					<tr style="${bb}"><td><input type="text" maxlength="1"/></td>
				</c:when>
				<c:when test="${GridSquare.x==size}">
					<td><input type="text" maxlength="1"/></td></tr>
				</c:when>
				<c:otherwise>
					<td style="${br}"><input type="text" maxlength="1"/></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>

	<br />

	<input type="Submit" name="Solve" />

</body>
</html>
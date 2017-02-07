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


</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SodukuSolver Home</title>
</head>
<body>
	<h1>This is the SodukuSolver Home Page</h1>

	<table>
		<c:forEach var="y" begin="1" end="9">
			<c:choose>
				<c:when test="${y%3==0 && y!=9}">
					<tr style="border-bottom: 5px solid black;">
				</c:when>
				<c:otherwise>
					<tr>
				</c:otherwise>
			</c:choose>
			<c:forEach var="x" begin="1" end="9">
				<c:choose>
					<c:when test="${x%3==0 && x!=9}">
						<td style="border-right: 5px solid black;">
					</c:when>
					<c:otherwise>
						<td>
					</c:otherwise>
				</c:choose>
				<input type="text" style="width: 50px;height: 50px;font-size: 40px;text-align: center;" maxlength="1"/>
				</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<br />

	<input type="Submit" name="Solve" />

</body>
</html>
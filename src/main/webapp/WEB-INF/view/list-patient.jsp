<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient List</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Patient Management System</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>

				<tr>
					<td>Name</td>
					<td>Mobile</td>
					<td>Age</td>
					<td>Gender</td>
					<td>Occupation</td>
				</tr>

				<!-- Loop over and print patients-->

				<c:forEach var="tempPatients" items="${patients}">
					<tr>
						<td>${tempPatients.name}</td>
						<td>${tempPatients.mobileNumber}</td>
						<td>${tempPatients.age}</td>
						<td>${tempPatients.gender}</td>
						<td>${tempPatients.occupation}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
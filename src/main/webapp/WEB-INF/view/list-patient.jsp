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

			<!-- put new button: Add Patient -->

			<input type="button" value="Add Patient"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>

				<tr>
					<td>Name</td>
					<td>Mobile</td>
					<td>Age</td>
					<td>Gender</td>
					<td>Occupation</td>
					<td>Action</td>
				</tr>

				<!-- Loop over and print patients-->

				<c:forEach var="tempPatients" items="${patients}">
				
				<!-- construct an "update" link with patient id -->
					<c:url var="updateLink" value="/patient/showFormForUpdate">
						<c:param name="patientId" value="${tempPatients.id}" />
					</c:url>
				
					<tr>
						<td>${tempPatients.name}</td>
						<td>${tempPatients.mobileNumber}</td>
						<td>${tempPatients.age}</td>
						<td>${tempPatients.gender}</td>
						<td>${tempPatients.occupation}</td>
						<!-- display the update link -->
						<td><a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
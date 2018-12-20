<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
		<!--  add a search box -->
		<form:form action="search" method="POST">
                Search patient: <input type="text" name="theSearchName" />

			<input type="submit" value="Search" class="add-button" />
		</form:form>
	</div>



	<div id="container">
		<div id="content">


			<!-- put new button: Add Patient -->
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

				<!-- put new button: Add Patient -->

				<input type="button" value="Add Patient"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />

			</security:authorize>

			<table>

				<tr>
					<td>Name</td>
					<td>Mobile</td>
					<td>Age</td>
					<td>Gender</td>
					<td>Occupation</td>

					<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<th>Action</th>
					</security:authorize>
				</tr>

				<!-- Loop over and print patients-->

				<c:forEach var="tempPatients" items="${patients}">

					<!-- construct an "update" link with patient id -->
					<c:url var="updateLink" value="/patient/showFormForUpdate">
						<c:param name="patientId" value="${tempPatients.id}" />
					</c:url>

					<!-- construct an "delete" link with patient id -->
					<c:url var="deleteLink" value="/patient/delete">
						<c:param name="patientId" value="${tempPatients.id}" />
					</c:url>

					<tr>
						<td>${tempPatients.name}</td>
						<td>${tempPatients.mobileNumber}</td>
						<td>${tempPatients.age}</td>
						<td>${tempPatients.gender}</td>
						<td>${tempPatients.occupation}</td>
						<!-- display the update and delete link -->
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">

							<td><security:authorize
									access="hasAnyRole('MANAGER', 'ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize> <security:authorize access="hasAnyRole('ADMIN')">
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">Delete</a>
								</security:authorize></td>

						</security:authorize>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<p></p>
	<br>
	<c:url var="doctors" value="/doctor/list"/>
	
	<a href="${doctors}"> Doctors List</a>
	
	<br>
	<br>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" class="add-button" />

	</form:form>

</body>
</html>
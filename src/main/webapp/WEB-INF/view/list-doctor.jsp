<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors List</title>

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
                Search doctor: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
	</div>
	
	

	<div id="container">
		<div id="content">
		

			<!-- put new button: Add doctor -->

			<input type="button" value="Add Doctor"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>

				<tr>
					<td>Name</td>
					<td>Department</td>
					<td>Joining Date</td>
					<td>Action</td>
				</tr>

				<!-- Loop over and print patients-->

				<c:forEach var="tempDoctors" items="${doctors}">

					<!-- construct an "update" link with patient id -->
					<c:url var="updateLink" value="/doctor/showFormForUpdate">
						<c:param name="doctorId" value="${tempDoctors.id}" />
					</c:url>

					<!-- construct an "delete" link with patient id -->
					<c:url var="deleteLink" value="/doctor/delete">
						<c:param name="doctorId" value="${tempDoctors.id}" />
					</c:url>

					<tr>
						<td>${tempDoctors.name}</td>
						<td>${tempDoctors.dept}</td>
						<td>${tempDoctors.joiningDate}</td>
						<!-- display the update and delete link -->
						<td><a href="${updateLink}">Update</a> | 
						<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this doctor?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>
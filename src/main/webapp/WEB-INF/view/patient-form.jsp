<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-patient-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Patient Management System</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Patient</h3>
	
		<form:form action="savePatient" modelAttribute="patient" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Mobile Number</label></td>
						<td><form:input path="mobileNumber" /></td>
					</tr>

					<tr>
						<td><label>Age</label></td>
						<td><form:input path="age" /></td>
					</tr>
					
					<tr>
						<td><label>Gender</label></td>
						<td><form:input path="gender" /></td>
					</tr>
					
					<tr>
						<td><label>Occupation</label></td>
						<td><form:input path="occupation" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/patient/list">Back to List</a>
		</p>
	
	</div>
	
</body>
</html>
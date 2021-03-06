<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-doctor-style.css">
	<style>
		.error {color:red}
	</style>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Patient Management System</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Doctor</h3>
	
		<form:form action="saveDoctor" modelAttribute="doctor" method="POST">

			<!-- need to associate this data with patient id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" />
						<form:errors path="name" cssClass="error" /></td>
					</tr>
				
					<tr>
						<td><label>Department</label></td>
						<td><form:input path="dept" />
						<form:errors path="dept" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Joining Date</label></td>
						<td><form:input path="joiningDate" />
						<form:errors path="joiningDate" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/doctor/list">Back to List</a>
		</p>
	
	</div>
	
</body>
</html>
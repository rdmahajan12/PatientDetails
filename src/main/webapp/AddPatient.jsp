<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Patient</title>
<script src="bootstrap/css/bootstrap.css"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<link href="style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="row">
<div class="col-md-6"></div>
<div class="col-md-4">
<form action="AddPatient" method="post">
<h1>Add Patient</h1>

<div>
<label>Patient ID: </label>
<input type="text" name="pid" required/>
</div>
<br>

<div>
<label>Patient Name: </label>
<input type="text" name="pname" required/>
</div>
<br>

<div>
<label>Patient Address: </label>
<input type="text" name="paddress" required/>
</div>
<br>

<div>
<label>Patient Phone: </label>
<input type="number" name="phone" required/>
</div>
<br>

<button type="submit" class="btn-primary">Save</button>
<button type="reset" class="btn-danger">Reset</button><br>
<a href="UpdatePatient.jsp">Edit</a>
<a href="DeletePatient.jsp">Delete</a>

<c:if test="${ result != null}">
<b>${result }</b>
</c:if>

</form>
</div>
<div class="col-md-2"></div>
</div>

</body>
</html>
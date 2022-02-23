<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Patient</title>
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
<form action="UpdatePatient" method="post">
<h1>Update Patient</h1>
<div>
<label>Patient ID: </label>
<input type="text" name="pid"/>
</div>
<br>

<div>
<label>Patient Name: </label>
<input type="text" name="pname"/>
</div>
<br>

<button type="submit" class="btn-primary">Update</button>

<c:if test="${ result != null}">
<b>${result }</b>
</c:if>
</form>
</div>
<div class="col-md-2"></div>
</div>
</body>
</html>
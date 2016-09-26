<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">
    
    <script  type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>
    
    
<title>Insert title here</title>
</head>
<body>
<!-- Start navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">GTC Movember</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
             <li><a href="upload">Upload</a></li>
              <li><a href="email">Contact</a></li>
            <li><a href="gallery">Gallery</a></li>
            <li><a href="student">StudentForm</a></li>
            <li><a href="#">Profile</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/logout">Logout<span class="sr-only">(current)</span></a></li>
          </ul>
        </div> 
      </div>
    </nav>
    <!-- End navbar -->
    
    <p style="color: yellow; padding-left: 80%;">Welcome  : ${username}</p>
    
    
    <div class="container">
    
    		<h1>Student List</h1>
	<table id="myTable" class="table table-striped" >
		<thead>
		<tr class="danger">
			<th>First Name</th>
			<th>Last Name</th>
			<th>Roll No</th>
			<th>Subject</th>
			<th>College Name</th> 
			<th>City</th>
			<th>Actions</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${studentList}">
			<!-- <c:if test="${row.subject ne null && row.subject eq 'Java' }"> -->
				<tr class="success">
					<td>${row.firstName}</td>
					<td>${row.lastName }</td>
					<td>${row.rollNo }</td>
					<td>${row.subject }</td>
					<td>${row.collegeName }</td>
					<td>${row.address.city}</td>
					<td colspan="2">
					<button type="button" class="btn btn-success" onclick="editStud(${row.id })" >Edit</button>
					<button type="button" class="btn btn-danger" onclick="deleteStud(${row.id })">Delete</button>
					</td>
				</tr>
				<!--</c:if>-->
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	<script type="text/javascript">
	
	
	
	
		function editStud(id){
			
			location.href = "${pageContext.request.contextPath}/" + id + "/edit";
		}


		function deleteStud(id){
			var r = confirm("Are you sure you want to delete this recored?");
			
			if (r == true) {
				window.location = "${pageContext.request.contextPath}/" + id + "/delete";
			} 
		}
		
		$(document).ready(function(){
		        $('#myTable').DataTable();
		    });
		
	</script>
    

</body>
</html>
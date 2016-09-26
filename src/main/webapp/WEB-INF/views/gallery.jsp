<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>

	<hr>
	<c:forEach var="imgname" items="${imgList}">
	<div class="img">
 	<a target="_blank" href="${pageContext.request.contextPath}/resources/imgs/${imgname}">
   		 <img src="${pageContext.request.contextPath}/resources/imgs/${imgname}" alt="Flower" width="300" height="200">
      
       </a>
       </div> 
	</c:forEach>
	
</body>
</html>
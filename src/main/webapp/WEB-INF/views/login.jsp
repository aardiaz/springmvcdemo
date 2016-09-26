<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">



<link rel="stylesheet" href="resources/css/style.css">

<title>Insert title here</title>
</head>
<body>

    <!-- Login Form -->
     <div class="login">
  	  <div class="login-triangle"></div>
 	  <h2 class="login-header">Log in</h2>
 	  
    <form class="login-container" action="login" method="post"  model= "user">
   
    <p><input type="text" name= "username"></p>
    <p><input type="password" name = "password"></p>
    <p><input type="submit" value="Log in"></p>
    
  </form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Green">
  <meta name="author" content="orangehat">
	
  <c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
	
  <link href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="${path}/css/style.css" rel="stylesheet">

	
  <title>Cloudnet Login</title>
</head>

<!-- <body> -->
<%--   <%@ include file="header.jsp" %>		 --%>
  <body style="background: url(${path}/images/login-background.png);">
  <div class="container">
<!--     <div class="card card-login mx-auto mt-5"> -->
<!--       <div class="card-header">Login</div> -->
<!--       <div class="card-body"> -->
    <form class="form-login" action="<c:url value="/login/doLogin.html" />" method="post">
	  <h4 class="form-login-heading">LOGIN</h4>
<!-- 	  <input type="text" class="form-control" name="userName" placeholder="username"> -->
<!-- 	  <input type="password" class="form-control" name="password" placeholder="password">  -->
<!--       <label class="checkbox">  -->
<!--         <input type="checkbox" value="remember-me"> Remember Me -->
<!--       </label> -->
<!-- 	  <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button> -->
	  <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1"  name="userName" aria-describedby="emailHelp" placeholder="Enter email">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1"  name="password" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <button class="btn btn-primary btn-block" type="submit">Login</button>
        </form>
  </div>
<!--     </div> -->
<!--   </div> -->
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>


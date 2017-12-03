<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
  <link href="${path}/css/bootstrap-wysihtml5.css" rel="stylesheet">
	
  <script src="${path}/js/wysihtml5-0.3.0.min.js"></script>
  <script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
  <script src="${path}/js/bootstrap3-wysihtml5.js"></script>
    
  <link href="${path}/css/style.css" rel="stylesheet">
	
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
	
  <title>Inventory</title>
</head>

<body>
  <%@ include file="header.jsp" %>	
  
 <div class="card">
  <h3 class="card-header">Featured</h3>
  <div class="card-block">
    <h4 class="card-title">Special title treatment</h4>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
  <div class="container">
    <form class="form-add-item" action="<c:url value="/inventory/addItem.html" />" method="post">
	  <h4 class="form-add-item-heading">Add Item</h4>
       <input type="text" class="form-control" id="title" name="itemName" placeholder="Item Name" value="${item.itemName}"></input>
<input type="text" class="form-control" id="itemPrice" name="itemPrice" placeholder="Item Price" value="${item.itemPrice}"></input>
      <input type="hidden" name="boardId" value="${itemId}"> 
	<input class="submit-btn btn btn-primary btn-lg" type="submit" value="add Item">
	</form>
  </div>
</body>
</html>


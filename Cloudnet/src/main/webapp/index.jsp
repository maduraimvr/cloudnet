<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="cloudnet">
  <meta name="author" content="orangehat">

  <c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

  <link href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="${path}/css/ihover.min.css" rel="stylesheet">
  <link href="${path}/css/style.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <title>Iris</title>
</head>
<body style="background: url(${path}/images/background.png);">
  <%@ include file="header.jsp"%>

  <div class="card card-1">
    <div class="ih-item circle  effect13 top_to_bottom">
	  <a href="<c:url value="/board/listBoardTopics-1.html"/>">
	    <div class="img">
		  <img alt="" src="${path}/images/flowers/cerasus.jpg">
		</div>
		<div class="info-back">
		  <div class="info">
		    <h3>header</h3>
			<p>paragragh</4>
		  </div>
		</div> 
	  </a>
	</div>
	<div class="card-content">
	  <h3>header</h3>
	  <span>
	 span content
		<br> <br>
		span content after br
	  </span>
	</div>
  </div>




 
	
  <%@ include file="footer.jsp"%>
  
  <script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>

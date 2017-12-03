<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
  <div class="container">
    <div class="navbar-header">
	  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	    <span class="sr-only">Toggle navigation</span> 
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span>
	  </button>
	  <a class="navbar-brand" href="<c:url value="/index.jsp"/>">Cloudnet</a>
	</div>
	<div class="collapse navbar-collapse">
	  <ul class="nav navbar-nav">
	    <li class="active"><a href="<c:url value="/index.jsp"/>">index</a></li>
	    <!-- <li><a href="#about">市集</a></li> -->
	    <li><a target="_blank" href="<c:url value="https://www.google.com"/>">link</a></li>
	    
	    
	    <c:if test="${USER_CONTEXT.userType == 2}">
	    <li class="dropdown">
          <a href="#>" class="dropdown-toggle" data-toggle="dropdown">dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/forum/addBoardPage.html"/>">menu1</a></li>
            <li><a href="<c:url value="/forum/setBoardManagerPage.html"/>">menu2</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="<c:url value="/forum/userLockManagePage.html"/>">menu3</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
	    </c:if>
	    
	  </ul>
	  
	  <ul class="nav navbar-nav navbar-right">
        <c:if test="${!empty USER_CONTEXT.userName}">
		  <li><a href="#">${USER_CONTEXT.userName} <span class="badge">${USER_CONTEXT.credit}</span></a></li>
		  <li><a href="<c:url value="/login/doLogout.html"/>">logout</a></li>
		</c:if>
		<c:if test="${empty USER_CONTEXT.userName}">
		  <li><a href="<c:url value="/login.jsp"/>">login</a></li>
  		  <li><a href="<c:url value="/register.jsp"/>">register</a></li>
		</c:if>
      </ul>
   	  <form class="navbar-form navbar-right search">
        <input type="text" class="form-control" placeholder="Search...">
      </form>	
	</div>
  </div>
</div>
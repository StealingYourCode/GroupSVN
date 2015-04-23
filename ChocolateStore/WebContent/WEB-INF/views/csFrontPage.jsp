<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/ChocolateStore/resources/css/csFrontPage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chocolate Sstore</title>
</head>
<body>

	<%@ include file="csHeader.jsp" %>
	
	<div class="container">
	<div class="row">
		<ul class="thumbnails">
            <li class="span4">
              <div class="thumbnail">
                <img src="/ChocolateStore/resources/images/snickers.jpg" alt="Snickers">
                <div class="caption">
                  <h3>Header Name</h3>
                  <p>Description</p>
                  <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                </div>
              </div>
            </li>
              <li class="span4">
              <div class="thumbnail">
                <img src="/ChocolateStore/resources/images/twix.jpg" alt="ALT NAME">
                <div class="caption">
                  <h3>Header Name</h3>
                  <p>Description</p>
                  <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                </div>
              </div>
            </li>
              <li class="span4">
              <div class="thumbnail">
                <img src="/ChocolateStore/resources/images/mars.jpg" alt="ALT NAME">
                <div class="caption">
                  <h3>Header Name</h3>
                  <p>Description</p>
                  <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                </div>
              </div>
            </li>
            <li class="span4">
              <div class="thumbnail">
                <img src="/ChocolateStore/resources/images/skor.jpg" alt="ALT NAME">
                <div class="caption">
                  <h3>Header Name</h3>
                  <p>Description</p>
                  <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                </div>
              </div>
            </li>
              <li class="span4">
                <div class="thumbnail">
                  <img src="/ChocolateStore/resources/images/FR.jpg" alt="ALT NAME">
                  <div class="caption">
                    <h3>Header Name</h3>
                    <p>Description</p>
                    <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                  </div>
                </div>
              </li>
              <li class="span4">
                <div class="thumbnail">
                  <img src="/ChocolateStore/resources/images/butterfinger.jpg" alt="ALT NAME">
                  <div class="caption">
                    <h3>Header Name</h3>
                    <p>Description</p>
                    <p align="center"><a href="http://bootsnipp.com/" class="btn btn-primary btn-block">Open</a></p>
                  </div>
                </div>
              </li>
        </ul>
	</div>
</div>
	<%@ include file="csFooter.jsp" %>
	
</body>
</html>
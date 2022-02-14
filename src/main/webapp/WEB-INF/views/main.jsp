<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/commons/navmenuHeader.jsp" %>
	<link rel="stylesheet" href="/resources/custom/css/main.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/commons/navmenuBar.jsp" %>
	
	<div class="canvas">
		<div class="input-group text-center">
			<input type="text" class="form-control" placeholder="Search Images">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button">Search</button>
			</span>
		</div>
		<div id="earth"></div>
		
		<div id="landmark-carousel" class="carousel slide" data-ride="carousel">
			<h3 style="position: absolute; top:0; text-align: center; width: 100%; transform: translate(0, 0); z-index:100;">Click to Search One</h3>
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox"></div>
			
			<!-- Controls -->
			<a class="left carousel-control" href="#landmark-carousel" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<!-- <span class="icon-prev" aria-hidden="true"></span> -->
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#landmark-carousel" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<!-- <span class="icon-next" aria-hidden="true"></span> -->
				<span class="sr-only">Next</span>
			</a>
		</div>
		
		<div id="search-result">
			<h3 style="position: absolute; top:0; text-align: center; width: 100%; transform: translate(0, 0); z-index:100;">Click to See More</h3>
			<div class="result-inner"></div>
		</div>
	</div>

	<!-- <script type="text/javascript">navmenuInit();</script> -->
	<script src="http://www.webglearth.com/v2/api.js"></script>
	<script type="text/javascript" src="/resources/custom/js/main.js"></script>
</body>
</html>
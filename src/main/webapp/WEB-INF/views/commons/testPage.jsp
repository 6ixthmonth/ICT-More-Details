<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/commons/navmenuHeader.jsp" %>

	<style type="text/css">
		/* custom css for this page */
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/commons/navmenuBar.jsp" %>

	<div class="canvas">
		<div class="page-header">
			<h1>Example page header <small>Subtext for header</small></h1>
		</div>
		<form class="navbar-form navbar-left" role="search" action="/test/search" method="get">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search" name="searchWord">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<c:forEach items="${photoList }" var="photo">
			<div>${photo }</div>
		</c:forEach>
	</div>
	<!-- <script type="text/javascript">navmenuInit();</script> -->
	<script type="text/javascript">
		// custom script for this page
	</script>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<html>
<head>
<title>Scheduleeeeee</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="https://momentjs.com/downloads/moment.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"> -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="${contextPath}/resources/js/jquery.min.js"></script>
<script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">

<link
	href="${contextPath}/resources/css/bootstrap/bootstrap-datetimepicker.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/groupSchedule.css"
	rel="stylesheet">
<script
	src="${contextPath}/resources/js/bootstrap/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/index.css">
</head>
<body>
	<div id ="home"></div>
	<div class="site-wrapper">
		<div class="site-wrapper-inner" style="height:100%">
			<div class="masthead clearfix" style="width:100%;background:#333;opacity:0.8">
				<div class="container inner" style="background:#333;opacity:0.8">
					<h3 class="masthead-brand" id="nure">
						<a href="#home" onclick="clearAfterRefHome()"><b>NURE</b></a>
					</h3>
					<nav>
						<ul class="nav masthead-nav">
							<li class="active"><a href="#">Student</a></li>
							<li><a href="${contextPath}/teacherList" >Prepody</a></li>
							<li><a href="#">Classroom</a></li>
						</ul>
					</nav>
					<h3 class="w3-border-bottom w3-border-light-grey w3-padding-16"></h3>
				</div>
			</div>
			<div class="inner cover">
				<h1 class="cover-heading">Schedule</h1>
				<p class="lead">Cover is a one-page template for building simple
					and beautiful home pages. Download, edit the text, and add your own
					fullscreen background photo to make it your own.</p>
				<p class="lead">
					<button type="button" class="btn btn-lg btn-default"
						id="startButton">Let's get started!</button>
				</p>
			</div>	</div></div>

			<div class="site-wrapper">
			<div id="facultyButtonList" style="height:100%; margin-left:2%;padding-top:5%">
				<h3 class="w3-padding-16">Projects</h3>
				<div>
					<c:forEach var="item" items="${university.facultyList}">
						<button type="button" class="btn btn-lg btn-default" style="margin-right:0.5%;margin-top:0.5%"
							onclick="facultyQuery(this)" value="${item.id}">${item.shortName}</button>
					</c:forEach>
				</div>
				<div id="directionList"></div>
			</div>
	</div>
	
	<script src="${contextPath}/resources/js/groupSchedule.js"></script>
</body>
</html>
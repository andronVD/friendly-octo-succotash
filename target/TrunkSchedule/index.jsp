<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<html>
<head>
<meta http-equiv="refresh" content="0; url=groupSchedule.html" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>IndexSchedule</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link rel="stylesheet" href="${contextPath}/resources/css/index.css">
<style type="text/css">
	body{
		background: #333;
	}
	#preloader {
		display: block;
		position: fixed;
		z-index: 99999;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		min-width: 1000px;
		background: #333
			url(http://hello-site.ru//main/images/preloads/bars.svg) center center
			no-repeat;
		background-size: 41px;
	}
</style>
</head>

<body>
	
	<a href="groupSchedule.html">Click here to See scheduleee
			Message... </a>
	<div id="preloader"></div>
	<script type="text/javascript">
	var preloader = document.getElementById("preloader");
	function fadeOutnojquery(el) {
		el.style.opacity = 1;
		var interpreloader = setInterval(function() {
			el.style.opacity = el.style.opacity - 0.05;
			if (el.style.opacity <= 0.05) {
				clearInterval(interpreloader);
				preloader.style.display = "none";
			}
		}, 16);
	}
	window.onload = function() {
		setTimeout(function() {
			fadeOutnojquery(preloader);
		}, 1000);
	};
	</script>
</body>
</html>
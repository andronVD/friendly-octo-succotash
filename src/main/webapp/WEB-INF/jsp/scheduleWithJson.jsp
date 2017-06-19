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
	<div style="width: 500px;">
		<div class="table-responsive">
    		<table class="table">
				<thead>
					<tr>
						<c:forEach var="item" items="${event}">
							<th>${item.startTime}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<c:forEach var="item" items="${event}"  varStatus="status">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>2</td>
						<c:forEach var="item" items="${event}">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
					<tr>	
						<td>3</td>
						<c:forEach var="item" items="${event}">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>4</td>
						<c:forEach var="item" items="${event}">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>5</td>
						<c:forEach var="item" items="${event}">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>6</td>
						<c:forEach var="item" items="${event}">
							<td>${item.subject.brief}</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
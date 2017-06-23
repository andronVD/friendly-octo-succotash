<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>Scheduleeeeee</title>
<style type="text/css">
body {
	background-image: url('https://crunchify.com/bg.png');
}
</style>
</head>
<body>

	<br>
	<br>
	<div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		${faculty.getFullName()}<p>
		${faculty.getShortName()}
	</div>
	<br>
	<br>
	<div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<c:forEach var="department" items="${faculty.department}">
		    <p><c:out value = "${department.id}"/> - <c:out value = "${department.fullName}"/>- <c:out value = "${department.shortName}"/></p>
		</c:forEach>
	</div>
</body>
</html>
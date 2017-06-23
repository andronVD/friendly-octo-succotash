<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
		<select name="faculties">
          <c:forEach var="item" items="${university.facultyList}">
            <option value="${item.id}">${item.fullName}</option>
          </c:forEach>
        </select>
	</div>
	<br>
	<br>
	<div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<select name="directions">
          <c:forEach var="itemFac" items="${university.facultyList}">
          	<c:forEach var="item" items="${itemFac.directionList}">
            	<option value="${item.id}">${item.fullName}</option>
			</c:forEach>          
          </c:forEach>
        </select>
	</div>
	<br>
	<br>
	<%-- <div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<select name="specialities">
          <c:forEach var="itemFac" items="${university.facultyList}">
          	<c:forEach var="itemDir" items="${itemFac.directionList}">
            	<c:forEach var="item" items="${itemDir.specialityList}">	
            		<option value="${item.id}">${item.fullName}</option>
				</c:forEach>
			</c:forEach>          
          </c:forEach>
        </select>
	</div>
	<br>
	<br> --%>
	<%-- <div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<select name="groups">
          <c:forEach var="itemFac" items="${university.facultyList}">
          	<c:forEach var="itemDir" items="${itemFac.directionList}">
            	<c:forEach var="item" items="${itemDir.groupList}">		
            		<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</c:forEach>          
          </c:forEach>
        </select>
	</div>
	<br>
	<br>
	<div style="padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<select name="groups">
          <c:forEach var="itemFac" items="${university.facultyList}">
          	<c:forEach var="itemDir" items="${itemFac.directionList}">
				<c:forEach var="itemSpec" items="${itemDir.specialityList}">		
            		<c:forEach var="item" items="${itemSpec.groups}">
            			<option value="${item.id}">${item.name}</option>
					</c:forEach>
				</c:forEach>
			</c:forEach>          
          </c:forEach>
        </select>
	</div> --%>
</body>
</html>
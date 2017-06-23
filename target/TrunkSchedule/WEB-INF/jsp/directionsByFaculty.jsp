<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>
<br>
<c:forEach var="itemDir" items="${faculty.directionList}">
	<button type="button" class="btn btn-lg btn-default" style="background-color:#b2b2b2;border:#b2b2b2;margin-right:0.5%;margin-top:0.5%" onclick="directionQuery(this)" 
		value="${itemDir.id}">${itemDir.fullName}</button>
		
</c:forEach>

<div id="groupList" class="table">
</div>

<input type="hidden" id="idFaculty" value="${faculty.id}">
<input type="hidden" id="idDirection">

<script type="text/javascript">
	function directionQuery(elem) {
		$('#directionList button').removeClass('active');
		$(elem).addClass('active');
		$('#idDirection').val($(elem).val());
		var data = {
			idDirection : $(elem).val(),
			idFaculty : $('#idFaculty').val()
		}
		console.log('idFac:' + data.idFaculty);
		console.log('idDirection: '+$('#idDirection').val());
		$.post('${contextPath}/groupsByDirection', data, function(data) {
			$('#groupList').html(data);
		});
	}
</script>
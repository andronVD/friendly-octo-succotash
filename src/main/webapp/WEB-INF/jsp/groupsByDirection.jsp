<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<br>
<style type="text/css">

</style>
<c:forEach var="itemGroup" items="${groupList}">
	<button type="button" class="btn btn-lg btn-default" style="background-color:#818181;border:#818181;margin-right:0.5%;margin-top:0.5%" value="${itemGroup.id}"
		onclick="selectedGroup(this)">${itemGroup.name}</button>
</c:forEach>
<div class="container">
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<div class="input-group date" id="datetimepickerStartDate">
					<input type="text" class="form-control" /> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2">
			<div class="form-group">
				<div class="input-group date" id="datetimepickerEndDate">
					<input type="text" class="form-control"/> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="scheduleTable">
</div>
<input type="hidden" id="idGroup">
<input type="hidden" id="startDate">
<input type="hidden" id="endDate">

<script type="text/javascript">
	function selectedGroup(elem) {
		$('#idGroup').val($(elem).val());
		$('#groupList button').removeClass('active');
		$(elem).addClass('active');
		console.log('idGroup: '+$('#idGroup').val());
		
		var data = {
    			idGroup 	: $('#idGroup').val(),
    			startDate 	: $('#startDate').val(),
        		endDate 	: $('#endDate').val()
    		}
		$.post('${contextPath}/scheduleData', data, function(data) {
			$('#scheduleTable').html(data);
        });
	}
	$(function () {
		 $('#datetimepickerStartDate').datetimepicker({
	            useCurrent: false,
	            format: 'DD.MM.YYYY',
	        });
	        $('#datetimepickerEndDate').datetimepicker({
	            useCurrent: false,
	            format: 'DD.MM.YYYY'
	        });
	        $("#datetimepickerStartDate").on("dp.change", function (e) {
	            $('#datetimepickerEndDate').data("DateTimePicker").minDate(e.date);
	            $('#startDate').val($('#datetimepickerStartDate').find("input").val());
	            console.log($('#startDate').val());
	            var data = {
	        			idGroup 	: $('#idGroup').val(),
	        			startDate 	: $('#startDate').val(),
	            		endDate 	: $('#endDate').val()
	        		}
	            $.post('${contextPath}/scheduleData', data, function(data) {
	    			$('#scheduleTable').html(data);
	            });
	        });
	        $("#datetimepickerEndDate").on("dp.change", function (e) {
	            $('#datetimepickerStartDate').data("DateTimePicker").maxDate(e.date);
	            $('#endDate').val($('#datetimepickerEndDate').find("input").val());
	            console.log($('#endDate').val());
	            var data = {
	        			idGroup 	: $('#idGroup').val(),
	        			startDate 	: $('#startDate').val(),
	            		endDate 	: $('#endDate').val()
	        		}
	            $.post('${contextPath}/scheduleData', data, function(data) {
	    			$('#scheduleTable').html(data);
	            });
	   });
	});
</script>
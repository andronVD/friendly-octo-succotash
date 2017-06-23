$(document).ready(function() {$('#startButton').on('click',function(event) {
			$('#facultyButtonList').css('display', 'block');
			$('html,body').animate({scrollTop : $("#facultyButtonList").offset().top}, 800);
	});
});

function clearAfterRefHome() {
	$('#facultyButtonList').css('display', 'none');
}

function facultyQuery(elem) {
	$('#facultyButtonList button').removeClass('active');
	$(elem).addClass('active');
	var data = {
		idFaculty : $(elem).val()
	}
	$.post('/TrunkSchedule/directionsByFaculty', data, function(data) {
		$('#directionList').html(data);
	});
}
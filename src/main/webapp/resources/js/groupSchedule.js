$(document).ready(function() {$('#startButton').on('click',function(event) {
			$('#facultyButtonList').css('display', 'block');
			$('html,body').animate({scrollTop : $("#facultyButtonList").offset().top}, 800);
			//$(window).scroll(function() {var distanceTop = $('#facultyButtonList').offset().top- $(window).height();
		//});
	});
						/*	var stickyNavTop = $('#stickyNavbar').offset().top;
							var stickyNav = function() {
								var scrollTop = $(window).scrollTop();
								if (scrollTop > stickyNavTop) {
									$('#startButton').css('display', 'none');
									$('#scheduleSpan').css('opacity', '0');
								} else {
									$('#startButton').css('display', 'block');
									$('#scheduleSpan').css('opacity', '1');
								}
							};
							stickyNav();
							$(window).scroll(function() {
								stickyNav();
							});*/
						});


function facultyQuery(elem) {
	$('#facultyButtonList button').removeClass('active');
	$(elem).addClass('active');
	var data = {
		idFaculty : $(elem).val()
	}
	$.post('/ControllerExample/directionsByFaculty', data, function(data) {
		$('#directionList').html(data);
	});
}
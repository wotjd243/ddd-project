	$(document).ready(function() {
		$("#intro").addClass("active");
	});
	var $topScroll = $(".topScroll");
	var $delay = 1000;

	$(window).scroll(function() {
		if($(this).scrollTop() > 700) {
			$topScroll.fadeIn();
		} else {
			$topScroll.fadeOut();
		}
	});


	$topScroll.on("click", function() {
		$("html, body").stop().animate({scrollTop: 0}, $delay);
	});
	
	
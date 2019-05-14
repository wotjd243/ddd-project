$(function() {
					$("#mainCarousel").owlCarousel({

				      navigation : false, // Show next and prev buttons
				      slideSpeed : 300,
				      paginationSpeed : 400,
				      lazyLoad : true,
				      loop:true,
				      dots:true,
				      dotsEach:true,
				      singleItem : true,
				      autoplay:true,
				      autoplayTimeout:5000,
				      autoplayHoverPause:true,
				      items : 1

				    });
					
					$("#staticCarousel").owlCarousel({

					      navigation : true, // Show next and prev buttons
					      navText: [
							   "<i class='fal fa-chevron-left fa2'></i>",
							   "<i class='fal fa-chevron-right fa2'></i>"
							],
					      slideSpeed : 300,
					      paginationSpeed : 400,
					      lazyLoad : true,
					      loop:true,
					      dots:false,
					      dotsEach:true,
					      singleItem : true,
					      autoplay:true,
					      autoplayTimeout:5000,
					      autoplayHoverPause:true,
					      items : 3,
					      responsiveClass:true,
					      responsive:{
					          0:{
					              items:2,
					              nav:true
					          },
					          480:{
					              items:3,
					              nav:true
					          }
					      }

					    });

		});
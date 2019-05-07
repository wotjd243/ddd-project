	$(document).ready(function() {
		
		
		$('.navigationMobile .tabWrap ul.nav-tabs li').hover(function() {
			var id = $(this).find('a').attr('href');
		
			console.log("id",id);
			$(this).addClass('active');
			$(id).addClass('show');
			$(id).addClass('active');
			
		},function(){
			$(this).removeClass('active');
			$('.navigationMobile .tabWrap .tab-content .tab-pane').removeClass('show');
			$('.navigationMobile .tabWrap .tab-content .tab-pane').removeClass('active');
		});

		 
		var windowWidthz = $(window).outerWidth();
		if(windowWidthz < 992 && windowWidthz > 767) {
			$('nav ul.theory li.root > a.rootA.other').text("예약/결과");
		}
		var menuBig = $('.sidebarMenu');
		
		$('#mobilemenu').on('click', function(e) {
			/* 기본동작 중지코드 ex) A태그 */
			e.preventDefault();
			/*  show - hide 반복 */
			
			$(this).toggleClass("active");
			
			if($(this).hasClass("active")){
				
				
				menuBig.css({
					right:0
				})
					
					
				$('.overlay92').fadeIn();
				
				$('html, body').css({'overflow': 'hidden', 'height': '100%'});
				
				
			}else{
				
				menuBig.css({
					right:-110+"%"
				});
				
			    $('.overlay92').fadeOut();
			    
			    $('html, body').css({'overflow': 'auto', 'height': '100%'});
			    
			    if($("#mainVisual")){
			    	visualModule($("#mainVisual > ul.visual_wrap > li.active").index());
			    }
			}
			
		});
		
		
		$('.overlay92').on('click', function () {
			
			$('#mobilemenu').removeClass("active");
			 
			menuBig.css({
				right:-110+"%"
			});
			
		    $('.overlay92').fadeOut();
		    
		    $('html, body').css({'overflow': 'auto', 'height': '100%'});
		    
		    if($("#mainVisual")){
		    	visualModule($("#mainVisual > ul.visual_wrap > li.active").index());
		    }
		    
		});
		
		$(".headerDoor").mouseover(function(){
			if(!$(".bannerBox").hasClass("active")){
				$(".bannerBox").addClass("active");
			}
		});
		
		$(".headerDoor").mouseleave (function(){
			if($(".bannerBox").hasClass("active")){
				$(".bannerBox").removeClass("active");
			}
		});
		
		/*ul 태그*/
        var $gnbList = $("ul.theory");
        var $gnbMenu = $gnbList.find("> li");
        /*span 태그*/
        var $gnbAcc = $(".liUnder");
        
        /* a 태그*/
        var menuGap = parseInt($gnbMenu.find("> a").css("paddingLeft"));
            
        $gnbMenu.on("mouseenter.hover focusin.hover", function(){
            var gnbAccPos = $(this).find("a").offset().left - $(".banner-container").offset().left; 
            var gnbWidth = $(this).find("a").width()*1;
            
            if( gnbAccPos === 0 ) {
                TweenMax.to( $gnbAcc, .1, { x : menuGap,width:gnbWidth } );
            } else {
                TweenMax.to( $gnbAcc, .1, { x : gnbAccPos+menuGap,width:gnbWidth } );
            }
        });
        
        var $uberSection =$(".uberSection");
        var $uberColumn =$uberSection.find(".uberColumn");
        
        $uberColumn.on("mouseenter.hover focusin.hover", function(){
        	
             var curIndex = $(this).index();
             
        	 var gnbAccPos = $gnbMenu.eq(curIndex).find("a").offset().left - $(".banner-container").offset().left; 
        	 var gnbWidth = $gnbMenu.eq(curIndex).find("a").width()*1;
        	
        	if( gnbAccPos === 0 ) {
        		TweenMax.to( $gnbAcc, .1, { x : menuGap,width:gnbWidth } );
        	} else {
        		TweenMax.to( $gnbAcc, .1, { x : gnbAccPos+menuGap,width:gnbWidth } );
        	}
        	
        });
		
	});
	
	$(window).resize(function() {
		var widthMove = $(window).width();

		$("section.wideBanner").css({
			width : widthMove
		});

	});
	
	//헤더 스크롤 고정
	$(document).ready(function() {
		var bodyOffset = $("body").offset();
		var $fixHeader = $(".bannerWrap");
		var $fixMenu = $(".introMenu");
		var $brandLogo = $(".brandLogo");
		
		/*var $lastScrollTop = 0;
		var $st = $(this).scrollTop();
		var $navHeight = $(".bannerWrap").outerHeight();
		console.log($st);
		console.log($navHeight);
		
		if($st > $lastScrollTop && $st > $navHeight) {
			$bannerBox.append('<div class="brandLogo">'+
					'<a href="/">'+
					'<img src="/images/hanshin_logo.png" alt=""/></a></div>');
		} else {
			if($st + $(window).height() < $(document).height()) {
				$(".brandLogo").remove();
			}
		}*/
		

		
		$(window).scroll(function() {
			
			
			
			if($(document).scrollTop() > bodyOffset.top) {
				
					
				$fixHeader.addClass("fixPosition");
				$fixMenu.addClass("fixPosition");
				$brandLogo.addClass("fixPosition")
				
				/*$bannerBox.append('<div class="brandLogo">'+
						'<a href="/">'+
						'<img src="/images/hanshin_logo.png" alt=""/></a></div>');*/
				
				
			} else {
				
				$fixHeader.removeClass("fixPosition");
				$fixMenu.removeClass("fixPosition");
				$brandLogo.removeClass("fixPosition");
			}
			
		});
		
		$( window ).resize(function() {
		
			var windowWidthz = $(window).outerWidth();
		if(windowWidthz < 992 && windowWidthz > 767) {
			$('nav ul.theory li.root > a.rootA.other').text("예약/결과");
		}
		});
	});
	
	
	function wait() {
		swal("준비중입니다.");
		return false;
	}
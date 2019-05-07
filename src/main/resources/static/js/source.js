$(document).ready(function() {

  var flagSu = 0;
  $(".act").mouseover(function(){
			if(!$(".navigator").hasClass("active")){
				$(".navigator").addClass("active");
			}
		});

		$(".act").mouseleave (function(){
			if($(".navigator").hasClass("active")){
				$(".navigator").removeClass("active");
			}
		});



    $('header .navigator .uberWrap .uberMenu .uberColumn ul').mouseover (function(){
        var inindex = $('.uberColumn ul').index(this);
        var su = parseInt(inindex) + 1;

        $('header .navigator .naviHeaderWrap ul li:nth-of-type('+su+')').addClass('active');
        console.log("su",su);
    });

    $('header .navigator .uberWrap .uberMenu .uberColumn ul li').mouseout (function(){


    $('header .navigator .naviHeaderWrap ul li').removeClass('active');
    });

   var uber = $('header .navigator .naviHeaderWrap ul').width();
   var uberWidth = uber + "px";
   $('header .navigator .uberWrap .uberMenu').css('width',uberWidth);


    $('.naviHeaderWrap ul li:not(.active)').on('click', function () {
        var indexM = $('.naviHeaderWrap ul li').index(this);
        var suM = parseInt(indexM) + 1;

        console.log("suM",suM);
        $('.naviHeaderWrap ul li').removeClass('active');
          $(this).addClass('active');
          $('.mobileMenuWrap .mobileMenu').removeClass('active');
          if(flagSu!=suM) {
          $('.mobileMenuWrap .mobileMenu:nth-of-type('+suM+')').addClass('active');
          console.log("꾸요");
          flagSu = suM;
        }else {
          flagSu = 0;
          console.log("노꾸요");
          $('.naviHeaderWrap ul li').removeClass('active');
        }
       });



        $('header .anotherMobileWrap').on('click', function () {
            $('.headerWrap header .fixedMenu').css('right','0');
        });

        $('.fixedMenu .exit').on('click', function () {
        	  $('.headerWrap header .fixedMenu').css('right','-310px');
        });

        $('.headerWrap header .fixedMenu .menuSet .title .detail').on('click', function () {

           if(flagSu==0) {
                $(this).find('.fas').removeClass('fa-angle-down');
                $(this).find('.fas').addClass('fa-angle-up');
                flagSu =1;
                  console.log("flagSu1");
           }else {
             $(this).find('.fas').removeClass('fa-angle-up');
             $(this).find('.fas').addClass('fa-angle-down');
             flagSu =0;
               console.log("flagSu2");
           }
           $(this).parents('.menuSet').children('.inner').slideToggle();
        });

 });

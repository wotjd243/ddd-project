var text;

window.onload= function(){
	text = document.getElementById("")
}

$(function(){

		 var fileTarget = $('.filebox .upload-hidden');
		 $('.filebox .upload-hidden').on('change', function(){
        if(window.FileReader){
            // 파일명 추출
            var filename = $(this)[0].files[0].name;
        } 

        else {
            // Old IE 파일명 추출
            var filename = $(this).val().split('/').pop().split('\\').pop();
        };

        $(this).siblings('.upload-name').val(filename);
    });

    //preview image   
    var imgTarget = $('.preview-image .upload-hidden');

    $('.preview-image .upload-hidden').on('change', function(){
        var parent = $(this).parent();
        parent.find('.snip1384').remove();
		signFlag =true;
        if(window.FileReader){
            //image 파일만
            if (!$(this)[0].files[0].type.match(/image\//)) return;
            
            var reader = new FileReader(); 
            reader.onload = function(e){
                var src = e.target.result;
                
                $(".faqBox").prepend('<figure class="snip1384"><img alt="썸네일 업로드" src="'+src+'" class ="upload-thumb"><figcaption>');
                		
            }
            reader.readAsDataURL($(this)[0].files[0]);
        }

        else {
            $(this)[0].select();
            $(this)[0].blur();
            var imgSrc = document.selection.createRange().text;
            parent.prepend('<figure class="snip1384"><img alt="썸네일 업로드" src="" class ="upload-thumb"><figcaption>');

            var img = $(this).siblings('.upload-display').find('img');
            img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""+imgSrc+"\")";        
        }
        
});
    
});

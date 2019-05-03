var file = document.querySelector('#getfile');

file.onchange = function () { 
    var fileList = file.files ;
    
    // 읽기
    var reader = new FileReader();
    reader.readAsDataURL(fileList [0]);

    //로드 한 후
    reader.onload = function  () {
        //로컬 이미지를 보여주기
        document.querySelector('#preview').src = reader.result;
        
        //썸네일 이미지 생성
        var tempImage = new Image(); //drawImage 메서드에 넣기 위해 이미지 객체화
        tempImage.src = reader.result; //data-uri를 이미지 객체에 주입
        tempImage.onload = function() {
            //리사이즈를 위해 캔버스 객체 생성
            var canvas = document.createElement('canvas');
            var canvasContext = canvas.getContext("2d");
            
            //캔버스 크기 설정
            canvas.width = 100; //가로 100px
            canvas.height = 100; //세로 100px
            
            //이미지를 캔버스에 그리기
            canvasContext.drawImage(this, 0, 0, 100, 100);
            //캔버스에 그린 이미지를 다시 data-uri 형태로 변환
            var dataURI = canvas.toDataURL("image/jpeg");
            
        };
        
    }; 

    a();
}; 


function a(){

	var form = new FormData(
			document.getElementById('signForm'));
	
	$.ajax({
		type : "post",
		url : "/ImageUpload",
		data : form,
		processData : false,
		contentType : false,
		dataType : "json",
		success : function(fileInfo) { // fileInfo는 이미지 정보를 리턴하는 객체
			
			if (fileInfo.result === -1) { // 서버단에서 체크 후 수행됨
				alert('허용받은 확장자만 업로드 가능합니다.');
				return false;
			} else if (fileInfo.result === -2) { // 서버단에서 체크 후 수행됨
				alert('파일이 100MB를 초과하였습니다.');
				return false;
			} else if (fileInfo.result === -3) {
				alert('썸네일 이미지를 등록해주세요.');
				return false;
			}else {
				$("#imageSrc").val(fileInfo.thumburl);
			}
		},
		error : function(args) {
			console.log('error');
		}
	});
}


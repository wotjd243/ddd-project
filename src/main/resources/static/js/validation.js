/**
 * 
 */

function onlyNumber(obj) {
	// disabled 여부
	if($(obj).attr("readonly")){
	}else{
		$(obj).keyup(function(){
			$(this).val($(this).val().replace(/[^0-9]/g,""));
		}); 
	}
}

/**
 * 숫자만 입력가능하게 하는 함수
 */
function fn_onlyNumber(event){
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 9 || keyID == 46 || keyID == 37 || keyID == 39 )
		return;
	else
		return false;
}

function isValidDateStr(str) {
	var date = new Date(str);
	return !_.isNaN(date.getTime());
}

/**
 * 문자를 제거하는 함수
 */
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}

/**
 * 핸드폰 번호 입력할 때 자동대시
 * 11자리 : 000-0000-0000
 * 10자리 : 000-000-0000
 */
function autoDashPhoneNumber(str){
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	if( str.length < 4){
		return str;
	}else if(str.length < 7){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3);
		return tmp;
	}else if(str.length < 11){

		console.log(str.length)

		var ss = str.substr(0,2);
		if(ss == "02"){
			if(str.length == 10){
				tmp += str.substr(0,2);
				tmp += '-';
				tmp += str.substr(2, 4);
				tmp += '-';
				tmp += str.substr(6);
			}else{
				tmp += str.substr(0,2);
				tmp += '-';
				tmp += str.substr(2, 3);
				tmp += '-';
				tmp += str.substr(5);
			}
		}else{
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 3);
			tmp += '-';
			tmp += str.substr(6);
		}
		return tmp;
	}else{
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 4);
		tmp += '-';
		tmp += str.substr(7);
		return tmp;
	}
	return str;
}

/*생년월일 'YYYY-MM-DD' '1994-05-13'
 * 자동대시 */

function autoDashBirth(str){
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	if( str.length < 5){
		return str;
	}else if(str.length < 7){
		tmp += str.substr(0, 4);
		tmp += '-';
		tmp += str.substr(4);
		return tmp;
	}else{
		tmp += str.substr(0, 4);
		tmp += '-';
		tmp += str.substr(4, 2);
		tmp += '-';
		tmp += str.substr(6);
		return tmp;
	}
	return str;
}

$('.phoneCheck').on('keyup', function(event){
	var phone = this.value.trim();
	this.value = autoDashPhoneNumber(phone) ;
});

$('.birthCheck').on('keyup', function(event) {
	var birth = this.value.trim();
	this.value = autoDashBirth(birth);
})

function validateEmail($email) {
	var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
	return emailReg.test( $email );
}

function checkMaxNum(evt) {

	var _pattern = /^(\d{1,3}([.]\d{0,2})?)?$/;
	var _value = event.srcElement.value;

	if (!_pattern.test(_value)) {
		alert("1000 이하의 숫자만 입력가능하며,\n소수점 둘째자리까지만 허용됩니다.");
		event.srcElement.value = event.srcElement.value.substring(0,event.srcElement.value.length - 1);
		event.srcElement.focus();
	}
}

//maxlength 체크
function maxLengthCheck(object){
	if (object.value.length > object.maxLength){
		object.value = object.value.slice(0, object.maxLength);
	}    
}

function value_chk(formName) {
	var formObj = $("#"+formName);
	var objs = formObj.find("[not_null]");

	for(var i = 0; i < objs.length; i++) {
		if(objs.eq(i).val() == '') {
			alert(objs.eq(i).attr("nm") + '은(는) 필수입력사항입니다.');					
			objs.eq(i).focus();
			return false;
		}
	}
	return true;
}

/* 생년월일 유효성 체크 */

function checkDate(dateStr) {
	var str = dateStr.replace(/[^0-9]/g, '');
	var year = Number(str.substr(0,4)); 
    var month = Number(str.substr(4,2));
    var day = Number(str.substr(6,2));
    var today = new Date(); // 날짜 변수 선언
    var yearNow = today.getFullYear();
    var oMsg = $("#dateMsg");
    
    console.log("year: "+year);
    console.log("month: "+month);
    console.log("day: "+day);
    console.log("today: "+today);
    console.log("yearNow: "+yearNow);
    
    if ( dateStr == "") {
        showErrorMsg(oMsg,"＊ 생년월일을 반드시 입력해주세요.");
        return false;
    }
    
    if(year < 1900) {
    	showErrorMsg(oMsg, "＊ 년도를 확인하세요. 1900년 이후 출생자만 등록 가능합니다.");
    	return false;
    }
	
	if(year > yearNow) {
		showErrorMsg(oMsg, "＊ 년도를 확인하세요. "+yearNow+"년 이전 출생자만 등록 가능합니다.");
		return false;
	}
	
	if(month < 1 || month > 12) {
		showErrorMsg(oMsg, "＊ 달은 1월부터 12월까지 입력 가능합니다.");
		return false;
	}
	
	if(day < 1 || day > 31) {
		showErrorMsg(oMsg, "＊ 일은 1일부터 31일까지 입력 가능합니다.");
		return false;
	}
	
	if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		showErrorMsg(oMsg, month+"월은 31일이 존재하지 않습니다.");
        return false;
   }
	
	if(month == 2) {
		var isleap = (year % 4 == 0 && (year  % 100 != 0 || year % 400 == 0));
		if (day > 29 || (day == 29 && !isleap)) {
			showErrorMsg(oMsg, "*"+year+"년 2월은 " + day + "일이 존재하지 않습니다.");
			return false;
		}
	}
	
	hideMsg(oMsg);
	return true;
	
}

/*생년월일 유효성 체크*/
$("#birthDate").blur(function() {
	  dateFlag = false;
	 var dateStr= $("#birthDate").val();
	  checkDate(dateStr);
});

function showErrorMsg(obj, msg) {
    obj.attr("class", "error_next_box");
    obj.prev().addClass('errorBorder');
    obj.html(msg);
    obj.show();
}

function hideMsg(obj) {
    obj.prev().removeClass('errorBorder');
    obj.hide();
}

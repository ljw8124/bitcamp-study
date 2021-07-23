function inputCheck(frm) { //회원가입 유효성 검증
	var uid=frm.uid.value;
	uid=uid.replace(/^\s*|\s*$/g, '');
	if(uid.length<8 || uid.length>15) {
		alert("아이디 8~15글자 이내 입력바람!!");
		frm.uid.focus();
		return;
	}

	//비번, 비번확인 4~8글자 이내
	var upw=frm.upw.value;
	upw=upw.replace(/^\s*|\s*$/g, '');
	if(upw.length<4 || upw.length>8) {
		alert("비번 4~8글자 이내 입력바람!!");
		frm.upw.focus();
		return;
	}
	var upw2=frm.upw2.value;
	upw2=upw2.replace(/^\s*|\s*$/g, '');
	if(upw2.length<4 || upw2.length>8) {
		alert("비번 4~8글자 이내 입력바람!!");
		frm.upw2.focus();
		return;
	}
	//비번,비번확인이 일치하는지?
	if(upw!=upw2) {
		alert("비번 일치하지 않음!!");
		return;
	}

	var uname=frm.uname.value;
	uname=uname.replace(/^\s*|\s*$/g, '');
	if(uname.length<3) {
		alert("이름 3글자 이상 입력바람!!");
		frm.uname.focus();
		return;
	}

	//이메일에서 @문자 있는지 ?
	var email=frm.email.value;
	email=email.replace(/^\s*|\s*$/g, '');	
	if(email.indexOf("@")<0)	{
       alert("이메일 @문자 입력했는지 확인");
       frm.email.focus();
       return;
	}
	
	//phone2, phone3에 숫자모양으로 된 문자가 입력됬는지?
	//isNaN()
	var phone2=frm.phone2.value;
	phone2=phone2.replace(/^\s*|\s*$/g, '');
	if(isNaN(phone2)) {
       alert("전화번호 0~9문자만 사용 가능!!");
       frm.phone2.focus();
       return;
	}

	// .html 파일은 전송 불가
	var attache=frm.attache.value;
	attache=attache.replace(/^\s*|\s*$/g, '');
	if(attache.length>3) { //첨부파일명이 있다면
		var ext = attache.toLowerCase(); // 파일명을 소문자로 변환
		if (ext.lastIndexOf(".html") > 0){
			alert("파일의 확장자 HTML 전송불가");
			return;
		}
	}
	else {
		alert("첨부 파일 선택 바람!!");
		return;
	}

	frm.submit(); //type=submit 전송
} //end

function idCheck(frm) { //아이디 중복 확인
	var uid=frm.uid.value;
	uid=uid.replace(/^\s*|\s*$/g, '');
	if(uid.length<8) {
		alert("중복 확인 아이디 8~15글자 이내 입력바람!!");
		frm.uid.focus();
		return;
	}
	//새창     window.open("파일명","창이름","옵션")
	//창닫기  window.close()
	var win=	window.open("doubleid.html","kg","width=300,height=250");	
	//화면에 나오는 위치 지정
    var sx=screen.width; // 화면 전체 폭
    var sy=screen.height;// 화면 전체 높이

    var x=sx/2;
    var y=sy/2; //화면 정중앙 좌표
    
    win.moveTo(x,y);    //화면이동
}//end

function move() {
	window.location.href="http://www.daum.net";
    //window.location="";
	//location="";
}//end

function func() {
	//alert(parseInt("123")); //정수형 변환 "123" -> 123
	//alert(parseInt(4.5)); //4
	//alert(Number("123")); //숫자형 변환 "123" -> 123
	//alert(Number("4.5"));  //4.5
	//alert(eval("123")+eval("456")); //579
	//alert(eval("4.5")+eval("1.2")); //5.7

	/*var a1=10, a2=20, a3=30;
	for(n=1; n<=3; n++) {
		alert(eval(a+n)); //에러
	}*/
}
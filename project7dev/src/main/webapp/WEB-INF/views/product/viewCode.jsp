<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 전송 폼 작성하기</title>
<link rel="stylesheet" href="${contextPath }/resources/bootstrap/css/bootstrap.css"> 

</head>

<!-- html01.jsp -> html01_ok.jsp
	 내용 작성       작성한 내용 받기(server) -->

<body>
	<button class="btn1">클래스로 만든 버튼</button>
	<button id="btn2">아이디로 만든 버튼btn2</button>
	<button id="btnid">아이디로 만든 버튼btnid</button>
	<script type="text/javascript">
	alert("출력 확인합니다.");
	console.log("많이 피곤합니까???");
	
	function test(){
		alert("스크립트 함수");
	}
	
	//const: 고정값(상수), var: 기본 변수선언(바닐라자바스크립트?) let: 요즘엔 var보단 이거 씀
	const btn1 = document.querySelector('.btn1');
	//const btn1 = document.querySelector('#btnid');
	
	const btn2 = document.querySelector('#btn2');

	btn2.addEventListener('click', () => {
	    alert('버튼 2이 클릭되었습니다!');
	});
	
	//script에서의 function의 의미: 실행하기
	btn1.onclick = function(){
		console.log("111111");
	};
	
	btn2.onclick = function(){
		console.log("222222");
	}
	
	btnid.onclick = function(){
		console.log("안녕");
	};
	
	
	</script>
	
	<button id="pt" onclick="alert('클릭이 되니?')">클릭해줘!!!</button> <!-- alert: 버튼 클릭 시 팝업 -->
	<input type="button" value="버튼 클릭" onclick="test();"/>

	<h2>문서의 바디</h2>
	<div>
		<h2>로그인 폼</h2>
		<form action="html01_ok.jsp" method="get">		<!-- 처음엔 get으로 보낸다(get:주소에 보내는 정보 포함,post:미포함) -->
		아이디 : <input type="text" value="" name="id"><br>  		<!-- name이 중요함 -->
		패스워드 : <input type="text" value="" name="pass"><br>
		닉네임 : <input type="text" value="" name="nickname"><br>
		<input type="submit" value="전송">
		<input type="reset" value="재작성">
		<br><br>
		
		<p>ID : <input type="text" name="ID" size="15" required></p>
        <p>PW : <input type="password" name="psw" size="15" placeholder="비밀번호" required></p>
        <p></p>
        <input type="submit" value="전송">
        <input type="reset" value="다시작성">
		<p></p>	
			
		<textarea rows="5" cols="50">텍스트를 작성하는 공간입니다.</textarea>
		
		<fieldset>
            <legend>개인 정보 입력</legend>
            <p>이름 : <input type="text" name="name"></p>
            <p>학교 : <input type="text" name="school"></p>
            <input type="submit" value="제출">
            <input type="reset" value="다시작성">
        </fieldset>
		
		<h3>당신은 몇 학년입니까?</h3>
        <input type="radio" name="year" value="1" checked>1학년
        <input type="radio" name="year" value="2">2학년
        <input type="radio" name="year" value="3">3학년
        <input type="radio" name="year" value="4">4학년
		
		<h3>현재 관심을 가지고 있는 학습 주제는 무엇입니까?</h3> 
        <input type="checkbox" name="subject" value="HTML5" checked>HTML5 
        <input type="checkbox" name="subject" value="CSS3">CSS3 
        <input type="checkbox" name="subject" value="Javascript">Javascript 
        <input type="checkbox" name="subject" value="Jquery">Jquery
		
		<h3>Button 태그 사용</h3> 
        <button type="button" onclick="alert('클릭-1 사용')">클릭-1</button>
        <h3>Input 태그 사용</h3> 
        <input type="button" onclick="alert('클릭-2 사용')" value="클릭-2">
        <h3>Image 버튼 사용</h3> 
        <button type="button" onclick="alert('클릭-3 사용')"><img src="../images/p3.png" width='80' height='120'></button>
		<br>
		<select name="subjects">
            <option value="1" selected>HTML5</option>
            <option value="2">CSS3</option>
            <option value="3">Javascript</option>
            <option value="4">Jquery</option>
        </select>
            <br><br>
        <select name="subjects" size="4" multiple>
            <option value="1" >HTML5</option>
            <option value="2">CSS3</option>
            <option value="3">Javascript</option>
            <option value="4" selected>Jquery</option>
        </select>
        	<br><br>
        	<select name="major">
            <optgroup label="computer">
                <option>Software</option>
                <option>Robot</option>
                <option>System</option>
            </optgroup>
            <optgroup label="language">
                <option selected>Korea</option>
                <option>English</option>
                <option>China</option>
                <option>Germany</option>
            </optgroup>
            <optgroup label="business">
                <option>Service</option>
                <option>Education</option>
                <option>Communication</option>
                <option>Marketing</option>
            </optgroup>
        </select>
        <br><br>
        <label>전공 분야를 입력하세요.
            <input type="text" list="majorlist" name="major">
            <datalist id="majorlist">
                <option value="Software">소프트웨어</option>
                <option value="Robot">로봇</option>
                <option value="System">시스템</option>
                <option value="Service">서비스</option>
                <option value="Education">교육</option>
            </datalist>
        </label>
        
        <h3>오늘 날짜 입력</h3> 
        Today : <input type="date" name="today">
        <h3>프로젝트 수행 기간</h3> 
        From : <input type="date" name="from" min="2016-03-01" max="2016-12-31">
        To : <input type="date" name="to" min="2018-03-01" max="2018-06-30">
		
		<h3>생일(년/월) 입력</h3> 
        생일 : <input type="month" name="birth">
        <h3>주간 계획(년/주) 입력</h3> 
        주간 계획 : <input type="week" name="weekeend">
		
		<h3>현재 시간 입력</h3> 
        Time : <input type="time" name="Now">
        <h3>생일(년도, 월, 일, 시간) 입력</h3> 
        Birthday : <input type="datetime-local" name="bdaytime">
		
		<h3>원하는 색상을 선택하세요.</h3> 
        <input type="color" name="color_value" value="#0000ff">
		
		<h3>나이를 입력하세요.</h3> 
    	<input type="number" name="count" min="1" max="130">
		
		<h3>0~100 범위에서 원하는 지점을 선택하세요.</h3> 
        <input type="range" name="point" min="0" max="100">
		
		<h3>이메일을 정확하게 입력하세요.</h3> 
        이메일 : <input type="email" name="myemail">
        <input type="submit" value="제출">
        <input type="reset" value="다시작성">
        
		
		<h3>홈페이지 주소를 입력하세요.</h3> 
        홈페이지 : <input type="url" name="myhome">
        <input type="submit" value="제출">
        <input type="reset" value="다시작성">
        
		<h3>검색어를 입력하세요.</h3> 
        구글검색 : <input type="search" name="googlesearch">
		<input type="submit" value="제출">
        <input type="reset" value="다시작성">
		
		<p>쓰기가능 : <input type="text" name="name" size="20" placeholder="이름을 입력하세요" autofocus></p>
        <p>읽기전용 : <input type="text" name="name" size="10" readonly></p>
        <p>사용안함 : <input type="text" name="name" size="10" disabled></p>
        <p>자동완성 : <input type="text" name="name" size="10" autocomplete="on" required></p>
        <textarea cols="50" rows="3" spellcheck="true">오타를 체크합니다.</textarea>
		
		<h3>div 공간 분할</h3>
  	    <div style="background-color: #FFFF00;">div 첫 번째 영역입니다.</div>
        <div style="background-color: #00FF00;">div 두 번째 영역입니다.</div>
        <div style="background-color: #FF00FF;">div 세 번째 영역입니다.</div>
      	<p/>
        <h3>span 공간 분할</h3>
        <span style="background-color: #FFFF00;">span 첫 번째 영역입니다.</span>
    	<span style="background-color: #00FF00;">span 두 번째 영역입니다.</span>
    	<span style="background-color: #FF00FF;">span 세 번째 영역입니다.</span>
		      
		<h3>div/span 공간 분할 조합</h3>
        <div style="height: 70px; background-color: #FFFF00;">머리말 영역</div>
        <div style="height: 50px; background-color: #FF00FF;">본문 영역</div> 
        <span style="background-color: #FF0000;">왼쪽 텍스트 영역</span>
        <span style="background-color: #FFFFFF;">가운데 텍스트 영역</span>
        <span style="background-color: #0000FF;">오른쪽 텍스트 영역</span>
        <div style="height: 40px; background-color: #FFFF00;">꼬리말 영역</div>
		
		<!-- <iframe src="html01_ok.html" width="400" height="200" name="if_a" frameborder="0"></iframe> -->
		
		<iframe src="https://www.youtube.com/embed/LqME1y6Mlyg" width="300" height="200" name="music" frameborder="0"></iframe>

		<p></p>
		</form>
	
	</div>
</body>
</html>
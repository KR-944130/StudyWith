<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StartWith</title>
	<link rel="shortcut icon" href="/resources/favicon/favicon.png" />
	<link rel="stylesheet" href="/resources/style/home_logo_style.css" />
	<link rel="stylesheet" href="/resources/style/user/join_style.css" />
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Smooch+Sans&display=swap');
	</style>
</head>
<body>
	<jsp:include page="../home_logo.jsp" />
	<form id="join-form" action="/users/join" method="post">
	
		<div>
			<div>
				<label for="userEmail">이메일</label>
			</div>
			<div>
				<input id="userEmail" type="text" name="userEmail" placeholder="이메일" autocomplete="off" spellcheck="false" />
				<input id="auth-request-btn" type="button" value="인증번호 받기" />
			</div>
		</div>
		
		<div class="check">
			<input id="auth" type="text" placeholder="인증번호 입력" autocomplete="off" maxlength="6" readonly />
			<input id="auth-code-check-btn" type="button" value="인증" />
			<div id="mail-auth-text"></div>
		</div>
		
		<div>
			<div>
				<label for="userPw">비밀번호</label>
			</div>
			<div>
				<input id="userPw" type="password" name="userPw" placeholder="비밀번호" />
			</div>
		</div>
		
		<div>
			<div>
				<label for="userPwCheck">비밀번호 확인</label>
			</div>
			<div style="position: relative;">
				<input id="userPwCheck" type="password" name="userPwCheck" placeholder="비밀번호 확인" />
				<div id="pwCheckBox"></div>
			</div>
		</div>
		
		<div>
			<div>
				<label for="nickname">닉네임</label>
			</div>
			<div>
				<input id="nickname" type="text" name="nickname" placeholder="닉네임" autocomplete="off" spellcheck="false" />
				<input type="button" value="중복확인" />
			</div>
		</div>
		
		<div class="check">
			중복된 닉네임입니다.
		</div>
		
		<div>
			<div>
				<label for="userName">이름</label>
			</div>
			<div>
				<input id="userName" type="text" name="userName" placeholder="이름" autocomplete="off" spellcheck="false" />
			</div>
		</div>
		
		<div>
			<div>
				<label for="userPhone1">핸드폰 번호</label>
			</div>
			<div id="phone-container">
				<select id="userPhone1" name="userPhone1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="012">012</option>
					<option value="013">013</option>
					<option value="014">014</option>
					<option value="015">015</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				&nbsp;&nbsp;-&nbsp;&nbsp;
				<input id="userPhone2" type="text" name="userPhone2" autocomplete="off" maxlength="4" />
				&nbsp;&nbsp;-&nbsp;&nbsp;
				<input id="userPhone3" type="text" name="userPhone3" autocomplete="off" maxlength="4" />
			</div>
			<input type="button" value="중복확인" />
		</div>
		
		<div class="check">
			중복된 핸드폰 번호입니다.
		</div>
		
		<div>
			<div>
				<label for="userBirth">생년월일</label>
			</div>
			<div>
				<input id="userBirth" type="text" name="userBirth" placeholder="생년월일" autocomplete="off" maxlength="8" />
			</div>
		</div>
		
		<div>
			<div>
				<label>성별</label>
			</div>
			<div id="gender-container">
				<div>
					<span>남자</span>&nbsp;&nbsp;
					<div id="male" class="gender-box"></div>
				</div>
				<div>
					<span>여자</span>&nbsp;&nbsp;
					<div id="female" class="gender-box"></div>
				</div>
				<input id="userGender" type="hidden" name="userGender" />
			</div>
		</div>
		
		<div>
			<div>
				<label for="postcode">우편번호</label>
			</div>
			<div>
				<input type="text" id="postcode" name="postCode" placeholder="우편번호" readonly="readonly" onclick="execDaumPostcode()">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
			</div>
		</div>
		
		<div>
			<div>
				<label for="address">주소</label>
			</div>
			<div>
				<input type="text" id="address" name="address" placeholder="주소" readonly="readonly">
			</div>
		</div>
		
		<div>
			<div>
				<label for="detailAddress">상세주소</label>
			</div>
			<div>
				<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" autocomplete="off" spellcheck="false">
			</div>
		</div>
		
		<div>
			<div>
				<label for="extraAddress">참고항목</label>
			</div>
			<div>
				<input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목" readonly="readonly">
			</div>
		</div>
		
		<div>
			<div id="submit-btn">
				<span>가입</span>
			</div>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/resources/javascript/user/daum_postcode.js"></script>
	<script src="/resources/javascript/user/join.js"></script>
</body>
</html>
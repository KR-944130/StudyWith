
const joinForm = document.querySelector("#join-form");

const userEmail = document.querySelector("#userEmail");

const authRequestBtn = document.querySelector("#auth-request-btn");
authRequestBtn.addEventListener("click", function() {
	$.ajax({
		url: "/authMail",
		data: {userEmail : userEmail.value},
		type: "POST",
		contentType: "application/json; charset=utf-8",
		success: function(result, status, xhr) {
			auth.readOnly = false;
			auth.focus();
		},
		error: function(xhr, status, e) {
			console.log("error");
		}
	});
});

const auth = document.querySelector("#auth");
const authCodeCheckBtn = document.querySelector("#auth-code-check-btn");
const mailAuthText = document.querySelector("#mail-auth-text");
authCodeCheckBtn.addEventListener("click", function() {
	$.ajax({
		url: "/authMail/codeCheck",
		data: "authCode=" + auth.value,
		type: "POST",
		success: function(result, status, xhr) {
			if(result === "auth complete") {
				mailAuthText.innerText = "인증이 완료되었습니다.";
				mailAuthText.style.color = "#69f0ae";
			}
			else {
				mailAuthText.innerText = "인증번호가 일치하지 않습니다.";
				mailAuthText.style.color = "#ff5252";
			}
		},
		error: function(xhr, status, e) {
			console.log("error");
		}
	});
});

//	비밀번호
const userPw = document.querySelector("#userPw");
const userPwCheck = document.querySelector("#userPwCheck");
const pwCheckBox = document.querySelector("#pwCheckBox");

userPw.addEventListener("keyup", function() {
	if(userPwCheck.value !== "") {
		userPwCheck.value = "";
		pwCheckBox.style.backgroundColor = "transparent";
	}
});

userPwCheck.addEventListener("keyup", function() {
	if(userPwCheck.value === "") {
		pwCheckBox.style.backgroundColor ="transparent";
	}
	else {
		if(userPw.value === userPwCheck.value) {
			pwCheckBox.style.backgroundColor = "#69f0ae";
		}
		else {
			pwCheckBox.style.backgroundColor = "#ff5252";
		}
	}
});

//	성별
const male = document.querySelector("#male");
const female = document.querySelector("#female");
const userGender = document.querySelector("#userGender");

male.addEventListener("click", function() {
	male.style.backgroundColor = "#69f0ae";
	female.style.backgroundColor = "white";
	userGender.value = "남자";
});
female.addEventListener("click", function() {
	female.style.backgroundColor = "#69f0ae";
	male.style.backgroundColor = "white";
	userGender.value = "여자";
});

//	가입 폼 전송
const submitBtn = document.querySelector("#submit-btn");

submitBtn.addEventListener("click", function() {
	submitForm();
});

function submitForm() {
	if(userPw.value !== userPwCheck.value) {
		alert("비밀번호를 확인하세요");
		userPwCheck.value = "";
		userPwCheck.focus();
		return;
	}
	if(userGender.value === "") {
		alert("성별을 선택하세요");
		return;
	}
	joinForm.submit();
}

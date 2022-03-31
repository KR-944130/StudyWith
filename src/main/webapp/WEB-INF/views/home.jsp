<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<link rel="shortcut icon" href="/resources/favicon/favicon.png" />
	<title>StudyWith</title>
	<meta name="viewport" content="device-width, initial-scale=1">
	<link rel="stylesheet" href="/resources/style/home_style.css" />
	<link rel="stylesheet" href="/resources/style/home_logo_style.css" />
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Smooch+Sans&display=swap');
	</style>
</head>
<body>
	<jsp:include page="./home_logo.jsp" />
	<form id="login-form" class="flex-col-center">
		<input id="user-email" type="text" name="userEmail" placeholder="이메일" autocomplete="off" />
		<input id="user-pw" type="password" name="userPw" placeholder="비밀번호" />
		<input id="login-btn" class="hover-pointer" type="submit" value="로그인" />
	</form>
	<div class="join-find flex-col-center">
		<a href="/users/terms">회원가입</a>
		<a href="#">비밀번호찾기</a>
	</div>
</body>
</html>

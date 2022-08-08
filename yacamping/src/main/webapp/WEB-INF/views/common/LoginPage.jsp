<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/login.css">
</head>
<body>
<body>
	<section id="loginFormArea">
		<form action="/Login" method="post">
			<div class="wrap">

				<div class="login">

					<img src="resources/image/logo.png">
					<h2>야캠핑어때</h2>

					<div class="login_id">
						<input type="text" name="id" id="id" value="${cookie.id.value}" placeholder="ID">
					</div>

					<div class="login_pw">
						<input type="password" name="password" id="password"
							placeholder="Password">
					</div>

					<div class="login_etc">
						<div class="checkbox">
							<input type="checkbox" ${empty cookie.id.value ? "":"checked" } name="rememberId"> 아이디 저장하기
						</div>

						<div class="forgot_id_pw">
							<a href="">아이디/비밀번호 찾기</a>
						</div>

					</div>

					<p class="message">
						아직 회원이 아니신가요? <a href="/Agree">회원가입</a>
					</p>

					<div class="submit">
						<input type="submit" value="로그인">
					</div>

					<div class="line">SNS로 로그인하기</div>

					<div class="sns_login">
						<div class="kakao_login">
							<img src="resources/image/kakao.jpg"><input type="button"
								onclick="location.href='https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=ede4ce6fbe5d5ff53dd7eb0f8fce2ccb&redirect_uri=http://localhost:8080/kakaoLogin'" value="카카오 로그인"
								class="kakao">
						</div>
						<div class="naver_login">
							<img src="resources/image/naver.png"><input type="submit"
								value="네이버 로그인" class="naver">
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>
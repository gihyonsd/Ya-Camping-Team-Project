<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>야캠핑어때 회원가입</title>
  <link type="text/css" rel="stylesheet" href="resources/css/join.css">
  <script src="resources/js/join.js"></script>
  <script src="resources/js/jquery-3.6.0.min.js"></script>
  <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
  function fn_idChk(){
		$.ajax({
			url : "/idChk",
			type : "post",
			dataType : "json",
			data : {"id" : $("#id").val()},
			success : function(data){
				if(data == 1){
					alert("중복된 아이디입니다.");
				}else if(data == 0){
					$("#idChk").attr("value", "Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		})
	} 
  </script>
</head>

<body>

  <div class="wrap">
    <form name="joinForm" action="/register" method="POST" onsubmit="return do_submit();">
      <!--회원가입 박스 테두리-->
      <div class="join">
        <!--헤더-->
        <div class="headermom">
          <div class="header" onclick="location.href='/'">
            <img src="resources/image/logo-white.png">
            <p>야캠핑어때</p>
          </div>
        </div>

        <!--회원가입 컨텐츠-->
        <div class="join_content">

          <!--아이디,비밀번호 입력란-->
          <div class="row_group">

            <!--아이디 입력란-->
            <div class="join_row">
              <h3 class="join_title">
                <label for="id">아이디</label>
              </h3>
              <span class="inputid">
                <input type="text" id="id" name="id" class="enter" maxlength="15" placeholder="15자 이하로 입력하세요.">
                <button class="doubleid" type="button" id="idChk" onclick="fn_idChk();" value="N">중복체크</button>
              </span>
            </div>

            <!--비밀번호 입력란-->
            <div class="join_row">
              <h3 class="join_title">
                <label for="password">비밀번호</label>
              </h3>
              <span class="input">
                <input type="password" id="password" name="password" class="enter" maxlength="20" placeholder="숫자를 포함하여 6자 이상 16자 이하로 입력하세요." onchange="check_pw()">
              </span>

            </div>

            <!--비밀번호 재확인 입력란-->
            <div class="join_row">
              <h3 class="join_title">
                <label for="PASSWD2">비밀번호 재확인</label>
              </h3>
              <span class="input">
                <input type="password" id="password2" name="password2" class="enter" maxlength="20"
                  onchange="check_pw2()">
              </span>
              <span id="check"></span>

            </div>
          </div>
          <!-- 아이디,비밀번호 입력란 끝 -->

          <!-- 이름,닉네임,생년월일,성별 -->
          <div class="row_group">

            <!--이름 입력란-->
            <div class="join_row">
              <h3 class="join_title">
                <label for="name">이름</label>
              </h3>
              <span class="input">
                <input type="text" id="name" name="name" class="enter" maxlength="20">
              </span>
            </div>

            <!--닉네임 입력란-->
            <div class="join_row">
              <h3 class="join_title">
                <label for="nickname">닉네임</label>
              </h3>
              <span class="input">
                <input type="text" id="nickname" name="nickname" class="enter" maxlength="20">
              </span>
            </div>

            <!--생년월일 입력란-->
            <div class="join_row_bd">
              <h3 class="join_title">
                <label for="birth">생년월일</label>
              </h3>
              <span class="input">
                <input type="date" id="birth" name="birth" class="enter">
              </span>
            </div>

            <!--성별 체크란-->
            <div class="join_row_gender">
              <h3 class="join_title">
                <label for="gender">성별</label>
              </h3>
              <span class="input_gender">
                <input type="radio" name="gender" value="남" id="r1">
                <label for="r1">남</label>
              </span>
              <span class="input_gender">
                <input type="radio" name="gender" value="여자" id="r2">
                <label for="r2">여</label>
              </span>
              <span class="input_gender">
                <input type="radio" name="gender" value="선택안함" id="r3">
                <label for="r3">선택안함</label>
              </span>
            </div>
          </div>
          <!-- 이름,닉네임,생년월일,성별 끝-->

          <!-- 전화번호,이메일, 주소 -->
          <div class="row_group">

            <!-- 전화번호 -->
            <div class="join_row_phone">
              <h3 class="join_title">
                <label for="phone">전화번호</label>
              </h3>

              <div class="input_phone">
                <select id="nation" name="nation" class="sel">
                  <option value="+82" selected> 대한민국 +82 </option>
                  <option value="+852"> 홍콩 +852 </option>
                  <option value="+65"> 싱가포르 +65 </option>
                  <option value="+976"> 몽골 +976 </option>
                  <option value="+81"> 일본 +81 </option>
                  <option value="+86"> 중화인민공화국 +86 </option>
                  <option value="+49"> 독일 +49 </option>
                  <option value="+84"> 베트남 +84 </option>
                  <option value="+855"> 캄보디아 +855 </option>
                  <option value="+52"> 멕시코 +52 </option>
                </select>
                <input type="text" id="phone" name="phone" class="enter" placeholder="전화번호 입력" maxlength="16">
              </div>
            </div>

            <!--이메일-->
            <div class="join_row_email">
              <h3 class="join_title">
                <label for="email">이메일</label>
              </h3>
              <div class="input_email">
              <input type="hidden" name="email">
                <input name="email1" type="text" id="email1" class="enter"> @ <input name="email2" type="text" id="email2" class="enter1">
                <select name="select_email" onChange="selectEmail(this)">
                  <option value="" selected>선택하세요</option>
                  <option value="1">직접입력</option>
                  <option value="naver.com">naver.com</option>
                  <option value="gmail.com">gmail.com</option>
                  <option value="hanmail.com">hanmail.com</option>
                  <option value="nate.com">nate.com</option>
                </select>
              </div>
            </div>

            <!--주소-->
            <div class="join_row_adr">
              <h3 class="join_title">
                <label for="address">주소</label>
              </h3>
              <div class="input_ad">
                <div class="ad_post">
                  <input type="text" id="sample6_postcode" class="enter" name="address" placeholder="우편번호">
                  <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="ad_find">
                </div>
                <div class="ad_ad">
                  <input type="text" id="sample6_address" name="address" placeholder="주소">
                  <input type="text" id="sample6_detailAddress" name="address" placeholder="상세주소">
                  <input type="text" id="sample6_extraAddress" name="address" placeholder="참고항목">
                </div>
              </div>
            </div>

          </div>
          <!-- 전화번호,이메일,주소 끝-->
        </div>

        <!--가입하기 버튼-->
        <div class="join_end">
          <input type="submit" value="가입하기" class="join_click">
        </div>
        <!--가입하기 버튼 끝-->

        <!--푸터-->
        <div class="footer">
          <ul>
            <li>
              <a href="#">이용약관</a>
            </li>

            <li>
              <strong>
                <a href="#">개인정보처리방침</a>
              </strong>
            </li>

            <li>
              <a href="#">책임의 한계와 법적고지</a>
            </li>

            <li>
              <a href="#">회원정보 고객센터</a>
            </li>
          </ul>

          <address>
            <a href="main.html" class="logo">야캠핑어때</a>
            <p class="copy">Copyright ©야캠핑어때 Corp. All Rights Reserved</p>
          </address>

        </div>
        <!--푸터 끝-->


      </div>
    </form>
  </div>

</body>

</html>
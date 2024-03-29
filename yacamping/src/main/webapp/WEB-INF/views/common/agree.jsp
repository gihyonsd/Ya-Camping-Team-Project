<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>회원가입 이용약관</title>
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="resources/js/agree.js"></script>
  <link type="text/css" rel="stylesheet" href="resources/css/agree.css">
</head>


<body>
  <div class="wrap">
    <div class="container">
      <!--로고&타이틀-->
      <div class="headermom">
        <div class="header" onclick="location.href='/'">
          <img src="resources/image/logo-white.png">
          <p>야캠핑어때</p>
        </div>
      </div>

      <div class="allagree">
        <input type="checkbox" id="cbx_chkAll" class="chk" required>
        <label class="agree_ch">약관에 전체동의(선택사항 포함)
        </label>
      </div>
      <div class="line">
        이용약관 확인하기
      </div>

      <div class="agreetop">
        <form name="frmJoin" onSubmit="return CheckForm(this)" action="/register">
          <div class="agreemenu">

            <input type="checkbox" name="chk" class="chk" id="ck1"> 
            <label class="agree_main">
              이용약관 동의<div class="must">(필수)</div>
            </label>

            <a href="javascript:void(0)" class="menutitle"
              onclick="document.getElementById('agree_content1').style.display='block';document.getElementById('fade').style.display='block'">약관보기
              ></a>
            <div id="agree_content1" class="white_content">
              <div class="text1">제 1 조(목적) 이 약관은 '야캠핑어때' 주식회사(전자상거래 사업자)가 운영하는 '야캠핑어때' 사이버 몰(이
                하 '야캠핑어때 몰'라 한다)에서 제공하는 인터넷 관련 서비스(이하 '서비스'라 한다)를 이용함에 있어 사이버 몰과 이용자의 권리 의무 및 책임사항을 규정함을
                목적으로 합니다.
                ※「PC통신, 무선 등을 이용하는 전자상거래에 대해서도 그 성질에 반하지 않는
                한 이 약관을 준용합니다.」
                제 2 조(정의)
                ① '야캠핑어때 몰'이란 야캠핑어때 주식회사가 재화 또는 용역(이하 '재화 등'이라 함)을 이용자
                에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 등을 거래
                할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 사이버몰을 운영하는
                사업자의 의미로도 사용합니다.
                ② '이용자'란 '야캠핑어때 몰'에 접속하여 이 약관에 따라 '야캠핑어때 몰'이 제공하는 서비스를 받는 회원 및 비회원을 말합니다.
                ③ '회원'이라 함은 '야캠핑어때 몰'에 회원등록을 한 자로서, 계속적으로 '야캠핑어때 몰'이 제공하는 서비스를 이용할 수 있는 자를 말합니다.
                ④ '비회원'이라 함은 회원에 가입하지 않고 '야캠핑어때 몰'이 제공하는 서비스를 이
                용하는 자를 말합니다.</div>
              <a href="javascript:void(0)"
                onclick="document.getElementById('agree_content1').style.display='none';document.getElementById('fade').style.display='none'">
                <div class="close">닫기</div>
              </a>
            </div>
            <div id="fade" class="black_overlay"></div>
          </div>

          <div class="agreemenu">
            <input type="checkbox" name="chk" class="chk" id="ck2">
            <label class="agree_main">
              개인정보 수집 및 이용에 대한 안내<div class="must">(필수)</div>
            </label>
            <a href="javascript:void(0)" class="menutitle"
              onclick="document.getElementById('agree_content2').style.display='block';document.getElementById('fade').style.display='block'">약관보기
              ></a>
            <div id="agree_content2" class="white_content">
              <div class="text1">제 1 조 (목적) '야캠핑어때 주식회사'(이하 '야캠핑어때')은(는) 「개인정보 보호법」 제30조에 따라
                정보주체의
                개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리방침을 수립·공개합니다.<br>
                ○ 이 개인정보처리방침은 2022년 7월 25부터 적용됩니다.</div>
              <a href="javascript:void(0)"
                onclick="document.getElementById('agree_content2').style.display='none';document.getElementById('fade').style.display='none'">
                <div class="close">닫기</div>
              </a>
            </div>
            <div id="fade" class="black_overlay"></div>
          </div>

          <div class="agreemenu">
            <input type="checkbox" name="chk" class="chk">
            <label class="agree_main">
              위치정보 이용약관 동의<div class="notmust">(선택)</div>
            </label>
            <a href="javascript:void(0)" class="menutitle"
              onclick="document.getElementById('agree_content3').style.display='block';document.getElementById('fade').style.display='block'">약관보기
              ></a>
            <div id="agree_content3" class="white_content">
              <div class="text1">제 1 조 (목적)
                본 약관은 회원(서비스 이용약관에 동의한 자를 말합니다. 이하 '회원'이라고 합니다.)이 야캠핑어때 주식회사(이하 '회사'라고 합니다.)가 제공하는 위치기반서비스(이하 '서비스'라고
                합니다)를
                이용함에
                있어 회사와 회원의 권리·의무 및 책임사항을 규정함을 목적으로 합니다
                제 2 조 (개인위치정보의 이용 또는 제공)①회사는 개인위치정보를 이용하여 서비스를 제공하고자 하는 경우에는 미리 이용약관에 명시한 후 개인위치정보주체의 동의를 얻어야 합니다.

                ②회원 및 법정대리인의 권리와 그 행사방법은 제소 당시의 이용자의 주소에 의하며, 주소가 없는 경우에는 거소를 관할하는 지방법원의 전속관할로 합니다. 다만, 제소 당시 이용자의 주소
                또는
                거소가
                분명하지 않거나 외국 거주자의 경우에는 민사소송법상의 관할법원에 제기합니다.

                ③회사는 타사업자 또는 이용 고객과의 요금정산 및 민원처리를 위해 위치정보 이용·제공·사실 확인자료를 자동 기록·보존하며, 해당 자료는 6개월 이상 보관합니다.

                ④회사는 개인위치정보주체의 동의 없이 개인위치정보를 제3자에게 제공하지 아니하며, 제3자에게 개인위치정보를 제공하는 경우에는 제공 받는자 및 제공목적을 사전에 개인위치정보주체에게
                고지하고
                동의를
                받습니다.

                ⑤회사는 개인위치정보를 회원이 지정하는 제3자에게 제공하는 경우에는 개인위치정보를 수집한 당해 통신 단말장치로 매회 회원에게 제공받는 자, 제공일시 및 제공목적을 즉시 통보합니다.
                단, 아래
                각
                호의
                1에 해당하는 경우에는 회원이 미리 특정하여 지정한 통신 단말장치 또는 전자우편주소로 통보합니다.

                1. 개인위치정보를 수집한 당해 통신단말장치가 문자, 음성 또는 영상의 수신기능을 갖추지 아니한 경우

                2. 개인위치정보주체가 개인위치정보를 수집한 해당 통신단말장치 외의 통신단말장치 또는 전자우편주소 등으로 통보할 것을 미리 요청한 경우</div>
              <a href="javascript:void(0)"
                onclick="document.getElementById('agree_content3').style.display='none';document.getElementById('fade').style.display='none'">
                <div class="close">닫기</div>
              </a>
            </div>
            <div id="fade" class="black_overlay"></div>
          </div>


          <div class="agreemenu">
            <input type="checkbox" name="chk" class="chk">
            <label class="agree_main">
              이벤트 등 프로모션 알림 SNS 수신<div class="notmust">(선택)</div>
            </label>
            <a href="javascript:void(0)" class="menutitle"
              onclick="document.getElementById('agree_content4').style.display='block';document.getElementById('fade').style.display='block'">약관보기
              ></a>
            <div id="agree_content4" class="white_content">
              <div class="text1">제 1 조(목적) '야캠핑어때' 주식회사(이하 '야캠핑어때')에서 제공하는 이벤트/혜택 등 다양한 정보를
                휴대전화(알림
                또는 문자), 이메일로 받아 보실 수 있습니다. 일부 서비스(별도 회원 체계로 운영하거나 '야캠핑어때' 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도
                수신
                동의를
                받을
                수 있으며, 이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.
                제 2 조(미동의시 불이익 사항)개인정보보호법 제22조 제 4항에 의해 선택정보 제공 사항에 대해서 동의 거부를 하더라도 서비스 이용에는 제한되지 않습니다. 다만, '야캠피어때'에서
                제공되는
                할인,
                이벤트 및 다양한 서비스 상품 추천 등의 프로모션 정보 안내 서비스가 제한됩니다.</div>
              <a href="javascript:void(0)"
                onclick="document.getElementById('agree_content4').style.display='none';document.getElementById('fade').style.display='none'">
                <div class="close">닫기</div>
              </a>
            </div>
            <div id="fade" class="black_overlay"></div>
          </div>

    
            <input type="submit" value="동의하고 계속하기" class="agree_go">

        </form>

      </div>
    </div>
</body>

</html>
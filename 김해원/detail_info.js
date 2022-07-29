/*섬네일 이미지*/
$(".thumb li a").click(function () {
  var address = $(this).children("img");
  $("#zoom_img img").attr("src", address.attr("src")).attr("alt", address.attr("alt"));
  $(this).parent().addClass("on").siblings().removeClass("on");
  return false;
});

/*주소 복사*/
function copy_to_clipboard() {
  var copyText = document.getElementById('myInput');
   // 지정된 내용을 강조한다.
  copyText.select();
  copyText.setSelectionRange(0, 99999);
    // 텍스트를 카피 하는 변수를 생성
  document.execCommand("Copy");
  alert('주소가 스크립트에 복사되었습니다.');
}

/*캠핑장 소개 더보기/접기*/
$(document).ready(function(){

  $('.box').each(function(){
      var content = $(this).children('.content');
      var content_txt = content.text();
      var content_txt_short = content_txt.substring(0,300)+"...";
      var btn_more = $('<a href="javascript:void(0)" class="more">더보기</a>');

      
      $(this).append(btn_more);
      
      if(content_txt.length >= 300){
          content.html(content_txt_short)
          
      }else{
          btn_more.hide()
      }
      
      btn_more.click(toggle_content);
      // 아래 bind가 안 되는 이유는??
      // btn_more.bind('click',toggle_content);

      function toggle_content(){
          if($(this).hasClass('short')){
              // 접기 상태
              $(this).html('더보기');
              content.html(content_txt_short)
              $(this).removeClass('short');
          }else{
              // 더보기 상태
              $(this).html('접기');
              content.html(content_txt);
              $(this).addClass('short');

          }
      }
  });
});

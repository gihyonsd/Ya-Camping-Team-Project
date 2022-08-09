<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>


<form action="/board/booking?campnum=${board.campnum}&&startDate=<fmt:formatDate value="${setdate.startDate}" pattern="yyyy-MM-dd"/>&&endDate=<fmt:formatDate value="${setdate.endDate}" pattern="yyyy-MM-dd"/>" name="booking" method="post">
<input type="number" name="audult_no" value="audult_no">
<input type="number" name="child_no" value="child_no">
<c:out value="${board.campnum}"/>
<c:out value="${board.facltnm}"/><br>
<input type="hidden" name="totalprice" value="<c:out value="${board.price}" />">
<input type="hidden" name="kakao_id" value="${sessionScope.id }"/>
</form>
<button id="check_module" type="button">예약 + 결제</button>
<fmt:parseNumber value="${setdate.startDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"></fmt:parseNumber>
<fmt:parseNumber value="${setdate.endDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"></fmt:parseNumber>
<script>
	var form = document.booking;
	$("#check_module").click(function () {
		var IMP = window.IMP; // 생략가능
		IMP.init('imp12102116'); 
		// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
		// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
		IMP.request_pay({
			pg: 'kakaopay',
			pay_method: 'card',
			merchant_uid: 'orderid' + new Date().getTime(),
			/* 
			 *  merchant_uid에 경우 
			 *  https://docs.iamport.kr/implementation/payment
			 *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
			 */
			name: '${board.facltnm}',
			// 결제창에서 보여질 이름
			// name: '주문명 : ${auction.a_title}',
			// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
			amount: '${board.price * (endDate - strDate)}',
			// 가격 
			buyer_name: '이름',
			// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
			// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
			buyer_postcode: '123-456',
			}, function (rsp) {
				console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.' + "\n";
				msg += '캠핑장 이름: ' + rsp.name + "\n";
				msg += '결제 금액 : ' + rsp.paid_amount;
				form.submit();
				// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
				// 자세한 설명은 구글링으로 보시는게 좋습니다.
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
	});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	
		<title>회원탈퇴</title>
	</head>
	<script src="resources/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				location.href = "/mypage";   
			})
		
			$("#submit").on("click", function(){
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				$.ajax({
					url : "/passChk",
					type : "POST",
					dataType : "json",
					data : $("#delForm").serializeArray(),
					success: function(data){
						
						if(data==0){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("회원탈퇴하시겠습니까?")){
								$("#delForm").submit();
							}
						}
					}
				})
				
			});
			
				
			
		})
	</script>
	<body>
			<form action="/memberDelete" method="post" id="delForm">
				<div>
					<label for="id">아이디</label>
					<input type="text" id="id" name="id" value="${id}" readonly="readonly"/>
				</div>
				<div>
					<label for="password">패스워드</label>
					<input type="password" id="password" name="password" />
				</div>
			</form>
			<button id="submit">회원탈퇴</button>
			<button class="cancle" type="button">취소</button>
	</body>
	
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Password</title>
</head>
<body>
<form method="post" action="/findpassword">
		<div>
			<input type="text" id="id" name="id">
			<label for="id">ID</label>
		</div>
		
		<div>
			<input type="text" id="name" name="name">
			<label for="name">name</label>
		</div>
		
		<div>
			<input type="text" id="phone" name="phone">
			<label for="phone">phone</label>
		</div>

		<div>
			<input type="submit" value="check">
		</div>

		<!-- 정보가 일치하지 않을 때-->
		<c:if test="${check == 1}">
			<script>
				opener.document.findform.id.value = "";
				opener.document.findform.name.value = "";
				opener.document.findform.phone.value = "";
			</script>
			<label>일치하는 정보가 존재하지 않습니다.</label>
		</c:if>
		
		<c:if test="${check == 0 }">
			<div>
			<label>찾으시는 비밀번호는 '${password}' 입니다.</label>
				<input type="button" value="OK" onclick="closethewindow()">
			</div>
		</c:if>
	</form>
	
	<script type="text/javascript">
		function closethewindow(){
			self.close();
		}
	</script>
</body>
</html>
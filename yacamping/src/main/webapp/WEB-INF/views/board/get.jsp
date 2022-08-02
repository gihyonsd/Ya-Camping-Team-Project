<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="/board/booking?campnum=${board.campnum}&&startDate=<fmt:formatDate value="${setdate.startDate}" pattern="yyyy-MM-dd"/>&&endDate=<fmt:formatDate value="${setdate.endDate}" pattern="yyyy-MM-dd"/>" method="post">
<h2>startdate=${setdate.startDate}</h2>
<input type="number" name="audult_no" value="audult_no">
<input type="number" name="child_no" value="child_no">
<c:out value="${board.campnum}"/>
<c:out value="${board.facltnm}"/><br>
<input type="submit" value="예약하기">
</form>
</body>
</html>
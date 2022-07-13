<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #joinformArea{
      width : 400px;
      margin : auto;
      border : 1px solid gray;
   }
   table{
      width : 380px;
      margin :  auto;
      text-align: center;
   }
</style>
</head>
<body>
<section id = "joinformArea">
<form name="joinform" action="./memberJoinAction.me" method="post">
<table>
   <tr>
      <td colspan="2">
         <h1>회원가입 페이지</h1>
      </td>
   </tr>
   <tr>
      <td><label for = "ID">아이디 : </label> </td>
      <td><input type="text" name="ID" id = "ID"/></td>
   </tr>
   <tr>
      <td><label for = "PASSWD">비밀번호 : </label></td>
      <td><input type="password" name="PASSWD" id = "PASSWD"/></td>
   </tr>
   <tr>
      <td><label for = "NAME">이름 : </label></td>
      <td><input type="text" name="NAME" id = "NAME"/></td>
   </tr>
   <tr>
      <td><label for = "NICKNAME">닉네임 : </label></td>
      <td><input type="text" name="NICKNAME" id = "NICKNAME"/></td>
   </tr>
   <tr>
      <td><label for = "PHONE">전화번호 : </label></td>
      <td><input type="text" name="PHONE" id = "PHONE"/></td>
   </tr>
   <tr>
      <td><label for = "BIRTH">생년월일 : </label></td>
      <td><input type="text" name="BIRTH"  id = "BIRTH"/></td>
   </tr>
   <tr>
      <td><label for = "EMAIL">이메일 : </label></td>
      <td><input type="text" name="EMAIL" id = "EMAIL"/></td>
   </tr>
   <tr>
      <td><label for = "ADDRESS">주소 : </label></td>
      <td><input type="text" name="ADDRESS" id = "ADDRESS"/></td>
   </tr>
   <tr>
      <td><label for = "GENDER">성별 : </label></td>
      <td>
         <input type="radio" name="GENDER" value="남" checked="checked" id = "GENDER"/>남자
         <input type="radio" name="GENDER" value="여"/>여자
      </td>
   </tr>
   <tr>
      <td colspan="2">
         <a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
         <a href="javascript:joinform.reset()">다시작성</a>
      </td>
   </tr>
</table>
</form>
</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<h2>로그인</h2>
<hr>
<form action="loginAction.do">

아이디 : <input type="text" name="userid" value="${userid }"><br>
비밀번호: <input type="oassword" name="userpw" value="${userpw }"><br>
<button type="submit">로그인</button>


</form>

<hr>
<h4 style ="color: red">${errorMsg }</h4>
</body>
</html>
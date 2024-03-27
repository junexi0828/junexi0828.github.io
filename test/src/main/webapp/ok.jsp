<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>가입처리 성공</title>
</head>
<body>
<div style="width:400px;" align="center"> 
  <strong>성공적으로 가입처리 되었습니다.</strong><br><br>
</div>


이메일 주소: <%= request.getParameter("email") %><br>
비밀 번호: <%= request.getParameter("psw") %><br>
Remember me: <%= request.getParameter("remember") %><br>
<br>

</body>
</html>
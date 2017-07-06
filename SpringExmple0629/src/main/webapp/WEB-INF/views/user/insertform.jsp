<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>유저 정보 입력 ${message}</h1>
<form action="insert" method="post">
아이디 : <input type="text" name="userId"><br>
이름 : <input type="text" name="userName"><br>
비밀번호 : <input type="password" name="userPassword"><br>
비밀번호 확인 : <input type="password" name="userPasswordConfirm"><br> <!--type을 password라고 해야 입력한 내용이 안나타남 -->
역할 :  <input type="text" name="userRole"><br>
<input type="submit" value="저장">
<input type="submit" value="취소">

</form>
</body>
</html>
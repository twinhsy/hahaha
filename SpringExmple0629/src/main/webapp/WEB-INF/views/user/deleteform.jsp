<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호를 입력해주세요${message}</h1>
<form action="delete" method="post">
사용자 비밀번호 : <input type="password" name="userPassword">
<input type="submit" value=" 삭제 ">
</form>
</body>
</html>
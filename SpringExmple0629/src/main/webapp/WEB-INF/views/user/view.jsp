<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 정보</h1>
회원번호 : ${user.userId }<br>
회원이름 : ${user.userName }<br>
비밀번호 : ${user.userPassword }<br>
회원역할 : ${user.userRole }<br>
<a href="update">수정</a>

</body>
</html>
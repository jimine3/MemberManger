<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="menu.jsp"></jsp:include></div>
		<c:forEach items="dto" var="s">
			
		</c:forEach>
		<div><p></div>
		<div align="center">
			<div> <h3><c:if test="${sid != null}" >
			${name }님 환영합니다. </c:if></h3><p></div>
			<div> <h3>
			<c:if test="${sid == null}" >
				아이디 또는 패스워드가 일치하지 않습니다.<p>
				다시 로그인 해 주세요.&nbsp;&nbsp;
				<% session.invalidate();%>  <!-- 세션 삭제하기 -->
				<button type="button" onclick="location.href='LoginForm.do'">확인</button>
			 </c:if></h3><p></div>
		</div>
	</div>
</body>
</html>
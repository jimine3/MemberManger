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
		<div><p></div>
				<c:if test = "${sname == null }">
			<div><h3> 정상적으로aasasasasasasasasasasa않습니다.</h3></div>
		</c:if>
		<c:if test = "${sname != null }">
			<div><h3> ${sname } 님 정상적으로 로그아웃 되었습니다.</h3></div>
			<% session.invalidate(); %> <!-- 세션 삭제 -->
		</c:if>
	</div>
</body>
</html>
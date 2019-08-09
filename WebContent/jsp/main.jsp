<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 테스트 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<jsp:include page="menu.jsp"></jsp:include>
	<c:if test = "${sid != null }">
		<div> <p> </div>
		<div align="center">
			<h3> ${sname }님의 My page에 오신것을 환영합니다.</h3>
		</div>
		<div><img alt="아름다운 밤" src="./image/1.jpg"></div>
	</c:if>
	<c:if test = "${sid == null }">
		<div> <p> </div>
		<div align="center">
			<h3> 여기는 기본으로 보여주는  홈페이지 입니다.</h3>
		</div>
		<div><img alt="할수있다" src="./image/2.jpg"></div>
	</c:if>
</div>
</body>
</html>
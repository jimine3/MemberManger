<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<%
	String sname = (String) session.getAttribute("sname");  //세션정보 이름얻기
	String sid = (String) session.getAttribute("sid");  //세션정보 아이디얻기
	String sgrant = (String) session.getAttribute("sgrant"); //세션정보 권한얻기
%>   
<body>
<div id="memu" align="center">
	<nav id="topMenu">
		<ul>
			<li class="topMenuLi"><a class="menuLink" href="Index.do"> 홈 </a></li>
			<li>|</li>
			<li class="topMenuLi"><a class="menuLink" href="LoginForm.do">로그인</a>
			</li>
			<li>|</li>
			<li class="topMenuLi"><a class="menuLink" href="#">회원가입</a>
				<ul class="submenu">
				<c:if test="${sgrant == 'S' }">
					<li><a href="MemberList.do" class="submenuLink">회원목록</a></li>
				</c:if>
					<li><a href="Registr.do" class="submenuLink">등록</a></li>
					<li><a href="#" class="submenuLink">수정</a></li>
					<li><a href="#" class="submenuLink">삭제</a></li>
				</ul></li>
			<li>|</li>
			<li class="topMenuLi"><a class="menuLink" href="BorderList.do">자유게시판</a></li>
			<li>|</li>
			<li class="topMenuLi"><a class="menuLink" href="Logout.do">로그아웃</a></li>
		</ul>
	</nav>
</div>
</body>
</html>
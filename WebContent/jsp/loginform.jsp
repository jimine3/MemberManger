<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm() {
		var thisForm = document.frm;
		if(thisForm.id.value =='') {
			alert("아이디를 입력 하세요.");
			thisForm.id.focus();
			return false;
		}else if(thisForm.pw.value ==''){
			alert("패스워드를 입력하세요.");
			thisForm.pw.focus();
			return false;
		}
		
		thisForm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div><jsp:include page="menu.jsp"></jsp:include></div>
		<div><p></div>
		<c:if test="${sid == null }">  <!-- 유효한 세션을 확인한다. -->
		<div align="center">
			<div> <h3>로그인</h3><p></div>
			<div>
			<form name="frm" action="Login.do" method="post">
				<table border = "1">
					<tr>
						<td width="100" align="center"> 사용자 ID</td>
						<td width="200" align="center"><input type="text" id="id" name="id"> </td>
					</tr>
					<tr>
						<td width="100" align="center"> 패스워드</td>
						<td width="200" align="center"> <input type="text" id="pw" name="pw"></td>
					</tr>
				</table>
				<div><p></div>
				<div>&nbsp;&nbsp;&nbsp;<input type="button" onclick="checkForm();" value="로그인">
					&nbsp;&nbsp;&nbsp;<input type="reset" value="취 소">
				</div>
			</form>
			</div>
		</div></c:if>  <!-- 유효한 세션이 존재할 때 -->
		<c:if test = "${sid !=null }">
			<div><h3> ${sname }님 이미 로그인 하셨습니다.</h3></div>
		</c:if>
	</div>
</body>
</html>
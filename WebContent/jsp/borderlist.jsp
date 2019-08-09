<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formSubmit(n) {
		var form = document.frm_list;
		form.id.value=n;
		form.submit();
}
</script>
</head>
<body>
<div align="center">
	<div><jsp:include page="menu.jsp"></jsp:include></div>
	<div><p></div>
	<div align="center">
		<div>
		<h3>목록보기</h3><p>
		<form name="frm_list" action="BorderContents.do" method="post">
			<input type="hidden" name="id"> <!-- 레코드에 pk값을 전달할 변수 -->
		<table border = "1">
			<tr>
				<td width="70" align="center"> 글번호</td>
				<td width="100" align="center"> 작성자</td>
				<td width="250" align="center"> 제 목</td>
				<td width="100" align="center"> 작성일자</td>
				<td width="150" align="center"> 첨부파일</td>
				<td width="70"align="center"> 조회수</td>
			</tr>
				<c:if test = "${list[0].dto.bno != null }";>
				<c:forEach items="${list }" var="dto">
					<tr onmouseover="this.style.background='#FAF082'" onmouseout="this.style.background='white'"
						onclick="formSubmit(${dto.bNo })">					
						<td align="center">${dto.bNo }</td>
						<td align="center">${dto.writer }</td>
						<td align="center">${dto.subject }</td>
						<td align="center">${dto.wdate }</td>
						<td align="center">${dto.fileName }</td>
						<td align="center">${dto.hit}</td>
					</tr>
				</c:forEach>
				</c:if>
				<c:if test = "${list == null }">
				<tr>
					<td align="center" colspan="6">등록된 글이 없습니다.</td>
				</tr>
				</c:if>
		</table></form></div>
		<div> <p></div>
		<div>
		<c:if test = "${sid !=null }"> 
			<button type="button" onclick="location.href='Writer.do'">글쓰기</button>
		</c:if>
		</div>
	</div>
</div>
</body>
</html>
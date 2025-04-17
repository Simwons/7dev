<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재조회</title>
</head>
<body>
<h3>자재 리스트</h3>
<table border="1">
	<tr>
		<th>자재명</th>
		<th>자재코드</th>
		<th>선택</th>
	</tr>
	<c:forEach var="material" items="${materialList}">
	<tr>
		<td>${material.materialName}</td>
		<td>${material.materialCode}</td>
		<td>
			<button type="button" class="select-btn" data-name="${fn:escapeXml(material.materialName)}" 
			data-code="${fn:escapeXml(material.materialCode)}" data-no="${material.materialNo}">선택</button>
 		</td> 
	</tr>
	</c:forEach>
</table>

<script>
document.addEventListener("DOMContentLoaded", function () {
	const buttons = document.querySelectorAll(".select-btn");
	buttons.forEach(button => {
		button.addEventListener("click", function () {
			const name = this.dataset.name;
			const code = this.dataset.code;
			const materialNo = this.dataset.no;

			// 부모창 함수 호출
			window.opener.addMaterialToParent(name, code, materialNo);
			//window.close();
		});
	});
});
</script>

</body>
</html>

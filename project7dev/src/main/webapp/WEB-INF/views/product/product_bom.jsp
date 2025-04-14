<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="5" cellspacing="1">
		<thead>
			<tr>
				<th colspan="2">품목코드</th>
				<td colspan="2">${product.productCode}</td>
				<th colspan="2">품목명</th>
				<td colspan="2">${product.productName}</td>
				
			</tr>
			<tr>
				<th colspan="7">부품목록</th>
				<th><button type="button" onclick="openMaterialModal()">부품등록</button></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="2">부품코드</th>
				<th>부품명</th>
				<th>재질</th>
				<th>규격</th>
				<th>단위</th>
				<th>소요량</th>
				<th>투입레벨</th>
			</tr>
		</tbody>
		<tbody>
			<c:forEach var="material" items="${materialList}">
				<tr>
					<th colspan="2">${material.materialCode}</th>
					<th>${material.materialName}</th>
					<th>${material.materialRawMaterial}</th>
					<th>${material.materialDescription}</th>
					<th>${material.materialUnit}</th>
					<th>${material.materialQuantity}</th>
					<th>L1</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 부품등록 모달 -->
	<div id="materialModal" style="display:none; position:fixed; top:20%; left:35%; background:#fff; border:1px solid #000; padding:20px; z-index:1000;">
    <form action="${contextPath}/material/createMaterial" method="post">
  		<input type="hidden" name="productNo" value="${product.productNo}" />
        <label>부품코드: <input type="text" name="materialCode" required></label><br><br>
        <label>부품명: <input type="text" name="materialName" required></label><br><br>
        <label>소재: <input type="text" name="materialRawMaterial" required></label><br><br>
        <label>규격: <input type="text" name="materialDescription" required></label><br><br>
        <label>단위: <input type="text" name="materialUnit" required></label><br><br>
        <label>소요량: <input type="number" name="materialQuantity" required></label><br><br>
        <label>첨부파일: <input type="file" name="materialFile"></label><br><br>
        
        <button type="submit">등록</button>
        <button type="button" onclick="closeMaterialModal()">닫기</button>
    </form>
	</div>
	
	<!-- 배경 어둡게 -->
	<div id="modalBackdrop" style="display:none; position:fixed; top:0; left:0; width:100vw; height:100vh; background-color:rgba(0,0,0,0.5); z-index:999;"></div>
	
	<!-- 스크립트 -->
	<script>
	  function openMaterialModal() {
	    document.getElementById("materialModal").style.display = "block";
	    document.getElementById("modalBackdrop").style.display = "block";
	  }
	
	  function closeMaterialModal() {
	    document.getElementById("materialModal").style.display = "none";
	    document.getElementById("modalBackdrop").style.display = "none";
	  }
	</script>

</body>
</html>
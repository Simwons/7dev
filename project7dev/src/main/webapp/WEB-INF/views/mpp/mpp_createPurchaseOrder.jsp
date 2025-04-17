<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매발주서 보기</title>
<style>
	@media print {
		button {
			display: none;
		}
		#printArea {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
		}
	}
</style>
</head>
<body>
<form action="${contextPath}/purchaseOrder/register" method="post">
	<input type="hidden" name="emp_no" value="${mpp.empNo}"/>
	<input type="hidden" name="purc_order_code" value="${mpp.mppCode}" />
	<input type="hidden" name="purc_order_status" value="${0}" />
		<div id="printArea">
		<h2>구매발주서</h2>
		<table border="1">
			<tr>
				<td colspan="4">
					작성일 : 
					<fmt:parseDate value="2000-01-01 00:00:00" pattern="yyyy-MM-dd HH:mm:ss" var="regDate" />
					<fmt:formatDate value="${regDate}" pattern="yyyy년 MM월 dd일 E요일" />
				</td>
				<td colspan="3">
					납기일 : ${fn:substring(mpp.mrpDueDate, 0, 10)}
				</td>
				<td colspan="3">
					발주번호 : ${mpp.mppCode}
				</td>
			</tr>
			<tr>
				<td colspan="5">공급자</td>
				<td colspan="5">공급받는자</td>
			</tr>
			<tr>
				<td colspan="2">등록번호</td>
				<td colspan="3">${sup.supRegNo}</td>
				<td colspan="2">등록번호</td>
				<td colspan="3">${company.compRegNo}</td>
			</tr>
			<tr>
				<td>상 호</td>
				<td colspan="2">${sup.supName}</td>
				<td>성 명</td>
				<td>${sup.supCeoName}</td>
				<td>상 호</td>
				<td colspan="2">${company.compName}</td>
				<td>성 명</td>
				<td>${company.compCeoName}</td>
			</tr>
			<tr>
				<td>주 소</td>
				<td colspan="4">${sup.supAddr1} ${sup.supAddr2}</td>
				<td>주 소</td>
				<td colspan="4">${company.compAddr1} ${company.compAddr2}</td>
			</tr>
			<tr>
				<td>담당자</td>
				<td>${sup.supCip}</td>
				<td>담당자 이메일</td>
				<td colspan="2">${sup.supCipEmail}</td>
				<td>담당자</td>
				<td>${mrp.empName}</td>
				<td>담당자 이메일</td>
				<td colspan="2">${mrp.empEmail}</td>
			</tr>
			<tr>
				<td colspan="10"><br></td>
			</tr>
			<tr>
				<td>NO</td>
				<td>품목</td>
				<td>품목번호</td>
				<td>규격</td>
				<td>단위</td>
				<td>단가</td>
				<td>수량</td>
				<td>소계</td>
				<td>화폐단위</td>
				<td>비고</td>
			</tr>
			
			<c:set var="totalCnt" value="0" />
			<c:set var="totalPrice" value="0" />
			
			<c:forEach var="material" items="${mrpList}" varStatus="status">
			<tr>
				<td>${material.materialNo}</td>
				<td>${material.materialName}</td>
				<td>${material.materialCode}</td>
				<td>${material.materialDescription}</td>
				<td>${material.materialUnit}</td>
				<td>${material.sellMprice}</td>
				<td>${material.mrpQuantity}</td>
				<td>${material.sellMprice * material.mrpQuantity}</td>
				<td>${material.mpriceCurrency}</td>
				<td><input type="text" name="purcOrderEtc"/></td>
			</tr>
			
			<c:set var="totalCnt" value="${totalCnt + material.mrpQuantity}" />
			<c:set var="totalPrice" value="${totalPrice + (material.sellMprice * material.mrpQuantity)}" />
			
			</c:forEach>
			<tr>
				<td colspan="6">합 계</td>
				<td>${totalCnt}</td>
				<td>${totalPrice}</td>
				<td colspan="2"></td>
			</tr>
		</table>
		</div>
		<input type="submit" value="저장"/>
		<button type="button" onclick="history.back()">닫기</button>
	</form>
</body>
</html>
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
<title>자재소요계획</title>
<style>
.scroll-table {
	width: 100%;
	border-collapse: separate;
	table-layout: fixed;
}

.scroll-table thead {
	background-color: #f2f2f2;
}

.scroll-table th, .scroll-table td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: center;
	word-wrap: break-word;
}

.scroll-container {
  height: 300px;     /* 고정 높이로 박스 크기 만들기 */
  overflow-y: auto;      /* 이 안에서만 스크롤 */
  border: 1px solid #ccc;
  margin-top: 10px;
  margin-bottom: 10px;
  box-shadow: 0 0 5px rgba(0,0,0,0.1);
  border-radius: 4px;
}

.sticky-row th, fix {
	position: sticky;
	background-color: #fff;
	z-index: 2;
}

.scroll-container thead th {
  position: sticky;
  top: 0;
  background-color: #fff;
  z-index: 2;
}

.label-cell {
	background-color: #7EFFAF;
	font-weight: semibold;
}
#fix {
  position: sticky;
  left: 0;
  background-color: #fff;
  z-index: 3;
}
.label-cell {
  background-color: #7EFFAF;
  font-weight: semibold;
}	

</style>
<h1>부품조달계획 등록</h1>
</head>
<body>
<form action="${contextPath}/mpp/createMpp" method="post">
	<input type="hidden" name="mrpDueDate" value="${mrp.mrpDueDate}"/>
	<input type="hidden" name="mppCode" value="${mppCode}" />
	<input type="hidden" name="mppVer" value="${mppVer}" />
	<input type="hidden" name="mppRegDate" value="${today}" />
	<input type="hidden" name="mrpNo" value="${mrp.mrpNo}" />
	<input type="hidden" name="empNo" value="${mrp.empNo}" />
	<input type="hidden" name="prplNo" value="${mrp.prplNo}" />
	
	<table border="1" cellpadding="5" cellspacing="0" style="width: 100%; margin-bottom: 10px;">
		<thead class="sticky-row">
			<tr>
				<td class="label-cell" style="width:15%;">부품조달계획코드</td>
				<td style="width:35%;">${mppCode}</td>
				<td class="label-cell" style="width:15%;">수립일</td>
				<td style="width:35%;">${today}</td>
			</tr>
			<tr>
				<td class="label-cell" style="width:15%;">차수</td>
				<td style="width:35%;">${mppVer}</td>
			</tr>
		</thead>
	</table>
	<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
		<thead class="sticky-row">
			<tr>
				<td class="label-cell" style="width:15%;">제품명</td>
				<td style="width:35%;">${mrp.productName}</td>
				<td class="label-cell" style="width:15%;">제품코드</td>
				<td style="width:35%;">${mrp.productCode }</td>
			</tr>
			<tr>
				
				<td class="label-cell" style="width:15%;">자재납기일</td>
				<td style="width:35%;">${fn:substring(mrp.mrpDueDate, 0, 10)}</td>
			</tr>
		</thead>
	</table>
					
	<div class="scroll-container">
		<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">	
			<thead class="sticky-row">	
				<tr style="position: sticky; background-color: #fff;">
					<th class="label-cell" colspan="6">소요자재 목록</th>
				</tr>
				<tr style="position: sticky; top: 36px; background-color: #fff;">
					<th style="width:15%;">자재명</th>
					<th style="width:20%;">자재코드</th>
					<th style="width:15%;">자재창고</th>
					<th style="width:10%;">순소요량</th>
					<th style="width:10%;">포장단위</th>
					<th style="width:10%;">리드타임(일)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="mrpList" items="${mrpList}">
					<tr>
						<td>${mrpList.materialName}</td>
						<td>${mrpList.materialCode}</td>
						<td>${mrpList.mstorageCode}</td>
						<td>${mrpList.mrpQuantity}</td>
						<td>${mrpList.mrpSku}</td>
						<td>${mrpList.mrpLeadtime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
		<tr>
	        <td class="label-cell" style="width:15%;">사원번호</td>
	        <td style="width:35%;">${mrp.empNo}</td>
	        <td class="label-cell" style="width:15%;">담당자명</td>
	        <td style="width:35%;">${mrp.empName}</td>
	    </tr>
		<tr>
	        <td class="label-cell" style="width:15%;">담당자 연락처</td>
	        <td style="width:35%;">${mrp.empPhone}</td>
	        <td class="label-cell" style="width:15%;">담당자 메일</td>
	        <td style="width:35%;">${mrp.empEmail}</td>
	    </tr>
	    <tr>
	    	<td colspan="4"></td>
	    </tr>
			<tr>
	        <td class="label-cell" style="width:15%;">기타사항</td>
	        <td colspan="3" style="width:35%;">
	         <textarea name="mppEtc" rows="4" cols="110">${mrp.mrpEtc}</textarea>
	        </td>
	    </tr>
	</table>
	<div style="text-align: center; margin-top: 20px;">
		<button type="submit">등록</button>
     	<button type="button" onclick="history.back()">닫기</button>
    </div>
</form>   
</body>
</html>
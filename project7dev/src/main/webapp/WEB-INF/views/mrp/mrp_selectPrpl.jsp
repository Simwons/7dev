<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
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
  
  .scroll-table th,
  .scroll-table td {
    border: 1px solid #ccc;
    padding: 8px;
    text-align: center;
    word-wrap: break-word;
  }

  .scroll-container {
    max-height: 300px;
    overflow-y: auto;
    border: 1px solid #ccc;
  }
  
  .sticky-row th {
  position: sticky;
  background-color: #fff;
  z-index: 2;
}

 .scroll-container thead th {
   position: sticky;
   top: 0;
   background-color: #fff; /* 배경 지정 안 하면 스크롤시 투명해짐 */
   z-index: 1;
 }
 
   .label-cell {
    background-color: #7EFFAF;
    font-weight: semibold;
  }
</style>
<h1>자재소요계획</h1>
</head>
<body>
<br><br><br>
	<h4>제품생산계획 선택</h4>
	<div class="scroll-container">
		<table border="1" cellpadding="5" cellspacing="1" style="width: 100%;">
		   	<thead class="sticky-row">
		        <tr style="position: sticky; top: 0; background-color: #fff; z-index: 3;">
			        <th colspan="8">
			        	<form action="${contextPath}/mrp/mrp_main" method="get">
								<select name="searchType" id="selectField">
						            <option value="productCode" selected>제품코드</option>
						            <option value="productName">제품명</option>
						        </select>
							  <input type="text" name="searchValue" id="inputCode">
				            <input type="submit" value="검색">
			            </form>
				    </th>
		        </tr>
		        <tr style="position: sticky; top: 36px; background-color: #fff; z-index: 2;">
		            <th colspan="8">제품생산계획 목록</th>
		        </tr>
				<tr style="position: sticky; top: 72px; background-color: #fff; z-index: 1;">
					<th>제품코드</th>
					<th>제품명</th>
					<th>생산공장</th>
					<th>생산라인</th>
					<th>생산계획수량</th>
					<th>생산 납기일</th>
					<th>담당자</th>
					<th>선택</th>
				</tr>
				</thead>
			<tbody>
				<c:forEach var="productionPlanning" items="${productionPlanning}">
						<tr>
							<td>${productionPlanning.productCode}</td>
							<td>${productionPlanning.productName}</td>
							<td>${productionPlanning.prplPlant}</td>
							<td>${productionPlanning.prplLine}</td>
							<td>${productionPlanning.productCnt}</td>
							<td>${fn:substring(productionPlanning.prplDueDate, 0, 10)}</td>
							<td>${productionPlanning.empName}</td>
							<td>
			             	    <form action="${contextPath}/mrp/mrp_getCreateMrp" method="get">
			                        <input type="hidden" name="prplNo" value="${productionPlanning.prplNo}" />
			                        <button type="submit">등록</button>
			                    </form>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
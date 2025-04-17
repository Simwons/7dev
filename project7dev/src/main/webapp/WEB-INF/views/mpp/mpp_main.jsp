<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부품조달계획</title>
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
<h1>부품조달계획 작성</h1>
</head>
<body>
<br><br><br>
	<div class="scroll-container">
		<table border="1" cellpadding="5" cellspacing="1" style="width: 100%;">
			<div class="topHeader" style="color:white;">
			   	<thead class="sticky-row">
			        <tr style="position: sticky; top: 0; background-color: #fff; z-index: 3;">
				        <th colspan="7">
				        	<form action="${contextPath}/mpp/mpp_main" method="get">
									<select name="searchType" id="selectField">
							            <option value="mppCode" selected>계약코드</option>
							            <option value="productCode">제품코드</option>
							            <option value="productName">제품명</option>
							        </select>
								  <input type="text" name="searchValue" id="inputCode">
					            <input type="submit" value="검색">
				            </form>
					    </th>
			        </tr>
			        <tr style="position: sticky; top: 36px; background-color: #fff; z-index: 2;">
			            <th colspan="5">조달계획 목록</th>
			            <th>
			            	<form action="${contextPath}/mpp/mpp_selectMrp">
			            		<button type="submit">신규등록</button>
			            	</form>
		            	</th>
			        </tr>
					<tr style="position: sticky; top: 72px; background-color: #fff; z-index: 1;">
						<th>조달계획코드</th>
						<th>제품코드</th>
						<th>제품명</th>
						<th>조달요구수량</th>
						<th>조달계획 수립일</th>
						<th>발주상태</th>
					</tr>
				</thead>
			</div>
			<tbody>
				<c:if test="${not empty mpp}">
					<c:forEach var="mpp" items="${mpp}">
						<tr>
							<td>
								<input type="hidden" name="mppNo" value="${mpp.mppNo}">
								<a href="${contextPath}/mpp/mpp_selectMpp?mppNo=${mpp.mppNo}">${mpp.mppCode}</a>
							</td>
							<td>${mpp.productCode}</td>
							<td>${mpp.productName}</td>
							<td>${mpp.productCnt}</td>
							<td>${mpp.mppRegDate}</td>
							<td>발주상태표시</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>
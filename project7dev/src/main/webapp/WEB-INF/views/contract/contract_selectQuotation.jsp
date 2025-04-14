<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계약 등록</title>
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
<h1>견적 선택</h1>
</head>
<body>
<br><br><br>
	<div class="scroll-container">
		<table border="1" cellpadding="5" cellspacing="1" style="width: 100%;">
			<div class="topHeader" style="color:white;">
			   	<thead class="sticky-row">
			        <tr style="position: sticky; top: 0; background-color: #fff; z-index: 3;">
				        <th colspan="7">
				        	<form action="${contextPath}/contract/selectQuotation" method="get">
									<select name="searchType" id="selectField">
							            <option value="quotCode" selected>견적코드</option>
							            <option value="materialCode">부품코드</option>
							            <option value="supName">회사명</option>
							        </select>
								  <input type="text" name="searchValue" id="inputCode">
					            <input type="submit" value="검색">
				            </form>
					    </th>
			        </tr>
			        <tr style="position: sticky; top: 36px; background-color: #fff; z-index: 2;">
			            <th colspan="5">부품 목록</th>
			        </tr>
					<tr style="position: sticky; top: 72px; background-color: #fff; z-index: 1;">
						<th>견적코드</th>
						<th>부품코드</th>
						<th>부품명</th>
						<th>상세보기</th>
						<th>등록하기</th>
					</tr>
				</thead>
			</div>
			<tbody>
				<c:forEach var="quotation" items="${quotationList}">
						<tr>
							<td>${quotation.quotCode}</td>
							<td>${quotation.materialCode}</td>
							<td>${quotation.materialName}</td>
							<td>
			             	    <form action="#" method="get">
			                        <input type="hidden" name="quotNo" value="${quotation.quotNo}" />
			                        <button type="submit">보기</button>
			                    </form>
							</td>
							<td>
			             	    <form action="${contextPath }/contract/getCreateContract" method="get">
			                        <input type="hidden" name="quotNo" value="${quotation.quotNo}" />
			                        <button type="submit">선택</button>
			                    </form>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
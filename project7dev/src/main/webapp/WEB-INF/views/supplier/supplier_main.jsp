<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래처 관리</title>
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
<h1>거래처 관리</h1>
</head>
<body>
<br><br><br>
	<div class="scroll-container">
	<table border="1" cellpadding="5" cellspacing="1" style="width: 100%;">
		<div class="topHeader" style="color:white;">
	   	<thead class="sticky-row">
	        <tr style="position: sticky; top: 0; background-color: #fff; z-index: 3;">
		        <th colspan="7">
		        	<form action="${contextPath}/supplier/supplier_main" method="get">
							<select name="searchType" id="selectField">
					            <option value="supName" selected>거래처명</option>
					            <option value="supRegNo">사업자등록번호</option>
					        </select>
						  <input type="text" name="searchValue" id="inputCode">
			            <input type="submit" value="검색">
		            </form>
			    </th>
	        </tr>
	        <tr style="position: sticky; top: 36px; background-color: #fff; z-index: 2;">
	            <th colspan="6">거래처 목록</th>
	            <th><button type="button" onclick="openNewSupplierModal()">신규등록</button></th>
					
	        </tr>
			<tr style="position: sticky; top: 72px; background-color: #fff; z-index: 1;">
				<th>사업자등록번호</th>
				<th>회사명</th>
				<th>분류</th>
				<th>회사 연락처</th>
				<th>회사 메일</th>
				<th>회사 주소</th>
				<th>대표명</th>
			</tr>
		</thead>
		</div>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<c:if test="${supplier.supNo >=1 }">
					<tr>
			  			<input type="hidden" name="supNo" value="${supplier.supNo}" />
						<td>${supplier.supRegNo}</td>
						<td style="cursor: pointer; color: blue; text-decoration: underline;">
							<a href="${contextPath}/supplier/getSupplierBySupNo?supNo=${supplier.supNo}">${supplier.supName}</a></td>
						<td>${supplier.supCategory}</td>
						<td>${supplier.supPhone}</td>
						<td>${supplier.supEmail}</td>
						<td>${supplier.supAddr1} ${supplier.supAddr2}</td>
						<td>${supplier.supCeoName}</td>
					</tr>
				
				    </form>
					</div>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	
	<!-- 거래처등록 모달 -->
	<div id="newSupplierModal" style="display:none; position:fixed; top:20%; left:35%; background:#fff; border:1px solid #000; padding:20px; z-index:1000; border-radius: 8px;"">
    <h3>거래처 신규등록</h3>
    <h6>*표시는 필수입력입니다.</h6>
    <form action="${contextPath}/supplier/createSupplier" method="post">
		  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; border-collapse: collapse; text-align:center;">
		    <tbody>
		      <tr>
		        <td class="label-cell">*회사명</td>
		        <td><label><input type="text" name="supName" required></label></td>
		        <td class="label-cell">*사업자등록번호</td>
		        <td> <label><input type="text" name="supRegNo" required></label></td>
		      </tr>
		      <tr>
		      	<td colspan="4"></td>
		      </tr>
		      <tr>
		        <td class="label-cell">*분류</td>
		        <td><label><input type="text" name="supCategory" required></label></td>
		        <td class="label-cell">*대표명</td>
		        <td><label><input type="text" name="supCeoName" required></label></td>
		      </tr>
		      <tr>
		      	<td class="label-cell">*회사 연락처</td>
		      	<td><label><input type="text" name="supPhone" required></label></td>
		      	<td class="label-cell">*회사 메일</td>
		      	<td><label><input type="text" name="supEmail" required></label></td>
		      </tr>
		      <tr>
		      	<td class="label-cell">*회사 주소</td>
		      	<td><label><input type="text" name="supAddr1" required></label></td>
		      	<td class="label-cell">상세주소</td>
		      	<td><label><input type="text" name="supAddr2" required></label></td>
		      </tr>
   		      <tr>
		      	<td colspan="4"></td>
		      </tr>
		      <tr>
		      	<td class="label-cell">*담당자명</td>
		      	<td><label><input type="text" name="supCip" required></label></td>
		      </tr>
		      <tr>
		      	<td class="label-cell">*담당자 연락처</td>
		      	<td><label><input type="text" name="supCipPhone" required></label></td>
		      	<td class="label-cell">*담당자 이메일</td>
		      	<td><label><input type="text" name="supCipEmail" required></label></td>
		      </tr>
   		      <tr>
		      	<td colspan="4"></td>
		      </tr>		      
		      <tr>
		      	<td class="label-cell">거래처 아이디</td>
		      	<td><label><input type="text" name="supId" required></label></td>
		      	<td class="label-cell">거래처 비밀번호</td>
		      	<td><label><input type="text" name="supPassword" required></label></td>
		      </tr>
   		      <tr>
		      	<td colspan="4"></td>
		      </tr>		      
		      <tr>
		      	<td class="label-cell">기타사항</td>
		      	<td colspan="3"><textarea name="supEtc"></textarea></td>
		      </tr>
		    </tbody>
		  </table>
		  <br>
        
      	  <div style="text-align: center; margin-top: 20px;">
       		<button type="submit">등록</button>
      		<button type="button" onclick="closeNewSupplierModal()">닫기</button>
      	  </div>
    </form>
	</div>
	
	<!-- 배경 어둡게 -->
	<div id="modalBackdrop" style="display:none; position:fixed; top:0; left:0; width:100vw; height:100vh; background-color:rgba(0,0,0,0.5); z-index:999;"></div>
	
	<script>
	  function openNewSupplierModal() {
	    document.getElementById("newSupplierModal").style.display = "block";
	    document.getElementById("modalBackdrop").style.display = "block";
	  }
	
	  function closeNewSupplierModal() {
	    document.getElementById("newSupplierModal").style.display = "none";
	    document.getElementById("modalBackdrop").style.display = "none";
	  }
	  
	  
	</script>


</body>
</html>
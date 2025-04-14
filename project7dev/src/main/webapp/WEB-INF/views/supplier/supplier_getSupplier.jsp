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
<h1>거래처 관리</h1>
</head>
<body>
<br><br><br>
    <h3>거래처 조회</h3>
	  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; border-collapse: collapse; text-align:center;">
	    <tbody>
	      <tr>
	        <td class="label-cell">*회사명</td>
	        <td>${supplierDTO.supName}</td>
	        <td class="label-cell">*사업자등록번호</td>
	        <td>${supplierDTO.supRegNo}</td>
	      </tr>
	      <tr>
	      	<td colspan="4"></td>
	      </tr>
	      <tr>
	        <td class="label-cell">*분류</td>
	        <td>${supplierDTO.supCategory}</td>
	        <td class="label-cell">*대표명</td>
	        <td>${supplierDTO.supCeoName}</td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*회사 연락처</td>
	      	<td>${supplierDTO.supPhone}</td>
	      	<td class="label-cell">*회사 메일</td>
	      	<td>${supplierDTO.supEmail}</td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*회사 주소</td>
	      	<td>${supplierDTO.supAddr1}</td>
	      	<td class="label-cell">상세주소</td>
	      	<td>${supplierDTO.supAddr2}</td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*담당자명</td>
	      	<td>${supplierDTO.supCip}</td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*담당자 연락처</td>
	      	<td>${supplierDTO.supCipPhone}</td>
	      	<td class="label-cell">*담당자 이메일</td>
	      	<td>${supplierDTO.supCipEmail}</td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>		      
	      <tr>
	      	<td class="label-cell">거래처 아이디</td>
	      	<td>${supplierDTO.supId}</td>
	      	<td class="label-cell">거래처 비밀번호</td>
	      	<td>${supplierDTO.supPassword}</td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>		      
	      <tr>
	      	<td class="label-cell">기타사항</td>
	      	<td colspan="3">${supplierDTO.supEtc}</td>
	      </tr>
	    </tbody>
	  </table>
	  <br>
       
   	  <div style="display: flex; justify-content: center; gap: 10px; margin-top: 20px;">
   	  	<form action="${contextPath}/supplier/getUpdateSupplier">
   	 	 	<input type="hidden" name="supNo" value="${supplierDTO.supNo}" />
    		<button type="submit">수정</button>
    	</form>
	   	<form action="${contextPath}/supplier/deleteSupplier" method="post">
   	 	 	<input type="hidden" name="supNo" value="${supplierDTO.supNo}" />
    		<button type="submit">삭제</button>
    	</form>
    	<form action="${contextPath}/supplier/supplier_main">
   			<button type="submit">뒤로</button>
   	  	</form>
   	  </div>
</body>
</html>
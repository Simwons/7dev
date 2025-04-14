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
    <h3>거래처 정보 수정</h3>
    <form action="${contextPath}/supplier/updateSupplier" method="post">
	  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; border-collapse: collapse; text-align:center;">
 		<input type="hidden" name="supNo" value="${supplierDTO.supNo}" />
	    <tbody>
	      <tr>
	        <td class="label-cell">*회사명</td>
	        <td><label><input type="text" name="supName" value="${supplierDTO.supName}" required></label></td>
	        <td class="label-cell">*사업자등록번호</td>
	        <input type="hidden" name="supRegNo" value="${supplierDTO.supRegNo}" />
	        <td>${supplierDTO.supRegNo}</td>
	      </tr>
	      <tr>
	      	<td colspan="4"></td>
	      </tr>
	      <tr>
	        <td class="label-cell">*분류</td>
	        <td><label><input type="text" name="supCategory" value="${supplierDTO.supCategory}" required></label></td>
	        <td class="label-cell">*대표명</td>
	        <td><label><input type="text" name="supCeoName" value="${supplierDTO.supCeoName}" required></label></td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*회사 연락처</td>
	      	<td><label><input type="text" name="supPhone" value="${supplierDTO.supPhone}" required></label></td>
	      	<td class="label-cell">*회사 메일</td>
	      	<td><label><input type="text" name="supEmail" value="${supplierDTO.supEmail}" required></label></td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*회사 주소</td>
	      	<td><label><input type="text" name="supAddr1" value="${supplierDTO.supAddr1}" required></label></td>
	      	<td class="label-cell">상세주소</td>
	      	<td><label><input type="text" name="supAddr2" value="${supplierDTO.supAddr2}" required></label></td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*담당자명</td>
	      	<td><label><input type="text" name="supCip" value="${supplierDTO.supCip}" required></label></td>
	      </tr>
	      <tr>
	      	<td class="label-cell">*담당자 연락처</td>
	      	<td><label><input type="text" name="supCipPhone" value="${supplierDTO.supCipPhone}" required></label></td>
	      	<td class="label-cell">*담당자 이메일</td>
	      	<td><label><input type="text" name="supCipEmail" value="${supplierDTO.supCipEmail}" required></label></td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>		      
	      <tr>
	      	<td class="label-cell">거래처 아이디</td>
	      	<td><label><input type="text" name="supId" value="${supplierDTO.supId}" required></label></td>
	      	<td class="label-cell">거래처 비밀번호</td>
	      	<td><label><input type="text" name="supPassword" value="${supplierDTO.supPassword}" required></label></td>
	      </tr>
  		      <tr>
	      	<td colspan="4"></td>
	      </tr>		      
	      <tr>
	      	<td class="label-cell">기타사항</td>
	      	<td colspan="3"><textarea name="supEtc">${supplierDTO.supEtc}</textarea></td>
	      </tr>
	    </tbody>
	  </table>
	  <br>
       
   	  <div style="text-align: center; margin-top: 20px;">
    	<button type="submit">변경사항 등록</button>
   		<button type="button" onclick="history.back()">취소</button>
   	  </div>
</body>
</html>
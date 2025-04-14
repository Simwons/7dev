<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계약 신규등록</title>
<style>
  .label-cell {
    background-color: #7EFFAF;
    font-weight: semibold;
  }	
</style>
<h1>계약 관리</h1>
</head>
<body>
<br><br><br>
	    <h3>계약 신규등록</h3>
	    <h6>*모든항목 필수입력</h6>
	    <form action="${contextPath}/contract/createContract" method="post" enctype="multipart/form-data">
			  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; table-layout: fixed; border-collapse: collapse; text-align:center;">
			    <tbody>
			    <input type="hidden" name="quotNo" value="${quotation.quotNo}">
			     <tr>
			        <input type="hidden" name="supNo" value="${quotation.supNo}" />
			        <td class="label-cell" style="width:15%;">사업자등록번호</td>
			        <td style="width:35%;"><input type="text" name="supRegNo" style="width:90%;" value="${quotation.supRegNo}" readonly></td>
			        <td class="label-cell" style="width:15%;">회사명</td>
			        <td style="width:35%;"><input type="text" name="supName" style="width:90%;" value="${quotation.supName}" readonly></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">계약일</td>
			        <td style="width:35%;"> 
			        	<input type="date" name="contDate" id="contDate" style="width:80%; box-sizing: border-box;">
			        </td>
			        <td class="label-cell" style="width:15%;">계약기간(년)</td>
			        <td style="width:35%;"><input type="number" name="contPeriod" id="contPeriod" style="width:90%; box-sizing: border-box;" required></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">담당자(거래처)</td>
			        <td style="width:35%;"><input type="text" name="supCip" style="width:90%;" value="${supplier.supCip}" readonly></td>
			        <td class="label-cell" style="width:15%;">담당자(당사)</td>
			        <td style="width:35%;">허재연</td>
			        <input type="hidden" name="empNo" value="2">
			      </tr>			      
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적서</td>
			        <td style="width:35%;">${quotation.quotFile}</td>
			      </tr>  
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			      	<input type="hidden" name="materialNo" value="${quotation.materialNo}">
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품코드</td>
			      	<td style="width:35%;"><input type="text" name="materialCode" style="width:90%;" value="${quotation.materialCode}" readonly></td>
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품명</td>
			      	<td style="width:35%;"><input type="text" name="materialName" style="width:90%;" value="${quotation.materialName}" readonly></td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">소재</td>
			      	<td style="width:35%;"><input type="text" name="materialRawMaterial" style="width:90%;" value="${quotation.materialRawMaterial}" readonly></td>
			      	<td class="label-cell" style="width:15%;">규격</td>
			      	<td style="width:35%; box-sizing: border-box;">
						<input type="text" name="materialDescription" value="${quotation.materialDescription}" readonly>
			      		<input type="text" name="materialUnit" size="1" value="${quotation.materialUnit}" readonly>
					</td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		   
			       <tr>
			      	<td class="label-cell" style="width:15%;">부품단가</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<label><input type="text" name="contMprice" value="${quotation.quotPrice}" required></label>
						<select name="mpriceCurrency" id="selectField">
						    <option value="KRW" <c:if test="${quotation.quotPriceCurrency == 'KRW'}">selected</c:if>>KRW</option>
						    <option value="USD" <c:if test="${quotation.quotPriceCurrency == 'USD'}">selected</c:if>>USD</option>
						    <option value="CNY" <c:if test="${quotation.quotPriceCurrency == 'CNY'}">selected</c:if>>CNY</option>
						    <option value="JPY" <c:if test="${quotation.quotPriceCurrency == 'JPY'}">selected</c:if>>JPY</option>
						    <option value="EUR" <c:if test="${quotation.quotPriceCurrency == 'EUR'}">selected</c:if>>EUR</option>
				        </select>
			      	</td>
			      	<td class="label-cell" style="width:15%;">수량</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<label><input type="text" name="contMaterialCnt" value="${quotation.quotMaterialCnt }" required></label>
			      		<select name="contMaterialSku" id="selectField">
				            <option value="EA" <c:if test="${quotation.quotMaterialSku == 'EA'}">selected</c:if>>EA</option>
				            <option value="BOX"<c:if test="${quotation.quotMaterialSku == 'BOX'}">selected</c:if>>BOX</option>
				            <option value="PCS"<c:if test="${quotation.quotMaterialSku == 'PCS'}">selected</c:if>>PCS</option>
				            <option value="PK"<c:if test="${quotation.quotMaterialSku == 'PK'}">selected</c:if>>PK</option>
				            <option value="SET"<c:if test="${quotation.quotMaterialSku == 'SET'}">selected</c:if>>SET</option>
				        </select>
		      		</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">총 금액</td>
			      	<td style="width:35%;">
				      	<input type="text" id="totalPrice" value="${quotation.quotPrice * quotation.quotMaterialCnt}" disabled>
				      	<input type="text" size="1" id="currencyDisplay" value="${quotation.quotPriceCurrency}" disabled>
			      	</td>
			      	<td class="label-cell" style="width:15%;">최소주문수량</td>
			      	<td style="width:35%;">${quotation.quotMaterialCnt}</td>
			      </tr>   
			      <tr>
			      	<td class="label-cell" style="width:15%;">포장단위</td>
			      	<td style="width:35%;">${quotation.quotMaterialSku}</td>
			      	<td class="label-cell" style="width:15%;">포장단위당 수량</td>
			      	<td style="width:35%;">1</td>
			      </tr>  
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>				       			      
			      <tr>
			        <td class="label-cell" style="width:15%;">인도조건</td>
			        <td style="width:35%;">${quotation.quotDterms}</td>
			        <input type="hidden" name="contDterms" value="${quotation.quotDterms}">
			        <td class="label-cell" style="width:15%;">리드타임(일)</td>
			        <td style="width:35%;"><input type="number" name="contLeadtime" id="contLeadtime" style="width:90%; box-sizing: border-box;" required></td>
			      </tr>
			      <tr>
	    		    <td class="label-cell" style="width:15%;">결제방법</td>
			        <td style="width:35%;">${paymentMethod}</td>
	          		<td class="label-cell" style="width:15%;">결제시기</td>
			        <td style="width:35%;">${paymentTiming}</td>
			        <input type="hidden" name="contPterms" id="contPterms">
			      </tr>

	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			     
			      <tr>
			      	<td class="label-cell" style="width:15%;">계약서</td>
			      	<td style="width:35%;"><input type="file" name="file"style="width:90%; box-sizing: border-box;" ></td>
			      </tr>
			    </tbody>
			  </table>
			  <br>
	        
	      	  <div style="text-align: center; margin-top: 20px;">
	       		<button type="submit">등록</button>
	      		<button type="button" onclick="history.back()">닫기</button>
	      	  </div>
	    </form>
	    
		<script>
		function toggleDaysInput(enabled) {
		    const daysInput = document.getElementById('daysInput');
		    daysInput.disabled = !enabled;
		    if (!enabled) daysInput.value = '';
		}

		document.querySelector('form').addEventListener('submit', function (e) {
		    const method = document.querySelector('input[name="paymentMethod"]:checked').value;
		    const timingRadio = document.querySelector('input[name="paymentTiming"]:checked');
		    let timing = timingRadio.value;

			if (timing === 'fewDaysAfterAcceptance') {
			    const days = document.getElementById('daysInput').value;
			    if (!days) {
			        alert("날짜를 입력해주세요.");
			        e.preventDefault(); // 제출 막기
			        return;
			    }
			    timing = days + "days after acceptance";
			}

		    document.getElementById('quotPterms').value = method + ", " + timing;
		});
		
	    function updateTotalPrice() {
	        const price = parseFloat(document.querySelector('input[name="contMprice"]').value) || 0;
	        const count = parseInt(document.querySelector('input[name="contMaterialCnt"]').value) || 0;
	        const currency = document.querySelector('select[name="mpriceCurrency"]').value;

	        const total = price * count;

	        document.getElementById('totalPrice').value = total;
	        document.getElementById('currencyDisplay').value = currency;
	    }
	    
	    document.querySelector('input[name="contMprice"]').addEventListener('input', updateTotalPrice);
	    document.querySelector('input[name="contMaterialCnt"]').addEventListener('input', updateTotalPrice);
	    document.querySelector('select[name="mpriceCurrency"]').addEventListener('change', updateTotalPrice);
		
	    window.onload = function() {
	        const today = new Date();
	        const formattedDate = today.toISOString().split('T')[0];
	        document.getElementById('contDate').value = formattedDate;
	    };
	    
	    document.querySelector('form').addEventListener('submit', function (e) {

	        const method = "${paymentMethod}";
	        const timing = "${paymentTiming}";

	        document.getElementById('contPterms').value = method + ", " + timing;
	    });

	    </script>
</body>
</html>
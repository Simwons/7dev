<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적 수정</title>
<style>
  .label-cell {
    background-color: #7EFFAF;
    font-weight: semibold;
  }	
</style>
<h1>견적 수정</h1>
</head>
<body>
<br><br><br>
	    <form action="${contextPath}/quotation/updateQuotation" method="post" enctype="multipart/form-data">
	    	  <input type="hidden" name="quotNo" value="${quotation.quotNo}"/>
			  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; table-layout: fixed; border-collapse: collapse; text-align:center;">
			    <tbody>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적코드</td>
			        <td style="width:35%;"><input type="text" name="quotCode" value="${quotation.quotCode}" readonly></td>
			        <td class="label-cell" style="width:15%;">계약확정여부</td>
			        <td style="width:35%;">
			        	<c:if test="${quotation.quotState == '0'}">미확정</c:if>
			        	<c:if test="${quotation.quotState == '1'}">확정</c:if>
			        </td>
			      </tr>
   			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">사업자등록번호</td>
			        <td style="width:35%;"><input type="text" name="supRegNo" value="${quotation.supRegNo}" /></td>
			        <td class="label-cell" style="width:15%;">회사명</td>
			        <td style="width:35%;"><input type="text" name="supName" value="${quotation.supName}" /></td>
			      </tr>
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적서</td>
			        <td style="width:35%;">
			        	<input type="file" name="file"/>
			        	<c:if test="${not empty quotation.quotFile}">
				            <br/>
				            <a href="${contextPath}/resources/file/${quotation.quotFile}" target="_blank">
				                ${quotation.quotFile}
				            </a>
				        </c:if>
				        <input type="hidden" name="existingFile" value="${quotation.quotFile}" />
			        </td>
			        <td class="label-cell" style="width:15%;">인도조건</td>
			        <td style="width:35%;">
						<input type="radio" name="quotDterms" value="EXW" <c:if test="${quotation.quotDterms == 'EXW'}">checked</c:if> style="box-sizing: border-box;"required>EXW 
				        <input type="radio" name="quotDterms" value="FCA" <c:if test="${quotation.quotDterms == 'FCA'}">checked</c:if> style="box-sizing: border-box;">FCA 
				        <input type="radio" name="quotDterms" value="D2D" <c:if test="${quotation.quotDterms == 'D2D'}">checked</c:if> style="box-sizing: border-box;">D2D
					</td>
			      </tr>
			      <tr>
	    		    <td class="label-cell" style="width:15%;">결제방법</td>
			        <td style="width:35%;">
			        	<input type="radio" name="paymentMethod" value="T/T" <c:if test="${paymentMethod == 'T/T'}">checked</c:if> required>T/T
				        <input type="radio" name="paymentMethod" value="L/C" <c:if test="${paymentMethod == 'L/C'}">checked</c:if>>L/C 
				        <input type="radio" name="paymentMethod" value="D/A" <c:if test="${paymentMethod == 'D/A'}">checked</c:if>>D/A
				        <input type="radio" name="paymentMethod" value="현금" <c:if test="${paymentMethod == '현금'}">checked</c:if>>현금
			        </td>
	          		<td class="label-cell" style="width:15%;">결제시기</td>
			        <td style="width:35%;">
						<input type="radio" name="paymentTiming" value="atSight" <c:if test="${paymentTiming == 'atSight'}">checked</c:if> required onclick="toggleDaysInput(false)">at sight
				        <input type="radio" name="paymentTiming" value="inAdvance" <c:if test="${paymentTiming == 'inAdvance'}">checked</c:if> onclick="toggleDaysInput(false)">in advance<br>
				        <input type="radio" name="paymentTiming" value="fewDaysAfterAcceptance" <c:if test="${paymentTiming == 'fewDaysAfterAcceptance'}">checked</c:if> onclick="toggleDaysInput(true)"><input type="number" id="daysInput" name="days" style="width: 40px;" value="${days}" <c:if test="${paymentTiming != 'fewDaysAfterAcceptance'}">disabled</c:if>>days after acceptance
				        <input type="hidden" name="quotPterms" id="quotPterms">
			        </td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			      <tr>
			     	<input type="hidden" name="materialNo" value="${quotation.materialNo}" />
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품코드</td>
			      	<td style="width:35%;">${quotation.materialCode}</td>
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품명</td>
			      	<td style="width:35%;">${quotation.materialName}</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">소재</td>
			      	<td style="width:35%;">${quotation.materialRawMaterial }</td>
			      	<td class="label-cell" style="width:15%;">규격</td>
			      	<td style="width:35%; box-sizing: border-box;">${quotation.materialDescription}${quotation.materialUnit}</td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			      <tr>
			      	<td class="label-cell" style="width:15%;">견적단가</td>
			      	<td style="width:35%; box-sizing: border-box;">
						<input type="text" name="quotPrice" value="${quotation.quotPrice}" required>
						<select name="quotPriceCurrency" id="selectField">
				            <option value="KRW" <c:if test="${quotation.quotPriceCurrency == 'KRW'}">selected</c:if> required>KRW</option>
				            <option value="USD" <c:if test="${quotation.quotPriceCurrency == 'USD'}">selected</c:if>>USD</option>
				            <option value="CNY" <c:if test="${quotation.quotPriceCurrency == 'CNY'}">selected</c:if>>CNY</option>
				            <option value="JPY" <c:if test="${quotation.quotPriceCurrency == 'JPY'}">selected</c:if>>JPY</option>
				            <option value="EUR" <c:if test="${quotation.quotPriceCurrency == 'EUR'}">selected</c:if>>EUR</option>
				        </select>
					</td>
			      	<td class="label-cell" style="width:15%;">수량</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<input type="text" name="quotMaterialCnt" value="${quotation.quotMaterialCnt}" required>
			      		<select name="quotMaterialSku" id="selectField">
				            <option value="EA" <c:if test="${quotMaterialSku == 'EA'}">selected</c:if>>EA</option>
				            <option value="BOX" <c:if test="${quotMaterialSku == 'BOX'}">selected</c:if>>BOX</option>
				            <option value="PCS" <c:if test="${quotMaterialSku == 'PCS'}">selected</c:if>>PCS</option>
				            <option value="PK" <c:if test="${quotMaterialSku == 'PK'}">selected</c:if>>PK</option>
				            <option value="SET" <c:if test="${quotMaterialSku == 'SET'}">selected</c:if>>SET</option>
				        </select>
		      		</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">총 금액</td>
			      	<td style="width:35%;">
			      		<input type="text" id="totalPrice" value="${quotation.quotPrice * quotation.quotMaterialCnt}" disabled>
				      	<input type="text" size="1" id="currencyDisplay" value="${quotation.quotPriceCurrency}" disabled>
			      	</td>
			      	<td class="label-cell" style="width:15%;">납기일</td>
			      	<td style="width:35%;"> 
			      		<input type="date" name="quotDueDate" value="${quotation.quotDueDate.substring(0, 10)}" style="width: 90%;" required>
			      	</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">기타사항</td>
			      	<td colspan="3" style="width:85%;"><textarea name="quotEtc">${quotation.quotEtc}</textarea></td>
			      </tr>
			    </tbody>
			  </table>
			  <br>
	        
	      	  <div style="text-align: center; margin-top: 20px;">
	       		<button type="submit">등록</button>
      			<button type="button" onclick="history.back()">뒤로</button>
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
	        const price = parseFloat(document.querySelector('input[name="quotPrice"]').value) || 0;
	        const count = parseInt(document.querySelector('input[name="quotMaterialCnt"]').value) || 0;
	        const currency = document.querySelector('select[name="quotPriceCurrency"]').value;

	        const total = price * count;

	        document.getElementById('totalPrice').value = total;
	        document.getElementById('currencyDisplay').value = currency;
	    }
	    
	    document.querySelector('input[name="quotPrice"]').addEventListener('input', updateTotalPrice);
	    document.querySelector('input[name="quotMaterialCnt"]').addEventListener('input', updateTotalPrice);
	    document.querySelector('select[name="quotPriceCurrency"]').addEventListener('change', updateTotalPrice);
		

		</script>
</body>
</html>
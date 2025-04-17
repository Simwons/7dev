<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계약 상세보기</title>
<style>
  .label-cell {
    background-color: #7EFFAF;
    font-weight: semibold;
  }	
</style>
<h1>계약 상세보기</h1>
</head>
<body>
<br><br><br>
   	    <form action="#" method="get">
			  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; table-layout: fixed; border-collapse: collapse; text-align:center;">
			    <tbody>
			    <input type="hidden" name="contNo" value="${contract.contNo}">
			     <tr>
			        <input type="hidden" name="supNo" value="${contract.supNo}" />
			        <td class="label-cell" style="width:15%;">사업자등록번호</td>
			        <td style="width:35%;">${contract.supRegNo}</td>
			        <td class="label-cell" style="width:15%;">회사명</td>
			        <td style="width:35%;">${contract.supName}</td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">계약일</td>
			        <td style="width:35%;">${contract.contDate}</td>
			        <td class="label-cell" style="width:15%;">계약기간(년)</td>
			        <td style="width:35%;">${contract.contPeriod}</td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">담당자(거래처)</td>
			        <td style="width:35%;">${contract.supCip}</td>
			        <td class="label-cell" style="width:15%;">담당자(당사)</td>
			        <td style="width:35%;">${contract.empName}</td>
			      </tr>			      
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품코드</td>
			      	<td style="width:35%;">${contract.materialCode}</td>
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">부품명</td>
			      	<td style="width:35%;">${contract.materialName}</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">소재</td>
			      	<td style="width:35%;">${contract.materialRawMaterial}</td>
			      	<td class="label-cell" style="width:15%;">규격</td>
			      	<td style="width:35%; box-sizing: border-box;">${contract.materialDescription}(${contract.materialUnit})</td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		   
			       <tr>
			      	<td class="label-cell" style="width:15%;">부품단가</td>
			      	<td style="width:35%; box-sizing: border-box;">${contract.contMprice} ${contract.mpriceCurrency}</td>
			      	<td class="label-cell" style="width:15%;">수량</td>
			      	<td style="width:35%; box-sizing: border-box;">${contract.contMaterialCnt} ${contract.contMaterialSku}</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">총 금액</td>
			      	<td style="width:35%;">${contract.contMprice * contract.contMaterialCnt} ${contract.mpriceCurrency }</td>
			      	<td class="label-cell" style="width:15%;">최소주문수량</td>
			      	<td style="width:35%;">${contract.contMaterialCnt}</td>
			      </tr>   
			      <tr>
			      	<td class="label-cell" style="width:15%;">포장단위</td>
			      	<td style="width:35%;">${contract.contMaterialSku}</td>
			      	<td class="label-cell" style="width:15%;">포장단위당 수량</td>
			      	<td style="width:35%;">1</td>
			      </tr>  
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>				       			      
			      <tr>
			        <td class="label-cell" style="width:15%;">인도조건</td>
			        <td style="width:35%;">${contract.contDterms}</td>
			        <input type="hidden" name="contDterms" value="${quotation.quotDterms}">
			        <td class="label-cell" style="width:15%;">리드타임(일)</td>
			        <td style="width:35%;">${contract.contLeadtime}</td>
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
			      	<td style="width:35%;"><a href="${contextPath}/resources/file/${contract.contFile}" target="_blank">${contract.contFile}</a></td>
			      </tr>
			    </tbody>
			  </table>
			  <br>
	        
	      	  <div style="text-align: center; margin-top: 20px;">
	      		<button type="button" onclick="history.back()">닫기</button>
	      	  </div>
	    </form>
		<div id="supplierModal" style="display: none; position: fixed; top:20%; left:30%; background: white; border: 1px solid #ccc; padding: 20px;">
		  <h3>조회 결과</h3>
		  <table id="supplierTable" border="1">
		    <thead>
		      <tr>
		      	<th>사업자등록번호</th>
		      	<th>회사명</th>
		      	<th>선택</th>
	      	  </tr>
		    </thead>
		    <tbody>
		    
		    </tbody>
		  </table>
		  <button onclick="closeSupplierModal()">닫기</button>
		</div>
	    
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
		</script>
</body>
</html>
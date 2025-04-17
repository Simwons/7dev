<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>견적 신규등록</title>
<style>
  .label-cell {
    background-color: #7EFFAF;
    font-weight: semibold;
  }	
</style>
<h1>견적 관리</h1>
</head>
<body>
<br><br><br>
	    <h3>견적 신규등록</h3>
	    <h6>*표시는 필수입력입니다.</h6>
	    <form action="${contextPath}/quotation/createQuotation" method="post" enctype="multipart/form-data">
			  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; table-layout: fixed; border-collapse: collapse; text-align:center;">
			    <tbody>
			      <tr>
			        <td class="label-cell" style="width:15%;">*사업자등록번호</td>
			        <td style="width:35%;"> 
			        	<label><input type="text" name="supRegNo" id="supRegNo" style="width:80%; box-sizing: border-box;" required></label>
			        </td>
			        <td class="label-cell" style="width:15%;">*회사명</td>
			        <td style="width:35%;"><label><input type="text" name="supName" id="supName" style="width:90%; box-sizing: border-box;" required></label></td>
			      </tr>
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적서</td>
			        <td style="width:35%;"><input type="file" name="file"style="width:90%; box-sizing: border-box;" ></td>
			        <td class="label-cell" style="width:15%;">*인도조건</td>
			        <td style="width:35%;">
						<input type="radio" name="quotDterms" value="EXW" style="box-sizing: border-box;" checked required>EXW 
				        <input type="radio" name="quotDterms" value="FCA" style="box-sizing: border-box;">FCA 
				        <input type="radio" name="quotDterms" value="D2D" style="box-sizing: border-box;">D2D
			        </td>
			      </tr>
			      <tr>
	    		    <td class="label-cell" style="width:15%;">*결제방법</td>
			        <td style="width:35%;">
						<input type="radio" name="paymentMethod" value="T/T" checked required>T/T
				        <input type="radio" name="paymentMethod" value="L/C">L/C 
				        <input type="radio" name="paymentMethod" value="D/A">D/A
				        <input type="radio" name="paymentMethod" value="현금">현금
			        </td>
	          		<td class="label-cell" style="width:15%;">*결제시기</td>
			        <td style="width:35%;">
						<input type="radio" name="paymentTiming" value="atSight" checked required onclick="toggleDaysInput(false)">at sight
				        <input type="radio" name="paymentTiming" value="inAdvance" onclick="toggleDaysInput(false)">in advance<br>
				        <input type="radio" name="paymentTiming" value="fewDaysAfterAcceptance" onclick="toggleDaysInput(true)"><input type="number" id="daysInput" style="width: 40px;" disabled>days after acceptance
				        <input type="hidden" name="quotPterms" id="quotPterms">
			        </td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			      <tr>
			     	<input type="hidden" name="materialNo" value="${material.materialNo}" />
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">*부품코드</td>
			      	<td style="width:35%;">
			      		    <input type="text" name="materialCode" style="width:90%;" value="${material.materialCode}" readonly>
			      	</td>
			      	<td class="label-cell" style="width:15%; box-sizing: border-box;">*부품명</td>
			      	<td style="width:35%;">
			      		<input type="text" name="materialName" style="width:90%;" value="${material.materialName}" readonly>
		      		</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">*소재</td>
			      	<td style="width:35%;">
			      		<input type="text" name="materialRawMaterial" style="width:90%;" value="${material.materialRawMaterial}" readonly>
			      	</td>
			      	<td class="label-cell" style="width:15%;">*규격</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<input type="text" name="materialDescription" value="${material.materialDescription}" readonly>
			      		<input type="text" name="materialUnit" size="1" value="${material.materialUnit}" readonly>
			      	</td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			      <tr>
			      	<td class="label-cell" style="width:15%;">*견적단가</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<input type="text" name="quotPrice" required>
						<select name="quotPriceCurrency" id="selectField">
				            <option value="KRW" selected>KRW</option>
				            <option value="USD">USD</option>
				            <option value="CNY">CNY</option>
				            <option value="JPY">JPY</option>
				            <option value="EUR">EUR</option>
				        </select>
			      	</td>
			      	<td class="label-cell" style="width:15%;">*수량</td>
			      	<td style="width:35%; box-sizing: border-box;">
			      		<input type="text" name="quotMaterialCnt" required>
			      		<select name="quotMaterialSku" id="selectField">
				            <option value="EA" selected>EA</option>
				            <option value="BOX">BOX</option>
				            <option value="PCS">PCS</option>
				            <option value="PK">PK</option>
				            <option value="SET">SET</option>
				        </select>
		      		</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">총 금액</td>
			      	<td style="width:35%;">
				      	<label><input type="text" disabled></label>
				      	<label><input type="text" size="1" disabled></label>
			      	</td>
			      	<td class="label-cell" style="width:15%;">*납기일</td>
			      	<td style="width:35%;"><input type="date" name="quotDueDate"style="width:80%; box-sizing: border-box;"></td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">기타사항</td>
			      	<td colspan="3" style="width:85%;"><textarea name="supEtc" style="width:90%; box-sizing: border-box;"></textarea></td>
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
		</script>
</body>
</html>
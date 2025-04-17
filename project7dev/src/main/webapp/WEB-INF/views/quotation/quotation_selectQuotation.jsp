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
<h1>견적 상세보기</h1>
</head>
<body>
<br><br><br>
	    <form action="${contextPath}/quotation/getUpdateQuotation" method="get">
	 		  <input type="hidden" name="quotNo" value="${quotation.quotNo}" />
			  <table border="1" cellpadding="5" cellspacing="0" style="width:100%; table-layout: fixed; border-collapse: collapse; text-align:center;">
			    <tbody>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적코드</td>
			        <td style="width:35%;">${quotation.quotCode}</td>
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
			        <td style="width:35%;">${quotation.supRegNo}</td>
			        <td class="label-cell" style="width:15%;">회사명</td>
			        <td style="width:35%;">${quotation.supName}</td>
			      </tr>
			      <tr>
			      	<td colspan="4"></td>
			      </tr>
			      <tr>
			        <td class="label-cell" style="width:15%;">견적서</td>
			        <td style="width:35%;"><a href="${contextPath}/resources/file/${quotation.quotFile}" target="_blank">${quotation.quotFile}</a></td>
			        <td class="label-cell" style="width:15%;">인도조건</td>
			        <td style="width:35%;">${quotation.quotDterms} </td>
			      </tr>
			      <tr>
	    		    <td class="label-cell" style="width:15%;">결제방법</td>
			        <td style="width:35%;">${paymentMethod}</td>
	          		<td class="label-cell" style="width:15%;">결제시기</td>
			        <td style="width:35%;">${paymentTiming}</td>
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
			      	<td style="width:35%; box-sizing: border-box;">${quotation.materialDescription}${quotation.materialUnit }</td>
			      </tr>
	   		      <tr>
			      	<td colspan="4"></td>
			      </tr>		      
			      <tr>
			      	<td class="label-cell" style="width:15%;">견적단가</td>
			      	<td style="width:35%; box-sizing: border-box;">${quotation.quotPrice}${quotation.quotPriceCurrency}</td>
			      	<td class="label-cell" style="width:15%;">수량</td>
			      	<td style="width:35%; box-sizing: border-box;">${quotation.quotMaterialCnt}${quotation.quotMaterialSku}</select>
		      		</td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">총 금액</td>
			      	<td style="width:35%;">
			      		${quotation.quotPrice * quotation.quotMaterialCnt}${quotation.quotPriceCurrency}
			      	</td>
			      	<td class="label-cell" style="width:15%;">납기일</td>
			      	<td style="width:35%;"><c:out value="${quotation.quotDueDate.substring(0, 10)}" /></td>
			      </tr>
			      <tr>
			      	<td class="label-cell" style="width:15%;">기타사항</td>
			      	<td colspan="3" style="width:85%;">${quotation.quotEtc}</textarea></td>
			      </tr>
			    </tbody>
			  </table>
			  <br>
	        
	      	  <div style="text-align: center; margin-top: 20px;">
	       		<button type="submit">수정</button>
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
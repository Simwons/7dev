<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재소요계획</title>
<style>
.scroll-table {
	width: 100%;
	border-collapse: separate;
	table-layout: fixed;
}

.scroll-table thead {
	background-color: #f2f2f2;
}

.scroll-table th, .scroll-table td {
	border: 1px solid #ccc;
	padding: 8px;
	text-align: center;
	word-wrap: break-word;
}

.scroll-container {
  height: 400px;     /* 고정 높이로 박스 크기 만들기 */
  overflow-y: auto;      /* 이 안에서만 스크롤 */
  border: 1px solid #ccc;
  margin-top: 10px;
  margin-bottom: 10px;
  box-shadow: 0 0 5px rgba(0,0,0,0.1);
  border-radius: 4px;
}

.sticky-row th, fix {
	position: sticky;
	background-color: #fff;
	z-index: 2;
}

.scroll-container thead th {
  position: sticky;
  top: 0;
  background-color: #fff;
  z-index: 2;
}

.label-cell {
	background-color: #7EFFAF;
	font-weight: semibold;
}
#fix {
  position: sticky;
  left: 0;
  background-color: #fff;
  z-index: 3;
}
.label-cell {
  background-color: #7EFFAF;
  font-weight: semibold;
}	

</style>
<h1>자재소요계획 등록</h1>
</head>
<body>
	<form action="${contextPath}/mrp/createMrp" method="post">
		<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
			<thead class="sticky-row">

				<input type="hidden" name="prplNo" value="${prpl.prplNo}"/>
				<input type="hidden" name="productNo" value="${prpl.productNo}"/>
				<tr>
					<td class="label-cell" style="width:15%;">제품명</td>
					<td style="width:35%;">${prpl.productName }</td>
					<td class="label-cell" style="width:15%;">제품코드</td>
					<td style="width:35%;">${prpl.productCode }</td>
				</tr>
				<tr>
					<input type="hidden" name="mrpDueDate" value="${mrpDueDate}"/>
					<td class="label-cell" style="width:15%;">자재납기일</td>
					<td style="width:35%;">${mrpDueDate}</td>
				</tr>
			</thead>
		</table>
						
		<div class="scroll-container">
			<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">	
				<thead class="sticky-row">	
					<tr style="position: sticky; background-color: #fff;">
						<th class="label-cell" colspan="7">소요자재 목록</th>
						<th><input type="button" value="자재조회" onclick="openMaterialModal()"></th>
					</tr>
					<tr style="position: sticky; top: 36px; background-color: #fff;">
						<th style="width:15%;">자재명</th>
						<th style="width:20%;">자재코드</th>
						<th style="width:15%;">자재창고</th>
						<th style="width:10%;">가용재고</th>
						<th style="width:10%;">총소요량</th>
						<th style="width:10%;">순소요량</th>
						<th style="width:10%;">포장단위</th>
						<th style="width:10%;">리드타임(일)</th>
					</tr>
				</thead>
				<tbody id="materialBody">
				
				
				</tbody>
			</table>
		</div>
		<table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
			<input type="hidden" name="empNo" value="4"/>
			<tr>
		        <td class="label-cell" style="width:15%;">사원번호</td>
		        <td style="width:35%;">${employee.empNo}</td>
		        <td class="label-cell" style="width:15%;">담당자명</td>
		        <td style="width:35%;">${employee.empName}</td>
		    </tr>
			<tr>
		        <td class="label-cell" style="width:15%;">담당자 연락처</td>
		        <td style="width:35%;">${employee.empPhone}</td>
		        <td class="label-cell" style="width:15%;">담당자 메일</td>
		        <td style="width:35%;">${employee.empEmail}</td>
		    </tr>
		    <tr>
		    	<td colspan="4"></td>
		    </tr>
 			<tr>
		        <td class="label-cell" style="width:15%;">기타사항</td>
		        <td colspan="3" style="width:35%;">
					<textarea rows="4" cols="110"></textarea>
				</td>
		    </tr>
		</table>
		<div style="text-align: center; margin-top: 20px;">
	       		<button type="submit">등록</button>
	      		<button type="button" onclick="history.back()">닫기</button>
      	</div>
	</form>
	<script>
		function openMaterialModal() {
			window.open('${contextPath}/material/search', '자재조회', 'width=600,height=500');
			
		}
		document.addEventListener("DOMContentLoaded", function () {
			  // 모든 총소요량 input에 이벤트 달기
			  document.addEventListener("input", function (e) {
			    if (e.target.classList.contains("totalQty")) {
			      const totalInput = e.target; // 총소요량 input
			      const row = totalInput.closest("tr"); // 해당 tr 찾기

			      const availableInput = row.querySelector(".availableQty"); // 가용재고 input
			      const netInput = row.querySelector(".netQty"); // 순소요량 input

			      const total = parseInt(totalInput.value) || 0;
			      const available = parseInt(availableInput.value) || 0;
			      const net = Math.max(total - available, 0); // 음수 방지

			      netInput.value = net;
			    }
			  });
			});
		
		let materialIndex = 0;

		function addMaterialToParent(name, code, materialNo) {
			const table = document.querySelector('#materialBody');
			const newRow = document.createElement('tr');

			newRow.innerHTML = '' +
				'<input type="hidden" name="materials[' + materialIndex + '].materialNo" value="' + materialNo + '">' +
				'<td>' + name + '</td>' +
				'<td>' + code + '</td>' +
				'<td>자재창고.창고코드</td>' +
				'<td><input type="number" class="availableQty" value="30" style="width: 60px;" readonly></td>' +
				'<td><input type="number" class="totalQty" style="width: 60px;"></td>' +
				'<td><input type="text" name="materials[' + materialIndex + '].mrpQuantity" class="netQty" style="width: 60px;" readonly></td>' +
				'<td>' +
				'<select name="materials[' + materialIndex + '].mrpSku">' +
				'<option value="EA">EA</option>' +
				'<option value="BOX">BOX</option>' +
				'<option value="PCS">PCS</option>' +
				'<option value="PK">PK</option>' +
				'<option value="SET">SET</option>' +
				'</select>' +
				'</td>' +
				'<td><input type="number" name="materials[' + materialIndex + '].mrpLeadtime" style="width: 60px;"></td>';

			table.appendChild(newRow);
			materialIndex++;
		}

		// 총소요량 입력 시 순소요량 자동 계산
		document.addEventListener("input", function (e) {
			if (e.target.classList.contains("totalQty")) {
				const totalInput = e.target;
				const row = totalInput.closest("tr");

				const availableInput = row.querySelector(".availableQty");
				const netInput = row.querySelector(".netQty");

				const total = parseInt(totalInput.value) || 0;
				const available = parseInt(availableInput.value) || 0;
				const net = Math.max(total - available, 0);

				netInput.value = net;
			}
		});
	</script>
</body>
</html>
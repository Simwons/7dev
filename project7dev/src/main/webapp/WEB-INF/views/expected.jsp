<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 입고 관리</title>

<style>
	/* 전체 레이아웃 */
	body {
		font-family: 'Arial', sans-serif;
		padding: 20px;
	}
	
	h1 {
		text-align: left;
		margin-bottom: 30px;
	}
	
	/* 검색 영역 */
	form {
		margin-bottom: 20px;
	}

	select, input[type="date"] {
		margin: 0 5px;
		padding: 3px 5px;
	}

	button {
		background-color: #4CAF50;
		color: white;
		border: none;
		padding: 7px 14px;
		cursor: pointer;
	}

	button:hover {
		background-color: #45a049;
	}

	table {
		width: 100%;
		border-collapse: collapse;
		text-align: center;
	}

	th, td {
		padding: 10px;
		border: 1px solid #ddd;
	}

	th {
		background-color: #f2f2f2;
	}

	/* 모달 */
	#myModal {
		display: none;
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.4);
		z-index: 1000;
	}

	#myModal > div {
		background: white;
		margin: 10% auto;
		padding: 20px;
		border-radius: 5px;
		width: 1200px;
		text-align: center;
	}
	#body{
		background: #d2d2d2;
	}
</style>

<script>
	function openModal() {
		let checked = document.querySelectorAll('.materialChk:checked');
		let modalTableBody = document.querySelector('#body');
		modalTableBody.innerHTML = "";  // 모달 내용 초기화
		let index =0;
		
		checked.forEach(chk => {
			let no = chk.dataset.no;
			let name = chk.dataset.name;
			let code = chk.dataset.code;
			let raw_material = chk.dataset.raw_material;
			let description = chk.dataset.description;
			let unit = chk.dataset.unit;
			let cnt = chk.dataset.cnt;
			let sup_name = chk.dataset.sup_name;
			let in_date = chk.dataset.in_date;
			let state = chk.dataset.state;
			let in_no = chk.dataset.in_no;
			const row = document.createElement("tr");
			row.innerHTML = `
					<td><input type="hidden" name="incomingDTOList[\${index}].material_no" value="\${no}" required>\${no}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_name" value="\${name}" required>\${name}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_code" value="\${code}" required>\${code}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_raw_material" value="\${raw_material}" required>\${raw_material}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_description" value="\${description}" required>\${description}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_unit" value="\${unit}" required>\${unit}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_in_cnt" value="\${cnt}" required>\${cnt}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].sup_name" value="\${sup_name}" required>\${sup_name}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].mstorage_in_date" value="\${in_date}" required>\${in_date}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].state" value="\${state}" required>${incoming.state == 0 ? '검수중' : '검수완료'}</td>
					<td><input type="hidden" name="incomingDTOList[\${index}].material_in_no" value="\${in_no}" required>\${in_no}</td>
			`;
			
				// 창고 선택 셀 추가
				let storageTd = document.createElement('td');
				storageTd.innerHTML = `
					<select name="incomingDTOList[\${index}].mstorage_code" class="storageSelect">
						<option value="MW001">MW001</option>
						<option value="MW002">MW002</option>
						<option value="MW003">MW003</option>
					</select>
					<input type="hidden" name="incomingDTOList[\${index}].mstorage_plant_code" class="plantCode" />
				`;
			
			row.appendChild(storageTd);
			modalTableBody.appendChild(row);
			
			// 이벤트 연결: select가 바뀔 때 plant_code 자동 설정
				const select = storageTd.querySelector(".storageSelect");
				const plantCodeInput = storageTd.querySelector(".plantCode");
	
				select.addEventListener("change", () => {
					const codeMap = {
						"MW001": "PL001",
						"MW002": "PL002",
						"MW003": "PL003"
					};
					plantCodeInput.value = codeMap[select.value] || "";
				});
				select.dispatchEvent(new Event("change"));
				
			index++;
		});
		document.getElementById('myModal').style.display = 'block';
		
	}

	function closeModal() {
		document.getElementById('myModal').style.display = 'none';
	}
	
	  function updateStorageCode(selectElem, index) {
	    document.getElementById("mstorageCode" + index).value = selectElem.value;
	  }
 
</script>

</head>

<body>

	<h1>자재입고관리</h1>
	
	<!-- 검색 조건 영역 -->
	<form action="expected" method="Get">
		자재코드 : <input type="text" name="material_code" value="${param.material_code}">
	
		입고상태 :
			검수중: <input type="radio" name="state" value="0" ${state == 0 ? 'checked' : ''}>
			완료: <input type="radio" name="state" value="1" ${state == 1 ? 'checked' : ''}>

		입고날짜 : 	
		<input type="date" name="start_date" value="${param.start_date}"> ~ 
		<input type="date" name="end_date" value="${param.end_date}">
	
		<button type="submit">검색</button>
	</form>

	<!-- 입고예정 목록 테이블 -->
	
		<table>
			<thead>
				<tr>
					<th>선택</th>
					<th>부품명</th>
					<th>품목코드</th>
					<th>소재</th>
					<th>규격</th>
					<th>단위</th>
					<th>수량</th>
					<th>공급업체</th>
					<!-- 입고 상태에 따라 동적으로 컬럼명 표시 -->
				    <c:choose>
				      <c:when test="${state == 1}">
				        <th>입고날짜</th>
				      </c:when>
				      <c:otherwise>
				        <th>도착날짜</th>
				      </c:otherwise>
				    </c:choose>
				    <th>입고가능여부</th>
					<th>상태</th>
					<th>입고번호</th>
				</tr>
			</thead>
			<tbody class="chkbox">
			<!-- items의 값은 Controller에서 add.object()로 보낸 데이터를 가져오는 거 -->
				<c:forEach var="incoming" items="${expected}" >
				<tr>
				<td><input type="checkbox" class="materialChk" 
					data-no="${incoming.material_no}"
					data-name="${incoming.material_name}"
					data-code="${incoming.material_code}"
					data-raw_material="${incoming.material_raw_material}"
					data-description="${incoming.material_description}"
					data-unit="${incoming.material_unit}"
					data-cnt="${incoming.material_in_cnt}"
					data-sup_name="${incoming.sup_name}"
					data-in_date="${incoming.mstorage_in_date}"
					data-state="${incoming.state}"
					data-status="${incoming.purc_order_status}"
					data-in_no="${incoming.material_in_no}"
					<c:if test="${incoming.state == 1 || incoming.purc_order_status == 0}">disabled</c:if>
					
				 ></td> 
					<!-- <c:if test="${incoming.state == 1 || incoming.purc_order_status == 0}">disabled</c:if> 
							state(이미 창고에 입고)의 값이 1이거나, purc_order_status(구매마감상태'미완료')의 값이 0이면 체크선택 불가 체크박스 비활성화 -->
					<td>${incoming.material_name}</td>
					<td>${incoming.material_code}</td>
					<td>${incoming.material_raw_material}</td>
					<td>${incoming.material_description}</td>
					<td>${incoming.material_unit}</td>
					<td>${incoming.material_in_cnt}</td>
					<td>${incoming.sup_name}</td>
					<td>${incoming.mstorage_in_date}</td>
					<td>${incoming.purc_order_status == 0 ? '입고불가' : '입고가능' }
					<td>${incoming.state == 0 ? '입고대기' : '입고완료'}</td>
					<td>${incoming.material_in_no}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	
	<br>
	
	<!-- 모달창열기 -->
	
	<c:if test="${state != 1}">
    <button type="button" onclick="openModal()">자재 등록</button>
	</c:if>
	
					
	<!-- 모달창 -->
	
	<div id="myModal" style="display:none; border:1px solid black; padding:20px;">
	
		<h3>선택한 자재 리스트</h3>
	<form action="${pageContext.request.contextPath}/expected/inProcess" method="post">
		<table id="modalTable" border="1">
			<thead>
				<tr>
							<th>번호</th>
							<th>부품명</th>
							<th>품목코드</th>
							<th>소재</th>
							<th>규격</th>
							<th>단위</th>
							<th>수량</th>
							<th>공급업체</th>
							<!-- 입고 상태에 따라 동적으로 컬럼명 표시 -->
						    <c:choose>
						      <c:when test="${state == 1}">
						        <th>입고날짜</th>
						      </c:when>
						      <c:otherwise>
						        <th>도착날짜</th>
						      </c:otherwise>
						    </c:choose>
							<th>상태</th>
							<th>입고번호</th>
							<th>창고</th>
				</tr>
			</thead>
		
			<tbody id="body">
				
			</tbody>
		</table>
		<input type="submit" value="등록">
	</form>
		
		<button onclick="closeModal()">닫기</button>
	</div>


	</body>
</html>

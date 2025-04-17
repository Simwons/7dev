<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자재 입고 관리</title>

</head>

<body>

	<h1>자재입고관리</h1>
	
	<!-- 검색 조건 영역 -->
	<form action="material_handling" method="get">
		발주번호 : <input type="text" name="order_code" value="${param.purc_order_code}">
		
		조달상태:
		<select name="mstorage_in_date">
			<option value="">선택없음</option>
			<option value="1" ${mstorage_in_date == '1' ? 'selected' : ''}>완료</option>
			<option value="0" ${mstorage_in_date == '0' ? 'selected' : ''}>미완료</option>
		</select>

		구매마감상태:
		<select name="purc_order_status">
			<option value="">선택없음</option>
			<option value="1" ${purc_order_status == 1 ? 'selected' : ''}>완료</option>
			<option value="0" ${purc_order_status == 0 ? 'selected' : ''}>미완료</option>
		</select>
		
		자재마감상태:
		<select name="state">
			<option value="">선택없음</option>
			<option value="1" ${state == 1 ? 'selected' : ''}>완료</option>
			<option value="0" ${state == 0 ? 'selected' : ''}>미완료</option>
		</select>
		
		발주날짜 : 	<!-- purc_order_reg_date를 기준으로 검색 -->
		<input type="date" name="start_date" value="${param.start_date}"> ~ 
		<input type="date" name="end_date" value="${param.end_date}">
	
		<button type="submit">검색</button>
	</form>

	<!-- 입고예정 목록 테이블 -->
	<form action="purchaseClose" method="post">
		<table>
			<thead>
				<tr>
					<th>선택</th>
					<th>발주번호</th>
					<th>거래처명</th>
					<th>품목명</th>
					<th>구매수량</th>
					<th>입고수량</th>
					<th>발주일</th>
					<th>도착날짜</th>
					<th>조달상태</th>
					<th>구매마감</th>
					<th>자재마감</th>
				</tr>
			</thead>
			<tbody class="chkbox">
			<!-- items의 값은 Controller에서 add.object()로 보낸 데이터를 가져오는 거 -->
				<c:forEach var="incoming" items="${material_handling}" >
				<tr>
				<td><input type="checkbox" name="purc_order_no" value="${incoming.purc_order_no}" 
					<c:if test="${incoming.state == 1 || incoming.purc_order_status == 1 || incoming.mstorage_in_date == null}">disabled</c:if> 
				 ></td> 
					<!-- <c:if test="${incoming.state == 1}">disabled</c:if> state의 값이 1이면 체크박스 비활성화 -->	
					<td>${incoming.purc_order_code}</td>
					<td>${incoming.sup_name}</td>
					<td>${incoming.material_name}</td>
					<td>${incoming.material_in_cnt}</td>
					<td>${incoming.material_in_cnt}</td>
					<td>${incoming.purc_order_reg_date}</td>
					<td>${incoming.mstorage_in_date}</td>
					<td>${incoming.mstorage_in_date != null ? '도착완료':'배송중'}</td>
					<!-- mstorage_in_date(자재회사에서 보낸 자재가 도착한 날짜가 생성되면 '도착완료'로 자동 변경 -->
					<td>${incoming.purc_order_status == 0 ?'미완료':'완료'}</td>
					<td>${incoming.state == 0 ? '미완료':'완료' }</td>
					<!-- 자재마감상태는 자재입고페이지에서 자재별로 나눠져 창고에 입고하면 state값이 1로 바뀌고 그러므로 '완료'로 자동변경 -->
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	<br>
	
	<button type="submit">선택 발주 구매마감</button>
		</form>
	</body>
</html>

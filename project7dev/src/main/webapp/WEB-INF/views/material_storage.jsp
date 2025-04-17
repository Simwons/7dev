<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>창고별 자재리스트</title>
</head>
<body>
	
	<h1>창고별 자재 리스트</h1>
	
	<form action="material_storage" method="get">
	창고코드 :
	<select name="mstorage_code" required>
    <option value="MW001" <c:if test="${mstorage_code eq 'MW001'}">selected</c:if>>MW001</option>
    <option value="MW002" <c:if test="${mstorage_code eq 'MW002'}">selected</c:if>>MW002</option>
    <option value="MW003" <c:if test="${mstorage_code eq 'MW003'}">selected</c:if>>MW003</option>
	</select>
	
	자재코드 : <input type="text" name="material_code" value="${param.material_code}">
	
	입고날짜 : 	
	<input type="date" name="start_date" value="${param.start_date}">
	~
	<input type="date" name="end_date" value="${param.end_date}">
	
	<button type="submit">검색</button>
	</form>
	
	<table border="1">
    <thead>
        <tr>
            <th>부품명</th>
            <th>품목코드</th>
            <th>소재</th>
            <th>규격</th>
            <th>단위</th>
            <th>수량</th>
            <th>창고</th>
            <th>담당자</th>
            <th>공급업체</th>
            <th>투입레벨</th>
            <th>입고날짜</th>
        </tr>
    </thead>
    <tbody>
	<c:forEach var="incoming" items="${material_storage}">
	<tr>
		<td>${incoming.material_name}</td>
		<td>${incoming.material_code}</td>
		<td>${incoming.material_raw_material}</td>
		<td>${incoming.material_description}</td>
		<td>${incoming.material_unit}</td>
		<td>${incoming.mstorage_stock}</td>
		<td>${incoming.mstorage_code}</td>
		<td>${incoming.emp_name}</td>
		<td>${incoming.sup_name}</td>
		<td>${incoming.product_no}</td>
		<td>${incoming.material_in_date}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
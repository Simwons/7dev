<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- 현재 요청 URL을 얻기 위함 (활성 메뉴 표시에 사용) --%>
<c:set var="currentUrl" value="${pageContext.request.requestURI}" />

<style>
    .side-menu { list-style: none; padding: 0; margin: 0; width: 180px; }
    .side-menu > li { /* 대분류 */ margin-bottom: 5px; font-weight: bold; padding: 10px; background-color: #e9ecef; }
    .side-menu ul { list-style: none; padding-left: 15px; margin-top: 5px; }
    .side-menu ul li { margin-bottom: 5px; font-weight: normal; }
    .side-menu a { text-decoration: none; color: #333; display: block; padding: 5px; }
    .side-menu a:hover { background-color: #f0f0f0; }
    /* 현재 활성화된 메뉴 스타일 */
    .side-menu a.active { color: #007bff; font-weight: bold; background-color: #e0e0e0; }
</style>

<ul class="side-menu">
    <li>Dashboard</li>
    <li>개발</li>
    <li>품목정보</li>
    <li>부품정보</li>
    <li>생산</li>
    <li>구매</li>
    <li>거래처 관리</li>
    <li>견적 관리</li>
    <li>계약 관리</li>
    <li>자재재고
        <ul>
            <%-- 현재 URL과 링크 URL이 일치하면 active 클래스 추가 --%>
            <li><a href="${contextPath}/inventory/status" class="${currentUrl.endsWith('/inventory/status') ? 'active' : ''}">재고조회</a></li>
            <li><a href="${contextPath}/inventory/documents" class="${currentUrl.endsWith('/inventory/documents') ? 'active' : ''}">자재문서조회</a></li>
            <li><a href="${contextPath}/inventory/report" class="${currentUrl.endsWith('/inventory/report') ? 'active' : ''}">재고현황</a></li>
        </ul>
    </li>
</ul>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
    .main-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px 20px;
        background-color: #f8f9fa; /* 예시 배경색 */
        border-bottom: 1px solid #dee2e6;
    }
    .main-header .logo { font-size: 1.5em; font-weight: bold; }
    .main-header .user-info a { margin-left: 15px; text-decoration: none; color: #007bff; }
</style>

<div class="main-header">
    <div class="logo">7chilldev</div>
    <div class="user-info">
        <span>안녕하세요 관리자 님</span>
        <a href="#">로그아웃</a>
        <a href="#">mypage</a>
    </div>
</div>
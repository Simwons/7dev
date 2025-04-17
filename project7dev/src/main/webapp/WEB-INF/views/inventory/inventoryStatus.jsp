<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A. 자재 재고 조회</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/test.css">
<style>
    body { margin: 0; font-family: sans-serif; display: flex; flex-direction: column; height: 100vh; }
    .main-container { display: flex; flex-grow: 1; }
    .left-menu { width: 200px; border-right: 1px solid #ccc; background-color: #f8f9fa; height: 100%; overflow-y: auto; }
    .content-area { flex-grow: 1; padding: 20px; display: flex; flex-direction: column; }
    .search-criteria { border: 1px solid #ccc; padding: 15px; margin-bottom: 20px; background-color: #fdfdfd; }
    .search-criteria fieldset { border: none; padding: 0; margin: 0; }
    .search-criteria legend { font-weight: bold; margin-bottom: 10px; font-size: 1.1em; }
    .criteria-row { display: flex; align-items: center; margin-bottom: 10px; flex-wrap: wrap; }
    .criteria-row label { width: 90px; text-align: right; margin-right: 10px; font-size: 0.9em; }
    .criteria-row input[type=text], .criteria-row input[type=month] { width: 130px; padding: 5px; margin-right: 20px; }
    .search-button-row { text-align: right; margin-top: 10px; }
    #resultsArea { flex-grow: 1; border: 1px solid #ccc; padding: 15px; overflow-y: auto; }
    table.styled-table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    table.styled-table th, table.styled-table td { border: 1px solid #ddd; padding: 8px; text-align: center; font-size: 0.9em; }
    table.styled-table th { background-color: #e9ecef; }
    .error-message { color: red; }
    table.styled-table td:nth-child(3),
    table.styled-table td:nth-child(7),
    table.styled-table td:nth-child(8) { text-align: right; }
</style>
</head>
<body>
    <jsp:include page="common/header.jsp" />
    <div class="main-container">
        <jsp:include page="common/menu.jsp" />
        <div class="content-area">
            <h2>재고 조회</h2>
            <div class="search-criteria">
                <form id="statusForm">
                    <fieldset>
                        <legend>조회 조건</legend>
                        <div class="criteria-row">
                            <label>기간(연월):</label>
                            <input type="month" name="queryMonthFrom" title="시작월"> ~
                            <input type="month" name="queryMonthTo" title="종료월">
                            <label>플랜트:</label>
                            <input type="text" name="plantCodeFrom" title="플랜트 시작"> ~
                            <input type="text" name="plantCodeTo" title="플랜트 종료">
                        </div>
                        <div class="criteria-row">
                            <label>자재품번:</label>
                            <input type="text" name="materialCodeFrom" title="자재품번 시작"> ~
                            <input type="text" name="materialCodeTo" title="자재품번 종료">
                            <label>저장위치:</label>
                            <input type="text" name="storageCodeFrom" title="저장위치 시작"> ~
                            <input type="text" name="storageCodeTo" title="저장위치 종료">
                        </div>
                        <div class="search-button-row">
                            <button type="button" id="searchBtn">조회</button>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div id="resultsArea"></div>
        </div>
     </div>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#searchBtn').on('click', function() {
                const formId = '#statusForm';
                const params = $(formId).serialize();
                const apiUrl = '${pageContext.request.contextPath}/api/inventory/status';
                const pageIdentifier = 'status';
                $('#resultsArea').html('로딩 중...');
                $.ajax({
                    url: apiUrl,
                    type: 'GET',
                    data: params,
                    dataType: 'json',
                    success: function(response, textStatus, jqXHR) {
                        const columns = 8;
                        let tableHtml = '<table class="styled-table">';
                        tableHtml += '<thead><tr>';
                        tableHtml += '<th>자재품번</th><th>자재내역</th><th>현재고</th><th>단위</th>';
                        tableHtml += '<th>플랜트</th><th>저장위치</th><th>기초재고</th><th>기간변동</th>';
                        tableHtml += '</tr></thead>';
                        tableHtml += '<tbody>';
                        if (Array.isArray(response) && response.length > 0) {
                            $.each(response, function(i, item) {
                                const materialCode = item.materialCode || '';
                                const materialDesc = item.materialDesc || '';
                                const stockQty = item.stockQty != null ? item.stockQty : 0;
                                const plantCode = item.plantCode || '';
                                const stockLocation = item.stockLocation || '';
                                const openingStock = item.openingStock != null ? item.openingStock : 0;
                                const periodNetChange = item.periodNetChange != null ? item.periodNetChange : 0;
                                tableHtml += '<tr>' +
                                                '<td>' + materialCode + '</td>' +
                                                '<td>' + materialDesc + '</td>' +
                                                '<td style="text-align:right;">' + stockQty + '</td>' +
                                                '<td>EA</td>' +
                                                '<td>' + plantCode + '</td>' +
                                                '<td>' + stockLocation + '</td>' +
                                                '<td style="text-align:right;">' + openingStock + '</td>' +
                                                '<td style="text-align:right;">' + periodNetChange + '</td>' +
                                             '</tr>';
                            });
                        } else {
                            tableHtml += '<tr><td colspan="' + columns + '"><p class="error-message">조회된 데이터가 없습니다.</p></td></tr>';
                        }
                        tableHtml += '</tbody></table>';
                        $('#resultsArea').html(tableHtml);
                    },
                    error: function(xhr, status, error) {
                        console.error(`--- ${pageIdentifier} AJAX 오류 ---`);
                        console.error('Status:', status, 'Error:', error);
                        const errorColumns = 8;
                        $('#resultsArea').html(`<table><tbody><tr><td colspan="${errorColumns}"><p class="error-message">데이터 조회 중 오류 (${status})</p></td></tr></tbody></table>`);
                    }
                });
            });
            $('input[name="queryMonthFrom"]').val('2025-01');
            $('input[name="queryMonthTo"]').val('2025-04');
            $('#searchBtn').click();
        });
    </script>
</body>
</html>
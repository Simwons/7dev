<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C. 재고 현황 보고서</title>
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
    table.styled-table td:nth-child(n+4) { text-align: right; }
</style>
</head>
<body>
    <jsp:include page="common/header.jsp" />
    <div class="main-container">
        <jsp:include page="common/menu.jsp" />
        <div class="content-area">
             <h2>재고 현황 보고서</h2>
             <div class="search-criteria">
                <form id="reportForm">
                    <fieldset>
                        <legend>조회 조건</legend>
                        <div class="criteria-row">
                            <label>조회 월:</label>
                            <input type="month" name="queryMonthFrom" title="시작월"> ~
                            <input type="month" name="queryMonthTo" title="종료월">
                            <label>자재 유형:</label>
                            <input type="text" name="materialTypeFrom" title="자재 유형 시작"> ~
                            <input type="text" name="materialTypeTo" title="자재 유형 종료">
                        </div>
                         <div class="criteria-row">
                            <label>자재 품번:</label>
                            <input type="text" name="materialCodeFrom" title="자재 품번 시작"> ~
                            <input type="text" name="materialCodeTo" title="자재 품번 종료">
                            <label>저장 위치:</label>
                            <input type="text" name="storageCodeFrom" title="저장 위치 시작"> ~
                            <input type="text" name="storageCodeTo" title="저장 위치 종료">
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
                const formId = '#reportForm';
                const params = $(formId).serialize();
                const apiUrl = '${pageContext.request.contextPath}/api/inventory/report';
                const pageIdentifier = 'report';
                $('#resultsArea').html('로딩 중...');
                $.ajax({
                    url: apiUrl,
                    type: 'GET',
                    data: params,
                    dataType: 'json',
                    success: function(response, textStatus, jqXHR) {
                        const columns = 9;
                        let tableHtml = '<table class="styled-table">';
                        tableHtml += '<thead><tr>';
                        tableHtml += '<th>자재유형</th><th>플랜트</th><th>저장위치</th>';
                        tableHtml += '<th>기초수량</th><th>기간변동</th><th>기말수량</th>';
                        tableHtml += '<th>기초금액</th><th>기말금액</th><th>증감금액</th>';
                        tableHtml += '</tr></thead>';
                        tableHtml += '<tbody>';
                        if (Array.isArray(response) && response.length > 0) {
                            $.each(response, function(i, item) {
                                const materialType = item.materialType || '';
                                const plantCode = item.plantCode || '';
                                const stockLocation = item.stockLocation || '';
                                const openingStockQty = item.openingStockQty || 0;
                                const periodNetChangeQty = item.periodNetChangeQty || 0;
                                const stockQty = item.stockQty || 0;
                                const openingStockAmount = item.openingStockAmount || 0;
                                const inventoryAmount = item.inventoryAmount || 0;
                                const periodNetChangeAmount = item.periodNetChangeAmount || 0;
                                tableHtml += '<tr>' +
                                               '<td>' + materialType + '</td>' +
                                               '<td>' + plantCode + '</td>' +
                                               '<td>' + stockLocation + '</td>' +
                                               '<td style="text-align:right;">' + openingStockQty + '</td>' +
                                               '<td style="text-align:right;">' + periodNetChangeQty + '</td>' +
                                               '<td style="text-align:right;">' + stockQty + '</td>' +
                                               '<td style="text-align:right;">' + openingStockAmount + '</td>' +
                                               '<td style="text-align:right;">' + inventoryAmount + '</td>' +
                                               '<td style="text-align:right;">' + periodNetChangeAmount + '</td>' +
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
                        const errorColumns = 9;
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
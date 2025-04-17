<%-- materialDocuments.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B. 자재 문서 조회</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
    /* 기존 스타일 유지 */
    body { margin: 0; font-family: sans-serif; display: flex; flex-direction: column; height: 100vh;}
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
    table.styled-table td:nth-child(6) { text-align: right; }
</style>
</head>
<body>
    <jsp:include page="common/header.jsp" />
    <div class="main-container">
        <jsp:include page="common/menu.jsp" />
        <div class="content-area">
            <h2>자재 문서 조회 <small>(입고 및 출고 내역)</small></h2>
            <div class="search-criteria">
                <form id="docsForm">
                    <fieldset>
                         <legend>조회 조건</legend>
                        <div class="criteria-row">
                            <label>조회 월:</label>
                            <input type="month" id="queryMonthFrom" name="queryMonthFrom" title="시작월"> ~
                            <input type="month" id="queryMonthTo" name="queryMonthTo" title="종료월">
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
        // --- 헬퍼 함수 (변경 없음) ---
        function formatDate(dateString) {
            if (!dateString) return '';
            try {
                const date = new Date(dateString.replace(' ', 'T'));
                if (isNaN(date.getTime())) { return dateString.split(' ')[0] || ''; }
                const year = date.getFullYear();
                const month = String(date.getMonth() + 1).padStart(2, '0');
                const day = String(date.getDate()).padStart(2, '0');
                return year + '-' + month + '-' + day;
            } catch (e) {
                console.error("Error formatting date:", dateString, e);
                return dateString.split(' ')[0] || '';
            }
        }
        function formatDocType(type) {
            if (type === 'IN') return '입고';
            if (type === 'OUT') return '출고';
            return type || '';
        }
        // --- 헬퍼 함수 끝 ---

         $(document).ready(function() {
            $('#searchBtn').on('click', function() {
                const formId = '#docsForm';
                const params = $(formId).serialize();
                // console.log("(Event Handler) Serialized Params:", params); // 필요 시 디버깅 로그 복원
                const apiUrl = '${pageContext.request.contextPath}/api/inventory/documents';
                const pageIdentifier = 'documents';
                $('#resultsArea').html('로딩 중...');
                $.ajax({
                    url: apiUrl,
                    type: 'GET',
                    data: params,
                    dataType: 'json',
                    success: function(response, textStatus, jqXHR) {
                        // --- Success 콜백 시작 로그 (정리됨) ---
                        // console.log(`--- ${pageIdentifier} AJAX Success Callback Start ---`);
                        // console.log("Received Raw Response:", response); // 필요 시 디버깅 로그 복원

                        try {
                            const columns = 9;
                            let tableHtml = '<table class="styled-table">';
                            tableHtml += '<thead><tr>';
                            tableHtml += '<th>문서타입</th><th>문서번호</th><th>일자</th><th>자재품번</th>';
                            tableHtml += '<th>자재내역</th><th>수량</th><th>단위</th><th>플랜트</th><th>저장위치</th>';
                            tableHtml += '</tr></thead>';
                            tableHtml += '<tbody>';

                            if (Array.isArray(response) && response.length > 0) {
                                $.each(response, function(i, item) {
                                    if (!item) { return true; } // continue
                                    const docType = formatDocType(item.documentType);
                                    const documentNo = item.documentNo || '';
                                    const docDate = formatDate(item.documentDate);
                                    const materialCode = item.materialCode || '';
                                    const materialDesc = item.materialDesc || '';
                                    const quantity = item.quantity != null ? item.quantity : 0;
                                    const plantCode = item.plantCode || '';
                                    const stockLocation = item.stockLocation || '';

                                    tableHtml += '<tr>' +
                                                     '<td>' + docType + '</td>' +
                                                     '<td>' + documentNo + '</td>' +
                                                     '<td>' + docDate + '</td>' +
                                                     '<td>' + materialCode + '</td>' +
                                                     '<td>' + materialDesc + '</td>' +
                                                     '<td style="text-align:right;">' + quantity + '</td>' +
                                                     '<td>EA</td>' +
                                                     '<td>' + plantCode + '</td>' +
                                                     '<td>' + stockLocation + '</td>' +
                                                  '</tr>';
                                });
                            } else {
                                tableHtml += '<tr><td colspan="' + columns + '"><p class="error-message">조회된 데이터가 없습니다.</p></td></tr>';
                            }
                            tableHtml += '</tbody></table>';
                            $('#resultsArea').html(tableHtml);
                            // console.log("Successfully updated #resultsArea."); // 필요 시 디버깅 로그 복원

                        } catch (e) {
                            console.error("Error occurred inside success callback while processing data:", e);
                            $('#resultsArea').html(`<table><tbody><tr><td colspan="9"><p class="error-message">데이터 처리 중 오류 발생: ${e.message}</p></td></tr></tbody></table>`);
                        } finally {
                             // console.log(`--- ${pageIdentifier} AJAX Success Callback End ---`); // 필요 시 디버깅 로그 복원
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error(`--- ${pageIdentifier} AJAX 오류 ---`);
                        console.error('Status:', status, 'Error:', error);
                        console.error('Response Text:', xhr.responseText);
                        const errorColumns = 9;
                        $('#resultsArea').html(`<table><tbody><tr><td colspan="${errorColumns}"><p class="error-message">데이터 조회 중 오류 (${status})</p></td></tr></tbody></table>`);
                    }
                }); // <- $.ajax 호출 끝
            }); // <- $('#searchBtn').on('click', ...) 끝

            // --- 기본값 설정 로직 (하드코딩: 2025-01 ~ 2025-04) ---
            try {
                console.log("Setting default month values (Hardcoded: 2025-01 to 2025-04)...");

                // --- !!! 하드코딩된 값 사용 !!! ---
                const defaultStartMonth = "2025-01"; // 시작 월
                const defaultEndMonth = "2025-04";   // 종료 월

                // --- 값 설정 ---
                $('#queryMonthFrom').val(defaultStartMonth);
                $('#queryMonthTo').val(defaultEndMonth);

                // --- 설정 후 값 확인 로그 (정리됨) ---
                // console.log("Value in #queryMonthFrom after set:", $('#queryMonthFrom').val());
                // console.log("Value in #queryMonthTo after set:", $('#queryMonthTo').val());

                // --- 자동 조회 실행 ---
                // 페이지 로드 시 바로 조회 실행 (setTimeout 없이)
                console.log("Triggering search click...");
                $('#searchBtn').click();

            } catch (e) {
                console.error("Error setting default month:", e);
            }
            // --- 기본값 설정 로직 끝 ---

        }); // <- $(document).ready(...) 끝
    </script>
</body>
</html>
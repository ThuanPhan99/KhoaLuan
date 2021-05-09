function reportProducts() {
    $("#reportProduct").css("display", "none");
    $("#reportProductLoading").css("display", "");
    $.ajax({
        url : '/quan-tri/thong-ke/products/report',
        type : 'GET',
        xhrFields: {
            responseType: 'blob'
        },
        success: function (data) {
            $("#reportProductLoading").css("display", "none");
            $("#reportProduct").css("display", "");
            var a = document.createElement('a');
            var url = window.URL.createObjectURL(data);
            a.href = url;
            a.download = 'thong_ke_san_pham.xlsx';
            document.body.append(a);
            a.click();
            a.remove();
            window.URL.revokeObjectURL(url);
        },
        error: function(xhr, status, error){
            $("#reportProductLoading").css("display", "none");
            $("#reportProduct").css("display", "");
            var errorMessage = xhr.status + ': ' + xhr.statusText
            alert('Error - ' + errorMessage);
        }
    });
};

function reportRevenue() {
    var fromDate  = $("#fromDate").val();
    var toDate  = $("#toDate").val();
    $("#reportRevenue").css("display", "none");
    $("#sniperReportRevenue").css("display", "");
    $.ajax({
        url : '/quan-tri/thong-ke/revenue/report?fromDate=' + fromDate + "&toDate=" + toDate,
        type : 'GET',
        xhrFields: {
            responseType: 'blob'
        },
        success: function (data) {
            $("#sniperReportRevenue").css("display", "none");
            $("#reportRevenue").css("display", "");
            var a = document.createElement('a');
            var url = window.URL.createObjectURL(data);
            a.href = url;
            a.download = 'thong_ke_doanh_thu.xlsx';
            document.body.append(a);
            a.click();
            a.remove();
            window.URL.revokeObjectURL(url);
        },
        error: function(xhr, status, error){
            $("#sniperReportRevenue").css("display", "none");
            $("#reportRevenue").css("display", "");
            var errorMessage = xhr.status + ': ' + xhr.statusText
            alert('Error - ' + errorMessage);
        }
    });
};

function reportProductLike() {

    var fromDate  = $("#fromDate").val();
    var toDate  = $("#toDate").val();
    $("#reportProductLike").css("display", "none");
    $("#sniperReportProductLike").css("display", "");
    $.ajax({
        url : '/quan-tri/thong-ke/productLike/report?fromDate=' + fromDate + "&toDate=" + toDate,
        type : 'GET',
        xhrFields: {
            responseType: 'blob'
        },
        success: function (data) {
            $("#sniperReportProductLike").css("display", "none");
            $("#reportProductLike").css("display", "");
            var a = document.createElement('a');
            var url = window.URL.createObjectURL(data);
            a.href = url;
            a.download = 'Thong_Ke_Yeu_Thich.xlsx';
            document.body.append(a);
            a.click();
            a.remove();
            window.URL.revokeObjectURL(url);
        },
        error: function(xhr, status, error){
            $("#sniperReportProductLike").css("display", "none");
            $("#reportProductLike").css("display", "");
            var errorMessage = xhr.status + ': ' + xhr.statusText
            alert('Error - ' + errorMessage);
        }
    });
};
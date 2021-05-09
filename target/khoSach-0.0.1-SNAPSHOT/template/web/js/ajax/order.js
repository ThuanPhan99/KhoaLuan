$('#submitorder').click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $('#formSubmit').serializeArray();
    $.each(formData, function (i, v) {
        data["" + v.name + ""] = v.value;
    });
    data["productIDs"] = $('#productIDs').val();
    data["totalMoney"] = $('#totalMoney').val();
    if(data["paymentMethods"] == "2"){
        addOrderMomo(data);
    } else {
        addOrder(data);
    }
});
function addOrderMomo(data) {
    $.ajax({
        url: '/api/orderMomo',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function (res) {
            console.log(res);
            $('#orderId').val(res.orderId);
            $('#requestId').val(res.requestId);
            $('#iframe_a').attr('src', res.payUrl)
            $("#myModalMomo").modal();
        },
        error: function (res) {

        }
    });
}


function addOrder(data) {
    $.ajax({
        url: '/api/order',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function (res) {
            location.replace("/dat-hang-thanh-cong");
        },
        error: function (res) {

        }
    });
}

$(document).ready(function(){

});

function clearText() {
    $("#id").val("");
    $("#name").val("");
    $("#address").val("");
    $("#salary").val("");
}

$("#btnClear").click(()=>{
    clearText();
});

$("#btnSearch").click(function () {
    let id = $("#id").val();
    $.ajax({
        url: 'http://localhost:8080/Thogakade_Spring_war/customer?id=' + id,
        method: 'get',
        async: true,
        success: function (data, responseState, xhr) {
            console.log(data);
            loadAllCustomers();
            clearText();
        }
    });
});
$("#btnRemove").click(function () {
    let id = $("#id").val();
    $.ajax({
        url: 'http://localhost:8080/Thogakade_Spring_war/customer?id=' + id,
        method: 'delete',
        async: true,
        success: function (data, textState, xhr) {
            console.log(data);

            loadAllCustomers();
            clearText();
        }
    });
});


$("#btnSave").click(function () {

    let id = $("#id").val();
    let name = $("#name").val();
    let address = $("#address").val();
    let salary = $("#salary").val();

    $.ajax({
        method: "POST",
        url: "http://localhost:8080/Thogakade_Spring_war/customer",
        contentType: 'application/json',
        async: true,
        data: JSON.stringify({
            id: id,
            name: name,
            address: address,
            salary: salary
        }),
        success: function (data) {
            console.log(data);
            loadAllCustomers();
            clearText();
        }
    });


});

$("#btnGetAll").click(()=>{
    loadAllCustomers();
});

function loadAllCustomers() {
    $("#tBody").empty();

    $.ajax({
        url: "http://localhost:8080/Thogakade_Spring_war/customer",
        method: 'get',
        async: true,
        dataType:"json",
        success: function (data, textState, xhr) {
            for (let customer of data.data) {
                $("#tBody").append(`<tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.address}</td><td>${customer.salary}</td></tr>`);
            }

        }
    });
}


$("#btnUpdate").click(function () {
    let id = $("#id").val();
    let name = $("#name").val();
    let address = $("#address").val();
    let salary = $("#salary").val();

    $.ajax({
        url: "http://localhost:8080/Thogakade_Spring_war/customer",
        method: 'put',
        async: true,
        contentType: "application/json",
        data: JSON.stringify({
            id: id,
            name: name,
            address: address,
            salary: salary
        }),
        success: function (data, responseState, xhr) {
            console.log(data);
            loadAllCustomers();
            clearText();
        }
    });
});

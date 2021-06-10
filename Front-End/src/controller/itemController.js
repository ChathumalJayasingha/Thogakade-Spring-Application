
$('#btnItemSave').on('click', function() {

    $('#tblItem>tr').off('onclick');

    try {
        let code = $('#txtItemCode').val();
        let name = $('#txtItemName').val();
        let price = $('#txtItemPrice').val();
        let qty = $('#txtItemQTY').val();

        let db =itemDB.push(new Item(code,name,price,qty));
        db?(alert("Item Added")):(alert("Item Cant Add"));
    }catch (e) {
        alert("Item add Error    ---->"+e);
    }

    clearTextFields();
    loadToTable();

    $('#tblItem>tr').click(function() {
        $("#txtItemCode").val($(this).children('td:eq(0)').text());
        $("#txtItemName").val($(this).children('td:eq(1)').text());
        $("#txtItemPrice").val($(this).children('td:eq(2)').text());
        $("#txtItemQTY").val($(this).children('td:eq(3)').text());
    });

});

$('#btnItemClear').on('click',function () {
    clearTextFields();
});

function clearTextFields() {
    $('#txtItemCode').val("").focus();
    $('#txtItemName').val("");
    $('#txtItemPrice').val("");
    $('#txtItemQTY').val("");

}

function loadToTable() {
    let all= itemDB;
    $('#tblItem').empty();
    for (var i in all) {
        let code = all[i].getItemCode();
        let name = all[i].getItemName();
        let price = all[i].getItemPrice();
        let qty = all[i].getItemQTY();

        var row = `<tr><td>${code}</td><td>${name}</td><td>${price}</td><td>${qty}</td></tr>`;
        $('#tblItem').append(row);
    }
}

$("#btnItemDelete").click(function() {
    let code = $("#txtItemCode").val();

        let res = deleteItem(code);
        if (res) {
            alert("Item Deleted");
        } else {
            alert("Item Failed")
        }


    loadToTable();
    clearTextFields();


});

function deleteItem(code) {


    let item = searchItem(code);
    if (item != null) {
        let indexNumber = itemDB.indexOf(item);
        itemDB.splice(indexNumber, 1);
        return true;
    } else {
        return false;
    }
}

function searchItem(code) {
    for (var i in itemDB) {
        if (itemDB[i].getId() === code) return itemDB[i];
    }
    return null;
}

$("#btnItemUpdate").click(function() {
    let code = $("#txtItemCode").val();
    let name = $("#txtItemName").val();
    let price = $("#txtItemPrice").val();
    let qty = $("#txtItemQTY").val();

    let res = updateItem(code, name, price, qty);
    if (res) {
        alert("Item Updated");
    } else {
        alert("Item Fail");
    }

    loadToTable();
    clearTextFields();

    $('#tblItem>tr').mouseenter(function() {
        $("#txtItemCode").val($(this).children('td:eq(0)').text());
        $("#txtItemName").val($(this).children('td:eq(1)').text());
        $("#txtItemPrice").val($(this).children('td:eq(2)').text());
        $("#txtItemQTY").val($(this).children('td:eq(3)').text());
    });



});

function updateItem(code, name, price, qty) {
    let item = searchItem(code);
    if (item != null) {
        item.setItemName(name);
        item.setItemPrice(price);
        item.setItemQTY(qty);
        return true;
    } else {
        return false;
    }
}

$('#txtItemCode,#txtItemName,#txtItemPrice,#txtItemQTY').on('keydown', function(event) {
    if (event.key === "Tab") {
        event.preventDefault();
    }
});

$("#txtItemCode").on('keyup', function(event) {
    let regEx = /^(I)[0-9]{3}$/;

    let input = $("#txtItemCode").val();
    if (regEx.test(input)) {
        $("#txtItemCode").css('border', '10px solid green');
    } else {
        $("#txtItemCode").css('border', '10px solid red');
    }
    if (event.key ==="Enter") {
        $('#txtItemName').focus();
    }
});

$("#txtItemName").on('keyup', function(event) {
    let regEx = /^[A-z ]{1,}$/;

    let input = $("#txtItemName").val();
    if (regEx.test(input)) {
        $("#txtItemName").css('border', '10px solid green');
    } else {
        $("#txtItemName").css('border', '10px solid red');
    }
    if (event.key == "Enter") {
        $('#txtItemPrice').focus();
    }
});

$("#txtItemPrice").on('keyup', function(event) {
    let regEx = /^[0-9 - ]{1,}$/;

    let input = $("#txtItemPrice").val();
    if (regEx.test(input)) {
        $("#txtItemPrice").css('border', '10px solid green');
    } else {
        $("#txtItemPrice").css('border', '10px solid red');
    }
    if (event.key == "Enter") {
        $('#txtItemQTY').focus();
    }
});

$("#txtItemQTY").on('keyup', function(event) {
    let regEx = /^[0-9 -]{1,}$/;

    let input = $("#txtItemQTY").val();
    if (regEx.test(input)) {
        $("#txtItemQTY").css('border', '10px solid green');
    } else {
        $("#txtItemQTY").css('border', '10px solid red');
    }
    if (event.key == "Enter") {
        $('#btnItemSave').focus();
    }
});
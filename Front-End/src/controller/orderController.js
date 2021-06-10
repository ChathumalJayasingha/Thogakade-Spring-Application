
function loadToCustomerComboBox(){
    $('#selectCustomer').empty();
    let allCustomers = customerDB;
    for (var i in allCustomers) {
        let id = allCustomers[i].getId();
        // let name = allCustomers[i].getName();
        // let address = allCustomers[i].getAddress();
        // let contact = allCustomers[i].getContact();
        // var row = `<tr><td>${id}</td><td>${name}</td><td>${address}</td><td>${contact}</td></tr>`;
        var row=`<option>${id}</option>`;
        $('#selectCustomer').append(row);
    }
}


$("#selectCustomer").on("change", function () {
    let searchCustomer = searchCustomer($());
    if (searchCustomer){
        alert("ok"+searchCustomer)
    }else {
        alert("Bad"+searchCustomer)
    }
});function searchCustomer(id) {
    for (var i in customerDB) {
        if (customerDB[i].getId() === id) return customerDB[i];
    }
    return null;
}


function Customer(id, name, address, contact) {
    let __id = id;
    let __name = name;
    let __address = address;
    let __contact = contact;

    this.getId = function() { return __id; }
    this.getName = function() { return __name; }
    this.getAddress = function() { return __address; }
    this.getContact = function() { return __contact; }

    this.setId = function(id) { __id = id; }
    this.setName = function(name) { __name = name; }
    this.setAddress = function(address) { __address = address; }
    this.setContact = function(contact) { __contact = contact; }


}
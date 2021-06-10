function Item(code,name,price,qty) {
    let __itemCode=code;
    let __itemName=name;
    let __itemPrice=price;
    let __itemQty=qty;

    this.getItemCode=function () {return __itemCode;}
    this.getItemName=function () {return __itemName;}
    this.getItemPrice=function () {return __itemPrice;}
    this.getItemQTY=function () {return __itemQty;}

    this.setItemCode=function (code) {__itemCode=code;}
    this.setItemName=function (name) {__itemName=name;}
    this.setItemPrice=function (price) {__itemPrice=price;}
    this.setItemQTY=function (qty) {__itemQty=qty;}
}
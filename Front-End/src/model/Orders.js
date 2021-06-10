function Orders(oid, cid, date, discount, total) {
    this.__oid = oid;
    this.__cid = cid;
    this.__date = date;
    this.__discount = discount;
    this.__total = total;

    this.getOrderId = function () {
        return this.__oid;
    }
    this.setOrderId = function (oid) {
        this.__oid = oid;
    }

    this.getCustomerId = function () {
        return this.__cid;
    }
    this.setCustomerId = function (cid) {
        this.__cid = cid;
    }

    this.getDate = function () {
        return this.__date;
    }
    this.setDate = function (date) {
        this.__date = date;
    }

    this.getDiscount = function () {
        return this.__discount;
    }
    this.setDiscount = function (discount) {
        this.__discount = discount;
    }

    this.getTotal = function () {
        return this.__total;
    }
    this.setTotal = function (total) {
        this.__total = total;
    }
}
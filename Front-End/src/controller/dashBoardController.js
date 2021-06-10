

    function hideAll() {
        $("#mainMenu,#customerMenu,#itemMenu,#orderMenu").css('display', 'none');
    }


    $('#linkHome').click(function() {
        hideAll();
        $("#mainMenu").css('display', 'block');
    });
    $('#linkCustomer').click(function() {
        hideAll();
        $("#customerMenu").css('display', 'block');
    });
    $('#linkItem').click(function() {
        hideAll();
        $("#itemMenu").css('display', 'block');
    });
    $('#linkOrder').click(function() {
        hideAll();
        $("#orderMenu").css('display', 'block');
    });
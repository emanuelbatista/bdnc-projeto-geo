$(document).ready(function () {
    jQuery('#start').click(function () {
        alert('Clicou');
        jQuery('#imgLogo').animate({
            marginLeft: "-=1000"
        }, 500);
    });
});
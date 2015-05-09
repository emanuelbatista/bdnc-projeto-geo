$(document).ready(function () {

    var searchFocus = false;

    jQuery('#maps').hide();
    jQuery('#start').click(function () {
        jQuery('#init').fadeOut(1000);
        jQuery('#maps').fadeIn(1000);
        jQuery('#address').hide();
        jQuery('#addImageForm').hide();

        jQuery('#search').click(function () {
            jQuery('#search').fadeOut(500);
            jQuery('#address').fadeIn(400);
            jQuery('#address').focus();
            esconderAddImageForm();
        });

        function esconderAddress() {
            jQuery('#address').fadeOut(500);
            jQuery('#search').fadeIn(400);
        }

        function esconderAddImageForm() {
            jQuery('#addImageForm').fadeOut(500);
            jQuery('#add').fadeIn(400);
        }

        jQuery('#address').blur(function () {
            esconderAddress();
        });

        jQuery('#add').click(function () {
            jQuery('#add').fadeOut(500);
            jQuery('#addImageForm').fadeIn(400);
            jQuery('#authors').focus();

            $('body').keydown(function (e) {

                if (e.which === 27) {
                    esconderAddImageForm();
                }
            });
        });

        jQuery('#fechar').click(function () {
            esconderAddress();
            esconderAddImageForm();
        });

    });


});
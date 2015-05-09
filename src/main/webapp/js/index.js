$(document).ready(function(){
    
    var searchFocus = false;
    
	jQuery('#maps').hide();
	jQuery('#start').click(function(){
		jQuery('#init').fadeOut(1000);
		jQuery('#maps').fadeIn(1000);
                jQuery('#address').hide();
                
                
                jQuery('#search').click(function (){
                    jQuery('#search').fadeOut(500);
                    jQuery('#address').fadeIn(400);
                    jQuery('#address').focus();
                }); 
                
                
                jQuery('#address').blur(function (){
                   jQuery('#address').fadeOut(500);
                   jQuery('#search').fadeIn(400);
                });
	});
        
        
});
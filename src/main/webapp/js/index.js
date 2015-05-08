$(document).ready(function(){
	jQuery('#maps').hide();
	jQuery('#start').click(function(){
		jQuery('#init').fadeOut(1000);
		jQuery('#maps').fadeIn(1000);
	});
});
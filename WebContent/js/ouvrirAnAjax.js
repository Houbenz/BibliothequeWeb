function ouvrirAn() {
	
$.ajax({
	type:'post',
	url:'DemarrerAn',
	data:{
		ouvrir:1
	},
	success: function(msg) {
		$("#aff").append(msg);
	}
});

}
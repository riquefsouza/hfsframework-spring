//var admParametroCategoria_id = $('#admParametroCategoria_id').val();
var admParametroCategoria_descricao = $('#admParametroCategoria_descricao');
var admParametroCategoria_ordem = $('#admParametroCategoria_ordem');

$('#btnCancelar').click(function(event) {
	event.preventDefault();
	
	window.location.href='/admParametroCategoriaMB/listar';	
});

$('#btnSalvar').click(function(event) {
	event.preventDefault();

	alert(admParametroCategoria_descricao.val());
});

$(function() {  	
	var responsePage = getPersistedItem("responsePage");
		
	$.get(responsePage, function(responsePage) {
		admParametroCategoria_descricao.val(responsePage.descricao);
		admParametroCategoria_ordem.val(responsePage.ordem);
		removePersistedItem("responsePage");
	});
 	 	
});

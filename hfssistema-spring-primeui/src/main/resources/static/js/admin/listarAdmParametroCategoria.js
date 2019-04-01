//var dataRowSelected;

$('#btnExportar').click(function(event) {
	event.preventDefault();
	
	var sUrl = 'exportar/'+$('#cmbTipoRelatorio').val()+'/'+$('#forcaDownload')[0].checked;
	window.open(sUrl, '_blank');	
});

$('#btnIncluir').click(function(event) {
	event.preventDefault();
	
	window.location.href='incluir';
});	
	
$('#btnEditar').click(function(event) {
	event.preventDefault();
	$('#alert-messages').hide();
	
	var dataRowSelected = $('#tabelaAdmParametroCategoria').puidatatable('getSelection');
	
	if (dataRowSelected.length > 0) {
		$.get(dataRowSelected[0]._links.self.href, function(responsePage) {
				persistItem("responsePage", responsePage._links.self.href);
				window.location.href='editar';
		});
	} else {
		$('#alert-messages').show();
	}
		
});	

function construirDialogExcluir(){
	$('#dlgDeleteConfirmation').puidialog({
	    minimizable: false,
	    maximizable: false,
	    responsive: true,
	    minWidth: 200,
	    modal: true,
	    buttons: [{
	            text: 'Sim',
	            icon: 'fa-check',
	            click: function() {
	            	var dataRowSelected = $('#tabelaAdmParametroCategoria').puidatatable('getSelection');
	            	
	            	if (dataRowSelected.length > 0) {
	            		console.log(dataRowSelected[0].descricao);	
	            	}
	            	
	                $('#dlgDeleteConfirmation').puidialog('hide');
	            }
	        },
	        {
	            text: 'Não',
	            icon: 'fa-close',
	            click: function() {
	                $('#dlgDeleteConfirmation').puidialog('hide');
	            }
	        }
	    ]
	});	
}

$('#btn-show').puibutton({
    icon: 'fa-external-link-square',
    click: function() {
        $('#dlg').puidialog('show');
    }
});


$('#btnExcluir').click(function(event) {
	event.preventDefault();
	$('#alert-messages').hide();
	
	var dataRowSelected = $('#tabelaAdmParametroCategoria').puidatatable('getSelection');
	
	if (dataRowSelected.length > 0) {
		$('#dlgDeleteConfirmation').puidialog('show');
	} else {
		$('#alert-messages').show();
	}
	
});

$('#btnVoltar').click(function(event) {
	event.preventDefault();
	
	window.location.href='/';
});	


function construirTabelaAdmParametroCategoria(sURL, responsePage) {
	$('#tabelaAdmParametroCategoria').puidatatable({
		caption: 'Categoria dos Parâmetros de Configuração',
		lazy: true,
		responsive: true,	           
		selectionMode: 'single',
		paginator: {
			rows: responsePage.page.size,
			totalRecords: (responsePage.page.totalElements-responsePage.page.size)
		},
		columns: [
			{field: 'descricao', headerText: 'Descrição', sortable: true, filter: false},
			{field: 'ordem', headerText: 'Ordem', sortable: true, filter: false}
		],
		datasource: function(callback, ui) {
			//ui.first = Index of the first record
			//ui.rows = Number of rows to load
			//ui.sortField = Field name of the sorted column
			//ui.sortOrder = Sort order of the sorted column
			//ui.sortMeta = Array of field names and sort orders of the sorted columns 
			//ui.filters = Filtering information with field-value pairs like ui.filters['fieldname'] = 'filtervalue'
			var uri = '';
			var ascDesc = 'asc';
			var fieldSort = 'id';
			
			//console.log(ui);
			/*
			if (ui.filters){
			   if (ui.filters.length > 0){
			   		console.log(ui.filters[0].field);
			   		console.log(ui.filters[0].value);
			   }	        	   		
			}
			*/	           
			
			ui.sortField ? fieldSort = ui.sortField : fieldSort = 'id'; 	            
			ui.sortOrder == 1 ? ascDesc='asc' : ascDesc='desc';
			
			if (ui.first==0)
				uri = sURL+'?page=0&size='+responsePage.page.size+'&sort='+fieldSort+','+ascDesc;
			else
				uri = sURL+'?page='+((ui.first/ui.rows)+1)+'&size='+responsePage.page.size+'&sort='+fieldSort+','+ascDesc;
			
			console.log(uri);
		
			$.ajax({
				type: "GET",
				url: uri,
				dataType: "json",
		        context: this,
		        success: function(response) {
		        	callback.call(this, response._embedded.admParametroCategorias);
		        }
		    });
		},	           
		rowSelect: function(event, data) {
			//dataRowSelected = data;
		}
	});
	
}

$(function() {  	
	var sURL = 'http://localhost:8090/admParametroCategorias';
	
	$.get(sURL, function(responsePage) {
		construirDialogExcluir();
		construirTabelaAdmParametroCategoria(sURL, responsePage);
	});
 	 	
});

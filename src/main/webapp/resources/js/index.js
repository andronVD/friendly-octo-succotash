var anketaTableId = '#anketaTable';

$(document).ready(function() {
	initAnketaTable();
	initTableButtons();
});
function initAnketaTable(){
	$(anketaTableId).DataTable({
    	"processing": true,
        "serverSide": true,
        "ordering": true,
        "searching": true,
        "paging":   true,
        "ajax":{ 
        	"url": stCtxForm + "search",
        	"data": function ( d ) {
        		var searchModel = {
          			metaData: d,
          			selectedAreaId: $('#selectedSearchAreaId').val(),
            		selectedStatusId: $('#selectedSearchAnketaStatusId').val(),
        				selectedProgramId: $('#selectedSearchProgramId').val()
          		};
        		return JSON.stringify(searchModel);
        	}
        },
        "columns": [
            {
            	"class":          "details-control",
            	"orderable":      false,
            	"data":           null,
            	"defaultContent": "",
            	"width": "20px"
            },                    
            { "data": "formId" },
            { "data": "fio"},
            { "data": "educations[0].institutionName"},
            { "data": "numberOfPoints"},
            { "data": "status.name" },
            { "data": "formattedCreatedDate"},
            {	
	        	"class":		"actions",
	        	"orderable":      false,
	        	"data":           null,
	        	"width": "9%",
	          	"defaultContent": ''
	              	+ '<div class="btn-toolbar" role="toolbar">'
	              	+ '	<div class="btn-group" role="group"> '
	              	+ '		<button type="button" class="btn btn-danger btn-xs glyphicon glyphicon-edit" title="Изменить статус"></button>'
	              	+ ' </div>'
	              	+ '	<div class="btn-group" role="group"> '
	              	+ '		<button type="button" class="btn btn-info btn-xs glyphicon glyphicon-print" title="Версия для печати"></button>' 
	              	+ ' </div>'
	              	+ '	<div class="btn-group" role="group"> '
	              	+ '		<button type="button" class="btn btn-success btn-xs glyphicon glyphicon-envelope" title="Отправить анкету"/>'
	              	+ ' </div>'
	              	+ '</div>'
            }, 
            {	
            	"data":"status.id",
            	"visible":false	
            }
        ],
        "order": [[1, 'desc']]
    } );
}
function initTableButtons(){
    $(anketaTableId +' tbody').on( 'click', 'tr td.details-control', function () {
		var tr = $(this).closest('tr');
		var table = $(anketaTableId).DataTable();
        var row = table.row( tr );
        var formId = row.data().formId;
        if ( row.child.isShown() ) {
        	row.child.hide();
        	tr.removeClass( 'details' );
        } else {
        	//console.log('formId => ' + formId);
        	$.get(stCtxForm + formId + '/detailView',  function(data) {
				row.child(data).show();
        	}).success(function() {
      			//console.log('detail view is succesfully shown');
    		}).fail(function() {
    			row.child("К сожалению возникла техническая ошибка").show();
    			//alert( "К сожалению возникла техническая ошибка" );
    		});    			
        	tr.addClass( 'details' );
        }
        return;
    } );	
    
    $(anketaTableId +' tbody').on( 'click', 'tr td.actions button.glyphicon',function(){
		var btn = $(this);
		var table = $(anketaTableId).DataTable();
		var rowData = table.row( btn.parents('tr') ).data();
		if(btn.hasClass('glyphicon-edit')){
			openChangeStatusDialog(table, rowData);
		} else if(btn.hasClass('glyphicon-print')){
			window.open(stCtxForm + rowData.formId + '/pdfView', '_blank');
		} else if(btn.hasClass('glyphicon-envelope')){
			showSendDialog(rowData.formId);
		}
    });
}

function openChangeStatusDialog(table, rowData){
	$.get( stCtxForm + rowData.formId + '/selectStatus', {statusId:rowData.status.id}, function( content ) {
		$(content).modal({	
		}).on('hidden.bs.modal', function(){
			$(this).remove();
		}).on('shown.bs.modal', function () {
		})
	}).success(function() {
		$('input:text:visible:first').focus(); 
	}).fail(function() {
		alert( "К сожалению возникла техническая ошибка" );
	});
}

function updateStatus() {
	var table = $(anketaTableId).DataTable();
	var path = stCtxForm + $('#formId').val() + '/updateStatus';
	var data = {
		statusId : $('#selectStatusForm input:radio:checked').val()
	}
	//console.log('updateStatus:' + data.formId + ' statusId:' + data.statusId);
	$.post(path, data, function(content) {
		//
	}).success(function() {
		table.page(table.page.info().page).draw('page');
	}).fail(function(jqXHR) {
		if(jqXHR.status== 500){
		 alert("Возникла техническая ошибка!");
	    }else if (jqXHR.status== 502){
	    	alert("У вас нет прав доступа!");
	    }
	}).complete(function(){
		$('.modal').modal('hide');
	});
	return false;
} 

function changeStatus(elem){
	$('#selectedStatus').val($(elem).attr('statusId'));
}

function changeSearchArea(elem){
	console.log('changeSearchArea');
	
	$('#selectedSearchAreaId').val($(elem).attr('areaId'));
	console.log($('#selectedSearchAreaId').val());
	$(anketaTableId).DataTable().draw();
	return;
	window.location = ctx +'/st/index?searchAreaId=' 
	+ $('#selectedSearchAreaId').val()
	+ '&searchStatusId=' +  $('#selectedSearchAnketaStatusId').val()
	+ '&searchProgramId=' + $('#selectedSearchProgramId').val();
	
}

function changeSearchStatus(elem){
	var statusId = $(elem).attr('statusId');
	if(statusId == -1){
		$('#selectedSearchAnketaStatusId').val('');
	} else{
		$('#selectedSearchAnketaStatusId').val($(elem).attr('statusId'));
	}
	$(anketaTableId).DataTable().draw();
}

function changeSearchProgram(elem){
	$('#selectedSearchProgramId').val($(elem).val());
	$(anketaTableId).DataTable().draw();
}
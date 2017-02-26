var movesContainer = $('#moves-container');
var movesCounter = 1;

/* Obteniendo las variables internacionalizadas del código html*/
var mDescription = strings['movimiento.descripcion'];
var mDate = strings['movimiento.fecha'];
var mAmount = strings['movimiento.importe'];

window.onload = function() {
	
	if($.cookie("movimientos")) {
		restaurarForm();
		replicarImportes();
		replicarFechas();
	}
	
	if($.cookie("resultados") == "1") {
		$('#modalResultados').modal('show'); 
		$.cookie("resultados", null);
	}
	
	$("#limiteCredito").on("change paste keyup", function() {
		replicarImportes();
	});
	
	$("#fechaApertura").on("change paste keyup", function() {
		replicarFechas();
	});
	
	$("#comisionApertura").on("change paste keyup", function() {
		replicarImportes();
	});
	
	$("#corretaje").on("change paste keyup", function() {
		replicarImportes();
	});
	
	$("#add-moves").click(function(){
	    
	    var row = $('<div class="row" />');
	    var inputs = $('<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.descripcionMovimiento">'+ mDescription + '</label>' +
		        '<div class="field-widget"><i class="fa fa-pencil" ></i><input name="movimientos[' + movesCounter + '].descripcionMovimiento" id="movimientos' + movesCounter + '.descripcionMovimiento" type="text" required="required"/>' +
		  	'</div></div>' +
	      
	        '<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.importeMovimiento">' + mAmount + '</label>' + 
	            '<div class="field-widget">' +
	            '<i class="fa fa-eur" ></i>' +
		        	'<input name="movimientos[' + movesCounter + '].importeMovimiento" id="movimientos' + movesCounter + '.importeMovimiento" type="text" value="0.0" required="required"/>' + 
		        '</div>' +
		  	'</div>' +
	      
	        '<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.fechaMovimiento">'+ mDate + '</label>' +
            	'<div class="field-widget">' + 
            	'<i class="fa fa-calendar"></i>' +
		        '<input name="movimientos[' + movesCounter + '].fechaMovimiento" id="movimientos' + movesCounter + '.fechaMovimiento" type="date" value="0" required="required"/>' +
		  	'</div></div>');
	   
	    
	    row.append(inputs);
	    
	    row.appendTo(movesContainer);
	   
	    
	    /*
	    remove.click(function() {
	        $(this).parent().next("br").remove();
	        $(this).parent().remove();
	    });
	    */
	    
	    movesCounter++;
	});
	
	$("#remove-moves").click(function(){
		if(movesCounter > 1) {
			$('#moves-container .row').last().remove();
			$('#moves-container br').last().remove();
			
			movesCounter--;
		}
	});
}

function replicarImportes() {
	$("#importe-cero").val($("#limiteCredito").val() * ($("#comisionApertura").val()/1000.0));
	$("#importe-uno").val($("#limiteCredito").val() * ($("#corretaje").val()/1000.0));
}

function replicarFechas() {
	$("#fecha-cero").val($("#fechaApertura").val());
	$("#fecha-uno").val($("#fechaApertura").val());
}

function restaurarForm() {
	$("#fechaApertura").val($.cookie("fechaApertura"));
	$("#fechaVencimiento").val($.cookie("fechaVencimiento"));
	
	var movimientos = $.parseJSON($.cookie("movimientos"));
	
	movesContainer.empty();
	movesCounter = 0;
	
	for(var i=0; i<movimientos.length; i++) {
		addMovimiento(movimientos[i].descripcionMovimiento, movimientos[i].importeMovimiento, movimientos[i].fechaMovimiento, i);
	}
	
	var date = new Date();
	date.setTime(date.getTime() + (1 * 1000));
	
	$.cookie("movimientos", null, { expires: date });
	$.cookie("fechaApertura", null, { expires: date });
	$.cookie("fechaVencimiento", null, { expires: date });
}

function addMovimiento(descripcion, importe, fecha, index) {
	var row = $('<div class="row" />');
    var inputs = $('<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.descripcionMovimiento">'+ mDescription + '</label>' +
		        '<div class="field-widget"><i class="fa fa-pencil" ></i><input name="movimientos[' + movesCounter + '].descripcionMovimiento" id="movimientos' + movesCounter + '.descripcionMovimiento" type="text" required="required"/>' +
		  	'</div></div>' +
	      
	        '<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.importeMovimiento">' + mAmount + '</label>' + 
	            '<div class="field-widget">' +
	            '<i class="fa fa-eur" ></i>' +
		        	'<input name="movimientos[' + movesCounter + '].importeMovimiento" id="movimientos' + movesCounter + '.importeMovimiento" type="text" value="0.0" required="required"/>' + 
		        '</div>' +
		  	'</div>' +
	      
	        '<div class="section-field col-md-4">' +
	            '<label for="movimientos' + movesCounter + '.fechaMovimiento">'+ mDate + '</label>' +
            	'<div class="field-widget">' + 
            	'<i class="fa fa-calendar"></i>' +
		        '<input name="movimientos[' + movesCounter + '].fechaMovimiento" id="movimientos' + movesCounter + '.fechaMovimiento" type="date" value="0" required="required"/>' +
		  	'</div></div>');
   
    
    row.append(inputs);
    
    row.appendTo(movesContainer);
   
    
    /*
    remove.click(function() {
        $(this).parent().next("br").remove();
        $(this).parent().remove();
    });
    */
    
    movesCounter++;
}
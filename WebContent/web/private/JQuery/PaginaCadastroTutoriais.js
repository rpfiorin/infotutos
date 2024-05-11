$(document).ready(function(){
	
	function verificaTitulo() {
		if ($("#tituloTutorial").val() == "" || $("#tituloTutorial").val().length < 8){
			$("#avisoTutorial").text("Mínimo de 8 caracteres");
	    	$("#avisoTutorial").css("color", "red");
		} else {
		$.ajax({
		     type: "POST",
		     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaCadastroTutoriais",
		     data: {
		    	 titulo: ""+$('#tituloTutorial').val()
		     },
		     success: function (data) {
		    	 if (data == "verdadeiro"){
		    	 $("#avisoTutorial").text("Título indisponível!");
		    	 $("#avisoTutorial").css("color", "red");
		    	 } else {
		    	 $("#avisoTutorial").text("Título disponível!");
		    	 $("#avisoTutorial").css("color", "green");
		    	 }
		     }
		     });
		     return false;		
		} 
	}
	
	$("#tituloTutorial").change(function(){
		var value = $("#tituloTutorial").val();
		value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
		$("#tituloTutorial").val(value);
		verificaTitulo();
	});
	
	$("#tituloTutorial").focus(function(){
		if ($("#tituloTutorial").val() != '') {
		verificaTitulo();
		}
	});
	
	$("#tutorialEnviado").change(function() {
		formato = $("#tutorialEnviado").val().split('.').pop().toLowerCase();
		if(formato == "pdf"){
			$("#avisoArquivo").text("Arquivo válido!");
			$("#avisoArquivo").css("color", "green");
		} else {
			$("#avisoArquivo").text("Arquivo inválido!");
			$("#avisoArquivo").css("color", "red");
		}
	});
		
		$("#enviarTutorial").click(function() {
			var msg = "Preencha corretamente os campos necessários: ";
			if ($("#avisoTutorial").text() == "*" || $("#avisoTutorial").text() == "Título indisponível!" || 
				$("#avisoTutorial").text() == "Mínimo de 8 caracteres"){
				msg = "Preencha um título válido!";
				alert(msg);
				$("#tituloTutorial").focus();
				event.preventDefault();
			} else if ($("#avisoArquivo").text() == "*" || $("#avisoArquivo").text() == "Arquivo inválido!"){
				msg = "Selecione um arquivo válido!";
				alert(msg);
				$("#tutorialEnviado").focus();
				event.preventDefault();
			} else {
				$("#criarTutorial").submit();
			}
	});
	
});
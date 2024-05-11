/**
 * 
 */
$(document).ready(function(){
	
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
		if ($("#avisoArquivo").text() == "Arquivo inválido!"){
			var msg = "Selecione um arquivo válido!";
			alert(msg);
			$("#tutorialEnviado").focus();
			event.preventDefault();
		} else {
			$("#editarTutorial").submit();
		}
});
	
});
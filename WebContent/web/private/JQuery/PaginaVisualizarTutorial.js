/**
 * 
 */
$(document).ready(function(){	

	$("#txtComentario").focus(function(){
		$("#txtComentario").text("");
		var tamanho = 200 - $("#experiencias").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#txtComentario").keyup(function(){
        var tamanho = 200 - $("#txtComentario").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#btnComentar").click(function(){
		if ($("#txtComentario").val().length < 1){
			alert("Seu comentário está vazio!");
			event.preventDefault();
		} else {
			$("#adcComentario").submit();
		}
	});
});
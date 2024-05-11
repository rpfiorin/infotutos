/**
 * 
 */
$(document).ready(function(){
	alert("oi");
	$("#btnPesquisa").click(function(){
		alert("o");
		if ($("#pesquisa").val() == ""){
			 $("#pesquisa").focus();
		} else {
			$("#busca").submit();
		}
	});
	
	$("#lblAptos").click(function(){
		alert("oi");
	});
});
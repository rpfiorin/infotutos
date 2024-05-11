/**
 * 
 */
$(document).ready(function(){
	
	jQuery.fn.alteraEstilo = function(campo){    
	    this.click(function(){
	    	$(this).css("visibility", "hidden");
	    	if ($(this).attr("id") == "alterarSenha"){
	    		$("#avisoSenhaOld").text("Preencha sua senha antiga!");
	    		$("#senhaolduser").attr("readonly", false);
	    		$("#senhaolduser").css("backgroundColor", "#FFFFFF");
	    		$("#senhaolduser").css("borderStyle" , "inset");
	    		$("#senhaolduser").css("borderWidth" , "2px");	
	    		$("#senhauser").css("backgroundColor", "#FFFFFF");
	    		$("#senhauser").css("borderStyle" , "inset");
	    		$("#senhauser").css("borderWidth" , "2px");
	    		$("#confirmasenha").css("backgroundColor", "#FFFFFF");
	    		$("#confirmasenha").css("borderStyle" , "inset");
	    		$("#confirmasenha").css("borderWidth" , "2px");	
	    		$("#alterarBtn").css("visibility" , "visible");
	    	} else if ($(this).attr("id") == "alterarExperiencias"){
	    		$("#experienciaText").css("visibility", "hidden");
	    		$("#experiencia").css("visibility", "visible");
	    		$("#experiencias").attr("readonly", false);
	    		$("#experiencias").css("backgroundColor", "#FFFFFF");
	    		$("#experiencias").css("borderStyle" , "inset");
	    		$("#experiencias").css("borderWidth" , "1px");
	    		$("#experiencias").css("visibility" , "visible");
	    		$("#alterarBtn").css("visibility" , "visible");
	    	} else {
	    	$("#"+campo).attr("readonly", false);
    		$("#"+campo).css("backgroundColor", "#FFFFFF");
    		$("#"+campo).css("borderStyle" , "inset");
    		$("#"+campo).css("borderWidth" , "2px");
    		$("#alterarBtn").css("visibility" , "visible");
	    	}
	    });
	}
	
	function verificaUsuario(olduser) {
		if ($("#usuariouserlbl").val() == "" || $("#usuariouserlbl").val().length < 4){
			$("#avisoUsuario").text("Mínimo de 4 caracteres");
	    	$("#avisoUsuario").css("color", "red");
		} else {
		$.ajax({
		     type: "POST",
		     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaDadosCadastro",
		     data: {
		    	 usuario_id: "" + $("#usuariouserlbl").val(),
		    	 acao: "usuario",
		     },
		     success: function (data) {
		    	 if ($("#usuariouserlbl").val() == olduser){
		    	 $("#avisoUsuario").text("Usuário disponível!");
			     $("#avisoUsuario").css("color", "green"); 
		    	 } else if (data == "verdadeiro"){
		    	 $("#avisoUsuario").text("Usuário indisponível!");
		    	 $("#avisoUsuario").css("color", "red");
		    	 } else {
		    	 $("#avisoUsuario").text("Usuário disponível!");
		    	 $("#avisoUsuario").css("color", "green");
		    	 }
		     }
		     });
		     return false;		
		}
	} 
	
	function verificaSenha(olduser) {
		$.ajax({
		     type: "POST",
		     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaDadosCadastro",
		     data: {
		    	 usuario_id: olduser,
		    	 senha:  $("#senhaolduser").val(),
		    	 acao: "senha",
		     },
		     success: function (data) {
		    	if (data == "verdadeiro"){
		    	 $("#avisoSenhaOld").text("Senha correta!");
		    	 $("#avisoSenhaOld").css("color", "green");
		    	 $("#senhauser").attr("readonly", false);
		    	 $("#confirmasenha").attr("readonly", false);
		    	 $("#senhaolduser").attr("readonly", false);
		    	 $("#avisoSenha").text("Preencha sua nova senha!");
		    	 } else {
		    	 $("#avisoSenhaOld").text("Senha incorreta!");
		    	 $("#senhaolduser").focus();
		    	 $("#senhauser").attr("readonly", true);
		    	 $("#confirmasenha").attr("readonly", true);
		    	 $("#senhauser").val("");
		    	 $("#confirmasenha").val("");
		    	 $("#avisoSenhaOld").css("color", "red");		    	 
		    	 }
		     }
		     });
		     return false;		
		} 
	
	function verificaEmail(){
		 var email = $("#emailuserlbl").val();
	      if(email != "")
	      {
	         var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	         if(filtro.test(email))
	         {
	       $("#avisoEmail").css("color","green");
		   $("#avisoEmail").text("Email válido!");
		   return true;
	         } else {
	        	 $("#avisoEmail").css("color","red");
	        	 $("#avisoEmail").text("Email inválido!");
	           return false;
	         }	     
	     }
	}
	
	$("#nomeuserlbl").attr("readonly", true);
	$("#cpfuserlbl").attr("readonly", true);
	$("#usuariouserlbl").attr("readonly", true);
	$("#emailuserlbl").attr("readonly", true);
	$("#senhauser").attr("readonly", true);
	$("#senhaolduser").attr("readonly", true);
	$("#confirmasenha").attr("readonly", true);	
	$("#experiencias").attr("readonly", true);
	$("#experiencia").css("visibility", "hidden");
	window.userOld = $("#usuariouserlbl").val();
		
	$("#alterarNome").alteraEstilo("nomeuserlbl");
	$("#alterarUsuario").alteraEstilo("usuariouserlbl");
	$("#alterarEmail").alteraEstilo("emailuserlbl");
	$("#alterarSenha").alteraEstilo("senhauser");
	$("#alterarExperiencias").alteraEstilo("experiencias");
	$("#contadorChar").text(200 - $("#experiencias").val().length + " caracteres restantes");
	
	$("#usuariouserlbl").blur(function() {
		if (!$("#usuariouserlbl").attr("readonly")){
		  verificaUsuario(userOld);
		}
	});
	
	$("#emailuserlbl").blur(function(){
		if (!$("#emailuserlbl").attr("readonly")){
		verificaEmail();
		}
	});
	
	$("#senhauser").blur(function(){
		if (!$("#senhauser").attr("readonly")){
		if($("#senhauser").val().length < 6){
		$("#avisoSenha").text("Mínimo de 6 caracteres!");
		$("#confirmasenha").val("");
		} else {
		$("#confirmasenha").val("");
		$("#avisoSenha").css("color","green");
		$("#avisoSenha").text("Senha válida!");	
		}
	}
	});
	
	$("#senhaolduser").blur(function(){
		if (!$("#senhaolduser").attr("readonly")){
		if($("#senhaolduser").val().length < 6){
		$("#avisoSenhaOld").text("Mínimo de 6 caracteres!");
		} else {
		verificaSenha(userOld);
		}
	}
	});
	
	$("#confirmasenha").focus(function() {
		if (!$("#senhauser").attr("readonly")){
		if($("#senhauser").val().length < 6){  
	    $("#confirmasenha").val("");
		$("#senhauser").focus();
		$("#avisoSenha").css("color","red");
		$("#avisoSenha").text("Mínimo de 6 caracteres!");
		}
	}
	});
	
	$("#confirmasenha").blur(function(){
		if (!$("#senhauser").attr("readonly")){
		if($("#senhauser").val() != $("#confirmasenha").val()){  
		$("#avisoSenha").css("color","red");
		$("#avisoSenha").text("Senhas não conferem!");	
		$("#senhauser").focus();
		} else {
		$("#avisoSenha").css("color","green");
		$("#avisoSenha").text("Senhas conferem!");	
		}
	}
	});
	
	$("#experiencias").focus(function(){
		$("#experiencias").css("color", "black");
		var tamanho = 200 - $("#experiencias").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#experiencias").keyup(function(){
        var tamanho = 200 - $("#experiencias").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#alterarBtn").click(function(){
		var msg = "Preencha corretamente os campos necessários: ";
		if (!$("#nomeuserlbl").attr("readonly") && $("#nomeuserlbl").val() == ""){
			msg += "Nome";
			alert(msg);
			$("#nomeuserlbl").focus();
			event.preventDefault();
		}
		else if (!$("#usuariouserlbl").attr("readonly") && $("#avisoUsuario").text() != "Usuário disponível!"){
			msg += "Usuário";
			alert(msg);
			$("#usuariouserlbl").focus();
			event.preventDefault();
		} 
		else if (!$("#emailuserlbl").attr("readonly") && $("#avisoEmail").text() != "Email válido!"){
				msg += "Email";
				alert(msg);
				$("#emailuserlbl").focus();
				event.preventDefault();
		} 
		else if (!$("#senhaolduser").attr("readonly") && $("#avisoSenhaOld").text() != "Senha correta!"){
				msg += "Senha";
				alert(msg);
				$("#senhaolduser").focus();
				event.preventDefault();
		}
		else if (!$("#senhauser").attr("readonly") && $("#avisoSenha").text() != "Senhas conferem!"){ 
				msg += "Senha";
				alert(msg);
				$("#senhauser").focus();
				event.preventDefault();
		}
		else if (!$("#experiencias").attr("readonly") && ($("#contadorChar").text() == "200 caracteres restantes")){
				msg += "Conhecimentos em informática ";
				alert(msg);
				$("#experiencias").focus();
				event.preventDefault();
		}
		else {
		$("#alterarDados").append("<input type='hidden' name='tipo' value='salvar'/>");
		$("#alterarDados").append("<input type='hidden' name='logica' value='UpdatePerfilLogic'/>");
		$("#alterarDados").submit();
		}
	});
	
	$("#excluirBtn").click(function(){
		var answer = confirm('Realmente deseja desativar sua conta?');
	    if (answer) {
	    	$("#alterarDados").append("<input type='hidden' name='tipo' value='excluir'/>");
			$("#alterarDados").append("<input type='hidden' name='logica' value='UpdatePerfilLogic'/>");
			$("#alterarDados").submit();
	    } else {
	       alert("Operação cancelada!");
	    }
	});
	
});
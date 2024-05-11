/**
 * 
 */
$(document).ready(function(){		
	
	 gerarNumeros();
	 
	 function gerarNumeros() {
		    $('#number1').text((Math.floor(Math.random() * 6) + 1)+ " + ");
		    $('#number2').text((Math.floor(Math.random() * 6) + 1)+ " = ");
		    $('#number3').text((Math.floor(Math.random() * 6) + 1)+ " + ");
		    $('#number4').text((Math.floor(Math.random() * 6) + 1)+ " = ");
		}
		    
	jQuery.fn.validacpf = function(){    
	    this.change(function(){
	        CPF = $(this).val();
	        if(!CPF){ return false;}
	        erro     = new String;
	        cpfv     = CPF;
	        if(cpfv.length == 14 || cpfv.length == 11){
	            cpfv = cpfv.replace('.', '');
	            cpfv = cpfv.replace('.', '');
	            cpfv = cpfv.replace('-', '');
	    
	            var nonNumbers = /\D/;
	        
	            if(nonNumbers.test(cpfv)){
	                erro = "A verificacao de CPF suporta apenas números!";
	            }else{
	                if (cpfv == "00000000000" ||
	                    cpfv == "11111111111" ||
	                    cpfv == "22222222222" ||
	                    cpfv == "33333333333" ||
	                    cpfv == "44444444444" ||
	                    cpfv == "55555555555" ||
	                    cpfv == "66666666666" ||
	                    cpfv == "77777777777" ||
	                    cpfv == "88888888888" ||
	                    cpfv == "99999999999") {
	                                                        
	                    erro = "Número de CPF inválido!";
	                }
	                var a = [];
	                var b = new Number;
	                var c = 11;
	    
	                for(i=0; i<11; i++){
	                    a[i] = cpfv.charAt(i);
	                    if (i < 9) b += (a[i] * --c);
	                }
	                if((x = b % 11) < 2){
	                    a[9] = 0;
	                }else{
	                    a[9] = 11-x;
	                }
	                b = 0;
	                c = 11;
	                for (y=0; y<10; y++) b += (a[y] * c--);
	        
	                if((x = b % 11) < 2){
	                    a[10] = 0;
	                }else{
	                    a[10] = 11-x;
	                }
	                if((cpfv.charAt(9) != a[9]) || (cpfv.charAt(10) != a[10])){
	                    erro = "Número de CPF inválido.";
	                }
	            }
	        }else{
	            if(cpfv.length == 0){                
	                return false;
	            }else{
	                erro = "Número de CPF inválido.";
	            }
	        }
	        if (erro.length > 0){
	            $(this).val();
	            $("#avisoCPF").css("color", "red");
	            $("#avisoCPF").text("Este CPF é inválido!");
	            setTimeout(function(){$(this).focus();},100);
	            return false;
	        }
	        verificaCPF();
	        return $(this);
	    });
	}
	
	function verificaCPF() {
		$.ajax({
		     type: "POST",
		     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaDadosCadastro",
		     data: {
		    	 cpf: ""+$('#cpf').val(),
		    	 acao: "cpf",
		     },
		     success: function (data) {
		    	 if (data == "verdadeiro"){
		    	 $("#avisoCPF").text("Este CPF já está cadastrado!");
		    	 $("#avisoCPF").css("color", "red");
		    	 } else {
		    	 $("#avisoCPF").text("Este CPF é válido!");
		    	 $("#avisoCPF").css("color", "green");
		    	 }
		     }
		     });
		     return false;		
	} 
	
	function verificaUsuario() {
		if ($("#usuario").val() == "" || $("#usuario").val().length < 4){
			$("#avisoUsuario").text("Mínimo de 4 caracteres");
	    	$("#avisoUsuario").css("color", "red");
		} else {
		$.ajax({
		     type: "POST",
		     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaDadosCadastro",
		     data: {
		    	 usuario_id: "" + $("#usuario").val(),
		    	 acao: "usuario",
		     },
		     success: function (data) {
		    	 if (data == "verdadeiro"){
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
		
	function verificaEmail(){
		 var email = $("#email").val();
	      if(email != "")
	      {
	         var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	         if(filtro.test(email))
	         {
	       $("#avisoEmail").css("color","green");
		   $("#avisoEmail").text("Email válido!");
		   return true;
	         } else {
	        	 $("#avisoEmail").text("Email inválido!");
	           return false;
	         }
	      } else {
	    	  $("#avisoEmail").css("color","red");
	    	  $("#avisoEmail").text("*");
	    	  return false;
	      }
	   }
	
	$("#cpf").mask("999.999.999-99",{placeholder:" "});
	
	$("#cpf").validacpf();
	
	$("#cpf").blur(function(){
		if ($("#cpf").val() == ""){
			$("#avisoCPF").text("*");
			$("#avisoCPF").css("color", "red");
		}		
	});
	
	$("#nome").blur(function() {
		var value = $("#nome").val();
		value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
		$("#nome").val(value);
	});
	
	$("#usuario").blur(function() {
		var value = $("#usuario").val();
		value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
		$("#usuario").val(value);
		verificaUsuario();
	});
	
	$("#email").blur(function(){
		verificaEmail();
	});
	
	$("#password").blur(function(){
		if($("#password").val().length < 6){
		$("#avisoSenha").text("Mínimo de 6 caracteres!");
		$("#confirmapass").val("");
		} else {
		$("#confirmapass").val("");
		$("#avisoSenha").css("color","green");
		$("#avisoSenha").text("Senha válida!");	
		}
	});
	
	$("#confirmapass").focus(function() {
		if($("#password").val().length < 6){  
	    $("#confirmapass").val("");
		$("#password").focus();
		$("#avisoSenha").css("color","red");
		$("#avisoSenha").text("Mínimo de 6 caracteres!");
		}
	});
	
	$("#confirmapass").blur(function(){
		if($("#password").val() != $("#confirmapass").val()){
		$("#avisoSenha").css("color","red");
		$("#avisoSenha").text("Senhas não conferem!");
		} else {
		$("#avisoSenha").css("color","green");
		$("#avisoSenha").text("Senhas conferem!");	
		}
	});
	
	$("#experiencias").focus(function(){
		$("#experiencias").text("");
		$("#experiencias").css("color", "black");
		var tamanho = 200 - $("#experiencias").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#experiencias").keyup(function(){
        var tamanho = 200 - $("#experiencias").val().length;
        $("#contadorChar").text(""+ tamanho +" caracteres restantes");
	});
	
	$("#resultado").blur(function(){
		var value = $("#resultado").val();
		value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
		$("#resultado").val(value);
	});
	
	$("#cadastrar").click(function() {
		var msg = "Preencha corretamente os campos necessários: ";
		if ($("#nome").val() == ""){
			msg += "Nome ";
			alert(msg);
			$("#nome").focus();
			event.preventDefault();
		} else if ($("#avisoCPF").text() == "*" || $("#avisoCPF").text() == "Este CPF é inválido!"){
			msg += "CPF ";
			alert(msg);
			$("#cpf").focus();
			event.preventDefault();
		} else if ($("#avisoUsuario").text() == "*" || $("#avisoUsuario").text() == "Mínimo de 4 caracteres"){
			msg += "Usuário ";
			alert(msg);
			$("#usuario").focus();
			event.preventDefault();
		} else if ($("#avisoEmail").text() == "*"){
			msg += "Email ";
			alert(msg);
			$("#email").focus();
			event.preventDefault();
		} else if ($("#avisoSenha").text() != "Senhas conferem!"){
			msg += "Senha ";
			alert(msg);
			$("#password").focus();
			event.preventDefault();
		} else if ($("#contadorChar").text() == "200 caracteres restantes"){
			msg += "Conhecimentos em informática ";
			alert(msg);
			event.preventDefault();
			$("#experiencias").focus();
		} else if (!($("#checkboxTermos").prop('checked'))){
			msg = "É necessário aceitar os termos de uso do site!";
			alert(msg);
			event.preventDefault();
		} else if (parseInt($("#resultado").val()) != parseInt($("#number1").text()) + parseInt($("#number2").text())){
			msg += "Verificação de segurança ";
			alert(msg);
			$("#resultado").focus();
			gerarNumeros();
			event.preventDefault();
		} else {
		$("#cadastro").append('<input type="hidden" name="logica" value="CadastroLogic"/>');
		$("#cadastro").submit();
		}
	});
		//* PARTE DE LOGIN *\\
		function verificaUsuarioExistente() {
			if ($("#usuario2").val() == "" || $("#usuario2").val().length < 4){
				$("#avisoUsuario2").text("Usuário inexistente!");
		    	$("#avisoUsuario2").css("color", "red");
			} else {
			$.ajax({
			     type: "POST",
			     url: "http://localhost:8080/TCC/web/private/mvc?logica=ValidaDadosCadastro",
			     data: {
			    	 usuario_id: "" + $("#usuario2").val(),
			    	 acao: "usuario",
			     },
			     success: function (data) {
			    	 if (data == "verdadeiro"){
			    		 $("#avisoUsuario2").text("");
			    	 } else {
			    		 $("#avisoUsuario2").text("Usuário inexistente!");
				    	 $("#avisoUsuario2").css("color", "red");	 
			    	 }
			     }
			     });
			     return false;		
			}
		}
		
		$("#usuario2").blur(function(){
			var value = $("#usuario2").val();
			value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
			$("#usuario2").val(value);
			verificaUsuarioExistente();
		});
		
		$("#resultado2").blur(function(){
			var value = $("#resultado2").val();
			value = value.replace(/[^a-zA-Zà-úÀ-Ú0-9" "]+/gi, '');
			$("#resultado2").val(value);
		});
		
		$("#loginBtn").click(function(){
			var msg = "Preencha corretamente os campos necessários: ";
			if ($("#usuario2").val() == "" || $("#avisoUsuario2").text() == "Usuário inexistente"){
				msg += "Usuário";
				alert(msg);
				event.preventDefault();
			} else if ($("#password2").val() == ""){
				msg += "Senha";
				alert(msg);
				event.preventDefault();
			} else if (parseInt($("#resultado2").val()) != parseInt($("#number3").text()) + parseInt($("#number4").text())){
				msg += "Verificação de segurança ";
				alert(msg);
				$("#resultado2").focus();
				gerarNumeros();
				event.preventDefault();
			} else {
				$("#login").append('<input type="hidden" name="logica" value="LoginLogic"/>');
				$("#login").submit();
			}
		});
	
});				  
	

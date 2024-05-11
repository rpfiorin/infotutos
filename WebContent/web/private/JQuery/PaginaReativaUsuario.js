/**
 * 
 */

$(document).ready(function(){

	function verificaEmail(){
		 var email = $("#email").val();
	      if(email != ""){
	         var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	         if(filtro.test(email)) {	
	        	 return true;
	         } else {
	        	 alert("Forneça um e-mail válido!");
	        	 var erro = 'erro';
	        	 return erro;
	         }
	      } else {
	    	  alert("Forneça um e-mail válido!");
	    	  var erro = 'erro';
	    	  return erro;
	      }
	   }
	
	function validacpf(){
	        CPF = $("#cpf").val();
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
	            alert("Forneça um CPF válido!");
	            setTimeout(function(){$(this).focus();},100);
	            var erro = 'erro';
		    	 return erro;
	        } else {
	        	 var erro = 'invalido';
		    	 return erro;
	        }
	        return $(this);
	    }
	
	function verificaUsuario() {
		if ($("#usuario").val() == "" || $("#usuario").val().length < 4){
			alert("Forneça um usuário válido!");
			var erro = 'erro';
	    	return erro;
		} else {
		    	var erro = 'falso';
		    	return erro;
		    	 }
		} 
	
	/* $("#email").blur(function(){
	verificaEmail();
	});

	$("#usuario").blur(function(){
	verificaUsuario();
	}); */

	$("#cpf").mask("999.999.999-99",{placeholder:" "});

	/* $("#cpf").blur(function(){
	$("#cpf").validacpf();
	}); */	
	
	$("#reativarBtn").click(function(){
		if (verificaUsuario() == 'erro'){
			var stop = 1;
			event.preventDefault();
			$("#usuario").focus();
		} else if (validacpf() == 'erro'){
			var stop = 1;
			event.preventDefault();
			$("#cpf").focus();
		} else if (verificaEmail() == 'erro'){
			var stop = 1;
			event.preventDefault();
			$("#email").focus();
		} else if (stop != 1) {
			$("#reativa").append('<input type="hidden" name="logica" value="ReativaUsuarioLogic"/>');		
			$("#reativa").submit();
		}
	});
	
});
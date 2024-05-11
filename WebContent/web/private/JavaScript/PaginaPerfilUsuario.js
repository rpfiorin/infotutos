/**
 * 
 */
function funcaoInputs(){
	document.getElementById('nomeuserlbl').readOnly = true;
	document.getElementById('cpfuserlbl').readOnly = true;
	document.getElementById('usuariouserlbl').readOnly = true;
	document.getElementById('emailuserlbl').readOnly = true;
	document.getElementById('senhauser').readOnly = true;
	document.getElementById('confirmasenha').readOnly = true;	
	document.getElementById("experiencias").readOnly = true;
}

function alterarCampo(nomeCampo){
	if (nomeCampo == 'senhauser'){
		document.getElementById('confirmasenha').readOnly = false;
		document.getElementById('confirmasenha').style.backgroundColor = "#FFFFFF";
		document.getElementById('confirmasenha').style.borderStyle = "inset";
		document.getElementById('confirmasenha').style.borderWidth = "2px";	
	}
	document.getElementById(nomeCampo).readOnly = false;
	document.getElementById(nomeCampo).style.backgroundColor = "#FFFFFF";
	document.getElementById(nomeCampo).style.borderStyle = "inset";
	document.getElementById(nomeCampo).style.borderWidth = "2px";
	document.getElementById("alterarBtn").style.visibility = "visible";
}

function createLogicaSalvarDados(){
	var input = document.createElement("input");
	var input2 = document.createElement("input");
	
	input2.setAttribute("type", "hidden");
	input2.setAttribute("name", "tipo");
	input2.setAttribute("value", "salvar");
	
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "logica");
	input.setAttribute("value", "UpdatePerfilLogic");
	
	document.getElementById("alterarDados").appendChild(input);	
	document.getElementById("alterarDados").appendChild(input2);
	document.getElementById("alterarDados").submit();
}

function createLogicaExcluirDados(){
	var input = document.createElement("input");
	var input2 = document.createElement("input");
	
	input2.setAttribute("type", "hidden");
	input2.setAttribute("name", "tipo");
	input2.setAttribute("value", "excluir");
	
	input.setAttribute("type", "hidden");
	input.setAttribute("name", "logica");
	input.setAttribute("value", "UpdatePerfilLogic");
	
	document.getElementById("alterarDados").appendChild(input);	
	document.getElementById("alterarDados").appendChild(input2);
	document.getElementById("alterarDados").submit();
}
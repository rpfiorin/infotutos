function createLogicaLogin() {
	var input = document.createElement("input");

	input.setAttribute("type", "hidden");

	input.setAttribute("name", "logica");

	input.setAttribute("value", "LoginLogic");
	
	document.getElementById("login").appendChild(input);
	
	document.getElementById("login").submit();
}

function createLogicaCadastro() {
	var input = document.createElement("input");

	input.setAttribute("type", "hidden");

	input.setAttribute("name", "logica");

	input.setAttribute("value", "CadastroLogic");
	
	document.getElementById("cadastro").appendChild(input);
	
	document.getElementById("cadastro").submit();
}
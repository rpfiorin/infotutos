<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StylePerfilUsuario.css" />
<script type="text/javascript" src="JQuery/jquery.js"></script>
<script type="text/javascript" src="JQuery/PaginaPerfilUsuario.js"></script>	
<%-- <script type="text/javascript" src="JavaScript/PaginaPerfilUsuario.js"></script> --%>
<title>InfoTutos - Página de perfil</title>
<c:if test="${requestScope.sucesso != null}">
<script type="text/javascript">
	alert("${requestScope.sucesso}");
</script>
</c:if>
</head> 
<body >
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel">
		<p id="tituloBemVindo">Bem vindo, ${requestScope.nomeUsuario}</p><img src="Imagens/meuperfil.png" id="novologo">
		<p id="tituloDados">Seus dados pessoais:</p>
		<form action="mvc" method="POST" id="alterarDados" name="alterarDados" accept-charset="ISO-8859-1">
			<p id="nomelbl">Nome:</p>
			<input type="text" id="nomeuserlbl" name="nomeuser" value="${requestScope.nomeUsuario}" maxlength="100"></input>
			<input type="button" id="alterarNome" class="pointer" value="Alterar"/>
			<p id="cpflbl">CPF:</p>
			<input type="text" id="cpfuserlbl" name="cpfuser" value="${requestScope.cpfUsuario}"></input>
			<p id="usuariolbl">Usuário:</p>
			<input type="text" id="usuariouserlbl" name="usuariouser" value="${sessionScope.usuarioLogado}" maxlength="15"></input>
			<p id="avisoUsuario"></p>
			<input type="button" id="alterarUsuario" class="pointer" value="Alterar"/>
			<p id="emaillbl">Email:</p>
			<input type="text" id="emailuserlbl" name="emailuser" value="${requestScope.emailUsuario}" maxlength="50"></input>
			<p id="avisoEmail"></p>
			<input type="button" id="alterarEmail" class="pointer" value="Alterar"/>
			<p id="senhaolduserlbl">Senha atual:</p>
			<input type="password" id="senhaolduser" name="senhaolduser" maxlength="12"></input>
			<p id="avisoSenhaOld"></p>
			<p id="senhauserlbl">Nova senha:</p>
			<input type="password" id="senhauser" name="senhauser" maxlength="12"></input>
			<p id="avisoSenha"></p>
			<input type="button" id="alterarSenha" class="pointer" value="Alterar"/>
			<p id="confirmasenhalbl">Confirmação da senha:</p>
			<input type="password" id="confirmasenha" name="confirmasenha" maxlength="12"></input>
			<p id="especificacao">Experiência em:</p>
			<p id="experienciaText">${requestScope.experienciasUsuario}</p>
			<select id="experiencia" name="experiencia">
			<option value="Hardware" <c:if test="${requestScope.experienciasUsuario == 'Hardware' }">selected</c:if>>Hardware</option>
			<option value="Redes" <c:if test="${requestScope.experienciasUsuario == 'Redes' }">selected</c:if>>Redes</option>
			<option value="Sistemas Operacionais" <c:if test="${requestScope.experienciasUsuario == 'Sistemas Operacionais' }">selected</c:if>>Sistemas Operacionais</option>
			<option value="Programação" <c:if test="${requestScope.experienciasUsuario == 'Programação' }">selected</c:if>>Programação</option>
			</select>
			<p id="experienciaslbl">Descrição </p>
			<p id="contadorChar">200 caracteres restantes</p>
			<input type="button" id="alterarExperiencias" class="pointer" value="Alterar"/>
			<textarea cols="10" rows="5" id="experiencias" name="experienciasUsuario" maxlenght="200">${requestScope.comentarioExperiencia}</textarea>
			<input type="submit" value="Salvar alterações" id="alterarBtn" /> 
			<input type="button" value="Desativar conta" id="excluirBtn" />
		</form>
	</div>
	<div id="rodapeInsert">
		<c:import url="../Paginas/Rodape.jsp" />
	</div>
</body>
</html>
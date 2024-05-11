<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>InfoTutos - Faça cadastro ou login!</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../JQuery/jquery.js"></script>
<script type="text/javascript" src="../JQuery/jquery-maskedinput.js"></script>
<script type="text/javascript" src="../JQuery/PaginaLoginCadastro.js"></script>
<link rel="stylesheet" type="text/css"	href="../StyleCSS/StyleLoginCadastro.css" />
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
		<p id="tituloCadastro">Cadastre-se:</p>
		<form action="../mvc" method="POST" id="cadastro"  accept-charset="ISO-8859-1">
			<p id="avisoNome">*</p>
			<p id="nomelbl">Nome:</p>
			<input type="text" id="nome" name="nomeCadastro" maxlength="100"/>
			<p id="avisoCPF">*</p>
			<p id="cpflbl">CPF:</p>
			<input type="text" id="cpf" name="cpfCadastro" maxlength="14"/>
			<p id="avisoUsuario">*</p>
			<p id="usuariolbl">Usuário:</p>
			<input type="text" id="usuario" name="usuarioCadastro" maxlength="15"/>
			<p id="avisoEmail">*</p>
			<p id="emaillbl">Email:</p>
			<input type="text" id="email" name="emailCadastro" maxlength="50"/>
			<p id="avisoSenha">*</p>
			<p id="passwordlbl">Senha:</p>
			<input type="password" id="password" name="senhaCadastro" maxlength="12"/>
			<p id="avisoConfirmaSenha">*</p>
			<p id="confirmapasslbl">Confirmação de senha:</p>
			<input type="password" id="confirmapass" name="confirmaSenha" maxlength="12"/> 
			<p id="especificacao">Possuo experiência em:</p>
			<select id="experiencia" name="experiencia">
			<option value="Hardware" selected>Hardware</option>
			<option value="Redes">Redes</option>
			<option value="Sistemas Operacionais">Sistemas Operacionais</option>
			<option value="Programação">Programação</option>
			</select>
			<p id="avisoExperiencias">*</p>
			<p id="experienciaslbl">Descreva:</p>
			<p id="contadorChar">200 caracteres restantes</p>
			<textarea cols="10" rows="5" id="experiencias" name="comentarioExperiencias" maxlength="200">Escreva um breve resumo com suas experiências na área selecionada</textarea>
			<p id="avisoTermos">*</p>
			<input type="checkbox" id="checkboxTermos" name="aceitoTermos"/>
			<p id="avisoGeral">Os campos marcados com (*) são necessários!</p>
			<p id="lblTermos">Eu aceito os <a title="Clique para visualizar" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTermos.jsp" target="_blank" class="termoslink">termos e condições de uso</a></p>
			<div id="captcha">
			<p id="seguranca">Verificação de segurança</p>
			<span id="number1"></span>
			<span id="number2"></span>			
			<input type="text" id="resultado"></input>
			</div>
			<input type="submit" value="Cadastrar" id="cadastrar"/>
		</form>
		<div id="separador"></div>
		<p id="tituloLogin">Faça login:</p>
		<form action="../mvc" method="POST" id="login" accept-charset="ISO-8859-1">
			<p id="avisoUsuario2"></p>
			<p id="usuariolbl2">Usuário:</p>
			<input type="text" id="usuario2" name="usuarioLogin" maxlength="15"/>
			<p id="passwordlbl2">Senha:</p>
			<input type="password" id="password2" name="senhaLogin" maxlength="12"/>
			<c:if test="${not empty param.erro}">
			<p id="erroLogin">Usuário ou senha inválidos!</p>
			</c:if>
			<div id="captcha2">
			<p id="seguranca">Verificação de segurança</p>
			<span id="number3"></span>
			<span id="number4"></span>			
			<input type="text" id="resultado2"></input>
			</div>
			<input type="submit" value="Login" id="loginBtn"/>
			<a href="PaginaRecuperaSenha.jsp" id="recuperaSenha">Esqueceu sua senha?</a>
			<a href="PaginaReativaUsuario.jsp" id="reativaUsuario">Reativar usuário?</a>
		</form>
	</div>
	<div id="rodapeInsert" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:210px;"</c:if>>
	<c:import url="../Paginas/Rodape.jsp" />
	</div>
</body>
</html>
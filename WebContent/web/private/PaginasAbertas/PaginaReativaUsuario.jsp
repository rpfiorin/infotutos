<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../JQuery/jquery.js"></script>
<script type="text/javascript" src="../JQuery/jquery-maskedinput.js"></script>
<script type="text/javascript" src="../JQuery/PaginaReativaUsuario.js"></script>
<link rel="stylesheet" type="text/css"	href="../StyleCSS/StyleReativaUsuario.css" />
<title>InfoTutos - Reativar Conta</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
	<p id="tituloReativa">Reative sua conta:<img src="../Imagens/recupera.png" id="novologo"></p>
	<p id="informacao"> Preencha os campos com os dados de sua conta e um e-mail será encaminhado com uma senha temporária para acesso a sua conta.</p>
	<form action="../mvc" method="POST" id="reativa" accept-charset="ISO-8859-1">
	<div id="reativacao">
	<p id="usuariolbl">Usuário:</p>
	<input type="text" id="usuario" name="usuarioReativa" maxlength="15"/>
	<p id="cpflbl">CPF:</p>
	<input type="text" id="cpf" name="cpfReativa" maxlength="14"/>	
	<p id="emaillbl">Email:</p>
	<input type="text" id="email" name="emailReativa" maxlength="50"/>
	<input type="submit" value="Reativar" id="reativarBtn"/>
	<c:if test="${sessionScope.erro == 1}">
	<p id="erroReativa">Dados inexistentes ou não conferem!</p>
	<c:remove var="erro"/>
	</c:if>
	</div>
	</form>
	</div>
	<div id="rodapeInsert">
	<c:import url="../Paginas/Rodape.jsp" />	
	</div>
</body>
</html>
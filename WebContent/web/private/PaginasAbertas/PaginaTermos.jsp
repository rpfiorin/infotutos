<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InfoTutos - Termos de Uso</title>
<link rel="stylesheet" type="text/css" href="../StyleCSS/StyleTermos.css" />
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp"/>
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
	<p id="termosLabel">Termos e condições de uso <img id="termosLogo" src="../Imagens/termos.png"></p>
	<iframe id="termosText" src="../Imagens/Termos de uso.pdf"></iframe>
</div>
<div id="rodapeInsert" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:70px;"</c:if>>
<c:import url="../Paginas/Rodape.jsp"/>
</div>
</body>
</html>
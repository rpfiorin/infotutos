<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="../StyleCSS/StylePaginaSobre.css" />
<title>InfoTutos - Sobre o site</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:115px;"</c:if>>
	<img alt="logotcc" src="../Imagens/Logo_TCC_new.png" id="logotcc">
	<img alt="logo" src="../Imagens/logofiec.png" id="logofiec">
	<p id="titulo">InfoTutos - Tutoriais de Informática</p>
	<p id="mensagem"> Trabalho de conclusão de curso - Sistemas de Informação - Vence - 2014
	<br><br> Desenvolvido por: Diego Silva, Lucas Araujo, Rafael Fiorin, Victor Andrade e Wagner Gerhart. </p>
	</div>
	<div id="rodapeInsert">
	<c:import url="../Paginas/Rodape.jsp" />	
	</div>
</body>
</html>
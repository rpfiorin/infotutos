<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${not empty requestScope.sessao}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="StyleCSS/StylePaginaErro.css" />
<title>InfoTutos - Erro</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:115px;"</c:if>>
	<img alt="error" src="Imagens/error.png" id="error">
	<p id="titulo">Ocorreu um erro...</p>
	<p id="mensagem"> Pedimos que tente realizar novamente o que estava fazendo, nos desculpe pelo inconveniente!</p>
	<img alt="logo" src="Imagens/Logo_TCC_new.png" id="logo2">
	<a href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp" id="return">Início</a>
	</div>
	<div id="rodapeInsert">
	<c:import url="../Paginas/Rodape.jsp" />	
	</div>
</body>
</html> 
</c:if>
<c:if test="${empty requestScope.sessao}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="../StyleCSS/StylePaginaErro.css" />
<title>InfoTutos - Erro</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:115px;"</c:if>>
	<img alt="error" src="../Imagens/error.png" id="error">
	<p id="titulo">Ocorreu um erro...</p>
	<p id="mensagem"> Pedimos que tente realizar novamente o que estava fazendo, nos desculpe pelo inconveniente!</p>
	<img alt="logo" src="../Imagens/Logo_TCC_new.png" id="logo2">
	<a href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTutoriaisPopulares.jsp" id="return">Início</a>
	</div>
	<div id="rodapeInsert">
	<c:import url="../Paginas/Rodape.jsp" />	
	</div>
</body>
</html> 
</c:if>
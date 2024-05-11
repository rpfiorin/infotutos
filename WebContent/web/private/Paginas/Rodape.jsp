<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${not empty requestScope.direct}">
		<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../StyleCSS/StyleRodape.css" />
</head>
	<div id="rodape">
	<p id="itens"><a class="rodape" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaSobre.jsp" id="sobre">Sobre o site</a> 
	<a class="rodape" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTermos.jsp" id="termos">Termos e condições de uso</a></p>
	<p id="direitos"><b>InfoTutos - Tutoriais de informática © 2014</b></p>
	<p id="autoria"><b>Produzido, idealizado e desenvolvido por -</b> Diego Silva, Lucas Araujo, Rafael Fiorin, Victor Andrade e Wagner Gerhart</p>
	</div>
		</html>
	</c:when>
	<c:when test="${empty requestScope.direct}">
		<c:if test="${empty requestScope.sessao}">
				<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../StyleCSS/StyleRodape.css" />
</head>
	<div id="rodape">
	<p id="itens"><a href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaSobre.jsp" id="sobre" class="rodape">Sobre o site</a> 
	<a class="rodape" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTermos.jsp" id="termos">Termos e condições de uso</a></p>
	<p id="direitos"><b>InfoTutos - Tutoriais de informática © 2014</b></p>
	<p id="autoria"><b>Produzido, idealizado e desenvolvido por -</b> Diego Silva, Lucas Araujo, Rafael Fiorin, Victor Andrade e Wagner Gerhart</p>
	</div>
		</html>
		</c:if>
		<c:if test="${not empty requestScope.sessao}">
				<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleRodape.css" />
</head>
	<div id="rodape">
	<p id="itens"><a class="rodape" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaSobre.jsp" id="sobre">Sobre o site</a> 
	<a class="rodape" href="http://localhost:8080/TCC/web/private/PaginasAbertas/PaginaTermos.jsp" id="termos">Termos e condições de uso</a></p>
	<p id="direitos"><b>InfoTutos - Tutoriais de informática © 2014</b></p>
	<p id="autoria"><b>Produzido, idealizado e desenvolvido por -</b> Diego Silva, Lucas Araujo, Rafael Fiorin, Victor Andrade e Wagner Gerhart</p>
	</div>
		</html>
		</c:if>
	</c:when>
</c:choose>

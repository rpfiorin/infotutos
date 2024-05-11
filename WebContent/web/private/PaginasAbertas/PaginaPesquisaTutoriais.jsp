<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StylePesquisaTutoriais.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InfoTutos - Pesquisa</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel"
		<c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
		<p id="lblResultados">Resultados encontrados <img src="Imagens/search.png" id="resultadoImg"></p>
		<div id="divResultados">
			<ul id="listaResultados">
				<c:forEach var="resultado" items="${resultadosPesquisa}">
					<c:choose>
					<c:when test="${resultado.titulo == '0'}">
						<li class="lista"><p id="Resultados1" style="margin-left: 0px;">Nenhum resultado
								foi encontrado, tente novamente com outros termos.</p></li>
					</c:when>
					<c:when test="${resultado.titulo != '0'}">
						<li class="lista"><a id="Resultados1"
							href="mvc?logica=VisualizarTutorialLogic&titulo=${resultado.titulo}" 
							class="aptos" style="margin-top: ${resultado.tutorialId * 30 }px">
								${resultado.titulo} </a></li>
					</c:when>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="rodapeInsert"
		<c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:223px;"</c:if>>
		<c:import url="../Paginas/Rodape.jsp" />
	</div>
</body>
</html>
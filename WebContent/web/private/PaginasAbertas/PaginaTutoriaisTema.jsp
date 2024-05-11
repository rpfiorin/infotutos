<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleTutoriaisTema.css" />
<title>InfoTutos - ${nomeTema}</title>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel"
		<c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
		<p id="lblTutoriais">
			Lista de tutoriais <img id="simbolo" src="Imagens/lista.png">
		</p>
		<p id="lblAptos">${nomeTema}</p>
		<c:choose>
			<c:when test="${nomeTema == 'Hardware'}">
				<img src="Imagens/hardware.png" id="temaLogo">
			</c:when>
			<c:when test="${nomeTema == 'Sistemas Operacionais'}">
				<img src="Imagens/so.png" id="temaLogo"
					style="width: 30px; height: 28px; margin-top: 55px;">
			</c:when>
			<c:when test="${nomeTema == 'Redes'}">
				<img src="Imagens/redes.png" id="temaLogo"
					style="width: 25px; height: 25px; margin-top: 57px;">
			</c:when>
			<c:when test="${nomeTema == 'Programação'}">
				<img src="Imagens/programacao.png" id="temaLogo"
					style="width: 30px; height: 28px; margin-top: 57px;">
			</c:when>
		</c:choose>
		<div id="divAptos">
			<ul id="listaAptos">
				<c:forEach var="tutorial" items="${tutoriaisTema}">
					<li class="lista"><a
						<c:if test="${tutorial.titulo != 'Ainda não existem tutoriais aptos para esta categoria!'}">
						href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}"  class="aptos"</c:if>
						id="aptosList"
						style="margin-top: ${tutorial.tutorialId * 30 }px">${tutorial.titulo}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="rodapeInsert"
		<c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:233px;"</c:if>>
		<c:import url="../Paginas/Rodape.jsp" />
	</div>

</body>
</html>
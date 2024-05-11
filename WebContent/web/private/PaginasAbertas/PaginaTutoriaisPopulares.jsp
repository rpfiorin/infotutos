<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${not empty requestScope.sessao}">
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleTutoriaisPopulares.css" />
</c:if>
<c:if test="${empty requestScope.sessao}">
<link rel="stylesheet" type="text/css"
	href="../StyleCSS/StyleTutoriaisPopulares.css" />
</c:if>
<c:if test="${sessionScope.sucesso != null}">
<script type="text/javascript">
	alert("${sessionScope.sucesso}");
	<c:remove var="sucesso"/>
</script>
</c:if>
<title>InfoTutos - Home</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.edu.tcc.mvc.model.TutorialDAO"/>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;"</c:if>>
		<p id="lblApresentacao">Bem vindo ao InfoTutos! <br>
		<span id="menorApresentacao">Visualize e comente tutoriais de 4 diferentes temas! Cadastre-se, envie seus tutoriais e faça parte!</span></p>
		<p id="lblPopulares">Tutoriais mais visitados</p>
		<img src="../Imagens/popular.png" id="popularLogo">
		<div id="divHardware">
		<p id="lblHardware">Hardware</p>
		<img src="../Imagens/hardware.png" id="hardwareLogo">
		<ul id="listaHardware">
		<c:if test="${empty dao.popularesHardware}">
		 	<li class="lista"><a id="hardware1">Não há nenhum tutorial nesta categoria!</a></li>
		 	</c:if>
		<c:forEach var="tutorial" items="${dao.popularesHardware}" varStatus="id">		 	
			<c:if test="${not empty requestScope.sessao}">
			<li class="lista"><a href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="hardware${id.count}" class="listas">${tutorial.titulo}</a></li>			
			</c:if>
			<c:if test="${empty requestScope.sessao}">
			<li class="lista"><a href="../mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="hardware${id.count}" class="listas">${tutorial.titulo}</a></li>			
			</c:if>
			</c:forEach>
		</ul>
		</div>		
		<div id="divRedes">
		<p id="lblRedes">Redes</p>
		<img src="../Imagens/redes.png" id="redesLogo">
		<ul id="listaRedes">
		<c:if test="${empty dao.popularesRedes}">
		 	<li class="lista"><a id="redes1">Não há nenhum tutorial nesta categoria!</a></li>
		 	</c:if>
		<c:forEach var="tutorial" items="${dao.popularesRedes}" varStatus="id">			
			<c:if test="${not empty requestScope.sessao}">
			<li class="lista"><a href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="redes${id.count}" class="listas">${tutorial.titulo}</a></li>
			</c:if>
			<c:if test="${empty requestScope.sessao}">
			<li class="lista"><a href="../mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="redes${id.count}" class="listas">${tutorial.titulo}</a></li>
			</c:if>
			</c:forEach>
		</ul>
		</div>
		<div id="divSO">
		<p id="lblSO">Sistemas Operacionais</p>
		<img src="../Imagens/so.png" id="soLogo">
		<ul id="listaSO">
		<c:if test="${empty dao.popularesSO}">
		 	<li class="lista"><a id="so1">Não há nenhum tutorial nesta categoria!</a></li>
		 	</c:if>
		<c:forEach var="tutorial" items="${dao.popularesSO}" varStatus="id">			
			<c:if test="${empty requestScope.sessao}">
			 <li class="lista"><a href="../mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="so${id.count}" class="listas">${tutorial.titulo}</a></li>
	  		 </c:if>
	  		 <c:if test="${not empty requestScope.sessao}">
			 <li class="lista"><a href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="so${id.count}" class="listas">${tutorial.titulo}</a></li>
	  		 </c:if>
	  		 </c:forEach>
		</ul>
		</div>
		<div id="divProgramacao">
		<p id="lblProgramacao">Programação</p>
		<img src="../Imagens/programacao.png" id="programacaoLogo">
		<ul id="listaProgramacao">
		<c:if test="${empty dao.popularesProgramacao}">
		 	<li class="lista"><a id="programacao1">Não há nenhum tutorial nesta categoria!</a></li>
		 	</c:if>
		<c:forEach var="tutorial" items="${dao.popularesProgramacao}" varStatus="id">					 	
			<c:if test="${empty requestScope.sessao}">
			<li class="lista"><a href="../mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="programacao${id.count}" class="listas">${tutorial.titulo}</a></li>
	   		</c:if>
	   		<c:if test="${not empty requestScope.sessao}">
			<li class="lista"><a href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" id="programacao${id.count}" class="listas">${tutorial.titulo}</a></li>
	   		</c:if>
	   		</c:forEach>
		</ul>
		</div>
	</div>
	<div id="rodapeInsert" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:445px;"</c:if>>
	<c:import url="../Paginas/Rodape.jsp" />
	</div>
</body>
</html>
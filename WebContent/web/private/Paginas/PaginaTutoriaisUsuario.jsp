<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleTutoriaisUsuario.css" />
<title>InfoTutos - Meus tutoriais</title>
<c:if test="${requestScope.sucesso != null}">
<script type="text/javascript">
	alert("${requestScope.sucesso}");
</script>
</c:if>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel">
		<p id="lblTutoriais">Meus tutoriais <img src="Imagens/meustutoriais.png" id="novologo"></p>
		<p id="lblAptos">Tutoriais aptos<span id="simboloAptos">&#10003;</span></p>	
		<div id="divAptos">			
			<ul id="listaAptos">
				<c:forEach var="tutorial" items="${tutoriaisAptos}">
					<c:choose>
						<c:when test="${tutorial.titulo == 'Você ainda não possui nenhum tutorial apto!'}">
							<li class="lista"><p id="Aptos1" style="margin-left: 0px;"><b>Você ainda não possui nenhum tutorial apto!</b></p></li>
						</c:when>
						<c:when test="${tutorial.conceito == 'Apto'}">
							<li class="lista">							
						<a id="Aptos1"
								href="mvc?logica=VisualizarTutorialLogic&titulo=${tutorial.titulo}" title="Clique para visualizar"
								id="Aptos1" class="listas" style="margin-top: ${tutorial.tutorialId * 30 }px">${tutorial.titulo}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
		</div>		
		
		<p id="lblAguardando">Tutoriais em avaliação <span id="simboloAval">&#8635;</span></p>
		<div id="divAguardando">		
			<ul id="listaAguardando">
				<c:forEach var="tutorial" items="${tutoriaisAvaliacao}">
					<c:choose>
						<c:when
							test="${tutorial.titulo == 'Você ainda não possui nenhum tutorial em avaliação!'}">
							<li class="lista"><p id="Aguardando1" style="margin-left: 0px;"><b>Você ainda não possui nenhum tutorial em avaliação!</b></p></li>
						</c:when>
						<c:when test="${tutorial.conceito == 'Aguardando'}">
							<li class="lista"><a id="Aguardando1" class="notlink" style="margin-top: ${tutorial.tutorialId * 30 }px">${tutorial.titulo}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
		
		<p id="lblInapto">Tutoriais inaptos <span id="simboloInaptos">&#10008;</span></p>
		<div id="divInapto">		
			<ul id="listaInapto">
				<c:forEach var="tutorial" items="${tutoriaisInaptos}">
					<c:choose>
						<c:when
							test="${tutorial.titulo == 'Você ainda não possui nenhum tutorial inapto!'}">
							<li class="lista"><p id="Inapto1" style="margin-left: 0px;"><b>Você ainda não possui nenhum tutorial inapto!</b></p></li>
						</c:when>
						<c:when test="${tutorial.conceito == 'Inapto'}">
							<li class="lista"><a id="Inapto1" class="listas" title="Clique para editar e reenviar" style="margin-top: ${tutorial.tutorialId * 30 }px" 
							href="Paginas/PaginaEditarTutoriais.jsp?titulo=${tutorial.titulo}&categoria=${tutorial.tema}">${tutorial.titulo}</a></li>
						</c:when>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="rodapeInsert">
		<c:import url="../Paginas/Rodape.jsp" />
	</div>

</body>
</html>
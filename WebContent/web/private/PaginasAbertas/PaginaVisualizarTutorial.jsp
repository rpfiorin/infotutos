<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleVisualizarTutorial.css" />
<script type="text/javascript" src="JQuery/jquery.js"></script>
<script type="text/javascript" src="JQuery/PaginaVisualizarTutorial.js"></script>
<title>InfoTutos - ${requestScope.tituloTutorial}</title>
<c:if test="${requestScope.sucesso != null}">
<script type="text/javascript">
	alert("${requestScope.sucesso}");
</script>
</c:if>
</head>
<body>
	<c:import url="../Paginas/Cabecalho.jsp" />
	<div id="panel" <c:if test="${empty sessionScope.usuarioLogado}">style="top:115px;height:1571px"</c:if>>
		<div id="exibirTutorial">
			<p id="tituloTutorial">${requestScope.tituloTutorial}</p>
			<p id="autorTutorial"><b>Enviado por:</b> ${requestScope.usuario_id}</p>
			<p id="dataTutorial"><b>Enviado em:</b> ${requestScope.dataPostagem}</p>
			<p id="temaTutorial"><b>Tema:</b> ${requestScope.categoria}</p>
			<iframe id="pdfTutorial" src="${requestScope.caminhoPdf}"></iframe>
			<c:if test="${sessionScope.usuarioLogado == requestScope.usuario_id}">
			<a href="Paginas/PaginaEditarTutoriais.jsp?titulo=${requestScope.tituloTutorial}&categoria=${requestScope.categoria}" 
			id="editarTutorial"><img src="Imagens/editartutorial.png" id="editarlogo" /><span id="editartexto">Editar</span></a>
			</c:if>
		</div>
		<c:if test="${not empty sessionScope.usuarioLogado}">
		<div id="comentarios">
			<p id="lblAdcComentario">Adicione um comentário: <img src="Imagens/comentarioadd.png" id="comentariologo" /></p>
			<form action="mvc" method="post" id="adcComentario"
				accept-charset="ISO-8859-1">
				<p id="lblNome">Usuário:</p>
				<p id="txtNome">${sessionScope.usuarioLogado}</p>
				<p id="lblComentario">Comentário:</p>
				<p id="contadorChar">200 caracteres restantes</p>
				<textarea cols="10" rows="5" id="txtComentario" name="txtComentario" maxlength="200"></textarea>
				<input type="hidden" name="tutorialid"
					value="${requestScope.tituloTutorial}" /> <input type="hidden"
					name="logica" value="EnviarComentarioLogic" /> <input
					type="submit" value="Enviar" id="btnComentar"/>
			</form>
		</div>
		</c:if>
		<p id="lblExibeComentario" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:920px;"</c:if>>Comentários:
		<img src="Imagens/comentarios.png" id="comentarioslogo" /></p>
		<div id="exibeComentarios" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:960px;"</c:if>>
			<ul id="comentariosTutorial">
				<c:forEach var="comentario" items="${comentarios}">
					<li><p id="lblidusuario">${comentario.usuario_id} - Data: ${comentario.dataComentario}</p></li>
					<li><p id="lblcomentario">${comentario.comentario}</p></li>
					<li id="comandosComentario">
					<a id="acao1" href="mvc?logica=GerenciaComentarioLogic&comentario_id=${comentario.comentario_id}
					&tipo=denuncia&tituloTutorial=${requestScope.tituloTutorial}">Denunciar</a>
					<c:if test="${comentario.usuario_id == sessionScope.usuarioLogado}">
					<a id="acao2" href="mvc?logica=GerenciaComentarioLogic&comentario_id=${comentario.comentario_id}
					&tipo=exclusao&tituloTutorial=${requestScope.tituloTutorial}">Excluir</a>
					</c:if>
					</li>					
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="insertRodape" <c:if test="${empty sessionScope.usuarioLogado}">style="margin-top:1050px;"</c:if>>
		<c:import url="../Paginas/Rodape.jsp" />
	</div>
</body>
</html>
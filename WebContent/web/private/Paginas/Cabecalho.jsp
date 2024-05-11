<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
<c:when test="${not empty requestScope.direct}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../StyleCSS/StyleCabecalho.css" />
</head>
<body>
	<div id="cabecalho">
	<div id="cabecalhoCentro">
		<a href="../PaginasAbertas/PaginaTutoriaisPopulares.jsp?direct=1,"><img
			src="../Imagens/Logo_TCC_new.png" alt="logo" id="logo" /></a>
		<form action="../mvc" method="post" id="busca" accept-charset="ISO-8859-1">
			<input type="text" id="pesquisa" name="pesquisa" placeholder="Ex.: Windows, Formatar, Limpeza, CD"/> 
			<img src="../Imagens/search.png" id="imgPesquisa"></img><input type="submit" value="Pesquisar" id="btnpesquisa" />
			<input type="hidden" value="PesquisaTutoriaisLogic" name="logica" />
		</form>
		<c:if test="${empty sessionScope.usuarioLogado}">
		<a href="../PaginasAbertas/PaginaLoginCadastro.jsp?direct=1"
			id="cadastrese"><img
			src="../Imagens/login.png" id="cadastreselogo" /><span id="cadastresetext">Cadastre-se ou faça login!</span></a>
			</c:if>
	</div>
		<div id="commandbar">
		<div id="commandCentro">
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Hardware" id="hardware" class="categorias"><img
			src="../Imagens/hardware.png" id="hardwarelogo" /><span id="hardwaretext">Hardware</span></a> 
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Redes" id="redes" class="categorias"><img
			src="../Imagens/redes.png" id="redeslogo" /><span id="redestext">Redes</span></a>
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Sistemas Operacionais" id="so" class="categorias"><img
			src="../Imagens/so.png" id="sologo" /><span id="sotext">Sistemas Operacionais</span></a> 
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Programação" id="programacao" class="categorias"><img
			src="../Imagens/programacao.png" id="programacaologo" /><span id="programacaotext">Programação</span></a>
		</div>
		</div>
		<c:if test="${not empty sessionScope.usuarioLogado}">
		<div id="usercommand">
		<div id="userCentro">
			<a href="../mvc?logica=VisualizarPerfilLogic" id="meuPerfil" class="perfil"><img
			src="../Imagens/meuperfil.png" id="perfillogo" /><span id="perfiltext">Meu perfil</span></a> 
			<a href="mvc?logica=TutoriaisUsuarioLogic" id="meusTutoriais" class="perfil"><img
			src="../Imagens/meustutoriais.png" id="meustutoriaislogo" /><span id="meustutoriaistext">Meus tutoriais</span></a> 
			<a href="../Paginas/PaginaCadastroTutoriais.jsp?direct=1" id="novoTutorial" class="perfil"><img
			src="../Imagens/novotutorial.png" id="novotutorialogo" /><span id="novotutorialtext">Novo tutorial</span></a> 
			<a href="mvc?logica=LogoutLogic" id="sair" class="perfil"><img
			src="../Imagens/logout.png" id="sairlogo" /><span id="sairtext">Sair</span></a>
		</div>
		</div>
		</c:if>
	</div>
</body>
</html>
</c:when>
<c:when test="${empty requestScope.direct}">
<c:if test="${empty requestScope.sessao}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../StyleCSS/StyleCabecalho.css" />
</head>
<body>
	<div id="cabecalho">
	<div id="cabecalhoCentro">
		<a href="../PaginasAbertas/PaginaTutoriaisPopulares.jsp?direct=1,"><img
			src="../Imagens/Logo_TCC_new.png" width="315px" height="120px"
			alt="logo" id="logo" /></a>
		<form action="../mvc" method="post" id="busca" accept-charset="ISO-8859-1">
			<input type="text" id="pesquisa" name="pesquisa" placeholder="Ex.: Windows, Formatar, Limpeza, CD"/> 
			<img src="../Imagens/search.png" id="imgPesquisa"></img><input type="submit" value="Pesquisar" id="btnpesquisa" />
			<input type="hidden" value="PesquisaTutoriaisLogic" name="logica" />
		</form>
		<c:if test="${empty sessionScope.usuarioLogado}">
		<a href="../PaginasAbertas/PaginaLoginCadastro.jsp?direct=1"
			id="cadastrese"><img
			src="../Imagens/login.png" id="cadastreselogo" /><span id="cadastresetext">Cadastre-se ou faça login!</span></a>
			</c:if>
	</div>
		<div id="commandbar">
		<div id="commandCentro">
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Hardware" id="hardware" class="categorias"><img
			src="../Imagens/hardware.png" id="hardwarelogo" /><span id="hardwaretext">Hardware</span></a> 
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Redes" id="redes" class="categorias"><img
			src="../Imagens/redes.png" id="redeslogo" /><span id="redestext">Redes</span></a>
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Sistemas Operacionais" id="so" class="categorias"><img
			src="../Imagens/so.png" id="sologo" /><span id="sotext">Sistemas Operacionais</span></a> 
			<a href="../mvc?logica=TutoriaisTemaLogic&tema=Programação" id="programacao" class="categorias"><img
			src="../Imagens/programacao.png" id="programacaologo" /><span id="programacaotext">Programação</span></a>
		</div>
		</div>
		<c:if test="${not empty sessionScope.usuarioLogado}">
		<div id="usercommand">
		<div id="userCentro">
			<a href="../mvc?logica=VisualizarPerfilLogic" id="meuPerfil" class="perfil"><img
			src="../Imagens/meuperfil.png" id="perfillogo" /><span id="perfiltext">Meu perfil</span></a>
			<a href="../mvc?logica=TutoriaisUsuarioLogic" id="meusTutoriais" class="perfil"><img
			src="../Imagens/meustutoriais.png" id="meustutoriaislogo" /><span id="meustutoriaistext">Meus tutoriais</span></a> 
			<a href="../Paginas/PaginaCadastroTutoriais.jsp?direct=1" id="novoTutorial" class="perfil"><img
			src="../Imagens/novotutorial.png" id="novotutorialogo" /><span id="novotutorialtext">Novo tutorial</span></a> 
			<a href="../mvc?logica=LogoutLogic" id="sair" class="perfil"><img
			src="../Imagens/logout.png" id="sairlogo" /><span id="sairtext">Sair</span></a>
		</div>
		</div>
		</c:if>
	</div>
</body>
</html>
</c:if>
<c:if test="${not empty requestScope.sessao}">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="StyleCSS/StyleCabecalho.css" />
</head>
<body>
	<div id="cabecalho">
	<div id="cabecalhoCentro">
		<a href="PaginasAbertas/PaginaTutoriaisPopulares.jsp?direct=1,"><img
			src="Imagens/Logo_TCC_new.png" width="350" height="150"
			alt="logo" id="logo" /></a>
		<form action="mvc" method="post" id="busca" accept-charset="ISO-8859-1">
			<input type="text" id="pesquisa" name="pesquisa" placeholder="Ex.: Windows, Formatar, Limpeza, CD"/> 
			<img src="Imagens/search.png" id="imgPesquisa"></img><input type="submit" value="Pesquisar" id="btnpesquisa" />
			<input type="hidden" value="PesquisaTutoriaisLogic" name="logica" />
		</form>
		<c:if test="${empty sessionScope.usuarioLogado}">
		<a href="PaginasAbertas/PaginaLoginCadastro.jsp?direct=1"
			id="cadastrese"><img
			src="Imagens/login.png" id="cadastreselogo" /><span id="cadastresetext">Cadastre-se ou faça login!</span></a>
			</c:if>
	</div>
		<div id="commandbar">
		<div id="commandCentro">
			<a href="mvc?logica=TutoriaisTemaLogic&tema=Hardware" id="hardware" class="categorias"><img
			src="Imagens/hardware.png" id="hardwarelogo" /><span id="hardwaretext">Hardware</span></a> 
			<a href="mvc?logica=TutoriaisTemaLogic&tema=Redes" id="redes" class="categorias"><img
			src="Imagens/redes.png" id="redeslogo" /><span id="redestext">Redes</span></a>
			<a href="mvc?logica=TutoriaisTemaLogic&tema=Sistemas Operacionais" id="so" class="categorias"><img
			src="Imagens/so.png" id="sologo" /><span id="sotext">Sistemas Operacionais</span></a>  
			<a href="mvc?logica=TutoriaisTemaLogic&tema=Programação" id="programacao" class="categorias"><img
			src="Imagens/programacao.png" id="programacaologo" /><span id="programacaotext">Programação</span></a>
		</div>
		</div>
		<c:if test="${not empty sessionScope.usuarioLogado}">
		<div id="usercommand">
		<div id="userCentro">
			<a href="mvc?logica=VisualizarPerfilLogic" id="meuPerfil" class="perfil"><img
			src="Imagens/meuperfil.png" id="perfillogo" /><span id="perfiltext">Meu perfil</span></a> <a
				href="mvc?logica=TutoriaisUsuarioLogic" id="meusTutoriais" class="perfil"><img
			src="Imagens/meustutoriais.png" id="meustutoriaislogo" /><span id="meustutoriaistext">Meus tutoriais</span></a>
			 <a	href="Paginas/PaginaCadastroTutoriais.jsp?direct=1"
				id="novoTutorial" class="perfil"><img
			src="Imagens/novotutorial.png" id="novotutorialogo" /><span id="novotutorialtext">Novo tutorial</span></a> 
			<a href="mvc?logica=LogoutLogic" id="sair" class="perfil"><img
			src="Imagens/logout.png" id="sairlogo" /><span id="sairtext">Sair</span></a>
		</div>
		</div>
		</c:if>
	</div>
</body>
</html>
</c:if>
</c:when>
</c:choose>

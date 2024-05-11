<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../StyleCSS/StyleCadastroTutoriais.css" />
<script type="text/javascript" src="../JQuery/jquery.js"></script>
<script type="text/javascript" src="../JQuery/PaginaCadastroTutoriais.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InfoTutos - Envie seu tutorial!</title>
</head>
<body id="body">
	<c:import url="Cabecalho.jsp"/>
	<div id="panel">
		<div id="cadastroTutorial">
			<p id="tituloCriacao">Criar tutorial <img src="../Imagens/novotutorial.png" id="novologo"></p>
			<div id="regraCriacaoleft">
				<b>Regras para envio: </b>
				<br/><b>1.</b> O arquivo deverá ser enviado em formato PDF pelo usuário. 
				<br/><b>2.</b> O tutorial não pode conter caracteres especiais no título.
				<br/><b>3.</b> O tutorial não pode conter conteúdo com direitos autorais que não sejam do autor.
				<br/><b>4.</b> Se o tutorial conter informações indevidas, o usuário estará passível de punição. 
				<br/><b>5.</b> Caso o tutorial seja avaliado como Apto, o usuário poderá editá-lo e enviar uma nova versão.
			</div>
			<div id="regraCriacaoright">
				<br/><b>6.</b> O tamanho máximo do arquivo é de 10 Mb. 
				<br/><b>7.</b> O tutorial deve estar de acordo com os termos de uso.
				<br/><b>8.</b> O tutorial passará por avaliação antes de ser disponibilizado.
				<br/><b>9.</b> Caso o tutorial seja avaliado como Inapto, o usuário poderá reenviá-lo. 
				<br/><b>10.</b> A cada vez que um tutorial é enviado, editado ou reenviado ficará indisponível até a avaliação.
			</div>
			<form action="../mvc?logica=CadastroTutorialLogic" method="post" id="criarTutorial" enctype="multipart/form-data" accept-charset="ISO-8859-1">			
				<p id="avisoTutorial">*</p>
				<p id="txtTutorial">Título:</p>
				<input type="text" id="tituloTutorial" name="tituloTutorial" maxlength="150"/>
				<p id="txtCategoria">Categoria:</p>
				<select id="categoriasList" name="categoria">
					<option value="Hardware">Hardware</option>
					<option value="Redes">Redes</option>
					<option value="Sistemas Operacionais">Sistemas Operacionais</option>
					<option value="Programação">Programação</option>
				</select>
				<p id="avisoArquivo">*</p>
				<p id="txtArquivo">Envie o tutorial:</p>
				<input type="file" id="tutorialEnviado" name="file" /> 
				<p id="avisoGeral">Os campos marcados com (*) são necessários!</p>
				<input type="submit" value="Enviar" id="enviarTutorial"/>				
			</form>
		</div>
	</div>
	<c:import url="Rodape.jsp"/>
</body>
</html>
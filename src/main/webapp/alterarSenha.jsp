<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Senha</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<%
	if(usuario == null){
		response.sendRedirect("listaPainelPublico.jsp");
	}
	%>
	
		<fieldset>
			<legend>ACESSAR</legend>
		    	<label for="senha">Senha Atual:</label> 
		    	<input class="larguraTexto"	type="password" name="senhaAtual" id="senhaAtual"> 
				<label for="senha">Nova Senha:</label> 
				<input class="larguraTexto" type="password" name="novaSenha" id="novaSenha"> 
				<label for="senha"> Confirmar Senha:</label> 
				<input class="larguraTexto"	type="password" name="confirmarSenha" id="confirmarSenha">
				<input type="submit" class="bt" value="Gravar" onclick="alterarSenha()">
				<span style="background-color: white; color: black;" id="msg"></span>
		</fieldset>
		
		<script type="text/javascript">

		function alterarSenha(){
			var senhaAtual = document.getElementById("senhaAtual").value;
			var novaSenha = document.getElementById("novaSenha").value;
			var confirmarSenha = document.getElementById("confirmarSenha").value;
			
			var paramentros = "senhaAtual="+senhaAtual;
			 paramentros += "&novaSenha="+novaSenha;
			 paramentros += "&confirmarSenha="+confirmarSenha;
			 acessarApi(paramentros);
		}
		
		function acessarApi(paramentros){
			const api = new XMLHttpRequest();
			api.open("POST","/alterarSenha");
			api.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			api.send(paramentros);
			api.onload = function() {
				document.getElementById("msg").innerHTML = this.responseText;
			}
		}
		
		</script>

</body>
</html>
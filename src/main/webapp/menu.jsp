<%@page import="org.senai.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<link rel="stylesheet" href="css/estilo.css">
<p>
		<img src="img/Bandeira_do_Distrito_Federal_Brasil.png" height="100px">
		<script>
			var myVar = setInterval(myTimer, 1000);
			function myTimer() {
				var d = new Date();
				document.getElementById("dt-hora").innerHTML = d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear()+' '+ d
						.toLocaleTimeString();

				var tabela = localStorage.getItem('corpo-tabela');

				document.getElementById("corpo-tabela").innerHTML = tabela;
			}
			documento.myTimer();
		</script>
		Hospital Regional de Taguatinga | Secretaria de Estado de Saúde do
		Distrito Federal | Pacientes no Centro Cirúgico - <span id="dt-hora">8/9/2021 18:15:04</span>
	</p>

<style>
ul {
	background-color: #A9E2F3;
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	width: 100%;
	margin: auto;
}
li {
	float: left;
}
li a {
	color: black;
	padding: 6px;
	display: block;
	text-align: center;
	text-decoration: none;
}
li a:hover {
	background-color: #E0F2F7;
}
#dadosUsuario {
	color: black;
	padding: 6px;
	display: block;
	text-align: center;
	text-decoration: none;
	float: right;
}
</style>
<ul>
<!-- -  	<li><a href="listaPainel.jsp">Home</a></li> -->
	<li><a href="index.jsp">Painel Publico</a></li>

<%
 	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
 	boolean verLista = false;
 	if(usuario != null){
 		//out.print(usuario.getEmail());
 		verLista = true;
 		%>
		<li><a href="formPainel.jsp">Cadastro</a></li>
 		<%
 		%>
		<li><a href="alterarSenha.jsp">Alterar Senha</a></li>
		<li><a href="loginServlet?acao=sair">Logoff</a></li>
		
		
		
 		<% 
 	} else {
 		%>
		<li><a href="login.jsp">Login</a></li>
 		<% 
	
 	}
 	%>
  


</ul>
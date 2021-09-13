<%@page import="org.senai.dao.UsuarioDao"%>
<%@page import="org.senai.model.Usuario"%>
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
	
	
	
 <fieldset>
             
       <span style="background-color: back; " id="msg"></span>


<script type="text/javascript">


 	function alterarSenha() {
 		var senhaAtual = document.getElementById("senhaAtual").value;
 		var novaSenha = document.getElementById("novaSenha").value;
 		var confirmarSenha = document.getElementById("confirmarSenha").value;
 		
 		var paramentros = "senhaAtual=" +senhaAtual;
 		    paramentros += "&novaSenha="+novaSenha;
 		    paramentros += "&confirmarSenha="+confirmarSenha;
 		    acessarApi(paramentros);
 		     		    
 	}
 	
 	function acessarApi(paramentros){
 		const api = new XMLHttpRequest();
 		api.open("POST", "http://localhost:8080/projeto-senai/alterar.jsp");
 		api.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 		api.send(paramentros);
 		api.onload = function() {
 			document.getElementById("msg").innerHTML = this.responseText;
// 			alert(this.responseText);
			
 		}
 		 
 	}
 	
 	
 	</script>

 </fieldset>
  
 </body>
</html>
<%@page import="java.util.List"%>
<%@page import="org.senai.dao.PainelDao"%>
<%@page import="org.senai.model.Painel"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.senai.db.Conexao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/estilo.css">

	<%
	PainelDao objDao = new PainelDao();
	List<Painel> ls = objDao.listaPainel();
	if (ls.size() > 0 ) {	
	
	%>

	<table id="estilo-tb">

		<tr>
<!-- 			<th>Id</th> -->
			<th>ID</th>
			<th>Nome do Paciente</th>
			<th>Status</th>
			<th>Início Previsto</th>
			<th>Início da Cirurgia</th>
			<th>Fim da Cirurgia</th>
			<th>Saída Prevista</th>
<!-- 			<th>Ação</th> -->

		</tr>
		
		<% 
		for(Painel ps : ls) {
		%>
		
		<tr onclick="window.location.href = 'formPainel.jsp?id=<%=ps.getId()%>'">
		
 			<td><%=ps.getId()%></td>
			<td><%=ps.getNomePaciente() %></td>
			<td><%=ps.getStatus() %></td>
			<td><%=ps.getInicioPrevisto()%></td>
			<td><%=ps.getInicioCirurgia()%></td>
			<td><%=ps.getFimCirurgia()%></td>
			<td><%=ps.getSaidaPrevista()%></td>
<%-- 			<td><a href="formCadastro.jsp?id=<%=ps.getId()%>">Editar</a> --%>
<%-- 			<a href="cadastroServlet?acao=apagar&id=<%=ps.getId()%>">Apagar</a></td> --%>
			
				
		</tr>
		<%
		} 
		%>
		
	</table>
	 <% 
	 
	 }
				
     %>
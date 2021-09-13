<%@page import="org.senai.dao.PainelDao"%>
<%@page import="org.senai.model.Painel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="css/estilo.css">



    <style>
        .bloco-inline label, 
        .bloco-inline input,
        .bloco-inline * {
            display: inline;
        }

    </style>


</head>

<body>

<%@ include file="menu.jsp" %>

<%



	Painel p = new Painel();

	try{
		
		int id = Integer.parseInt(request.getParameter("id"));	
		PainelDao dao = new PainelDao();
		p = dao.getPainel(id);

	}catch (Exception e){ 
		
		
	}

	
%>


    <form action="painelServlet">
    <input type="hidden" name='id' value="<%=p.getId()%>">
    
        <fieldset>
            <legend><b>CADASTRO PAINEL</b></legend>
            
            
                        
            <label for="nome">Nome do Paciente</label>
            <input class="larguratexto" type="text" id="nomep" name="nomePaciente" value="<%=p.getNomePaciente()%>"> 
           
                       
            
            <label for="">Status</label>
            <select name="status" id="status">
                <option value="pré-operatório">Pré-operatório</option>
                <option value="Transferido">Transferido</option>
                <option value="Em cirurgia">Em cirurgia</option>
                <option value="Em recuperação">Em recuperação</option>

            </select>
            
			
            <label for="nome">Local</label>
            <input class="larguratexto" type="text" id="local" name="local" value="<%=p.getLocal()%>"> 
            
            
            <label for="inicioPrevisto">Início Presvisto</label>
            <input class="larguratexto" type="time" id="inicioPrevisto" name="inicioPrevisto" value="<%=p.getInicioPrevisto()%>"> 
            
            
            
            <label for="inicioCirugia">Início Cirurgia</label>
            <input class="larguratexto" type="time" id="inicioCirurgia" name="inicioCirurgia" value="<%=p.getInicioCirurgia()%>">
           
           
           
            <label for="fimCirugia">Fim Cirurgia</label>
            <input class="larguratexto" type="time" id="fimCirurgia" name="fimCirurgia" value="<%=p.getFimCirurgia()%>">
           
           
            <label for="saidaPrevista">Saída Prevista</label>
            <input class="larguratexto" type="time" id="saidaPrevista" name="saidaPrevista" value="<%=p.getSaidaPrevista()%>"> 
           
            
            <a class="bt" href="formPainel.jsp">Novo</a>
		    <%
		    if(p.getId()>0){
		    %>           
            <a class="bt" onclick=" return confirm('Você realmente quer apagar esse registro?');" href="painelServlet?id=<%=p.getId()%>&acao=apagar">Apagar</a>
            <%
		    }else {
		    %>
		     <input type="reset" class="bt" value="Limpar">
		    <%
		    }
            %>
            <input type="submit" class="bt" value="Gravar">
            
            
            
        </fieldset>
    </form>

   
    <script type="text/javascript">
	
	document.getElementById("status").value = '<%=p.getStatus()%>';
	
		
	
	</script>
    
    <div id="tb"> 
    
     <%@ include file="listaPainel.jsp" %> 
    
    </div>
</body>

</html>
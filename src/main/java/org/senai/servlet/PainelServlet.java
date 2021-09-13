package org.senai.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.PainelDao;
import org.senai.db.Conexao;
import org.senai.model.Painel;


//import com.sun.jdi.connect.spi.Connection;

@WebServlet("/painelServlet")
public class PainelServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Painel objP = new Painel();
		
		String acao = req.getParameter("acao");
		
		if (acao != null && acao.equals("apagar")) {
			objP.setId(Integer.parseInt(req.getParameter("id")));
		} else {
		objP.setNomePaciente(req.getParameter("nomePaciente"));
		objP.setStatus(req.getParameter("status"));
		objP.setLocal(req.getParameter("local"));
		objP.setInicioPrevisto(req.getParameter("inicioPrevisto"));
		objP.setInicioCirurgia(req.getParameter("inicioCirurgia"));
		objP.setFimCirurgia(req.getParameter("fimCirurgia"));
		objP.setSaidaPrevista(req.getParameter("saidaPrevista"));
		objP.setId(Integer.parseInt(req.getParameter("id")));
		}

		PainelDao objDao = new PainelDao();
		
		
		boolean validar = false;
		
		
		if(objP.getId() > 0) {
			if (acao != null && acao.equals("apagar")) {
				validar = objDao.apagar(objP.getId());
			}else {
				validar = objDao.alterar(objP);
			}
		}else {
				validar = objDao.adicionar(objP);
		
		}
			
			if(validar) {
				res.sendRedirect("formPainel.jsp");
			}else {
				PrintWriter saida = res.getWriter();
				saida.println("<html>");
				saida.println("Erro ao gravar");
				saida.println("</html>");
			
		}

		
		}
		
	}


	


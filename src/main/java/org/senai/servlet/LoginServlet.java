package org.senai.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.PainelDao;
import org.senai.dao.UsuarioDao;
import org.senai.model.Usuario;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		
		if(acao != null && acao.equals("sair")) {
			req.getSession().removeAttribute("usuario");
			res.sendRedirect("login.jsp");
			
		}else {
			

			String email = req.getParameter("email");
			String senha = req.getParameter("senha");
			
			
			UsuarioDao dao = new UsuarioDao();
			Usuario u = dao.validarUsuario(email, senha);
			
			   
		    PrintWriter saida = res.getWriter();
			saida.println("<html>");
			
			if(u.getId() > 0) {
				//saida.println("Acesso Aprovado");
				res.sendRedirect("formPainel.jsp");
				req.getSession().setAttribute("usuario", u);
			}else {
				saida.println("Acesso Reprovado");
				res.sendRedirect("login.jsp?erro");
				
		}
	    
		}	
		
	}
	}
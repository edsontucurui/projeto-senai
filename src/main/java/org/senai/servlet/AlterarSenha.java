package org.senai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.UsuarioDao;
import org.senai.model.Usuario;

@WebServlet("/alterarSenha")

public class AlterarSenha extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String senhaAtual = req.getParameter("senhaAtual");
		String novaSenha = req.getParameter("novaSenha");
		String confirmarSenha = req.getParameter("confirmarSenha");
	
		Usuario u = (Usuario)req.getSession().getAttribute("usuario");
		//res.setCharacterEncoding("UTF=8");
		PrintWriter out = res.getWriter();
		
		if(novaSenha.equals(confirmarSenha) && u.getSenha().equals(senhaAtual)) {
			
			u.setSenha(novaSenha);
			UsuarioDao dao = new UsuarioDao();
			dao.alterarSenha(u);
			out.print("Senha alterada!");
			
		}else {
			
			out.print("Incorreto, tente alterar novamente.");
			
		}
	}
	
	
	
}

package org.senai.dao;

import java.awt.List;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.senai.db.Conexao;
import org.senai.model.Painel;
import org.senai.model.Usuario;

public class UsuarioDao {

	
	public Usuario validarUsuario(String email, String senha) {
		Usuario u = new Usuario();
		
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("Select * from usuario WHERE email = '"+email+"' AND senha = '"+senha+"' ");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setId(rs.getInt("id"));					
			}
			cont.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return u;
				
	}
	
	public boolean alterarSenha(Usuario objP) {
		 
	 	try {
			//Conexao c = new Conexao();
		   java.sql.Connection cont = Conexao.conectar(); 
			
				String sql = " update usuario set "  
				       + "senha = ? "
					   + "where "
					   + "id= ?";
				
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.setString(1,objP.getSenha());
				pst.setInt(2,objP.getId());
				
				pst.execute();
				pst.close();
				cont.close();
				return true; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
	}

}

	 


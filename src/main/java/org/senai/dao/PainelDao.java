package org.senai.dao;

import java.awt.List;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.senai.db.Conexao;
import org.senai.model.Painel;
import org.senai.model.Usuario;

public class PainelDao {

	public boolean adicionar(Painel objP) {
		
		
		
		
		
		
		
		
		
		try {
			
		   java.sql.Connection cont = Conexao.conectar(); 
			
				String sql ="insert into painel (nome_paciente, status, local_sala, inicio_previsto, inicio_cirurgia, fim_cirurgia , saida_prevista)"
						+ "values('"+ objP.getNomePaciente() +"','"+ objP.getStatus()+"','"+ objP.getLocal() +"','"+ objP.getInicioPrevisto() +"','"+ objP.getInicioCirurgia() +"','"+ objP.getFimCirurgia() +"','"+ objP.getSaidaPrevista()+"') ";
				
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.execute();
				pst.close();
				cont.close();
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public java.util.List<Painel> listaPainel() {
		
		java.util.List<Painel> ls = new ArrayList<>();
		
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("Select id, nome_paciente, status, inicio_previsto, inicio_cirurgia, fim_cirurgia , saida_prevista  from painel order by id");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Painel p = new Painel();
				p.setId(rs.getInt("id"));
				p.setNomePaciente(rs.getString("nome_paciente"));
				p.setStatus(rs.getString("status"));
				p.setInicioPrevisto(rs.getString("inicio_previsto"));
				p.setInicioCirurgia(rs.getString("inicio_cirurgia"));
				p.setFimCirurgia(rs.getString("fim_cirurgia"));
				p.setSaidaPrevista(rs.getString("saida_prevista"));
				
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
					
		return ls;
	}
	
	
	public Painel getPainel(int id) {
		Painel p = new Painel();
		
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("Select * from painel where id = ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNomePaciente(rs.getString("nome_paciente"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local_sala"));
				p.setInicioPrevisto(rs.getString("inicio_previsto"));
				p.setInicioCirurgia(rs.getString("inicio_cirurgia"));
				p.setFimCirurgia(rs.getString("fim_cirurgia"));
				p.setSaidaPrevista(rs.getString("saida_prevista"));
									
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return p;
	}
	
	 public boolean alterar(Painel objP) {
		 
		 	try {
				//Conexao c = new Conexao();
			   java.sql.Connection cont = Conexao.conectar(); 
				
					String sql = " update painel set "  
					       + "nome_paciente = ?,"
						   + "status = ?,"
						   + "local_sala = ?,"
						   + "inicio_previsto = ?,"
						   + "inicio_cirurgia = ?,"
						   + "fim_cirurgia = ?," 
						   + "saida_prevista = ?"
						   + "where "
						   + "id= ?";
					
					PreparedStatement pst = cont.prepareStatement(sql);
					pst.setString(1,objP.getNomePaciente());
					pst.setString(2,objP.getStatus());
					pst.setString(3,objP.getLocal());
					pst.setString(4,objP.getInicioPrevisto());
					pst.setString(5,objP.getInicioCirurgia());
					pst.setString(6,objP.getFimCirurgia());
					pst.setString(7,objP.getSaidaPrevista());
					pst.setInt(8,objP.getId());
					
					pst.execute();
					pst.close();
					cont.close();
					return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		 
	 }
	
public boolean apagar(int id) {

			try {
			   java.sql.Connection cont = Conexao.conectar(); 
				
					String sql = " delete from painel where id = ?";
					
					PreparedStatement pst = cont.prepareStatement(sql);
					pst.setInt(1,id);
					
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

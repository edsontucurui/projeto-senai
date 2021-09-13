package org.senai.db;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {

	
	
	public static Connection conectar() {
		
		try {
		
		Class.forName ("org.postgresql.Driver");
				
		String url = "jdbc:postgresql://chunee.db.elephantsql.com:5432/cndtyrfq";
		String usuarioDb = "cndtyrfq";
		String senhaDb = "VuVMVPCHKuD-7HpMXwotpzGwxGvFp9-E";
		return DriverManager.getConnection(url,usuarioDb,senhaDb);
		} catch (Exception e) {
			System.out.println("Erro de conexão");
			e.printStackTrace();
			return null;
		}
	}
			
}

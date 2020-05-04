package br.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
	private static Connection cnx;

	public static Connection getConnection() {
		// 
		
		  String url = "jdbc:mysql://localhost:3306/agendinha";
		  String usuario = "root";
		  String senha = "root";
		 
		/*String url = "jdbc:postgresql://localhost:5432/agenda";
		String usuario = "postgres";
		String senha = "userpg";*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Class.forName("org.postgresql.Driver").newInstance();
			cnx = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.err.println("SQLState: " + ex.getSQLState());
			System.err.println("VendorError: " + ex.getErrorCode());
			return null;
		} catch (Exception e) {
			System.err.println("Problemas ao tentar conectar com o banco de dados");
			return null;
		}

		return cnx;
	}

}
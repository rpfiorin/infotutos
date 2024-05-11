package br.edu.tcc.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		Connection c = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost/tcc", "root", "1234");
		} catch (ClassNotFoundException e){
			System.out.println("Erro ao carregar driver: " +  e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco de dados: " +  e.getMessage());
		}
		return c;
	}
}

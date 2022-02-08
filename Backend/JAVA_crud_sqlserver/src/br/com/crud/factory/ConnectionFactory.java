package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection createConnectionSQLServer() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		
		// Cria a conex�o com o banco de dados ----------------------- SEM senha
		// Connection connection = DriverManager.getConnection(
			//"jdbc:sqlserver://DESKTOP-N1O36L9;integratedSecurity=true;databaseName=Agencia;");
		
		// Cria a conex�o com o banco de dados ----------------------- COM senha
		// Connection connection = DriverManager.getConnection(
				// "jdbc:sqlserver://localhost;databaseName=Bookstore;", "usuario", "senha");
		
		// Cria a conex�o com o banco de dados ----------------------- COM senha pelo Azure
		Connection connection = DriverManager.getConnection(
				"jdbc:sqlserver://iagoserver.database.windows.net;databaseName=Agencia;", "adminazure", "7894561230aA@");
		
		return connection;
	}
	public static void main(String[] args) throws Exception{
		// Recupera uma conex�o com o banco de dados
		Connection con = createConnectionSQLServer();
		// Testa se a conex�o � nula
		if (con != null) {
			System.out.println("Conexão obtida com sucesso! " + con);
			con.close();
		}
	}
	
	
	
	
}

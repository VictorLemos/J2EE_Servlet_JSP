package br.com.jobs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gerenciador de conexao com o banco de dados Postgres.</br>
 * Esta classe eh utilizada nas classes DAO para o Postgres.
 */
class ConnectionManagerPostgres {

	//instancia(unica) a ser fornecida
	private static ConnectionManagerPostgres instance;
	
		
	private ConnectionManagerPostgres() throws ClassNotFoundException {

		//
		//Registra o driver JDBC (neste caso o driver de conexao para o Postgres)
		//
		Class.forName("org.postgresql.Driver");		
	}
	
	
	/**
	 * Pega a instancia desta classe.
	 * @return A instancia.
	 * @throws SQLException
	 */
	public static ConnectionManagerPostgres getInstance() throws SQLException{

		try{
		
			//verifica se jah existe uma instancia, se nao existe entao instancia
			if (instance == null) {
				instance = new ConnectionManagerPostgres();
			}
		
		}
		catch(ClassNotFoundException e){
			
			throw new SQLException("O Driver JDBC nao foi encontrado!");
			
		}
		
		return instance;
	}
	
	
	/**
	 * Abre uma conexao com o banco de dados.
	 * @return Um objeto que representa a conexao com o banco de dados.
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
				
		//parametros da conexao
		String usuario = "postgres";
		String senha = "root";
		String jdbcUrl = "jdbc:postgresql://localhost:5432/teste"; 
		
		try{
			//
			//Abre a conexao com o SGBDR
			//
			return DriverManager.getConnection(jdbcUrl, usuario, senha);
	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			throw new SQLException("Erro ao abrir a conexão com banco de dados", e);

		}
		
	}

}

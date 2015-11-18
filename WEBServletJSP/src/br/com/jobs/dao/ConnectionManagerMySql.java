package br.com.jobs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gerenciador de conexao com o banco de dados MySql.</br>
 * Esta classe eh utilizada nas classes DAO para o MySql.
 */
class ConnectionManagerMySql {

	//instancia(unica) a ser fornecida
	private static ConnectionManagerMySql instance;
	
		
	private ConnectionManagerMySql() throws ClassNotFoundException {

		//
		//Registra o driver JDBC (neste caso o driver de conexao para o Oracle)
		//
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	
	
	/**
	 * Pega a instancia desta classe.
	 * @return A instancia.
	 * @throws SQLException
	 */
	public static ConnectionManagerMySql getInstance() throws SQLException{

		try{
		
			//verifica se jah existe uma instancia, se nao existe entao instancia
			if (instance == null) {
				instance = new ConnectionManagerMySql();
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
				
		// parametros da conexao
		String usuario = "root";
		String senha = "root";
		String jdbcUrl = "jdbc:mysql://localhost:3306/dahora"; 
		
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

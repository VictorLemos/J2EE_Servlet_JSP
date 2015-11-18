package br.com.jobs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.jobs.entity.Customer;

public class CustomerDAO {
	
	public void inserir(Customer customer) throws SQLException{
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionManagerPostgres.getInstance().getConnection();
			
			PreparedStatement stmtInsert = conn
					.prepareStatement("INSERT INTO Customer(nome, cpf, sexo, email, telefone)" +
							"VALUES( ?, ?, ?, ?, ?)");
			
			stmtInsert.setString(1, customer.getNome());
			stmtInsert.setString(2, customer.getCpf());
			stmtInsert.setString(3, customer.getSexo());
			stmtInsert.setString(4, customer.getEmail());
			stmtInsert.setString(5, customer.getTelefone());
			stmtInsert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(
					"Erro ao conectar ou manipular o banco de dados!", e);
		} finally{
			
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					throw new SQLException(
							"Erro ao fechar a conexao com o banco de dados!", e);
				}
			}
		}
	}
	
	public ArrayList<Customer> listarTodos() throws SQLException{
		
		ArrayList<Customer> listaCustomer = new ArrayList<Customer>();
		Connection conn = null;
		
		try {
			conn = ConnectionManagerPostgres.getInstance().getConnection();
			
			PreparedStatement stmtSelect = conn.prepareStatement("SELECT * FROM customer");
			
			ResultSet rs = stmtSelect.executeQuery();
			
			while (rs.next()) {
				Customer customer = new Customer();
				
				customer.setId(rs.getInt("id"));
				customer.setNome(rs.getString("nome"));
				customer.setCpf(rs.getString("cpf"));
				customer.setSexo(rs.getString("sexo"));
				customer.setEmail(rs.getString("email"));
				customer.setTelefone(rs.getString("telefone"));
				
				listaCustomer.add(customer);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o banco de dados!", e);
		} finally {
			
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException("Erro ao fechar a conexao com o banco de dados!", e);
				}
		}
		
		return listaCustomer;
	}
	
	public Customer buscarPorId(int id) throws SQLException {
		Connection conn = null;
		Customer customer = null;
		
		try {
			conn = ConnectionManagerPostgres.getInstance().getConnection();
			
			PreparedStatement stmtSelect = conn.prepareStatement("Select * FROM customer WHERE ID = ?");
			stmtSelect.setInt(1, id);
			
			ResultSet rs = stmtSelect.executeQuery();
			
			if (rs.next()) {
				
				customer = new Customer();
				
				customer.setId(rs.getInt("id"));
				customer.setNome(rs.getString("nome"));
				customer.setCpf(rs.getString("cpf"));
				customer.setSexo(rs.getString("sexo"));
				customer.setEmail(rs.getString("email"));
				customer.setTelefone(rs.getString("telefone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o banco de dados!", e);
		} finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException("Erro ao fechar a conexao com o banco de dados!", e);
				}
			}
		}
		return customer;
	}

	public void alterar(Customer customer) throws SQLException {
		Connection conn = null;
		
		try {
			conn = ConnectionManagerPostgres.getInstance().getConnection();
			
			PreparedStatement stmtAlterar = conn
					.prepareStatement("UPDATE customer SET nome=?, cpf=?, sexo=?, email=?, telefone=? WHERE ID=?");
			
			stmtAlterar.setString(1, customer.getNome());
			stmtAlterar.setString(2, customer.getCpf());
			stmtAlterar.setString(3, customer.getSexo());
			stmtAlterar.setString(4, customer.getEmail());
			stmtAlterar.setString(5, customer.getTelefone());
			stmtAlterar.setInt(6, customer.getId());
			stmtAlterar.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o banco de dados!", e);
		}finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException("Erro ao fechar a conexao com o banco de dados!", e);
				}
			}
		}
	}
	
	public void removerPorId(int id) throws SQLException {
		Connection conn = null;
		
		try {
			conn = ConnectionManagerPostgres.getInstance().getConnection();
			
			PreparedStatement stmtRemover = conn
					.prepareStatement("DELETE FROM customer WHERE ID=?");
			
			stmtRemover.setInt(1, id);
			stmtRemover.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao conectar ou manipular o banco de dados!", e);
		} finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new SQLException("Erro ao fechar a conexao com o banco de dados!", e);
				}
			}
		}
	}
	
}

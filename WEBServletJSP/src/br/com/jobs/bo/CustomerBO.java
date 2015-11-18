package br.com.jobs.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.jobs.dao.CustomerDAO;
import br.com.jobs.entity.Customer;

public class CustomerBO {

	private CustomerDAO customerDAO = new CustomerDAO();
	
	public void inserir(Customer customer){
		try {
			customerDAO.inserir(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> listarTodos(){
		try {
			return customerDAO.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Customer>();
		}
	}
	
	public Customer buscarPorId(int id){
		try {
			return customerDAO.buscarPorId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void alterar(Customer customer){
		try {
			customerDAO.alterar(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removerPorId(int id){
		try {
			customerDAO.removerPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

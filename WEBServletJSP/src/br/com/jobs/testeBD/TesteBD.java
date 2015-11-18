package br.com.jobs.testeBD;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.jobs.bo.CustomerBO;
import br.com.jobs.entity.Customer;

public class TesteBD {

	public static void main(String[] args)throws SQLException {
		
		CustomerBO customerBO = new CustomerBO();
		
		Customer customer = new Customer();
		
		/* INSERIR
		customer.setNome("Victor Lemos");
		customer.setCpf("399.999.929-22");
		customer.setSexo("Masculino");
		customer.setEmail("desnuey@gmail.com");
		customer.setTelefone("(11)3932-3137");
		
		customerBO.inserir(customer);
		*/
		
		/* SELECT
		ArrayList<Customer> listarCustomers = customerBO.listarTodos();
		
		for (Customer c : listarCustomers) {
			System.out.println("ID: " + c.getId());
			System.out.println("Nome: " + c.getNome());
			System.out.println("CPF: " + c.getCpf());
			System.out.println("Sexo: " + c.getSexo());
			System.out.println("E-mail: " + c.getEmail());
			System.out.println("Telefone: " + c.getTelefone());
			System.out.println();
		}
		*/
		
		
	}	
}

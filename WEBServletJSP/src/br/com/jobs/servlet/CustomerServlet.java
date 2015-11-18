package br.com.jobs.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jobs.bo.CustomerBO;
import br.com.jobs.entity.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		private CustomerBO customerBO = new CustomerBO();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String retorno = "";
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "salvar":
			salvar(request);
			listar(request);
			retorno = "listaCliente.jsp";
			break;
		case "remover":
			remover(request);
			listar(request);
			retorno = "listaCliente.jsp";
			break;	
		case "exibir":
			editar(request);
			retorno = "formularioCliente.jsp";
			break;
		case "listar":
			listar(request);
			retorno = "listaCliente.jsp";
			break;
		}
		
		request.getRequestDispatcher(retorno).forward(request, response);
	}
	
	private void salvar(HttpServletRequest request){
		String nome = request.getParameter("nmCliente");
		String cpf = request.getParameter("cpf");
		String sexo = request.getParameter("sexo");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		String id = request.getParameter("id");
		
		Customer customer = new Customer();
		
		customer.setNome(nome);
		customer.setCpf(cpf);
		customer.setSexo(sexo);
		customer.setEmail(email);
		customer.setTelefone(telefone);
		
		if (id.equals("")){
			customerBO.inserir(customer);
			request.setAttribute("msg", "Cliente Cadastrado com sucesso!");
		}else{
			int codigo = Integer.parseInt(id);
			customer.setId(codigo);
			customerBO.alterar(customer);
			request.setAttribute("msg", "Cliente Alterado com sucesso!");
		}
	}
	
	private void editar(HttpServletRequest request){
		if (request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			Customer customer = customerBO.buscarPorId(id);
			request.setAttribute("customer", customer);			
		}
	}
	
	private void listar(HttpServletRequest request){
		ArrayList<Customer> lista = customerBO.listarTodos();
		request.setAttribute("customers", lista );
	}

	private void remover(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		customerBO.removerPorId(id);
		request.setAttribute("msg", "Cliente Removido com sucesso!");
	}
}

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Customer</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="container">
	<h1>Cliente</h1>
	<form action="CustomerServlet" method="post">
		<input type="hidden" name="acao" value="salvar"/>
		<input type="hidden" name="id" value="${customer.id }"/>
		
		<div class="form-group">
			<label>Nome</label>
			<input type="text" name="nmCliente" class="form-control" placeholder="Nome do Cliente" value="${customer.nome }"/>
		</div>
		
		<div class="form-group">
			<label>CPF</label>
			<input type="text" name="cpf" class="form-control" placeholder="Digite o CPF" value="${customer.cpf }"/>
		</div>
		
		<div class="form-group">
			<label>Sexo</label>
			<input type="text" name="sexo" class="form-control" placeholder="Digite o Sexo" value="${customer.sexo }"/>
		</div>
	
		<div class="form-group">
			<label>E-mail</label>
			<input type="text" name="email" class="form-control" placeholder="Digite o E-mail" value="${customer.email }"/>
		</div>	
	
		<div class="form-group">
			<label>Telefone</label>
			<input type="text" name="telefone" class="form-control" placeholder="Digite o Telefone" value="${customer.telefone }"/>
		</div>
		
		<div class="form-group">
			<input type="submit" value="Salvar" class="btn btn-primary" />
			<c:if test="${not empty customer}">
				<a data-toggle="modal" href="#myModal" class="btn btn-danger">Excluir</a>
				<a href="CustomerServlet?acao=listar" class="btn btn-default">Voltar</a>
			</c:if>
		</div>	
	</form>
</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Excluir</h4>
			</div>
			<div class="modal-body">
				Deseja Excluir o Cliente <c:out value="${customer.nome }"/> ?
			</div>
			<div class="modal-footer">
				<form action="CustomerServlet?acao=remover" method="post">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="hidden" name="id" value="${customer.id }"/>
	          		<input type="submit" class="btn btn-danger" value="Excluir"/>
				</form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
</body>
</html>